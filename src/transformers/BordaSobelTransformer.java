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
public class BordaSobelTransformer extends Transformer{

    public BordaSobelTransformer(Imagem i) {
        super(i);
    }
    
    @Override
    public Imagem transform(){
        
        Imagem img1 = input.aplicaMatrizConvolucao(
                new double[][]{
                    {1,  0, -1},
                    {2, 0, -2},
                    {1,  0, -1}}
        );
        Imagem img2 = input.aplicaMatrizConvolucao(
                new double[][]{
                    {1,  2, 1},
                    {0,  0, 0},
                    {-1,  -2, -1}}
        );
        BufferedImage saida = new BufferedImage(img1.getLargura(), img1.getAltura(), BufferedImage.TYPE_INT_RGB);
        img1.percorrePixelsImagem(p -> {
            if(p.x < 1 || p.x > img1.getLargura()-1) return;
            if(p.y < 1 || p.y > img1.getAltura()-1) return;
            int resultado = (int)Math.sqrt(Math.pow(p.getEscalaCinza(), 2) + Math.pow(img2.getPixel(p.x, p.y).getEscalaCinza(), 2));
            saida.setRGB(p.x, p.y, new Color(resultado, resultado, resultado).getRGB());
        });
        
        return new Imagem(saida);
        
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
