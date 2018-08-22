/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Constructor;
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
                    return f.getName().endsWith(".png") || f.isDirectory();
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
            int xPos = p.x + 1;
            int yPos = p.y + 1;
            int xFinal = (int)(matriz[0][0] * xPos + matriz[1][0] * yPos + matriz[2][0] * 1);
            int yFinal = (int)(matriz[0][1] * xPos + matriz[1][1] * yPos + matriz[2][1] * 1);
            xFinal--;
            yFinal--;
            if(xFinal < 0 || yFinal < 0 ||
               xFinal >= buffered.getWidth() || yFinal >= buffered.getHeight())
                return;
            saida.setRGB(xFinal, yFinal, p.cor.getRGB());
        });
        return new Imagem(saida);
    }
}
