/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TELA;

import BEAN.Login_bean;
import CONEXAO.Conexao;
import DAO.Login_dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Caixa_senha = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Caixa_login = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Botton_entrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(235, 235, 235));
        setMinimumSize(new java.awt.Dimension(450, 700));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MotiON");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 30, 170, 60);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setText("Usuario:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 260, 120, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setText("Senha:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 330, 140, 28);

        Caixa_senha.setForeground(new java.awt.Color(96, 131, 154));
        Caixa_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_senhaActionPerformed(evt);
            }
        });
        getContentPane().add(Caixa_senha);
        Caixa_senha.setBounds(30, 360, 370, 30);

        Caixa_login.setForeground(new java.awt.Color(96, 131, 154));
        jScrollPane1.setViewportView(Caixa_login);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 290, 370, 30);

        jPanel1.setBackground(new java.awt.Color(174, 205, 253));
        jPanel1.setForeground(new java.awt.Color(135, 127, 255));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 310, 370, 20);

        jPanel3.setBackground(new java.awt.Color(174, 205, 253));
        jPanel3.setForeground(new java.awt.Color(135, 127, 255));
        getContentPane().add(jPanel3);
        jPanel3.setBounds(30, 380, 370, 20);

        Botton_entrar.setBackground(new java.awt.Color(235, 235, 235));
        Botton_entrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/botao_login.png"))); // NOI18N
        Botton_entrar.setBorder(null);
        Botton_entrar.setContentAreaFilled(false);
        Botton_entrar.setRequestFocusEnabled(false);
        Botton_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_entrarActionPerformed(evt);
            }
        });
        getContentPane().add(Botton_entrar);
        Botton_entrar.setBounds(170, 440, 90, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/splash.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 450, 700);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Botton_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_entrarActionPerformed
        try {
            String usuario_login, usuario_senha;
            usuario_login = Caixa_login.getText();
            usuario_senha = Caixa_senha.getText();
            
            Login_bean loginBean = new Login_bean();
            loginBean.setUsuario(usuario_login);
            loginBean.setSenha(usuario_senha);
            
            int max = 0;
            while (max <= 2){ //se adicionar mais um nível de acesso, prestar atenção neste trecho
                loginBean.setNivel(max); //primeiro o sistema vai tentar logar como usuário normal
                Login_dao loginDao = new Login_dao();
                ResultSet rsLoginDao = loginDao.autenticaUsuario(loginBean);

                if(rsLoginDao.next()){
                    dispose();
                    if (max == 0){
                        System.out.println("ADMIN!!!!!");
                        Jhome jhome = new Jhome(true, usuario_login);
                        jhome.setVisible(true);
                    }else{
                        System.out.println("USUÁRIO COMUM!!!!!!");
                        Jhome jhome = new Jhome(false, usuario_login);
                        jhome.setVisible(true);
                        }
                    return;
                } else {
                    if (max > 1){
                    JOptionPane.showMessageDialog(null,"Usuario ou senha incorretos");
                    }
                    max++;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em tela de login "+e);
        }
    }//GEN-LAST:event_Botton_entrarActionPerformed

    private void Caixa_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_senhaActionPerformed

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
    private javax.swing.JButton Botton_entrar;
    private javax.swing.JTextPane Caixa_login;
    private javax.swing.JPasswordField Caixa_senha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
