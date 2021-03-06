import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Patrik
 */
public class User_Settings extends javax.swing.JFrame {

    /**
     * Creates new form User_Settings
     */
    public User_Settings() {
        initComponents();
        jButtonSave.setEnabled(false);
        jButtonCancel.setEnabled(false);
        jLabelConfirm.setEnabled(false);
        jButtonConfirm.setEnabled(false);
        jPasswordFieldConfirm.setEnabled(false);
        jPasswordFieldNewPassword.setEnabled(false);
        jCheckBoxNewPassword.setEnabled(false);
        jLabelUpdateSucessful.setVisible(false);
        
        // Hier rufe ich die Methode auf, die mir die Daten des Users in die TextFields reinschreibt
        showUserdata();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabelUserSettings = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelFirstName = new javax.swing.JLabel();
        jLabelLastName = new javax.swing.JLabel();
        jLabelMailAddress = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jTextFieldFirstName = new javax.swing.JTextField();
        jTextFieldLastName = new javax.swing.JTextField();
        jTextFieldMailAddress = new javax.swing.JTextField();
        jButtonEdit = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPasswordFieldConfirm = new javax.swing.JPasswordField();
        jLabelConfirm = new javax.swing.JLabel();
        jButtonConfirm = new javax.swing.JButton();
        jPasswordFieldNewPassword = new javax.swing.JPasswordField();
        jCheckBoxNewPassword = new javax.swing.JCheckBox();
        jLabelUpdateSucessful = new javax.swing.JLabel();
        jButtonDeleteAccount = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabelUserSettings.setText("Allgemeine Kontoeinstellungen");

        jLabelUsername.setText("Benutzername:");

        jLabelFirstName.setText("Vorname:");

        jLabelLastName.setText("Nachname:");

        jLabelMailAddress.setText("E-Mail-Adresse:");

        jTextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsernameActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Bearbeiten");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonSave.setText("Speichern");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Abbrechen");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabelConfirm.setText("Änderungen mit Passwort bestätigen:");

        jButtonConfirm.setText("Bestätigen");
        jButtonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmActionPerformed(evt);
            }
        });

        jCheckBoxNewPassword.setText("Neues Passwort setzen");
        jCheckBoxNewPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxNewPasswordMouseClicked(evt);
            }
        });

        jLabelUpdateSucessful.setText("jLabel1");

        jButtonDeleteAccount.setForeground(new java.awt.Color(255, 0, 0));
        jButtonDeleteAccount.setText("Account löschen");
        jButtonDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabelUserSettings)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUsername)
                            .addComponent(jLabelFirstName)
                            .addComponent(jLabelLastName)
                            .addComponent(jLabelMailAddress))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                    .addComponent(jTextFieldMailAddress)
                                    .addComponent(jTextFieldLastName)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jCheckBoxNewPassword)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPasswordFieldNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldUsername))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonConfirm)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jButtonSave)
                                                .addGap(37, 37, 37)
                                                .addComponent(jButtonCancel))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelUpdateSucessful)
                                                    .addComponent(jLabelConfirm)))
                                            .addComponent(jButtonDeleteAccount))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPasswordFieldConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(156, 156, 156)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEdit)
                .addGap(162, 162, 162))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUserSettings)
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsername)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFirstName)
                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLastName)
                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMailAddress)
                    .addComponent(jTextFieldMailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxNewPassword)
                    .addComponent(jPasswordFieldNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonCancel))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelConfirm)
                    .addComponent(jPasswordFieldConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonConfirm)
                .addGap(18, 18, 18)
                .addComponent(jLabelUpdateSucessful)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jButtonDeleteAccount))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsernameActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        jTextFieldLastName.setEnabled(true);
        jTextFieldMailAddress.setEnabled(true);
        jTextFieldFirstName.setEnabled(true);
        jTextFieldFirstName.requestFocus(true);
        jButtonEdit.setEnabled(false);
        jButtonSave.setEnabled(true);
        jButtonCancel.setEnabled(true);
        jCheckBoxNewPassword.setEnabled(true);
        jLabelUpdateSucessful.setVisible(false);
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        showUserdata();    
        jButtonEdit.setEnabled(true);
        jButtonSave.setEnabled(false);
        jButtonCancel.setEnabled(false);
        jLabelConfirm.setEnabled(false);
        jButtonConfirm.setEnabled(false);
        jPasswordFieldConfirm.setEnabled(false);
        jPasswordFieldNewPassword.setEnabled(false);
        jPasswordFieldNewPassword.setText(null);
        jCheckBoxNewPassword.setEnabled(false);
        jCheckBoxNewPassword.setSelected(false);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmActionPerformed
        // TODO add your handling code here:
        if (checkTextfields()) {
            if (checkPassword() == true){
                if (jCheckBoxNewPassword.isSelected() == true){
                    String new_pwd = new String (jPasswordFieldNewPassword.getPassword());
                    if (new_pwd.equals("")){
                    jLabelUpdateSucessful.setText("Das neue Passwort darf kein leerer String sein!");
                    jLabelUpdateSucessful.setVisible(true);
                    }
                    else {
                        updateUserdata();
                        jLabelUpdateSucessful.setText("Die Daten wurden erfolgreich aktualisiert!");
                        jLabelUpdateSucessful.setVisible(true);

                        jPasswordFieldConfirm.setText(null);
                        jPasswordFieldConfirm.setEnabled(false);
                        jTextFieldLastName.setEnabled(false);
                        jTextFieldMailAddress.setEnabled(false);
                        jTextFieldFirstName.setEnabled(false);
                        jTextFieldFirstName.requestFocus(false);
                        jButtonEdit.setEnabled(true);
                        jButtonSave.setEnabled(false);
                        jButtonCancel.setEnabled(false);
                        jCheckBoxNewPassword.setEnabled(false);

                        jLabelConfirm.setEnabled(false);
                        jButtonConfirm.setEnabled(false);
                        jPasswordFieldNewPassword.setEnabled(false);
                        jPasswordFieldNewPassword.setText(null);
                        jCheckBoxNewPassword.setEnabled(false);
                        jCheckBoxNewPassword.setSelected(false);
                    }

                }
               else{
               updateUserdata();
               jLabelUpdateSucessful.setText("Die Daten wurden erfolgreich aktualisiert!");
               jLabelUpdateSucessful.setVisible(true);

               jPasswordFieldConfirm.setText(null);
               jPasswordFieldConfirm.setEnabled(false);
               jTextFieldLastName.setEnabled(false);
               jTextFieldMailAddress.setEnabled(false);
               jTextFieldFirstName.setEnabled(false);
               jTextFieldFirstName.requestFocus(false);
               jButtonEdit.setEnabled(true);
               jButtonSave.setEnabled(false);
               jButtonCancel.setEnabled(false);
               jCheckBoxNewPassword.setEnabled(false);

               jLabelConfirm.setEnabled(false);
               jButtonConfirm.setEnabled(false);
               jPasswordFieldNewPassword.setEnabled(false);
               jPasswordFieldNewPassword.setText(null);
               jCheckBoxNewPassword.setEnabled(false);
               jCheckBoxNewPassword.setSelected(false);
               }


            }
            else {
               jLabelUpdateSucessful.setText("Passwort falsch! Bitte versuchen Sie es erneut!");
               jLabelUpdateSucessful.setVisible(true);
            }
        }
        else {
            jLabelUpdateSucessful.setText("Bitte fülle alle Felder VOLLSTÄNDIG aus!");
            jLabelUpdateSucessful.setVisible(true);
        }
    }//GEN-LAST:event_jButtonConfirmActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
        if (checkTextfields()) {
            if (jCheckBoxNewPassword.isSelected() == true){
                    String new_pwd = new String (jPasswordFieldNewPassword.getPassword());
                    if (new_pwd.equals("")){
                    jLabelUpdateSucessful.setText("Das neue Passwort darf kein leerer String sein!");
                    jLabelUpdateSucessful.setVisible(true);
                    }
                    else {
                        jLabelConfirm.setEnabled(true);
                        jButtonConfirm.setEnabled(true);
                        jPasswordFieldConfirm.setEnabled(true);        
                        jButtonSave.setEnabled(false);
                        jLabelUpdateSucessful.setVisible(false);
                    }
                    }
            else {
                jLabelConfirm.setEnabled(true);
                jButtonConfirm.setEnabled(true);
                jPasswordFieldConfirm.setEnabled(true);        
                jButtonSave.setEnabled(false);
                jLabelUpdateSucessful.setVisible(false);
            }
        }
        else {
            jLabelUpdateSucessful.setText("Bitte fülle alle Felder VOLLSTÄNDIG aus!");
            jLabelUpdateSucessful.setVisible(true);
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jCheckBoxNewPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxNewPasswordMouseClicked
        // TODO add your handling code here:
        
        if (jPasswordFieldNewPassword.isEnabled()==false) {
        jPasswordFieldNewPassword.setEnabled(true);
        validate();
        System.out.println("Passwordfeld wird sichtbar gemacht");
        }
        else if (jPasswordFieldNewPassword.isEnabled()==true) {
        jPasswordFieldNewPassword.setEnabled(false);
        validate();
        System.out.println("Passwordfeld wird unsichtbar gemacht");
    }
    }//GEN-LAST:event_jCheckBoxNewPasswordMouseClicked

    private void jButtonDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAccountActionPerformed
        // TODO add your handling code here:
        int delete_account = JOptionPane.showConfirmDialog(null, "Willst du deinen Account wirklich löschen?");
        if (delete_account == 0) {// wenn User auf JA klickt
            deleteAccount();
            System.exit(0);
            
        }else if (delete_account == 1){// wenn User auf ABBRECHEN klickt
            
        }else if (delete_account == 2){// wenn User auf NEIN klickt
            
        }
        
    }//GEN-LAST:event_jButtonDeleteAccountActionPerformed

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
            java.util.logging.Logger.getLogger(User_Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonConfirm;
    private javax.swing.JButton jButtonDeleteAccount;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JCheckBox jCheckBoxNewPassword;
    private javax.swing.JLabel jLabelConfirm;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelMailAddress;
    private javax.swing.JLabel jLabelUpdateSucessful;
    private javax.swing.JLabel jLabelUserSettings;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPasswordField jPasswordFieldConfirm;
    private javax.swing.JPasswordField jPasswordFieldNewPassword;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldMailAddress;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables


    //Diese Methode ruft die Informationen aus der Datenbank ab und schreibt sie in die einzelnen Textfelder
    
    public void showUserdata(){
        try {
//          // Verbindung zur Datenbank herstellen:
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://141.2.89.26/TEAM_6D_DB";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "TEAM_6D", "gE8f6CAd");
            
            // Variable hier wird vorübergehend mal festgelegt, später wird sie beim Login aber mitgeschickt
            String identity = "1";
            
            // Hier formuliere ich meine SQL-Anfrage:
            String query = "SELECT * FROM user WHERE id ="+identity;
            
            // PreparedStatement-Instanz (Benutzt man bei Variablen im SQL-Code)
            
            // Statementinstanz:
            Statement st = conn.createStatement();
            
            // Anfrage wird ausgeführt und ich erhalte ein ResultSet:
            ResultSet rs = st.executeQuery(query);
            
            // Ich iteriere durch das komplette ResultSet:
            while (rs.next())
            {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String nickName = rs.getString("nickname");
                String emailAddress = rs.getString("email_address");
                String password = rs.getString("password");
         
                // print the results
                jTextFieldFirstName.setText(firstName);
                jTextFieldFirstName.setEnabled(false);
                jTextFieldLastName.setText(lastName);
                jTextFieldLastName.setEnabled(false);
                jTextFieldMailAddress.setText(emailAddress);
                jTextFieldMailAddress.setEnabled(false);
                jTextFieldUsername.setText(nickName);
                jTextFieldUsername.setEnabled(false);
            }
            
            
            //Daten in Textfeld reinschreiben
            
            
            
            // Statement wird geschlossen;
            st.close();
        }
        
        catch (Exception e)
            {
            System.err.println("Es gab einen Fehler mit der Datenbank!");
            System.err.println(e.getMessage());
        }
    }
    
    
    public void updateUserdata(){ // Hier werden die Daten in der Datenbank überschrieben
        try {
//          // Verbindung zur Datenbank herstellen:
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://141.2.89.26/TEAM_6D_DB";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "TEAM_6D", "gE8f6CAd");
            
            // Variable hier wird vorübergehend mal festgelegt, später wird sie beim Login aber mitgeschickt
            String identity = "1";
            
           
            String new_pwd = new String (jPasswordFieldNewPassword.getPassword());
            
            // Hier formuliere ich meine SQL-Anfrage:
            String query = null;
            if (jCheckBoxNewPassword.isSelected() == false){
                    query = "UPDATE user SET first_name ='"+jTextFieldFirstName.getText()+"', last_name ='"+jTextFieldLastName.getText()+"' WHERE id ="+identity;
            }
            else if (jCheckBoxNewPassword.isSelected() == true){
                    query = "UPDATE user SET first_name ='"+jTextFieldFirstName.getText()+"', last_name ='"+jTextFieldLastName.getText()+"' , password ='"+md5(new_pwd)+"' WHERE id ="+identity;
            }
            
            // PreparedStatement-Instanz (Benutzt man bei Variablen im SQL-Code)
            
            // Statementinstanz:
            Statement st = conn.createStatement();
            
            // Query wird ausgeführt:
            st.execute(query);
            
            // Statement wird geschlossen;
            st.close();
        }
        
        catch (Exception e)
            {
            System.err.println("Es gab einen Fehler mit der Datenbank!");
            System.err.println(e.getMessage());
        }
    }
    
    
    public boolean checkPassword(){
        try {
//          // Verbindung zur Datenbank herstellen:
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://141.2.89.26/TEAM_6D_DB";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "TEAM_6D", "gE8f6CAd");
            
            // Variable hier wird vorübergehend mal festgelegt, später wird sie beim Login aber mitgeschickt
            String identity = "1";
            
            // Hier formuliere ich meine SQL-Anfrage:
            String query = "SELECT * FROM user WHERE id ="+identity;
            
            // PreparedStatement-Instanz (Benutzt man bei Variablen im SQL-Code)
            
            // Statementinstanz:
            Statement st = conn.createStatement();
            
            // Anfrage wird ausgeführt und ich erhalte ein ResultSet:
            ResultSet rs = st.executeQuery(query);
            
            // Ich iteriere durch das komplette ResultSet:
            String pwd2 = null;
            while (rs.next())
            {
                pwd2 = rs.getString("password");
         
            }
            System.out.println(pwd2);
            
            String pwd1 = new String (jPasswordFieldConfirm.getPassword());
            System.out.println(md5(pwd1));
            System.out.println(pwd2);
            // Statement wird geschlossen;
            st.close();
            
            if (md5(pwd1).equals(pwd2)){
                return true;
            }
            

            
        }
        
        catch (Exception e)
            {
            System.err.println("Es gab einen Fehler mit der Datenbank!");
            System.err.println(e.getMessage());
            return false;
        }
        return false;
    }
    
// hier liegt meine MD5-Hashfunktion für das Passwort!
    public static String md5(String input) {
        
		String md5 = null;
		if(null == input) return null;
		
                try {	
		//Create MessageDigest object for MD5
		MessageDigest digest = MessageDigest.getInstance("MD5");
		//Update input string in message digest
		digest.update(input.getBytes(), 0, input.length());
		//Converts message digest value in base 16 (hex) 
		md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}   
    
    public void deleteAccount(){ // Mit dieser Methode wird der Account gelöscht
        try {
//          // Verbindung zur Datenbank herstellen:
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://141.2.89.26/TEAM_6D_DB";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "TEAM_6D", "gE8f6CAd");
            
            // Variable hier wird vorübergehend mal festgelegt, später wird sie beim Login aber mitgeschickt
            String identity = "1";
            
            // Hier formuliere ich meine SQL-Anfrage:
            String query = null;
            query = "DELETE FROM user WHERE id ="+identity;
    
            // Statementinstanz:
            Statement st = conn.createStatement();
            
            // Query wird ausgeführt:
            st.execute(query);
            
            // Statement wird geschlossen;
            st.close();
        }
        
        catch (Exception e)
            {
            System.err.println("Es gab einen Fehler mit der Datenbank!");
            System.err.println(e.getMessage());
        }
    }
    
    public boolean checkTextfields() {
        String first_name = new String (jTextFieldFirstName.getText());
        String last_name = new String (jTextFieldLastName.getText());
        String mail_address = new String (jTextFieldMailAddress.getText());
        if (first_name.equals("") || last_name.equals("") || mail_address.equals("")){
            return false;
        }
        else {
            return true;
            
        }
    }
    
}
