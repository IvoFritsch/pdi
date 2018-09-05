/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.image.BufferedImage;

/**
 *
 * @author 0186779
 */
public class Utils {
    
    public static BufferedImage aplicaMatrizImagem(BufferedImage inp, double[][] matriz){
        
        BufferedImage saida = new BufferedImage(inp.getWidth(), inp.getHeight(), BufferedImage.TYPE_INT_RGB);
        
        Imagem imagem = new Imagem(inp);
        imagem.percorrePixelsImagem(p -> {
            
            int xFinal = (int)(matriz[0][0] * (p.x - inp.getWidth() / 2) + matriz[0][1] * (p.x - inp.getWidth() / 2));
            int yFinal = (int)(matriz[1][0] * (p.y - inp.getHeight()/ 2) + matriz[1][1] * (p.y - inp.getHeight()/ 2));
            saida.setRGB(xFinal, yFinal, p.cor.getRGB());
        });
        return saida;
    }
    
}
