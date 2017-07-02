/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gipp.notepad;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import say.swing.JFontChooser;

/**
 *
 * @author intel
 */
public class NewNote extends javax.swing.JFrame {

    /**
     * Creates new form NewNote
     */
    public NewNote() {
        initComponents();
        this.setIconImage(new GippNotepad().createImageIcon().getImage());
    }
    private File selectedFile = null;  //Initially selected file name in the dialog.
    private File editFile = null;
    private char[] pwd = null;
    private boolean save = false;
    private int pwdLength = 0;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogPwdPrompt = new javax.swing.JDialog();
        LabelPwd = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        btnOK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaNote = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        MenuItemNew = new javax.swing.JMenuItem();
        MenuItemOpen = new javax.swing.JMenuItem();
        MenuItemSave = new javax.swing.JMenuItem();
        MenuEdit = new javax.swing.JMenu();
        CheckBoxMenuItemWordwrap = new javax.swing.JCheckBoxMenuItem();
        MenuItemFont = new javax.swing.JMenuItem();
        MenuHome = new javax.swing.JMenu();

        DialogPwdPrompt.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        DialogPwdPrompt.setTitle("Encrypt File");
        DialogPwdPrompt.setAlwaysOnTop(true);
        DialogPwdPrompt.setLocation(new java.awt.Point(400, 200));
        DialogPwdPrompt.setMinimumSize(new java.awt.Dimension(305, 170));
        DialogPwdPrompt.setModal(true);
        DialogPwdPrompt.setPreferredSize(new java.awt.Dimension(305, 170));
        DialogPwdPrompt.setResizable(false);

        LabelPwd.setText("Enter Password:");

        PasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PasswordFieldKeyReleased(evt);
            }
        });

        btnOK.setText("Encrypt");
        btnOK.setEnabled(false);
        btnOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOKMouseClicked(evt);
            }
        });

        jLabel2.setForeground(java.awt.Color.red);
        jLabel2.setText("(* Min 6 characters)");

        javax.swing.GroupLayout DialogPwdPromptLayout = new javax.swing.GroupLayout(DialogPwdPrompt.getContentPane());
        DialogPwdPrompt.getContentPane().setLayout(DialogPwdPromptLayout);
        DialogPwdPromptLayout.setHorizontalGroup(
            DialogPwdPromptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogPwdPromptLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelPwd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DialogPwdPromptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        DialogPwdPromptLayout.setVerticalGroup(
            DialogPwdPromptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogPwdPromptLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(DialogPwdPromptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPwd)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOK)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create New Note");
        setLocation(new java.awt.Point(350, 100));

        TextAreaNote.setColumns(70);
        TextAreaNote.setRows(25);
        jScrollPane1.setViewportView(TextAreaNote);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        MenuFile.setText("File");
        MenuFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuFileMouseClicked(evt);
            }
        });

        MenuItemNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemNew.setText("New");
        MenuItemNew.setToolTipText("Create New Note");
        MenuItemNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuItemNewMouseClicked(evt);
            }
        });
        MenuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemNewActionPerformed(evt);
            }
        });
        MenuFile.add(MenuItemNew);

        MenuItemOpen.setText("Open");
        MenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemOpenActionPerformed(evt);
            }
        });
        MenuFile.add(MenuItemOpen);

        MenuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemSave.setText("Save");
        MenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemSaveActionPerformed(evt);
            }
        });
        MenuFile.add(MenuItemSave);

        jMenuBar1.add(MenuFile);

        MenuEdit.setText("Edit");

        CheckBoxMenuItemWordwrap.setText("WordWrap");
        CheckBoxMenuItemWordwrap.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckBoxMenuItemWordwrapItemStateChanged(evt);
            }
        });
        MenuEdit.add(CheckBoxMenuItemWordwrap);

        MenuItemFont.setText("Font");
        MenuItemFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemFontActionPerformed(evt);
            }
        });
        MenuEdit.add(MenuItemFont);

        jMenuBar1.add(MenuEdit);

        MenuHome.setText("Home");
        MenuHome.setToolTipText("Go to homescreen without saving");
        MenuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuHomeMouseClicked(evt);
            }
        });
        MenuHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuHomeActionPerformed(evt);
            }
        });
        jMenuBar1.add(MenuHome);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemSaveActionPerformed
            if (pwd == null) {
            JFileChooser fileDialog = null;
            if (selectedFile == null){
                fileDialog = new JFileChooser();
            }
            else{
                try {
                    fileDialog = new JFileChooser(selectedFile.getCanonicalPath());
                } catch (IOException ex) {
                    Logger.getLogger(NewNote.class.getName()).log(Level.SEVERE, null, ex);
                    fileDialog = new JFileChooser();
                }
            }
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Only gipp files", "gipp");
            fileDialog.setFileFilter(filter);
            if (editFile == null) {
                selectedFile = new File("*.gipp");
            } else {
                selectedFile = new File(editFile.getName());
            }
            fileDialog.setSelectedFile(selectedFile);
            fileDialog.setDialogTitle("Save as");
            int option = fileDialog.showSaveDialog(this);
            if (option != JFileChooser.APPROVE_OPTION) {
                return;  // User canceled or clicked the dialog's close box.
            }
            selectedFile = fileDialog.getSelectedFile();

            if (selectedFile.getName().lastIndexOf(".") == -1 || !".gipp".equals(selectedFile.getName().substring(selectedFile.getName().lastIndexOf(".")))) {
                selectedFile = new File(selectedFile.getAbsoluteFile() + ".gipp");
            }

            if (selectedFile.exists()) {  // Ask the user whether to replace the file.
                int response = JOptionPane.showConfirmDialog(this,
                        "The file \"" + selectedFile.getName()
                        + "\" already exists.\nDo you want to replace it?",
                        "Confirm Save",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                if (response != JOptionPane.YES_OPTION) {
                    return;  // User does not want to replace the file.
                }
            }
            System.out.println("file to be saved as " + selectedFile);

            promptPwd();
        }
        if (save) {
            String note = TextAreaNote.getText();
            InputStream is = new ByteArrayInputStream(note.getBytes());
            FileOutputStream output = null;
            try {
                output = new FileOutputStream(selectedFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewNote.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                EncryptDecrypt.encrypt(128, pwd, is, output);
                System.out.println("File encrypted successfully");
                this.setTitle(selectedFile.getName());
//                save = false;
//                pwd = null;
            } catch (EncryptDecrypt.InvalidKeyLengthException | EncryptDecrypt.StrongEncryptionNotAvailableException | IOException ex) {
                Logger.getLogger(NewNote.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                if (output != null) {
                    try {
                        output.flush();
                        output.close();
                    } catch (IOException ex) {
                        Logger.getLogger(NewNote.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_MenuItemSaveActionPerformed
    
    private void promptPwd(){
        DialogPwdPrompt.setVisible(true);
        DialogPwdPrompt.setAutoRequestFocus(true);
        PasswordField.setText(null);
    }
    
    public void setNote(String note){
        TextAreaNote.setText(note);
    }

    public void setEditFile(File editFile) {
        this.editFile = editFile;
    }

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }
    
    private void MenuHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuHomeActionPerformed
        
    }//GEN-LAST:event_MenuHomeActionPerformed

    private void MenuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuHomeMouseClicked
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MenuHomeMouseClicked

    private void MenuItemNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuItemNewMouseClicked
        
    }//GEN-LAST:event_MenuItemNewMouseClicked

    private void MenuFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuFileMouseClicked
        
    }//GEN-LAST:event_MenuFileMouseClicked

    private void CheckBoxMenuItemWordwrapItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckBoxMenuItemWordwrapItemStateChanged
        if(TextAreaNote.getLineWrap() == false){
            TextAreaNote.setLineWrap(true);
        }
        else{
            TextAreaNote.setLineWrap(false);
        }
    }//GEN-LAST:event_CheckBoxMenuItemWordwrapItemStateChanged

    private void MenuItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemNewActionPerformed
        TextAreaNote.setText("");
        editFile = null;
        this.setTitle("Create New Note");
    }//GEN-LAST:event_MenuItemNewActionPerformed

    private void MenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemOpenActionPerformed
        GippNotepad gn = new GippNotepad();
        selectedFile = gn.fileChooser(this);
        if (selectedFile != null){
            System.out.println("selected file is "+selectedFile.getName());
            gn.decryptFile(selectedFile, this, this);
            this.setTitle(selectedFile.getName());
            this.setEditFile(selectedFile);
        }
    }//GEN-LAST:event_MenuItemOpenActionPerformed

    private void MenuItemFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemFontActionPerformed
        JFontChooser fontChooser = new JFontChooser();
        int result = fontChooser.showDialog(this);
        if(result == JFontChooser.OK_OPTION){
            Font selectedFont = fontChooser.getSelectedFont();
            TextAreaNote.setFont(selectedFont);
        }
    }//GEN-LAST:event_MenuItemFontActionPerformed

    private void btnOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOKMouseClicked
        onEncryptBtn();
    }//GEN-LAST:event_btnOKMouseClicked

    private void PasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordFieldKeyReleased
        pwdLength = PasswordField.getPassword().length;
        System.out.println("length of password is "+pwdLength);
        if (pwdLength > 5) {
            btnOK.setEnabled(true);
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                onEncryptBtn();
            }
        }
        else{
            btnOK.setEnabled(false);
        }
    }//GEN-LAST:event_PasswordFieldKeyReleased

    private void onEncryptBtn() {
        pwd = PasswordField.getPassword();
        //System.out.println("password is "+PasswordField.getText());
        if (pwdLength > 5) {
            save = true;
            DialogPwdPrompt.dispose();
        }
        else save = false;
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
            java.util.logging.Logger.getLogger(NewNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewNote().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem CheckBoxMenuItemWordwrap;
    private javax.swing.JDialog DialogPwdPrompt;
    private javax.swing.JLabel LabelPwd;
    private javax.swing.JMenu MenuEdit;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenu MenuHome;
    private javax.swing.JMenuItem MenuItemFont;
    private javax.swing.JMenuItem MenuItemNew;
    private javax.swing.JMenuItem MenuItemOpen;
    private javax.swing.JMenuItem MenuItemSave;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JTextArea TextAreaNote;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
