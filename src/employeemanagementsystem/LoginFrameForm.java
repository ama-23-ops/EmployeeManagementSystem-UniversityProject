/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package employeemanagementsystem;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;

/**
 *
 * @author Amasha
 */
public class LoginFrameForm extends javax.swing.JFrame  {
    
  
    public LoginFrameForm() {
       initComponents();
    }
    
     public void LoadSubPanels(JPanel subPanel) {
        mainLoginPanel.removeAll();
        mainLoginPanel.add(subPanel);
        mainLoginPanel.repaint();
        mainLoginPanel.revalidate();
    }
     private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "adminpass";
    
    public static void login(String userName, String password) {
        if (userName.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            openAdminFrame();
        } else {
            String role = authenticate(userName, password);
            if (role != null) {
                switch (role) {
                    case "HR Manager":
                        openHRManagerFrame();
                        break;
                    case "HR Assistant":
                        openHRAssistantFrame();
                        break;
                    default:
                        System.out.println("Unknown role.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password.", "Login error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private static String authenticate(String userName, String password) {
        try {
        BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            // Split the line using regex to handle spaces around '='
            String[] data = line.split("\\s*,\\s*");

            // Iterate through the data fields and split each field into key-value pairs
            for (String keyValue : data) {
                String[] pair = keyValue.split("\\s*=\\s*");

                // Check if the username and password match
                if (pair.length == 2 && pair[0].trim().equals("UserName") && pair[1].trim().equals(userName)
                        && data[3].equals("Password =" + password)) {
                    reader.close();
                    // Return the designation (role)
                    return data[2].substring(6); // Removing "Role =" from the designation
                }
            }
        }
        reader.close();
    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Error: File 'user_data.txt' not found. Please make sure the file exists.", "Login error", JOptionPane.ERROR_MESSAGE);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error while authenticating: ", "Login error", JOptionPane.ERROR_MESSAGE);
    }
    return null;
    }
    
    private static void openAdminFrame() {
        // Code to open Admin Frame
        adminFrame adminFrame = new adminFrame(); // Instantiate AdminFormFrame
        adminFrame.setVisible(true); // Make the frame visible
        System.out.println("Opening Admin Frame...");
    }
    
    private static void openHRManagerFrame() {
        // Code to open HR Manager Frame
        HrManagerMainForm HrManagerMainForm = new HrManagerMainForm(); // Instantiate HR Manager Frame
        HrManagerMainForm.setVisible(true); // Make the frame visible
        System.out.println("Opening HR Manager Frame...");
    }
    
    private static void openHRAssistantFrame() {
        // Code to open HR Assistant Frame
        hrAssistantFrame hrAssistantFrame= new hrAssistantFrame(); // Instantiate HR Assistant Frame
        hrAssistantFrame.setVisible(true); // Make the frame visible
        System.out.println("Opening HR Assistant Frame...");
    }
     
     
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginIonLabel = new javax.swing.JLabel();
        mainLoginPanel = new javax.swing.JPanel();
        LogindesignPanel = new javax.swing.JPanel();
        instuteNameLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        passworLabel = new javax.swing.JLabel();
        commonLoginButton = new javax.swing.JButton();
        userNameTextField = new javax.swing.JTextField();
        systemNameLabel = new javax.swing.JLabel();
        loginPasswordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        loginIonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png"))); // NOI18N
        loginIonLabel.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainLoginPanel.setBackground(new java.awt.Color(151, 188, 226));
        mainLoginPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204)));
        mainLoginPanel.setForeground(new java.awt.Color(0, 102, 153));
        mainLoginPanel.setDoubleBuffered(false);
        mainLoginPanel.setFocusTraversalPolicyProvider(true);

        LogindesignPanel.setBackground(new java.awt.Color(97, 84, 164));

        instuteNameLabel.setFont(new java.awt.Font("Modern No. 20", 1, 36)); // NOI18N
        instuteNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        instuteNameLabel.setText("Colombo Institute of Studies");

        javax.swing.GroupLayout LogindesignPanelLayout = new javax.swing.GroupLayout(LogindesignPanel);
        LogindesignPanel.setLayout(LogindesignPanelLayout);
        LogindesignPanelLayout.setHorizontalGroup(
            LogindesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogindesignPanelLayout.createSequentialGroup()
                .addContainerGap(276, Short.MAX_VALUE)
                .addComponent(instuteNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
        );
        LogindesignPanelLayout.setVerticalGroup(
            LogindesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogindesignPanelLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(instuteNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        userNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        userNameLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        userNameLabel.setText("User Name");

        passworLabel.setBackground(new java.awt.Color(255, 255, 255));
        passworLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        passworLabel.setText("Password");

        commonLoginButton.setBackground(new java.awt.Color(0, 102, 153));
        commonLoginButton.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        commonLoginButton.setForeground(new java.awt.Color(255, 255, 255));
        commonLoginButton.setText("Log in");
        commonLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commonLoginButtonActionPerformed(evt);
            }
        });

        userNameTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204)));

        systemNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        systemNameLabel.setFont(new java.awt.Font("Microsoft YaHei", 1, 20)); // NOI18N
        systemNameLabel.setForeground(new java.awt.Color(0, 102, 153));
        systemNameLabel.setText("Employee Managemnt System");

        loginPasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/6.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1111.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2222.png"))); // NOI18N

        javax.swing.GroupLayout mainLoginPanelLayout = new javax.swing.GroupLayout(mainLoginPanel);
        mainLoginPanel.setLayout(mainLoginPanelLayout);
        mainLoginPanelLayout.setHorizontalGroup(
            mainLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogindesignPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainLoginPanelLayout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addComponent(systemNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainLoginPanelLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(mainLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLoginPanelLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(mainLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainLoginPanelLayout.createSequentialGroup()
                                .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addComponent(passworLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainLoginPanelLayout.createSequentialGroup()
                                .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainLoginPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(commonLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))))
        );
        mainLoginPanelLayout.setVerticalGroup(
            mainLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLoginPanelLayout.createSequentialGroup()
                .addComponent(LogindesignPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(systemNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(mainLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLoginPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(passworLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(commonLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLoginPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        getContentPane().add(mainLoginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void commonLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commonLoginButtonActionPerformed
    String username = userNameTextField.getText(); // Assuming you have a JTextField for username input named "usernameTextField"
    String password = new String(loginPasswordField.getPassword()); // Assuming you have a JPasswordField for password input named "passwordField"

    // Call the login method to handle authentication and frame opening
    login(username, password);
    }//GEN-LAST:event_commonLoginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrameForm().setVisible(true);
            }
      
    private String hashPassword(String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LogindesignPanel;
    private javax.swing.JButton commonLoginButton;
    private javax.swing.JLabel instuteNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel loginIonLabel;
    private javax.swing.JPasswordField loginPasswordField;
    private javax.swing.JPanel mainLoginPanel;
    private javax.swing.JLabel passworLabel;
    private javax.swing.JLabel systemNameLabel;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables
}
