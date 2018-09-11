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
public class ReescalaImagemTransformer extends Transformer{

    public ReescalaImagemTransformer(Imagem i) {
        super(i);
    }
    
    @Override
    public Imagem transform(){
        double x = getInputValue("x(%)") / 100.0;
        double y = getInputValue("y(%)") / 100.0;
        return input.aplicaMatrizImagem(
                new double[][]{
                    {x,  0, 0}, 
                    {0,  y, 0}, 
                    {0,  0, 1}});
    }
    
    @Override
    protected BufferedImage go() {
        return null;
    }
    
    @Override
    public String[] getInputValuesNames() {
        return new String[]{"x(%)", "y(%)"};
    }
    
}
