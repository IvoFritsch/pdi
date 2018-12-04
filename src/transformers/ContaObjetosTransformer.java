/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformers;

import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import model.Imagem;

/**
 *
 * @author ivoaf
 */
public class ContaObjetosTransformer extends Transformer{

    private int tamMinimo;
    private int corProcurar;
    private int corPintar;
    public Integer qtdObjs;
    
    public ContaObjetosTransformer(Imagem i) {
        super(i);
    }
    
    public Imagem transform(int inferior, int superior){
        return new Imagem(this.go());
    }

    @Override
    public Imagem transform() {
        tamMinimo = getInputValue("tamanho mínimo");
        corProcurar = getInputValue("cor procurar");
        corPintar = getInputValue("cor pintar");
        return new Imagem(this.go());
    }
    
    @Override
    protected BufferedImage go() {
        Imagem current = input;
        int qtdObjs = 0;
        for(int x = 0; x < input.getLargura(); x++){
            for(int y = 0; y < input.getAltura(); y++){
                if(current.getPixel(x, y).getEscalaCinza() == corProcurar){
                    PreenchimentoTransformer transf = new PreenchimentoTransformer(current);
                    current = transf.transform(x, y, corPintar);
                    if(transf.getPixelsPintados() >= tamMinimo)
                        qtdObjs++;
                }
            }
        }
        this.qtdObjs = qtdObjs;
        return current.getBuffered();
    }

    @Override
    public String[] getInputValuesNames() {
        return new String[]{
            "cor procurar",
            "cor pintar",
            "tamanho mínimo",
        };
    }
}
