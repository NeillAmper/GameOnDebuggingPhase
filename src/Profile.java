
import java.awt.HeadlessException;
import javax.swing.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Profile extends javax.swing.JFrame {

    private final String usname; // The username of the signed-in user
    private static final String FILE_PATH = "src/UserData.json"; // Path to UserData.json

    public Profile(String usname) {
        this.usname = usname;

        initComponents();

        // Fetch the user type and validate the username
        String userType = fetchUserType();
        String displayName = (this.usname != null && !this.usname.trim().isEmpty()) ? this.usname : "Unknown User";

        // Update the label to display the username and user type
        jLabel1.setText("Edit Profile Information for " + displayName);

        // Set the user type in the TypeComboBox
        if ("Game Master".equalsIgnoreCase(userType)) {
            typeComboBox.setSelectedItem("Game Master");
        } else if ("Player".equalsIgnoreCase(userType)) {
            typeComboBox.setSelectedItem("Player");
        } else if ("Administrator".equalsIgnoreCase(userType)) {
            typeComboBox.setSelectedItem("Administrator");
        } else {
            typeComboBox.setSelectedItem("Unknown"); // Fallback for invalid or missing type
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        newUsernameField = new javax.swing.JTextField();
        newPasswordField = new javax.swing.JTextField();
        confirmNewPasswordField = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        typeComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setBackground(new java.awt.Color(0, 51, 255));
        backButton.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 0, 0));
        backButton.setText("<");
        backButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 17, 100, 40));

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edit Profile Information for (...)");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, 30));

        newUsernameField.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        newUsernameField.setText("Enter New Username");
        newUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUsernameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(newUsernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 190, 40));

        newPasswordField.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        newPasswordField.setText("Enter New Password");
        jPanel1.add(newPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 190, 40));

        confirmNewPasswordField.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        confirmNewPasswordField.setText("Confirm New Password");
        jPanel1.add(confirmNewPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 190, 40));

        confirmButton.setBackground(new java.awt.Color(0, 51, 255));
        confirmButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        confirmButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("Confirm");
        confirmButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        jPanel1.add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 160, 40));

        typeComboBox.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Player", "Game Master" }));
        jPanel1.add(typeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 190, 40));

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter New Username:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 100, 230, 40));

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter New Password:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 170, 230, 40));

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Confirm New Password:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 250, 40));

        deleteButton.setBackground(new java.awt.Color(0, 51, 255));
        deleteButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete Account");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 160, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GameOn! Blue BG (Big Logo Ver.).png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 560));

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

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        try {
            String userType = fetchUserType();
            switch (userType) {
                case "Administrator" -> {
                    new Administrator(usname, usname).setVisible(true);
                }
                case "Game Master" -> {
                    new GameMaster(usname, usname).setVisible(true);
                }
                case "Player" -> {
                    new Player(usname, "Player", 1, 2, "Player", usname).setVisible(true);
                }
                default -> {
                    JOptionPane.showMessageDialog(this, "No valid user type found to navigate back.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error navigating back: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            this.dispose();
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        String newUsername = newUsernameField.getText().trim();
        String newPassword = newPasswordField.getText().trim();
        String confirmPassword = confirmNewPasswordField.getText().trim();
        String newType = typeComboBox.getSelectedItem().toString();

        if (newUsername.equals("Enter New Username") && newPassword.equals("Enter New Password")
                && confirmPassword.equals("Confirm New Password") && newType.equalsIgnoreCase(usname)) {
            JOptionPane.showMessageDialog(this, "No changes were made to your profile.", "No Changes", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to update your profile?", "Confirm Changes", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            JSONParser parser = new JSONParser();
            JSONObject userData = (JSONObject) parser.parse(new FileReader(FILE_PATH));
            JSONArray users = (JSONArray) userData.get("Accounts");

            boolean updated = false;

            for (Object obj : users) {
                JSONObject user = (JSONObject) obj;
                if (user.get("username").toString().equals(usname)) {
                    if (!newUsername.isBlank() && !newUsername.equals("Enter New Username")) {
                        user.put("username", newUsername);
                    } else {
                        newUsername = usname;
                    }

                    if (!newPassword.isBlank() && !newPassword.equals("Enter New Password")) {
                        if (!newPassword.equals(confirmPassword)) {
                            JOptionPane.showMessageDialog(this, "Passwords do not match!");
                            return;
                        }
                        user.put("password", newPassword);
                    }

                    if (!newType.equalsIgnoreCase(user.get("type").toString())) {
                        user.put("type", newType);
                    }

                    updated = true;
                    break;
                }
            }

            if (updated) {
                // Update quizzes
                JSONObject quizData = (JSONObject) parser.parse(new FileReader(FILE_PATH));
                JSONArray quizzes = (JSONArray) quizData.get("Quizzes");
                for (Object obj : quizzes) {
                    JSONObject quiz = (JSONObject) obj;
                    if (!quiz.get("creator").toString().equals(usname)) {
                    } else {
                        quiz.put("creator", newUsername);
                    }
                }
                try (FileWriter writer = new FileWriter(FILE_PATH)) {
                    quizData.put("Quizzes", quizzes);
                    writer.write(quizData.toJSONString());
                }

                // Update history and standing
                JSONArray history = (JSONArray) userData.get("History");
                if (history != null) {
                    for (Object obj : history) {
                        JSONObject entry = (JSONObject) obj;
                        if (entry.get("player").toString().equals(usname)) {
                            entry.put("player", newUsername);
                        }
                    }
                }

                JSONArray standing = (JSONArray) userData.get("Standing");
                if (standing != null) {
                    for (Object obj : standing) {
                        JSONObject entry = (JSONObject) obj;
                        if (entry.get("player").toString().equals(usname)) {
                            entry.put("player", newUsername);
                        }
                    }
                }

                try (FileWriter writer = new FileWriter(FILE_PATH)) {
                    userData.put("Accounts", users);
                    userData.put("History", history);
                    userData.put("Standing", standing);
                    writer.write(userData.toJSONString());
                }

                JOptionPane.showMessageDialog(this, "Profile updated successfully!");

                if ("Game Master".equals(newType)) {
                    new GameMaster(newUsername, usname).setVisible(true);
                } else {
                    new Player(newUsername, "Player", 1, 2, "Player", usname).setVisible(true);
                }

                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "User not found!");
            }

        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error updating profile: " + e.getMessage());
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void newUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newUsernameFieldActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to permanently delete your account?\nThis will remove all associated data.", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            JSONParser parser = new JSONParser();
            JSONObject userData = (JSONObject) parser.parse(new FileReader(FILE_PATH));
            JSONArray accounts = (JSONArray) userData.get("Accounts");
            JSONArray history = (JSONArray) userData.get("History");
            JSONArray standing = (JSONArray) userData.get("Standing");

            accounts.removeIf(obj -> ((JSONObject) obj).get("username").toString().equals(usname));
            if (history != null) {
                history.removeIf(obj -> ((JSONObject) obj).get("player").toString().equals(usname));
            }
            if (standing != null) {
                standing.removeIf(obj -> ((JSONObject) obj).get("player").toString().equals(usname));
            }

            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                userData.put("Accounts", accounts);
                userData.put("History", history);
                userData.put("Standing", standing);
                writer.write(userData.toJSONString());
            }

            // Remove user's quizzes
            JSONObject quizData = (JSONObject) parser.parse(new FileReader(FILE_PATH));
            JSONArray quizzes = (JSONArray) quizData.get("Quizzes");
            quizzes.removeIf(obj -> {
                return usname.equals(((JSONObject) obj).get("creator").toString());
            });

            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                quizData.put("Quizzes", quizzes);
                writer.write(quizData.toJSONString());
            }

            JOptionPane.showMessageDialog(this, "Account deleted successfully.");
            new SignIn(usname, null).setVisible(true);
            this.dispose();

        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error deleting account: " + e.getMessage());
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private String fetchUserType() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject userData = (JSONObject) parser.parse(reader);
            JSONArray accounts = (JSONArray) userData.get("Accounts");

            // Iterate through accounts to find the matching username
            for (Object obj : accounts) {
                JSONObject user = (JSONObject) obj;
                if (user.get("username").toString().equals(usname)) {
                    // Populate fields with user data
                    String username = user.get("username").toString();
                    String userType = user.get("type").toString();
                    newUsernameField.setText(username);
                    newPasswordField.setText(user.get("password").toString());
                    confirmNewPasswordField.setText(""); // Default to empty
                    updateDynamicLabel(username, userType); // Update the label
                    return userType;
                }
            }
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error fetching user type: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return "Unknown"; // Default return value if user not found
    }

    private void updateDynamicLabel(String username, String userType) {
        if (username == null || username.trim().isEmpty()) {
            username = "Unknown User";
        }
        if (userType == null || userType.trim().isEmpty()) {
            userType = "Unknown";
        }
        jLabel1.setText("Edit Profile Information for " + username + " (" + userType + ")");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Profile("User").setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JTextField confirmNewPasswordField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField newPasswordField;
    private javax.swing.JTextField newUsernameField;
    private javax.swing.JComboBox<String> typeComboBox;
    // End of variables declaration//GEN-END:variables
}
