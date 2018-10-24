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
public class CropValoresTransformer extends Transformer{

    private int inferior;
    private int superior;
    
    public CropValoresTransformer(Imagem i) {
        super(i);
    }
    
    public Imagem transform(int inferior, int superior){
        return new Imagem(this.go());
    }

    @Override
    public Imagem transform() {
        inferior = getInputValue("inferior");
        superior = getInputValue("superior");
        return new Imagem(this.go());
    }
    
    @Override
    protected BufferedImage go() {
        BufferedImage saida = new BufferedImage(input.getLargura(), input.getAltura(), BufferedImage.TYPE_INT_RGB);
        input.percorrePixelsImagem(p -> {
            if(p.getEscalaCinza() < inferior || p.getEscalaCinza() > superior)
                saida.setRGB(p.x, p.y, 0);
            else
                saida.setRGB(p.x, p.y, new Color(p.getEscalaCinza(),p.getEscalaCinza(),p.getEscalaCinza()).getRGB());
        });
        return saida;
    }

    @Override
    public String[] getInputValuesNames() {
        return new String[]{
            "inferior",
            "superior"
        };
    }
}
