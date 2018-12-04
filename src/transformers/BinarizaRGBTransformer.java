/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformers;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import model.Imagem;

/**
 *
 * @author ivoaf
 */
public class BinarizaRGBTransformer extends Transformer{

    private int r;
    private int g;
    private int b;
    
    public BinarizaRGBTransformer(Imagem i) {
        super(i);
    }
    
    public Imagem transform(int inferior, int superior){
        return new Imagem(this.go());
    }

    @Override
    public Imagem transform() {
        r = getInputValue("r");
        g = getInputValue("g");
        b = getInputValue("b");
        return new Imagem(this.go());
    }
    
    @Override
    protected BufferedImage go() {
        BufferedImage saida = new BufferedImage(input.getLargura(), input.getAltura(), BufferedImage.TYPE_INT_RGB);
        input.percorrePixelsImagem(p -> {
            int newRed, newGreen, newBlue;
            if(p.cor.getRed() < r)
                newRed = 0;
            else
                newRed = 255;
            if(p.cor.getGreen() < g)
                newGreen = 0;
            else
                newGreen = 255;
            if(p.cor.getBlue() < b)
                newBlue = 0;
            else
                newBlue = 255;
            saida.setRGB(p.x, p.y, new Color(newRed, newGreen, newBlue).getRGB());
        });
        return saida;
    }

    @Override
    public String[] getInputValuesNames() {
        return new String[]{
            "r",
            "g",
            "b",
        };
    }
}
