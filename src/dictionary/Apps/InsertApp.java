/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary.Apps;

import dictionary.Function.InsertWord;
import dictionary.Function.ListSuggest;
import dictionary.Function.SearchWord;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author chinh
 */
public class InsertApp extends javax.swing.JFrame {

    /**
     * Creates new form AppInsert
     */
    
    public InsertApp() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setLocation(screenWidth / 4 + 450, screenHeight / 4-150);
        this.setResizable(false);
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextString = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxKindOfWord = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButtonInsert = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorExplain = new javax.swing.JEditorPane();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Insert New Word");
        setLocation(new java.awt.Point(460, 240));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionary/Icons/banner.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Insert New Word ➕");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 35, -1, -1));

        jLabel2.setBackground(new java.awt.Color(51, 51, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionary/Icons/bannerInsert.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 410, 28));

        jLabel4.setText("Spelling");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        getContentPane().add(jTextString, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 280, 30));

        jLabel5.setText("Kind of words");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, 20));

        jComboBoxKindOfWord.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose kind of words", "Noun", "Adjective", "Adverb", "Verb", "Phrase", "Sentence" }));
        jComboBoxKindOfWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxKindOfWordActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxKindOfWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 108, 160, -1));

        jLabel6.setText("Explain");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 145, -1, 20));

        jButtonInsert.setText("Insert");
        jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

        jScrollPane1.setViewportView(jEditorExplain);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 280, 120));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionary/Icons/background.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 410, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxKindOfWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxKindOfWordActionPerformed
        //int tmp = jComboBoxKindOfWord.getSelectedIndex();
        //jTextExplain.setText(String.valueOf(tmp));
    }//GEN-LAST:event_jComboBoxKindOfWordActionPerformed

    private void jButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertActionPerformed
        String spelling = jTextString.getText();
        String explain = jEditorExplain.getText();
        int tmp = jComboBoxKindOfWord.getSelectedIndex();
        String kindOfWord = null;
        switch (tmp) {
            case 1:
                kindOfWord = "danh từ";
                break;
            case 2:
                kindOfWord = "tính từ";
                break;
            case 3:
                kindOfWord = "trạng từ";
                break;
            case 4:
                kindOfWord = "động từ";
                break;
            case 5:
                kindOfWord = "cụm từ";
                break;
            case 6:
                kindOfWord = "câu";
                break;
            default:
                kindOfWord = "";
                break;
        }
        SearchWord sw = new SearchWord();
        if(sw.searchWord(spelling)==null){
            InsertWord iw = new InsertWord();
            if(iw.insertWord(spelling, explain, kindOfWord) == 1){
                JOptionPane.showMessageDialog(null,"Insert \""+spelling+"\" Success!!!");
                DictionaryApp da = new DictionaryApp();
                spelling = da.jTextSpelling.getText();
                ListSuggest ls = new ListSuggest();
                da.jListSuggest.setModel(ls.listSuggest(spelling));
            } else{
                JOptionPane.showMessageDialog(null,"Fail!!!");
            }
        } else{
            JOptionPane.showMessageDialog(null,"This word already exists in the dictionary");
        }
    }//GEN-LAST:event_jButtonInsertActionPerformed
    
    public void openInsertApp() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InsertApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertApp().setVisible(true);
            }
        });
    }
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
            java.util.logging.Logger.getLogger(InsertApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JComboBox<String> jComboBoxKindOfWord;
    private javax.swing.JEditorPane jEditorExplain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextString;
    // End of variables declaration//GEN-END:variables
}
