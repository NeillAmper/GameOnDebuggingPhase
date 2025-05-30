
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SignUp extends javax.swing.JFrame {

    private static String addname, addpass, addtype;
    private final String usname;
    private static final String FILE_PATH = "src/UserData.json";
    private static final JSONParser jsonParser2 = new JSONParser();
    private static JSONObject record = new JSONObject();
    private static JSONArray userlist = new JSONArray();

    public SignUp(String usname) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        Password = new javax.swing.JTextField();
        ConfirmPassword = new javax.swing.JTextField();
        TypeComboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        SignUpButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jLabel1.setText("Create Account");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        Username.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        Username.setText("Username");
        jPanel1.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 220, 40));

        Password.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        Password.setText("Password");
        jPanel1.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 220, 40));

        ConfirmPassword.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        ConfirmPassword.setText("Confirm Password");
        jPanel1.add(ConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 220, 40));

        TypeComboBox.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        TypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select User Type", "Player", "Game Master" }));
        jPanel1.add(TypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 220, 40));

        jButton1.setBackground(new java.awt.Color(204, 0, 51));
        jButton1.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sign In");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 160, 40));

        SignUpButton.setBackground(new java.awt.Color(204, 0, 51));
        SignUpButton.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        SignUpButton.setForeground(new java.awt.Color(255, 255, 255));
        SignUpButton.setText("Sign Up");
        SignUpButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SignUpButton.setVerifyInputWhenFocusTarget(false);
        SignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButtonActionPerformed(evt);
            }
        });
        jPanel1.add(SignUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 160, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Sign up BG.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButtonActionPerformed
        String password = Password.getText();
        String confirmPassword = ConfirmPassword.getText();
        String userCategory = TypeComboBox.getSelectedItem().toString();
        String username = Username.getText();

        // Validate inputs
        if (username.equals("Username")) {
            JOptionPane.showMessageDialog(null, "Please enter a Username", "Input Information", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (password.equals("Password")) {
            JOptionPane.showMessageDialog(null, "Please enter a Password", "Input Information", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (userCategory.equals("Select User Type")) {
            JOptionPane.showMessageDialog(null, "Please select a user type!", "Invalid Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match! Please enter matching passwords.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            filecheck(); // Ensure the file and structure are ready
        } catch (IOException | ParseException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Check if the username already exists
        if (isUsernameTaken(username)) {
            JOptionPane.showMessageDialog(null, "Username already exists. Please choose a different username.", "Duplicate Username", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Confirm user addition
        int confirm = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to add this user?",
                "Confirm User Addition",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Gather user input
            addname = Username.getText();
            addpass = Password.getText();
            addtype = TypeComboBox.getSelectedItem().toString();

            // Create the new user object with the required structure
            JSONObject newUser = new JSONObject();
            newUser.put("username", addname);
            newUser.put("password", addpass);
            newUser.put("type", addtype);
            newUser.put("status", "Accessible"); // Default status to "Disabled"
            newUser.put("disabledFeature", ""); // Ensure "disabledFeature" is set to "None"

            // Add the new user to the user list
            userlist.add(newUser);
            record.put("Accounts", userlist);

            try {
                save(); // Save the updated JSON structure to the file
            } catch (IOException ex) {
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Successfully Added into the Database...");
        } else {
            JOptionPane.showMessageDialog(null, "User addition canceled.", "Canceled", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_SignUpButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SignIn a = new SignIn(usname, "test");
        a.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (!"Nimbus".equals(info.getName())) {
                } else {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new SignUp("Tets").setVisible(true);
        });
    }

    public void filecheck() throws FileNotFoundException, IOException, ParseException {
        FileReader reader = new FileReader(FILE_PATH);

        if (reader.ready()) {
            Scanner scan = new Scanner(reader);
            String line = "";

            while (scan.hasNext()) {
                line = line + scan.nextLine();
            }
            reader.close();
            if (!line.equals("")) {
                reader.close();
                try (FileReader reader2 = new FileReader(FILE_PATH)) {
                    record = (JSONObject) jsonParser2.parse(reader2);
                    userlist = (JSONArray) record.get("Accounts");
                } catch (IOException a) {
                    System.out.println("error");
                }
            }
        }
    }

    private boolean isUsernameTaken(String username) {
        for (Object userObject : userlist) {
            JSONObject user = (JSONObject) userObject;
            if (user.get("username").toString().equalsIgnoreCase(username)) {
                return true; // Username exists
            }
        }
        return false; // Username does not exist
    }

    public static void save() throws IOException {
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(record.toJSONString());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ConfirmPassword;
    private javax.swing.JTextField Password;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JComboBox<String> TypeComboBox;
    private javax.swing.JTextField Username;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
