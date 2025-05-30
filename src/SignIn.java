
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SignIn extends javax.swing.JFrame {

    private static String usname, pass;

    private static final String FILE_PATH = "src/UserData.json";
    private static final JSONParser jsonParser = new JSONParser();
    private static JSONObject record = new JSONObject();
    private static JSONArray userlist = new JSONArray();

    public SignIn(String usname, String pass) {
        initComponents();
        this.usname = usname;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        SignIn = new javax.swing.JButton();
        show = new javax.swing.JLabel();
        hide = new javax.swing.JLabel();
        SignUpButton = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jLabel3.setText("Sign In");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, -1, -1));

        Username.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        Username.setText("Username");
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });
        jPanel1.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 220, 40));

        SignIn.setBackground(new java.awt.Color(204, 0, 51));
        SignIn.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        SignIn.setForeground(new java.awt.Color(255, 255, 255));
        SignIn.setText("Sign In");
        SignIn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInActionPerformed(evt);
            }
        });
        jPanel1.add(SignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 160, 40));

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/show.png"))); // NOI18N
        show.setText("jLabel4");
        jPanel1.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 40, 20));

        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hide.png"))); // NOI18N
        hide.setText("jLabel5");
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hideMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                hideMouseReleased(evt);
            }
        });
        jPanel1.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 40, 20));

        SignUpButton.setBackground(new java.awt.Color(204, 0, 51));
        SignUpButton.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        SignUpButton.setForeground(new java.awt.Color(255, 255, 255));
        SignUpButton.setText("Sign Up");
        SignUpButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButtonActionPerformed(evt);
            }
        });
        jPanel1.add(SignUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 160, 40));

        Password.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        Password.setText("Password");
        jPanel1.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 220, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Sign In BG.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void SignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInActionPerformed
        String username = Username.getText().trim();
        String password = Password.getText().trim();

        if ((username.equals("Username") && password.equals("Password")) || (username.isEmpty() && password.isEmpty())) {
            JOptionPane.showMessageDialog(null, "Please enter an existing Username and Password.", "Input needed", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (username.isEmpty() || username.equals("Username")) {
            JOptionPane.showMessageDialog(null, "Please enter an existing Username", "Input Information", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (password.isEmpty() || password.equals("Password")) {
            JOptionPane.showMessageDialog(null, "Please enter your Password", "Input Information", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            usname = username;
            pass = password;

            filecheck(); // Load accounts from JSON file

            boolean userFound = false;
            boolean accountAccessible = false;
            String foundType = null;

            for (Object obj : userlist) {
                JSONObject userobject = (JSONObject) obj;
                String foundusname = (String) userobject.get("username");
                String foundpass = (String) userobject.get("password");
                String status = (String) userobject.get("status");
                foundType = (String) userobject.get("type");

                if (usname.equals(foundusname) && pass.equals(foundpass)) {
                    if ("Accessible".equalsIgnoreCase(status)) {
                        userFound = true;
                        accountAccessible = true;
                    } else {
                        userFound = true;
                        accountAccessible = false;
                    }
                    break;
                }
            }

            if (!userFound) {
                JOptionPane.showMessageDialog(null, "No user found!", "Login Failed", JOptionPane.ERROR_MESSAGE);
            } else if (!accountAccessible) {
                JOptionPane.showMessageDialog(null, "This account has been disabled. Please contact an administrator.", "Access Denied", JOptionPane.ERROR_MESSAGE);
            } else {
                if ("Game Master".equalsIgnoreCase(foundType)) {
                    GameMaster g = new GameMaster(usname, usname);
                    g.setVisible(true);
                    setVisible(false);
                } else if ("Player".equalsIgnoreCase(foundType)) {
                    Player p = new Player(usname, "Player", 1, 2, "Player", usname);
                    p.setVisible(true);
                    setVisible(false);
                } else if ("Administrator".equalsIgnoreCase(foundType)) {
                    // ✅ REDIRECT TO ADMINISTRATOR FRAME
                    Administrator a = new Administrator(usname, "test");
                    a.setVisible(true);
                    setVisible(false);
                }
            }

        } catch (HeadlessException | IOException | ParseException e) {
            Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "An error occurred while logging in.", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SignInActionPerformed

    private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButtonActionPerformed
        SignUp a = new SignUp(usname);
        a.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_SignUpButtonActionPerformed

    private void hideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMousePressed
        show.setVisible(true);
        hide.setVisible(false);
        Password.setEchoChar((char) 0);
    }//GEN-LAST:event_hideMousePressed

    private void hideMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseReleased
        show.setVisible(false);
        hide.setVisible(true);
        Password.setEchoChar('*');
    }//GEN-LAST:event_hideMouseReleased

    public void filecheck() throws FileNotFoundException, IOException, ParseException {
        FileReader reader = new FileReader(FILE_PATH);

        if (reader.ready()) {
            Scanner scan = new Scanner(reader);
            StringBuilder line = new StringBuilder();

            while (scan.hasNext()) {
                line.append(scan.nextLine());
            }
            reader.close();

            if (!line.toString().isEmpty()) {
                try (FileReader reader2 = new FileReader(FILE_PATH)) {
                    record = (JSONObject) jsonParser.parse(reader2);
                    userlist = (JSONArray) record.get("Accounts");

                    if (userlist == null) {
                        userlist = new JSONArray(); // Avoid null pointer exceptions
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file again: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new SignIn("Test", "Testss").setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton SignIn;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel hide;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel show;
    // End of variables declaration//GEN-END:variables
}
