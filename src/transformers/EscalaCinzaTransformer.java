/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformers;

import java.awt.image.BufferedImage;
import model.Imagem;

/**
 *
 * @author ivoaf
 */
public class EscalaCinzaTransformer extends Transformer{

    public EscalaCinzaTransformer(Imagem i) {
        super(i);
    }
    
    @Override
    public Imagem transform(){
        return new Imagem(this.go());
    }
    
    @Override
    protected BufferedImage go() {
        BufferedImage saida = new BufferedImage(input.getLargura(), input.getAltura(), BufferedImage.TYPE_INT_RGB);
        
        input.percorrePixelsImagem(p -> saida.setRGB(p.x, p.y, p.getEscalaCinzaRGB()));
        return saida;
    }

    @Override
    public String[] getInputValuesNames() {
        return null;
    }
    
}
