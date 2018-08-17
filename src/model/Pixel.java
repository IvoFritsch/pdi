/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;

/**
 *
 * @author ivoaf
 */
public class Pixel {
    public final Color cor;
    public final int x;
    public final int y;

    public Pixel(int rgb, int x, int y) {
        this.cor = new Color(rgb);
        this.x = x;
        this.y = y;
    }
    
    public int getEscalaCinza(){
        return (cor.getBlue() + cor.getGreen() + cor.getRed()) / 3;
    }
    
    public int getEscalaCinzaRGB(){
        int cinza = (cor.getBlue() + cor.getGreen() + cor.getRed()) / 3;
        return new Color(cinza, cinza, cinza).getRGB();
    }
    
    public int getCanaisFiltradosRGB(boolean r, boolean g, boolean b){
        return new Color(
                    r ? cor.getRed() : 0, 
                    g ? cor.getGreen(): 0, 
                    b ? cor.getBlue(): 0
                ).getRGB();
    }
}
