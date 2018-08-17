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
public abstract class Transformer {

    protected Imagem input;
    
    public Transformer(Imagem input) {
        this.input = input;
    }
    
    protected abstract BufferedImage go();
}
