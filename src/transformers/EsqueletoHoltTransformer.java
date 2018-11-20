/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformers;

import java.awt.Color;
import java.awt.image.BufferedImage;
import model.Imagem;
import model.Pixel;

/**
 *
 * @author ivoaf
 */
public class EsqueletoHoltTransformer extends Transformer{
    
    private final int STEP_1 = 1;
    private final int STEP_2 = 2;
    
    
    public EsqueletoHoltTransformer(Imagem i) {
        super(i);
    }

    @Override
    public Imagem transform() {
        return new Imagem(this.go());
    }
    
    private int step = 0;
    boolean change = true;
    @Override
    protected BufferedImage go() {
        BufferedImage saida = new BufferedImage(input.getLargura(), input.getAltura(), BufferedImage.TYPE_INT_RGB);
        
        

        while (change) {
            change = false;
            step++;
            input.percorrePixelsImagem(p -> {
                if(p.isHigher()){
                    Pixel[][] pixels = pixels(input, p.x, p.y);
                    int v = calc(pixels, step);
                    //System.out.println(v+ "  "+ p.getEscalaCinza());
                    if (v != p.getEscalaCinza()) {
                        change = true;
                    }
                    saida.setRGB(p.x, p.y, new Color(v,v,v).getRGB());
                }
                
                
            });
            input = (Imagem)new Imagem(saida).clone();
            if (step == STEP_2) {
                step = 0;
            }
        }
        return saida;
    }
    
    private int calc(Pixel[][] pixels, int step) {
        int[] neighborhood = getNeighborhood(pixels);
        if (!isEdge(neighborhood)) {
            return pixels[1][1].getEscalaCinza();
        }
        Pixel n = pixels[1][0];
        Pixel l = pixels[2][1];
        Pixel s = pixels[1][2];
        Pixel o = pixels[0][1];
        if (step == STEP_1) {
            if (l.isHigher() && s.isHigher() && (n.isHigher() || o.isHigher())) {
                return pixels[1][1].getEscalaCinza();
            }
        } else if (step == STEP_2) {
            if (o.isHigher() && n.isHigher() && (s.isHigher() || l.isHigher())) {
                return pixels[1][1].getEscalaCinza();
            }
        }
        return 0;
    }

    private Pixel[][] pixels(Imagem mtz, int i, int j) {
        Pixel[][] pixels = new Pixel[3][3];
        for (int x2 = 0; x2 < 3; x2++) {
            for (int y2 = 0; y2 < 3; y2++) {
                pixels[x2][y2] = mtz.getPixel(i + x2 - 1, j + y2 - 1);
            }
        }
        return pixels;
    }
    
    private int[] getNeighborhood(Pixel[][] pixels) {
        int p2 = pixels[1][0].toZeroUm();
        int p3 = pixels[2][0].toZeroUm();
        int p4 = pixels[2][1].toZeroUm();
        int p5 = pixels[2][2].toZeroUm();
        int p6 = pixels[1][2].toZeroUm();
        int p7 = pixels[0][2].toZeroUm();
        int p8 = pixels[0][1].toZeroUm();
        int p9 = pixels[0][0].toZeroUm();
        return new int[] { p2, p3, p4, p5, p6, p7, p8, p9 };
    }
    
    private boolean isEdge(int[] neighborhood) {
        double np = neighborhood[0] + neighborhood[1] + neighborhood[2]
                + neighborhood[3] + neighborhood[4] + neighborhood[5]
                + neighborhood[6] + neighborhood[7];
        return (np >= 2 && np <= 6) && isConnected(neighborhood);
    }
    
    private boolean isConnected(int[] neighborhood) {
        int sp = (neighborhood[0] < neighborhood[1] ? 1 : 0)
                + (neighborhood[1] < neighborhood[2] ? 1 : 0)
                + (neighborhood[2] < neighborhood[3] ? 1 : 0)
                + (neighborhood[3] < neighborhood[4] ? 1 : 0)
                + (neighborhood[4] < neighborhood[5] ? 1 : 0)
                + (neighborhood[5] < neighborhood[6] ? 1 : 0)
                + (neighborhood[6] < neighborhood[7] ? 1 : 0)
                + (neighborhood[7] < neighborhood[0] ? 1 : 0);
        return sp == 1;
    }
    
    @Override
    public String[] getInputValuesNames() {
        return null;
    }
}
