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
public class TrabalhoBotanicaTransformer extends Transformer{
    
    public TrabalhoBotanicaTransformer(Imagem i) {
        super(i);
    }
    
    public Imagem transform(int inferior, int superior){
        return new Imagem(this.go());
    }

    @Override
    public Imagem transform() {
        return new Imagem(this.go());
    }
    
    @Override
    protected BufferedImage go() {
        ContaObjetosTransformer contadorManchas = (ContaObjetosTransformer)input.getTransformer(BinarizaRGBTransformer.class).set("r", 128).set("g", 128).set("b", 128).transform()
                .getTransformer(TransladaImagemTransformer.class).set("y", 270).transform()
                .getTransformer(PreenchimentoTransformer.class).set("cor", 255).transform()
                .getTransformer(BinarizaImagemTransformer.class).set("threshold", 150).transform()
                .getTransformer(ContaObjetosTransformer.class).set("cor pintar", 100).set("tamanho mínimo",20);
        Imagem retorno = contadorManchas.transform();
        int qtdManchas =  contadorManchas.qtdObjs;
        String contaminacao = "Não encontrado";
        String tratamento = "Não encontrado";
        if(qtdManchas == 1){
            contaminacao = "Inicial";
            tratamento = "Chá de alho.";
        } else if (qtdManchas == 2 || qtdManchas == 3){
            contaminacao = "Média";
            tratamento = "Pó de calcário dissolvido em 1 litro de água.";
        } else if (qtdManchas > 3){
            contaminacao = "Grave";
            tratamento = "Pulverizar a planta com aerosol anti-ferrugem.";
        }
        
        String alert = String.format("Manchas encontradas: %d\n"
                + "Contaminação: %s\n"
                + "Tratamento: %s", qtdManchas,contaminacao, tratamento);
        
        JOptionPane.showMessageDialog(null, alert);
        
        return retorno.getBuffered();
    }

    @Override
    public String[] getInputValuesNames() {
        return null;
    }
}
