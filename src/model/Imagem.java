/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import transformers.Transformer;

/**
 *
 * @author 0186779
 */
public class Imagem {
    private final int largura;
    private final int altura;
    private double mediaCinza = -1;
    private double variancia = -1;
    private int mediana = -1;
    private Boolean escalaCinza = null;
            
    
    private BufferedImage buffered;

    public Imagem(BufferedImage bi) {
        this.buffered = bi;
        altura = bi.getHeight();
        largura = bi.getWidth();
    }

    @Override
    public Object clone(){
        return new Imagem(deepCopyBuffered(buffered));
    }
    
    private BufferedImage deepCopyBuffered(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    

    public BufferedImage getBuffered() {
        return buffered;
    }
    
    
    public static Imagem escolheImagem(){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            JFileChooser fc = new JFileChooser(System.getProperty("user.home")+"/desktop");
            fc.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().endsWith(".png") || f.isDirectory() || f.getName().endsWith(".jpg");
                }

                @Override
                public String getDescription() {
                    return "Imagens";
                }
            });
            fc.setAcceptAllFileFilterUsed(false);
            fc.setDialogTitle("Escolha uma imagem.");
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File arquivo = fc.getSelectedFile();
                BufferedImage imagem_arquivo = ImageIO.read(arquivo);
                return new Imagem(imagem_arquivo);
            }
        } catch (Exception ex) {
        }
        return null;
    }

    public double getMediaCinza(){
        if(mediaCinza >= 0) return mediaCinza;
        DoubleBasico soma = new DoubleBasico();
        percorrePixelsImagem(p -> soma.n += p.getEscalaCinza());
        mediaCinza = soma.n / (getAltura() * getLargura());
        return mediaCinza;
    }
    
    public int[] vetorImagemCinza(){
        int[] retorno = new int[buffered.getWidth() * buffered.getHeight()];
        IntegerBasico cont = new IntegerBasico();
        percorrePixelsImagem(p -> {
            retorno[cont.n] = p.getEscalaCinza();
            cont.n++;
        });
        return retorno;
    }    
            
    public double getVarianciaCinza(){
        if(variancia >= 0) return variancia;
        DoubleBasico soma = new DoubleBasico();
        percorrePixelsImagem(p -> {
            soma.n += (p.getEscalaCinza() - getMediaCinza())*(p.getEscalaCinza() - getMediaCinza());
        });
        variancia = soma.n / (getAltura() * getLargura());
        return variancia;
    }
    
    public int getMedianaCinza(){
        if(mediana >= 0) return mediana;
        int[] vetor = vetorImagemCinza();
        if (vetor.length % 2 == 0) {
            mediana = vetor[vetor.length / 2];
        } else {
            mediana = vetor[vetor.length / 2 + 1];
        }
        return mediana;
    }
    
    public int getModaCinza(){
        int[] vetorCores = new int[256];
        percorrePixelsImagem(p -> {
            vetorCores[p.getEscalaCinza()]++;
        });
        int max = -1, corMais = -1;
        for (int c = 0; c < 256; c++) {
            if(vetorCores[c] > max){
                max = vetorCores[c];
                corMais = c;
            }
        }
        return corMais;
    }
    
    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }
    
    public void percorrePixelsImagem(Consumer<Pixel> consumidor){
        
        for(int a = 0; a < getAltura(); a++)
            for (int l = 0; l < getLargura(); l++){
                consumidor.accept(new Pixel(buffered.getRGB(l, a),l,a));
            }
    }
 
    public <T extends Transformer> T getTransformer(Class<T> c){
        try {
            Constructor<T> constructor = c.getConstructor(Imagem.class);
            return constructor.newInstance(this);
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean isEscalaCinza() {
        if (escalaCinza == null){
            escalaCinza = true;
            percorrePixelsImagem(p -> {
                if(!p.isCinza())
                    escalaCinza = false;
            });
        }
        return escalaCinza;
    }
    
    public Imagem aplicaMatrizImagem(double[][] matriz){
        BufferedImage saida = new BufferedImage(buffered.getWidth(), buffered.getHeight(), BufferedImage.TYPE_INT_RGB);
        
        percorrePixelsImagem(p -> {
            int xPos = p.x + 1 - getLargura() / 2;
            int yPos = p.y + 1 - getAltura()/ 2;
            int xFinal = (int)(matriz[0][0] * xPos + matriz[1][0] * yPos + matriz[2][0] * 1);
            int yFinal = (int)(matriz[0][1] * xPos + matriz[1][1] * yPos + matriz[2][1] * 1);
            xFinal--;
            yFinal--;
            xFinal += getLargura() / 2;
            yFinal += getAltura() / 2;
            if(xFinal < 0 || yFinal < 0 ||
               xFinal >= buffered.getWidth() || yFinal >= buffered.getHeight())
                return;
            saida.setRGB(xFinal, yFinal, p.cor.getRGB());
        });
        return new Imagem(saida);
    }
    
    public Imagem aplicaMatrizMorfologia(int[][] kernel, Comparator<Integer> comp){
        BufferedImage saida = new BufferedImage(buffered.getWidth(), buffered.getHeight(), BufferedImage.TYPE_INT_RGB);
        
        int xInicial = kernel.length / 2;
        int xFinal = buffered.getWidth() - xInicial - 1;
        int yInicial = kernel.length / 2;
        int yFinal = buffered.getHeight()- yInicial - 1;
        
        percorrePixelsImagem(p -> {
            if (p.x < xInicial || p.x > xFinal) return;
            if (p.y < yInicial || p.y > yFinal) return;
            int compared = 0;
            int soma;
            for (int x = 0; x < kernel.length; x++) {
                for (int y = 0; y < kernel.length; y++) {
                    if( x == 0 && y == 0) compared = getPixel(p.x + ( x - kernel.length / 2 ), p.y + ( y - kernel.length / 2 ))
                            .getEscalaCinza() + kernel[x][y];
                    if(kernel[x][y] < 0) continue;
                    soma = getPixel(p.x + ( x - kernel.length / 2 ), p.y + ( y - kernel.length / 2 ))
                            .getEscalaCinza() + kernel[x][y];
                    if(comp.compare(soma, compared) > 0) compared = soma;
                }
            }
            if(compared > 255) compared = 255;
            if(compared < 0) compared = 0;
            for (int x = 0; x < kernel.length; x++) {
                for (int y = 0; y < kernel.length; y++) {
                    if(kernel[x][y] < 0) continue;
                    saida.setRGB(p.x + ( x - kernel.length / 2 ), p.y + ( y - kernel.length / 2 ), 
                            new Color(compared, compared, compared).getRGB());
                }
            }
        });
        return new Imagem(saida);
    }
    
    public Imagem aplicaMatrizConvolucao(double[][] kernel, int suavizar){
        BufferedImage saida = new BufferedImage(buffered.getWidth(), buffered.getHeight(), BufferedImage.TYPE_INT_RGB);
        
        int xInicial = kernel.length / 2;
        int xFinal = buffered.getWidth() - xInicial - 1;
        int yInicial = kernel.length / 2;
        int yFinal = buffered.getHeight()- yInicial - 1;
        
        percorrePixelsImagem(p -> {
            if (p.x < xInicial || p.x > xFinal) return;
            if (p.y < yInicial || p.y > yFinal) return;
            double soma = 0;
            for (int x = 0; x < kernel.length; x++) {
                for (int y = 0; y < kernel.length; y++) {
                    soma += getPixel(p.x + ( x - kernel.length / 2 ), p.y + ( y - kernel.length / 2 ))
                            .getEscalaCinza() * kernel[x][y];
                }
            }
            int resultado = (int)(soma);
            resultado = Math.abs(resultado);
            if(suavizar > 1) resultado /= suavizar;
            if(resultado > 255) resultado = 255;
            saida.setRGB(p.x, p.y, new Color(resultado, resultado, resultado).getRGB());
            
        });
        return new Imagem(saida);
    }
    
    public Imagem aplicaFiltroMediana(){
        BufferedImage saida = new BufferedImage(buffered.getWidth(), buffered.getHeight(), BufferedImage.TYPE_INT_RGB);
        
        int xInicial = 1;
        int xFinal = buffered.getWidth() - 2;
        int yInicial = 1;
        int yFinal = buffered.getHeight()- 2;
        percorrePixelsImagem(p -> {
            if (p.x < xInicial || p.x > xFinal) return;
            if (p.y < yInicial || p.y > yFinal) return;
            List<Integer> valores = new ArrayList<>();
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    valores.add(getPixel(p.x + ( x - 1 ), p.y + ( y - 1 )).getEscalaCinza());
                }
            }
            Collections.sort(valores);
            int resultado = valores.get(4);
            saida.setRGB(p.x, p.y, new Color(resultado, resultado, resultado).getRGB());
        });
        return new Imagem(saida);
    }
    
    public Pixel getPixel(Coordenadas coord){
        return getPixel(coord.x, coord.y);
    }
    
    public Pixel getPixel(int x, int y){
        return new Pixel(buffered.getRGB(x, y), x, y);
    }
    
    public boolean temTop(Coordenadas coord){
        return coord.y > 0;
    }
    public boolean temBot(Coordenadas coord){
        return coord.y < altura - 1;
    }
    public boolean temLeft(Coordenadas coord){
        return coord.x > 0;
    }
    public boolean temRight(Coordenadas coord){
        return coord.x < largura - 1;
    }
    
}
