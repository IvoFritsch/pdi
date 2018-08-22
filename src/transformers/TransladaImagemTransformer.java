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
public class TransladaImagemTransformer extends Transformer{

    public TransladaImagemTransformer(Imagem i) {
        super(i);
    }
    
    @Override
    public Imagem transform(){
        int x = getInputValue("x");
        int y = getInputValue("y");
        return input.aplicaMatrizImagem(
                new double[][]{
                    {1,  0, 0}, 
                    {0,  1, 0}, 
                    {x,  y, 1}});
    }
    
    @Override
    protected BufferedImage go() {
        return null;
    }
    
    @Override
    public String[] getInputValuesNames() {
        return new String[]{"x", "y"};
        
    }
    
}
