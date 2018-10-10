/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Imagem;
import transformers.BinarizaImagemTransformer;
import transformers.BordaSobelTransformer;
import transformers.BrilhoContrasteTransformer;
import transformers.CropValoresTransformer;
import transformers.EscalaCinzaTransformer;
import transformers.EspelhaImagemTransformer;
import transformers.FiltraCanaisTransformer;
import transformers.InverteCoresTransformer;
import transformers.MediaTransformer;
import transformers.ReescalaImagemTransformer;
import transformers.RotacionaImagemTransformer;
import transformers.TransladaImagemTransformer;
import transformers.Transformer;

/**
 *
 * @author 0186779
 */
public class Tela extends javax.swing.JFrame {

    private Imagem imgEntrada = null;
    private Imagem imgTransformada = null;
    
    /**
     * Creates new form Tela
     */
    public Tela() {
        initComponents();
        escondeCampoValor1();
        escondeCampoValor2();
        escondeCampoValor3();
        escondeCampoValor4();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        labelImgEntrada = new javax.swing.JLabel();
        verImgInfo = new javax.swing.JButton();
        labelImgSaida = new javax.swing.JLabel();
        btnTrocarImgs = new javax.swing.JButton();
        comboEfeito = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnAplicarEfeito = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbCanalBlue = new javax.swing.JCheckBox();
        cbCanalRed = new javax.swing.JCheckBox();
        cbCanalGreen = new javax.swing.JCheckBox();
        btnAplicarCanais = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        labelValor1 = new javax.swing.JLabel();
        labelValor2 = new javax.swing.JLabel();
        campoValor1 = new javax.swing.JSpinner();
        campoValor2 = new javax.swing.JSpinner();
        labelValor3 = new javax.swing.JLabel();
        labelValor4 = new javax.swing.JLabel();
        campoValor3 = new javax.swing.JSpinner();
        campoValor4 = new javax.swing.JSpinner();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnCarregarImagem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnSobre = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ivo Fritsch & Lucas Land - PDI");
        setLocation(new java.awt.Point(150, 150));

        labelImgEntrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImgEntrada.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        verImgInfo.setText("Ver informações da imagem de saída");
        verImgInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verImgInfoActionPerformed(evt);
            }
        });

        labelImgSaida.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnTrocarImgs.setText("<html>&lt;-<br />-&gt;</html>");
        btnTrocarImgs.setToolTipText("Inverter entrada e saída.");
        btnTrocarImgs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrocarImgsActionPerformed(evt);
            }
        });

        comboEfeito.setMaximumRowCount(15);
        comboEfeito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ECZ - Escala de cinza", "ICR - Inverte cores da imagem", "CVL - Cropa valores abaixo/acima de uma faixa", "BIN - Binariza a imagem", "TRL - Translada/Move a imagem", "ARI - Amplia/Reduz imagem", "ROT - Rotaciona imagem", "ESP - Espelha a imagem", "BRC - Altera o brilho e contraste", "MED - Aplica média na imagem", "ROB - Detector de borda Sobel" }));
        comboEfeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEfeitoActionPerformed(evt);
            }
        });

        jLabel1.setText("Aplicar efeito:");

        btnAplicarEfeito.setText("Aplicar efeito ->");
        btnAplicarEfeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarEfeitoActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecionar canais:");

        cbCanalBlue.setSelected(true);
        cbCanalBlue.setText("Azul (B)");

        cbCanalRed.setSelected(true);
        cbCanalRed.setText("Vermelho (R)");

        cbCanalGreen.setSelected(true);
        cbCanalGreen.setText("Verde (G)");

        btnAplicarCanais.setText("Aplicar canais ->");
        btnAplicarCanais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarCanaisActionPerformed(evt);
            }
        });

        jLabel3.setText("Entrada:");

        jLabel4.setText("Saida:");

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelValor1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelValor1.setText("Valor 1:");

        labelValor2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelValor2.setText("Valor 2:");

        labelValor3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelValor3.setText("Valor 3:");

        labelValor4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelValor4.setText("Valor 4:");

        jLayeredPane1.setLayer(labelValor1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(labelValor2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(campoValor1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(campoValor2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(labelValor3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(labelValor4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(campoValor3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(campoValor4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(labelValor2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoValor2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(labelValor1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoValor1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(labelValor4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoValor4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(labelValor3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoValor3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValor1)
                    .addComponent(campoValor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelValor3)
                    .addComponent(campoValor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValor2)
                    .addComponent(campoValor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelValor4)
                    .addComponent(campoValor4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setText(" Arquivo");

        btnCarregarImagem.setText("Carregar imagem");
        btnCarregarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarImagemActionPerformed(evt);
            }
        });
        jMenu1.add(btnCarregarImagem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sobre");

        btnSobre.setText("Sobre");
        btnSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSobreActionPerformed(evt);
            }
        });
        jMenu2.add(btnSobre);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(37, 37, 37)
                                .addComponent(comboEfeito, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cbCanalRed)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbCanalGreen)
                                .addGap(7, 7, 7)
                                .addComponent(cbCanalBlue)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAplicarEfeito, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAplicarCanais))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(labelImgEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(btnTrocarImgs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelImgSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(6, 10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(verImgInfo)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboEfeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAplicarEfeito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAplicarCanais)
                            .addComponent(jLabel2)
                            .addComponent(cbCanalBlue)
                            .addComponent(cbCanalRed)
                            .addComponent(cbCanalGreen)))
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelImgSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelImgEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnTrocarImgs, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verImgInfo)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verImgInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verImgInfoActionPerformed
        if(imgTransformada == null) return;
        JOptionPane.showMessageDialog(this,
            "Largura x Altura: "+imgTransformada.getAltura()+" x "+imgTransformada.getLargura()+
                    "\nMédia de cinza: "+ imgTransformada.getMediaCinza()+
                    "\nVariancia de cinza: "+ imgTransformada.getVarianciaCinza()+
                    "\nMediana de cinza: "+ imgTransformada.getMedianaCinza()+
                    "\nModa de cinza: "+ imgTransformada.getModaCinza(),
            "Informações da imagem",
            JOptionPane.INFORMATION_MESSAGE);        // TODO add your handling code here:
    }//GEN-LAST:event_verImgInfoActionPerformed

    private void btnTrocarImgsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrocarImgsActionPerformed
        Imagem aux = imgEntrada;
        setImagemEntrada(imgTransformada);
        setImagemTransformada(aux);
    }//GEN-LAST:event_btnTrocarImgsActionPerformed

    private void btnAplicarEfeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarEfeitoActionPerformed
        if(imgEntrada == null) return;
        Transformer transformerToUse = getSelectedTransformer();
        if(transformerToUse == null) return;
        populaTransformerComInputValues(transformerToUse);
        Imagem resultado = transformerToUse.transform();
        if(resultado == null) return;
        setImagemTransformada(resultado);
    }//GEN-LAST:event_btnAplicarEfeitoActionPerformed

    private void populaTransformerComInputValues(Transformer transformer){
        String[] inputValuesNames = transformer.getInputValuesNames();
        if(inputValuesNames == null) return;
        if(inputValuesNames.length > 0)
            transformer.setInputValue(inputValuesNames[0], (Integer)campoValor1.getValue());
        if(inputValuesNames.length > 1)
            transformer.setInputValue(inputValuesNames[1], (Integer)campoValor2.getValue());
        if(inputValuesNames.length > 2)
            transformer.setInputValue(inputValuesNames[2], (Integer)campoValor3.getValue());
        if(inputValuesNames.length > 3)
            transformer.setInputValue(inputValuesNames[3], (Integer)campoValor4.getValue());
    }
    
    private Transformer getSelectedTransformer(){
        if(imgEntrada == null) return null;
        switch(comboEfeito.getSelectedItem().toString().substring(0, 3)){
            case "ECZ":
                return imgEntrada.getTransformer(EscalaCinzaTransformer.class);
            case "ICR":
                return imgEntrada.getTransformer(InverteCoresTransformer.class);
            case "CVL":
                return imgEntrada.getTransformer(CropValoresTransformer.class);
            case "BIN":
                return imgEntrada.getTransformer(BinarizaImagemTransformer.class);
            case "TRL":
                return imgEntrada.getTransformer(TransladaImagemTransformer.class);
            case "ARI":
                return imgEntrada.getTransformer(ReescalaImagemTransformer.class);
            case "ROT":
                return imgEntrada.getTransformer(RotacionaImagemTransformer.class);
            case "ESP":
                return imgEntrada.getTransformer(EspelhaImagemTransformer.class);
            case "BRC":
                return imgEntrada.getTransformer(BrilhoContrasteTransformer.class);
            case "MED":
                return imgEntrada.getTransformer(MediaTransformer.class);
            case "ROB":
                return imgEntrada.getTransformer(BordaSobelTransformer.class);
            default:
                return null;
        }
        
    }
    
    
    private void btnAplicarCanaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarCanaisActionPerformed
        if(imgEntrada == null) return;
        FiltraCanaisTransformer transformer = imgEntrada.getTransformer(FiltraCanaisTransformer.class);
        transformer.setInputValue("r", cbCanalRed.isSelected() ? 1 : 0);
        transformer.setInputValue("g", cbCanalGreen.isSelected() ? 1 : 0);
        transformer.setInputValue("b", cbCanalBlue.isSelected() ? 1 : 0);
        setImagemTransformada(transformer.transform());
    }//GEN-LAST:event_btnAplicarCanaisActionPerformed

    private void btnCarregarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarImagemActionPerformed
        Imagem imagemEscolhida = Imagem.escolheImagem(); 
        if(imagemEscolhida == null) return;
        setImagemEntrada(imagemEscolhida);
    }//GEN-LAST:event_btnCarregarImagemActionPerformed

    private void btnSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSobreActionPerformed
        JOptionPane.showMessageDialog(this,
            "Trabalho prático\nProcessamento Digital de Imagens\n"
                    + "Ivo Averbeck Fritsch - 0186779\n"
                + "Lucas Land - 0106360",
            "Sobre",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnSobreActionPerformed

    private void comboEfeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEfeitoActionPerformed
        escondeCampoValor1();
        escondeCampoValor2();
        escondeCampoValor3();
        escondeCampoValor4();
        
        Transformer selectedTransformer = getSelectedTransformer();
        if(selectedTransformer == null) return;
        String[] inputValuesNames = selectedTransformer.getInputValuesNames();
        if(inputValuesNames == null) return;
        if(inputValuesNames.length > 0)
            exibeCampoValor1(inputValuesNames[0]);
        if(inputValuesNames.length > 1)
            exibeCampoValor2(inputValuesNames[1]);
        if(inputValuesNames.length > 2)
            exibeCampoValor3(inputValuesNames[2]);
        if(inputValuesNames.length > 3)
            exibeCampoValor4(inputValuesNames[3]);
    }//GEN-LAST:event_comboEfeitoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    public void setImagemEntrada(Imagem i) {
        this.imgEntrada = i;
        labelImgEntrada.setIcon(null);
        if(i != null)
            labelImgEntrada.setIcon(new ImageIcon(this.imgEntrada.getBuffered().
                    getScaledInstance(labelImgEntrada.getWidth(), labelImgEntrada.getHeight(),
                    Image.SCALE_SMOOTH)));
        comboEfeitoActionPerformed(null);
    }
    
    public void setImagemTransformada(Imagem i) {
        this.imgTransformada = i;
        labelImgSaida.setIcon(null);
        if(i != null)
            labelImgSaida.setIcon(new ImageIcon(this.imgTransformada.getBuffered().
                    getScaledInstance(labelImgSaida.getWidth(), labelImgSaida.getHeight(),
                    Image.SCALE_SMOOTH)));
    }

    public void exibeCampoValor1(String titulo){
        labelValor1.setText(titulo.substring(0, 1).toUpperCase() + titulo.substring(1)+":");
        labelValor1.setVisible(true);
        campoValor1.setVisible(true);
    }
    
    public final void escondeCampoValor1(){
        labelValor1.setVisible(false);
        campoValor1.setVisible(false);
    }
    
    public void exibeCampoValor2(String titulo){
        labelValor2.setText(titulo.substring(0, 1).toUpperCase() + titulo.substring(1)+":");
        labelValor2.setVisible(true);
        campoValor2.setVisible(true);
    }
    
    public final void escondeCampoValor2(){
        labelValor2.setVisible(false);
        campoValor2.setVisible(false);
    }
    public void exibeCampoValor3(String titulo){
        labelValor3.setText(titulo.substring(0, 1).toUpperCase() + titulo.substring(1)+":");
        labelValor3.setVisible(true);
        campoValor3.setVisible(true);
    }
    
    public final void escondeCampoValor3(){
        labelValor3.setVisible(false);
        campoValor3.setVisible(false);
    }
    public void exibeCampoValor4(String titulo){
        labelValor4.setText(titulo.substring(0, 1).toUpperCase() + titulo.substring(1)+":");
        labelValor4.setVisible(true);
        campoValor4.setVisible(true);
    }
    
    public final void escondeCampoValor4(){
        labelValor4.setVisible(false);
        campoValor4.setVisible(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarCanais;
    private javax.swing.JButton btnAplicarEfeito;
    private javax.swing.JMenuItem btnCarregarImagem;
    private javax.swing.JMenuItem btnSobre;
    private javax.swing.JButton btnTrocarImgs;
    private javax.swing.JSpinner campoValor1;
    private javax.swing.JSpinner campoValor2;
    private javax.swing.JSpinner campoValor3;
    private javax.swing.JSpinner campoValor4;
    private javax.swing.JCheckBox cbCanalBlue;
    private javax.swing.JCheckBox cbCanalGreen;
    private javax.swing.JCheckBox cbCanalRed;
    private javax.swing.JComboBox<String> comboEfeito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel labelImgEntrada;
    private javax.swing.JLabel labelImgSaida;
    private javax.swing.JLabel labelValor1;
    private javax.swing.JLabel labelValor2;
    private javax.swing.JLabel labelValor3;
    private javax.swing.JLabel labelValor4;
    private javax.swing.JButton verImgInfo;
    // End of variables declaration//GEN-END:variables
}
