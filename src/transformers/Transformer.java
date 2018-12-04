/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformers;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import model.Imagem;

/**
 *
 * @author ivoaf
 */
public abstract class Transformer {

    private Map<String, Integer> inputValues = new HashMap<>();
    
    protected Imagem input;
    
    public Transformer(Imagem input) {
        this.input = input;
    }
    
    protected abstract BufferedImage go();
    
    public abstract String[] getInputValuesNames();
    
    public abstract Imagem transform();
    
    public Transformer setInputValue(String nome, int valor){
        inputValues.put(nome, valor);
        return this;
    }
    
    public Transformer set(String nome, int valor){
        inputValues.put(nome, valor);
        return this;
    }
    
    public int getInputValue(String nome){
        if(!inputValues.containsKey(nome)) return 0;
        return inputValues.get(nome);
    }
    
    
}