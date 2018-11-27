/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformers;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import model.Coordenadas;
import model.Imagem;
import model.Pixel;

/**
 *
 * @author ivoaf
 */
public class PreenchimentoTransformer extends Transformer{

    private int x;
    private int y;
    private int cor;
    private int corBase;
    public  Integer pixelsPintados;
    private Stack<Coordenadas> marcados = new Stack<>();
    private Set<Coordenadas>  processar = new HashSet<>();
    
    public PreenchimentoTransformer(Imagem i) {
        super(i);
    }
    
    public Imagem transform(int inferior, int superior){
        return new Imagem(this.go());
    }

    @Override
    public Imagem transform() {
        x = getInputValue("X");
        y = getInputValue("Y");
        cor = getInputValue("cor");
        return new Imagem(this.go());
    }
    
    @Override
    protected BufferedImage go() {
        pixelsPintados = 0;
        corBase = input.getPixel(x, y).getEscalaCinza();
        marcados.push(new Coordenadas(x, y));
        while(!marcados.isEmpty()){
            Coordenadas n = marcados.peek();
            processar.add(n);
            marcados.pop();
            if (input.temLeft(n) && input.getPixel(n.left()).getEscalaCinza() == corBase) {
                if(!processar.contains(n.left()))
                    marcados.push(n.left());
            }
            if (input.temRight(n) && input.getPixel(n.right()).getEscalaCinza() == corBase) {
                if(!processar.contains(n.right()))
                    marcados.push(n.right());
            }
            if (input.temTop(n) && input.getPixel(n.top()).getEscalaCinza() == corBase) {
                if(!processar.contains(n.top()))
                    marcados.push(n.top());
            }
            if (input.temBot(n) && input.getPixel(n.bot()).getEscalaCinza() == corBase) {
                if(!processar.contains(n.bot()))
                    marcados.push(n.bot());
            }
        }
        BufferedImage saida = ((Imagem)input.clone()).getBuffered();
        processar.forEach(c -> {
            saida.setRGB(c.x, c.y, new Color(cor, cor, cor).getRGB());
            pixelsPintados++;
        });
        return saida;
    }
    
    
    private void marcaVizinhos(Coordenadas coord){
        if(processar.contains(coord)) return;
        processar.add(coord);
        Coordenadas testar;
        if(coord.x > 0){
            testar = new Coordenadas(coord.x-1, coord.y);
            if(input.getPixel(testar).getEscalaCinza() == corBase){
                marcados.add(testar);
                marcaVizinhos(testar);
            }
        }
        if(coord.y > 0){
            testar = new Coordenadas(coord.x, coord.y-1);
            if(input.getPixel(testar).getEscalaCinza() == corBase){
                marcados.add(testar);
                marcaVizinhos(testar);
            }
        }
        if(coord.x < input.getLargura() - 1){
            testar = new Coordenadas(coord.x+1, coord.y);
            if(input.getPixel(testar).getEscalaCinza() == corBase){
                marcados.add(testar);
                marcaVizinhos(testar);
            }
        }
        if(coord.y < input.getAltura() - 1){
            testar = new Coordenadas(coord.x, coord.y+1);
            if(input.getPixel(testar).getEscalaCinza() == corBase){
                marcados.add(testar);
                marcaVizinhos(testar);
            }
        }
    }
    
    @Override
    public String[] getInputValuesNames() {
        return new String[]{
            "X",
            "Y",
            "cor"
        };
    }
}
