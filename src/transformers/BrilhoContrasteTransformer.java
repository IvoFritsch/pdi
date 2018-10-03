/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformers;

import java.awt.Color;
import java.awt.image.BufferedImage;
import model.Imagem;

/**
 *
 * @author ivoaf
 */
public class BrilhoContrasteTransformer extends Transformer{

    public BrilhoContrasteTransformer(Imagem i) {
        super(i);
    }
    
    @Override
    public Imagem transform(){
        return new Imagem(this.go());
    }
    
    @Override
    protected BufferedImage go() {
        int brilho = getInputValue("brilho");
        double contraste = getInputValue("contraste(%)") / 100.0;
        BufferedImage saida = new BufferedImage(input.getLargura(), input.getAltura(), BufferedImage.TYPE_INT_RGB);
        input.percorrePixelsImagem(p -> {
            double newRed = p.cor.getRed() * contraste + brilho;
            double newGreen = p.cor.getGreen() * contraste + brilho;
            double newBlue = p.cor.getBlue() * contraste + brilho;
            
            newRed = newRed > 255 ? 255 : newRed;
            newGreen = newGreen > 255 ? 255 : newGreen;
            newBlue = newBlue > 255 ? 255 : newBlue;
            
            newRed = newRed < 0 ? 0 : newRed;
            newGreen = newGreen < 0 ? 0 : newGreen;
            newBlue = newBlue < 0 ? 0 : newBlue;
            saida.setRGB(p.x, p.y, new Color((int)newRed, (int)newGreen, (int)newBlue).getRGB());
        });
        return saida;
    }

    @Override
    public String[] getInputValuesNames() {
        return new String[]{
            "brilho",
            "contraste(%)"
        };
    }
    
}
