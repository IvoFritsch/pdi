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
public class GaussianoTransformer extends Transformer{

    public GaussianoTransformer(Imagem i) {
        super(i);
    }
    
    @Override
    public Imagem transform(){
        
        Imagem img = input.aplicaMatrizConvolucao(
            new double[][]{
                        {1, 2, 1}, 
                        {2, 4, 2}, 
                        {1, 2, 1}}, 16);
        
        return img;
        
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
