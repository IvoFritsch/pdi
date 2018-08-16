/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author 0186779
 */
public class Imagem {
    private int largura;
    private int altura;
    private double mediaCinza = -1;
    private double variancia = -1;
    private int mediana = -1;
            
    
    private BufferedImage original;
    private BufferedImage escalaCinza;

    public Imagem(BufferedImage bi) {
        this.original = bi;
        altura = bi.getHeight();
        largura = bi.getWidth();
        carregaEscalaCinza();
    }
    
    private void carregaEscalaCinza(){
        escalaCinza = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = escalaCinza.getGraphics();
        g.drawImage(original, 0, 0, null);
        g.dispose();
    }

    public BufferedImage getOriginal() {
        return original;
    }

    public BufferedImage getEscalaCinza() {
        return escalaCinza;
    }
    
    
    public static Imagem escolheImagem(){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            JFileChooser fc = new JFileChooser(System.getProperty("user.home")+"/desktop");
            fc.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().endsWith(".png");
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
        NumeroBasico soma = new NumeroBasico();
        percorrePixelsCinza(p -> soma.n += p);
        mediaCinza = soma.n / (getAltura() * getLargura());
        return mediaCinza;
    }
    
    public int[] vetorImagemCinza(){
        int[] retorno = new int[escalaCinza.getWidth() * escalaCinza.getHeight()];
        InteiroBasico cont = new InteiroBasico();
        percorrePixelsCinza(p -> {
            retorno[cont.n] = p;
            cont.n++;
        });
        return retorno;
    }    
            
    public double getVariancia(){
        if(variancia >= 0) return variancia;
        NumeroBasico soma = new NumeroBasico();
        percorrePixelsCinza(p -> {
            soma.n += (p - getMediaCinza())*(p - getMediaCinza());
        });
        variancia = soma.n / (getAltura() * getLargura());
        return variancia;
    }
    
    public int getMediana(){
        if(mediana >= 0) return mediana;
        int[] vetor = vetorImagemCinza();
        if (vetor.length % 2 == 0) {
            mediana = vetor[vetor.length / 2];
        } else {
            mediana = vetor[vetor.length / 2 + 1];
        }
        return mediana;
    }
    
    public int getModa(){
        int[] vetorCores = new int[256];
        percorrePixelsCinza(p -> {
            vetorCores[p]++;
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
    
    private void percorrePixelsCinza(Consumer<Integer> consumidor){
        
        for(int a = 0; a < getAltura(); a++)
            for (int l = 0; l < getLargura(); l++){
                Color color = new Color(escalaCinza.getRGB(l, a));
                consumidor.accept(color.getBlue());
            }
    }
    
}
