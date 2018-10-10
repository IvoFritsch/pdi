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
public class MediaTransformer extends Transformer{

    public MediaTransformer(Imagem i) {
        super(i);
    }
    
    @Override
    public Imagem transform(){
        return input.aplicaMatrizConvolucao(
        new double[][]{
                    {1, 1, 1}, 
                    {1, 1, 1}, 
                    {1, 1, 1}}, true
        );
    }
    
    @Override
    protected BufferedImage go() {
        return null;
    }

    @Override
    public String[] getInputValuesNames() {
        return null;
    }
    
}
