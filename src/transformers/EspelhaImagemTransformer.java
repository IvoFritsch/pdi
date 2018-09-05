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
public class EspelhaImagemTransformer extends Transformer{

    public EspelhaImagemTransformer(Imagem i) {
        super(i);
    }
    
    @Override
    public Imagem transform(){
        int inverteVertical = getInputValue("vertical") > 0 ? -1 : 1;
        int inverteHorizontal = getInputValue("horizontal") > 0 ? -1 : 1;
        
        return input.aplicaMatrizImagem(
        new double[][]{
                    {inverteHorizontal,  0, 0}, 
                     {0,  inverteVertical, 0}, 
                     {0,  0, 1}}
        );
    }
    
    @Override
    protected BufferedImage go() {
        return null;
    }

    @Override
    public String[] getInputValuesNames() {
        return new String[]{"vertical", "horizontal"};
    }
    
}
