/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TELA;

import BEAN.Lotes_bean;
import CONEXAO.Conexao;
import DAO.Lotes_dao;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Samsung
 */
public class Jcadastrar_lote extends javax.swing.JFrame {

     private Conexao conexao;
     private Connection conn;
    
    
     public void conexao_cadastrar(){
     this.conexao = new Conexao();
     this.conn = this.conexao.Bd_Conexao();
     }
     
     public void update_l(){
   
         
        String sql = "update lote set l_produto = ?, quantidade = ?, valor = ?, "
                + "alocacao = ?, data_v = ?, fornecedor = ? "
               + "where lote = ?;";
        try {
            PreparedStatement pst = this.conn.prepareStatement(sql);
           // pst.setString(1, Caixa_produto.getText());
           // pst.setString(2, Caixa_quantidade.getText());
           // pst.setString(3, Caixa_valor.getText());
            pst.setInt(4, Integer.parseInt(Caixa_alocacao.getText()));
           // pst.setString(5, Caixa_data.getText()); 
           // pst.setInt(6, Integer.parseInt(Caixa_fornecedor.getText()));
            pst.setInt(7, Integer.parseInt(Caixa_codigo.getText()));
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Lote atualizado com sucesso");
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Erro em  UPDATE lote");
        }  
    }
     
     public void consultar (){
    
        String sql = "select * from lote where lote = ?; ";
        ResultSet rs;
        
        try { 
            PreparedStatement pst3 = this.conn.prepareStatement(sql);
            pst3.setString(1, Caixa_codigo.getText());
            rs = pst3.executeQuery();
            
            if (rs.next()) {
                
              Caixa_produto.setText(rs.getString(2));
              Caixa_quantidade.setText(rs.getString(3));
              Caixa_valor.setText(rs.getString(4));
              Caixa_alocacao.setText(rs.getString(5));
              Caixa_data.setText(rs.getString(6));
              Caixa_fornecedor.setText(rs.getString(7));
           
             
              
                
                
            } else {
                JOptionPane.showMessageDialog(null,"Lote não encontrado");
                
              Caixa_produto.setText(null);
              Caixa_quantidade.setText(null);
              Caixa_valor.setText(null);
              Caixa_alocacao.setText(null);
              Caixa_data.setText(null);
              Caixa_fornecedor.setText(null);
            }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em metodo CONSULTAR Lote");
           
        }
    }
     
     
     public void delete(){
        
        int confirmar;
        String message = "Deseja realmente remover este lote?";
        
        confirmar = JOptionPane.showConfirmDialog(null, message);
       
        
        if(confirmar == JOptionPane.YES_OPTION){
            
        String sql = "delete from lote where lote = ?";
        try {
             PreparedStatement pst = this.conn.prepareStatement(sql);
             pst.setString(1, Caixa_codigo.getText());
             pst.executeUpdate();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em metodo DELETE de lote");
        }
    } else if(confirmar == JOptionPane.NO_OPTION) {
     dispose();
        }
    }
     
     
    
    public Jcadastrar_lote(){
        initComponents();
        conexao_cadastrar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Botton_cadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Caixa_produto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Caixa_quantidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Caixa_data = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Caixa_valor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Caixa_alocacao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Caixa_fornecedor = new javax.swing.JTextField();
        Botton_cancelar = new javax.swing.JButton();
        titulo1 = new javax.swing.JLabel();
        titulo2 = new javax.swing.JLabel();
        Botton_deletar = new javax.swing.JButton();
        Codigo = new javax.swing.JLabel();
        Botton_consultar = new javax.swing.JToggleButton();
        Caixa_codigo = new javax.swing.JTextField();
        Botton_Atualizar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(700, 550));
        setMinimumSize(new java.awt.Dimension(700, 550));
        setPreferredSize(new java.awt.Dimension(700, 600));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(208, 214, 216));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 550));
        jPanel1.setLayout(null);

        Botton_cadastrar.setBackground(new java.awt.Color(208, 214, 216));
        Botton_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_salvar.png"))); // NOI18N
        Botton_cadastrar.setBorder(null);
        Botton_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_cadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_cadastrar);
        Botton_cadastrar.setBounds(480, 320, 90, 40);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Codigo do produto:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(100, 70, 130, 17);

        Caixa_produto.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_produto.setBorder(null);
        Caixa_produto.setPreferredSize(new java.awt.Dimension(0, 25));
        Caixa_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_produtoActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_produto);
        Caixa_produto.setBounds(100, 90, 150, 25);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Quantidade:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 230, 78, 17);

        Caixa_quantidade.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_quantidade.setBorder(null);
        Caixa_quantidade.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel1.add(Caixa_quantidade);
        Caixa_quantidade.setBounds(100, 250, 150, 25);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Data de validade:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(390, 230, 120, 17);

        Caixa_data.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_data.setBorder(null);
        Caixa_data.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel1.add(Caixa_data);
        Caixa_data.setBounds(390, 250, 170, 25);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Valor:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(390, 70, 40, 17);

        Caixa_valor.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_valor.setBorder(null);
        Caixa_valor.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel1.add(Caixa_valor);
        Caixa_valor.setBounds(390, 90, 170, 25);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Alocação:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(390, 150, 80, 17);

        Caixa_alocacao.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_alocacao.setBorder(null);
        Caixa_alocacao.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel1.add(Caixa_alocacao);
        Caixa_alocacao.setBounds(390, 170, 170, 25);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Codigo do fornecedor:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(100, 150, 150, 17);

        Caixa_fornecedor.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_fornecedor.setBorder(null);
        Caixa_fornecedor.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel1.add(Caixa_fornecedor);
        Caixa_fornecedor.setBounds(100, 170, 150, 25);

        Botton_cancelar.setBackground(new java.awt.Color(208, 214, 216));
        Botton_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_cancelar.png"))); // NOI18N
        Botton_cancelar.setBorder(null);
        Botton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_cancelar);
        Botton_cancelar.setBounds(380, 320, 80, 39);

        titulo1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        titulo1.setForeground(new java.awt.Color(0, 0, 0));
        titulo1.setText("Atualizar ou Deletar");
        jPanel1.add(titulo1);
        titulo1.setBounds(260, 390, 170, 22);

        titulo2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        titulo2.setForeground(new java.awt.Color(0, 0, 0));
        titulo2.setText("CADASTRO DE LOTES");
        jPanel1.add(titulo2);
        titulo2.setBounds(239, 22, 200, 22);

        Botton_deletar.setBackground(new java.awt.Color(209, 214, 216));
        Botton_deletar.setForeground(new java.awt.Color(0, 0, 0));
        Botton_deletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_deletar.png"))); // NOI18N
        Botton_deletar.setBorder(null);
        Botton_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_deletarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_deletar);
        Botton_deletar.setBounds(390, 490, 80, 40);

        Codigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Codigo.setForeground(new java.awt.Color(0, 0, 0));
        Codigo.setText("Codigo:");
        jPanel1.add(Codigo);
        Codigo.setBounds(100, 420, 60, 17);

        Botton_consultar.setBackground(new java.awt.Color(255, 255, 255));
        Botton_consultar.setForeground(new java.awt.Color(51, 51, 51));
        Botton_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/lupa.png"))); // NOI18N
        Botton_consultar.setBorder(null);
        Botton_consultar.setBorderPainted(false);
        Botton_consultar.setContentAreaFilled(false);
        Botton_consultar.setFocusCycleRoot(true);
        Botton_consultar.setFocusTraversalPolicyProvider(true);
        Botton_consultar.setRequestFocusEnabled(false);
        Botton_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_consultarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_consultar);
        Botton_consultar.setBounds(320, 440, 30, 20);

        Caixa_codigo.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_codigo.setBorder(null);
        Caixa_codigo.setPreferredSize(new java.awt.Dimension(4, 25));
        Caixa_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_codigoActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_codigo);
        Caixa_codigo.setBounds(100, 440, 249, 25);

        Botton_Atualizar.setBackground(new java.awt.Color(208, 214, 216));
        Botton_Atualizar.setForeground(new java.awt.Color(51, 51, 51));
        Botton_Atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_atualizar.png"))); // NOI18N
        Botton_Atualizar.setBorder(null);
        Botton_Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_AtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_Atualizar);
        Botton_Atualizar.setBounds(490, 490, 80, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 700, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Botton_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_cadastrarActionPerformed
        try {
            String codigo_produto, valor, quantidade, data_v, alocacao, fornecedor;
            
            codigo_produto = Caixa_produto.getText();
            valor = Caixa_valor.getText();
            quantidade = Caixa_quantidade.getText();
            data_v = Caixa_data.getText();
            alocacao = Caixa_alocacao.getText();
            fornecedor = Caixa_fornecedor.getText();
            
            Lotes_bean l_bean = new Lotes_bean();
            l_bean.setL_produto(parseInt(codigo_produto));
            l_bean.setValor(parseInt(valor));
            l_bean.setQuantidade(parseInt(quantidade));
            l_bean.setData_v(data_v);
            l_bean.setAlocacao(parseInt(alocacao));
            l_bean.setFornecedor(parseInt(fornecedor));
            
            Lotes_dao l_dao = new Lotes_dao();
            l_dao.inserir(l_bean);
            
            Caixa_produto.setText("");
            Caixa_valor.setText("");
            Caixa_quantidade.setText("");
            Caixa_data.setText("");
            Caixa_alocacao.setText("");
            Caixa_fornecedor.setText("");
            
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao cadastrar lote");
        }
        this.dispose();
    }//GEN-LAST:event_Botton_cadastrarActionPerformed

    private void Caixa_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_produtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_produtoActionPerformed

    private void Botton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_Botton_cancelarActionPerformed

    private void Caixa_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_codigoActionPerformed

    private void Botton_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_deletarActionPerformed
    delete();
    
    dispose();
    }//GEN-LAST:event_Botton_deletarActionPerformed

    private void Botton_AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_AtualizarActionPerformed
    update_l();

        dispose();
    }//GEN-LAST:event_Botton_AtualizarActionPerformed

    private void Botton_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_consultarActionPerformed
consultar();
        
    }//GEN-LAST:event_Botton_consultarActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jcadastrar_lote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jcadastrar_lote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jcadastrar_lote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jcadastrar_lote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jcadastrar_lote().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Botton_Atualizar;
    private javax.swing.JButton Botton_cadastrar;
    private javax.swing.JButton Botton_cancelar;
    private javax.swing.JToggleButton Botton_consultar;
    private javax.swing.JButton Botton_deletar;
    private javax.swing.JTextField Caixa_alocacao;
    private javax.swing.JTextField Caixa_codigo;
    private javax.swing.JTextField Caixa_data;
    private javax.swing.JTextField Caixa_fornecedor;
    private javax.swing.JTextField Caixa_produto;
    private javax.swing.JTextField Caixa_quantidade;
    private javax.swing.JTextField Caixa_valor;
    private javax.swing.JLabel Codigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo2;
    // End of variables declaration//GEN-END:variables
}
