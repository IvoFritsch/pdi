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
public class FiltraCanaisTransformer extends Transformer{

    private boolean r; 
    private boolean g; 
    private boolean b;
    
    public FiltraCanaisTransformer(Imagem i) {
        super(i);
    }
    
    @Override
    public Imagem transform(){
        r = getInputValue("r") != 0;
        g = getInputValue("g") != 0;
        b = getInputValue("b") != 0;
        return new Imagem(this.go());
    }
    
    @Override
    protected BufferedImage go() {
        BufferedImage saida = new BufferedImage(input.getLargura(), input.getAltura(), BufferedImage.TYPE_INT_RGB);
        
        input.percorrePixelsImagem(p -> saida.setRGB(p.x, p.y, p.getCanaisFiltradosRGB(r, g, b)));
        return saida;
    }

    @Override
    public String[] getInputValuesNames() {
        
        return new String[]{
            "r",
            "g",
            "b"
        };
    }
    
}
