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
public class DilatacaoTransformer extends Transformer{

    public DilatacaoTransformer(Imagem i) {
        super(i);
    }
    
    @Override
    public Imagem transform(){
        
        Imagem img = input.aplicaMatrizMorfologia(
            new int[][]{
            {-1,  10, -1},
            {10, 10, 10},
            {-1,  10, -1}}, (x, y) -> x - y);
        
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
