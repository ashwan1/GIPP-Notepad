package gipp.notepad;

import java.awt.Component;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author intel
 */
public class GippNotepad {

    private char[] pwd = null;
    private boolean open = false;

    public void setPwd(char[] pwd) {
        this.pwd = pwd;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.setVisible(true);
    }
    
    public ImageIcon createImageIcon(){
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("gipp_notepad_icon.jpg"));
        return imgIcon;
    }
    
    public File fileChooser(Component parent){
        File selectedFile = null;
        JFileChooser fileDialog = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Only gipp files","gipp");
        fileDialog.setFileFilter(filter);
        fileDialog.setDialogTitle("Select File to be Opened");
        fileDialog.setSelectedFile(null);  // No file is initially selected.
        int option = fileDialog.showOpenDialog(parent);
        if (option == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileDialog.getSelectedFile();
            String ext = selectedFile.getName().substring(selectedFile.getName().lastIndexOf("."));
            System.out.println("extension is "+ext);
            if (!ext.equals(".gipp")){
                JOptionPane.showMessageDialog(fileDialog, "Only .gipp files can be opened", "Invalid File Extension", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        return selectedFile;
    }
    
    public void decryptFile (File selectedFile, JFrame parent, NewNote nn){
        PromptPassword pwdDialog = new PromptPassword(parent, true);
        pwdDialog.setVisible(true);
        pwdDialog.setGnVar(this);
        if (open){
            FileInputStream fis = null;
            OutputStream os = new ByteArrayOutputStream();
            try {
                fis = new FileInputStream(selectedFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GippNotepad.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                String note = EncryptDecrypt.decrypt(pwd, fis, os);
                /*System.out.println("note is "+note);*/
                nn.setNote(note);
                open = false;
            } catch (EncryptDecrypt.InvalidAESStreamException | IOException | EncryptDecrypt.StrongEncryptionNotAvailableException ex) {
                Logger.getLogger(GippNotepad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (EncryptDecrypt.InvalidPasswordException ex) {
                Logger.getLogger(GippNotepad.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "You entered wrong password. Unable to decrypt file.", "Invalid Password", JOptionPane.ERROR_MESSAGE);
            }
            finally{
                try {
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(GippNotepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
