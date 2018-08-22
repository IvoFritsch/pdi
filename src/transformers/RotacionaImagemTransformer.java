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
public class RotacionaImagemTransformer extends Transformer{

    public RotacionaImagemTransformer(Imagem i) {
        super(i);
    }
    
    @Override
    public Imagem transform(){
        int angulo = getInputValue("angulo");
        double radianos = Math.toRadians(angulo);
        return input.aplicaMatrizImagem(
                new double[][]{
                    {Math.cos(radianos),  0 - Math.sin(radianos), 0}, 
                    {Math.sin(radianos),  Math.cos(radianos)    , 0}, 
                    {                 0,                       0, 1}});
    }
    
    @Override
    protected BufferedImage go() {
        return null;
    }
    
    @Override
    public String[] getInputValuesNames() {
        return new String[]{"angulo"};
        
    }
    
}
