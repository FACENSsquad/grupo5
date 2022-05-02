/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TELA;

import BEAN.Login_bean;
import DAO.Login_dao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author joaom
 */
public class Jlogin extends javax.swing.JFrame {

    /**
     * Creates new form Jlogin
     */
    public Jlogin() {
        initComponents();
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
        logo = new javax.swing.JLabel();
        Label_Usuario = new javax.swing.JLabel();
        Caixa_Usuario = new javax.swing.JTextField();
        Label_Senha = new javax.swing.JLabel();
        Caixa_Senha = new javax.swing.JTextField();
        Boton_Entrar = new javax.swing.JToggleButton();
        botao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(235, 235, 235));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        logo.setForeground(new java.awt.Color(0, 0, 0));
        logo.setText("MotiON");
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 12, -1, -1));

        Label_Usuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Label_Usuario.setForeground(new java.awt.Color(0, 0, 0));
        Label_Usuario.setText("Usuario");
        jPanel1.add(Label_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 118, -1, -1));

        Caixa_Usuario.setBorder(null);
        Caixa_Usuario.setOpaque(false);
        Caixa_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_UsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 143, 358, 28));

        Label_Senha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Label_Senha.setForeground(new java.awt.Color(0, 0, 0));
        Label_Senha.setText("Senha");
        jPanel1.add(Label_Senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 189, -1, -1));

        Caixa_Senha.setBorder(null);
        Caixa_Senha.setOpaque(false);
        Caixa_Senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_SenhaActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_Senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 214, 358, 28));

        Boton_Entrar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Boton_Entrar.setForeground(new java.awt.Color(0, 0, 0));
        Boton_Entrar.setText("Entrar");
        Boton_Entrar.setBorder(null);
        Boton_Entrar.setOpaque(false);
        Boton_Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_EntrarActionPerformed(evt);
            }
        });
<<<<<<< HEAD
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 50, 20));
=======
        jPanel1.add(Boton_Entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 520, 90, 40));
>>>>>>> eea87e59710c97a6139f34f451d0d2af7c33e5d1

        botao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_login.png"))); // NOI18N
        jPanel1.add(botao, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Caixa_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_UsuarioActionPerformed

    private void Caixa_SenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_SenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_SenhaActionPerformed

    private void Boton_EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EntrarActionPerformed
        try {
            String usuario_login, usuario_senha; // Variaveis para receber valores das caixas de texto
            usuario_login = Caixa_Usuario.getText();
            usuario_senha = Caixa_Senha.getText();
            
            Login_bean loginbean = new Login_bean(); // puxando classe Login_bean para mandar as variaveis para lá
            loginbean.setUsuario(usuario_login);
            loginbean.setSenha(usuario_senha);
            
            Login_dao logindao = new Login_dao(); //puxando classe Login_dao para usar o metodo de autenticação
            ResultSet rsLogin_dao = logindao.autenticaUsuario(loginbean);
            
            if(rsLogin_dao.next()){   // Se usuario correto
                Jhome home = new Jhome();
                home.setVisible(true);
                dispose();
            
            } else { // Se usuario incorreto
                 JOptionPane.showMessageDialog(null,"Usuario ou senha incorretos");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em tela de login "+e);
        }
       
        
        
    }//GEN-LAST:event_Boton_EntrarActionPerformed

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
            java.util.logging.Logger.getLogger(Jlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jlogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Boton_Entrar;
    private javax.swing.JTextField Caixa_Senha;
    private javax.swing.JTextField Caixa_Usuario;
    private javax.swing.JLabel Label_Senha;
    private javax.swing.JLabel Label_Usuario;
    private javax.swing.JLabel botao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}