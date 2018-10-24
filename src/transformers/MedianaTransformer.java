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
public class MedianaTransformer extends Transformer{

    public MedianaTransformer(Imagem i) {
        super(i);
    }
    
    @Override
    public Imagem transform(){
        
        Imagem img = input.aplicaFiltroMediana();
        
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
