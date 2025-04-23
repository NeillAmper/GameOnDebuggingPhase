
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public final class GameMaster extends javax.swing.JFrame {

    private final String gameMasterName;
    private final String usname;
    private String Disabled_Feature; // Instance field for the disabled feature

    public GameMaster(String gameMasterName, String usname) {
        this.gameMasterName = gameMasterName;
        this.usname = usname;
        initComponents();
        WelcomeMessage.setText("Welcome, Game Master " + gameMasterName + "!"); // ✅ Fixed from usernameLabel
        Current_Disabled_Feature(); // Dynamically enable/disable buttons based on Disabled_Feature
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        Logout = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        historyButton = new javax.swing.JButton();
        leaderboardButton = new javax.swing.JButton();
        deleteQuizButton = new javax.swing.JButton();
        editQuizButton = new javax.swing.JButton();
        createQuizButton = new javax.swing.JButton();
        WelcomeMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logout.setBackground(new java.awt.Color(51, 0, 153));
        Logout.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 0, 0));
        Logout.setText("Logout");
        Logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jLayeredPane1.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 150, 40));

        profileButton.setBackground(new java.awt.Color(51, 0, 153));
        profileButton.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        profileButton.setForeground(new java.awt.Color(255, 255, 255));
        profileButton.setText("Profile");
        profileButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(profileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 150, 40));

        historyButton.setBackground(new java.awt.Color(51, 0, 153));
        historyButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        historyButton.setForeground(new java.awt.Color(255, 255, 255));
        historyButton.setText("History");
        historyButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        historyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(historyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 150, 40));

        leaderboardButton.setBackground(new java.awt.Color(51, 0, 153));
        leaderboardButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        leaderboardButton.setForeground(new java.awt.Color(255, 255, 255));
        leaderboardButton.setText("Leaderboard");
        leaderboardButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        leaderboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderboardButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(leaderboardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 150, 40));

        deleteQuizButton.setBackground(new java.awt.Color(51, 0, 153));
        deleteQuizButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        deleteQuizButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteQuizButton.setText("Delete Quiz");
        deleteQuizButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteQuizButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(deleteQuizButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 150, 40));

        editQuizButton.setBackground(new java.awt.Color(51, 0, 153));
        editQuizButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        editQuizButton.setForeground(new java.awt.Color(255, 255, 255));
        editQuizButton.setText("Edit Quiz");
        editQuizButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editQuizButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(editQuizButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 150, 40));

        createQuizButton.setBackground(new java.awt.Color(51, 0, 153));
        createQuizButton.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        createQuizButton.setForeground(new java.awt.Color(255, 255, 255));
        createQuizButton.setText("Create Quiz");
        createQuizButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createQuizButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(createQuizButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 150, 40));

        WelcomeMessage.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        WelcomeMessage.setForeground(new java.awt.Color(255, 255, 255));
        WelcomeMessage.setText("Welcome, Game Master (...)!");
        jLayeredPane1.add(WelcomeMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GameOn! (Purple BG).png"))); // NOI18N
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        new SignIn(usname, "pass").setVisible(true); // Open the SignIn JFrame
        this.dispose(); // Dispose this JFrame and release resources
    }//GEN-LAST:event_LogoutActionPerformed

    private void createQuizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createQuizButtonActionPerformed
        this.setVisible(false);
        new CreateQuiz(null, gameMasterName, usname).setVisible(true);
    }//GEN-LAST:event_createQuizButtonActionPerformed

    private void deleteQuizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteQuizButtonActionPerformed
        this.setVisible(false);
        new DeleteQuiz(null, gameMasterName, usname).setVisible(true);
    }//GEN-LAST:event_deleteQuizButtonActionPerformed

    private void editQuizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editQuizButtonActionPerformed
        this.setVisible(false);
        new EditQuizTable(null, gameMasterName, usname, null).setVisible(true);
    }//GEN-LAST:event_editQuizButtonActionPerformed

    private void leaderboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderboardButtonActionPerformed
        this.setVisible(false);
        // Navigate to the Leaderboard with the Game Master's details
        new Leaderboard(null, gameMasterName, null, usname).setVisible(true);
    }//GEN-LAST:event_leaderboardButtonActionPerformed

    private void historyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyButtonActionPerformed
        this.setVisible(false);
        // Corrected the argument order and roles passed to the History class
        new History(null, gameMasterName, null, usname).setVisible(true);
    }//GEN-LAST:event_historyButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        this.dispose();
        // Pass the correct username to the Profile constructor
        new Profile(usname).setVisible(true); // changed
    }//GEN-LAST:event_profileButtonActionPerformed

    public void Current_Disabled_Feature() {
        Disabled_Feature = ""; // Default value in case of error or missing data

        try (FileReader reader = new FileReader("src/UserData.json")) {
            // Parse the JSON file
            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(reader);

            // Get the "Accounts" array
            JSONArray accounts = (JSONArray) data.get("Accounts");

            // Search for the account matching the current username
            for (Object obj : accounts) {
                JSONObject account = (JSONObject) obj;
                String username = (String) account.get("username");

                if (username.equals(gameMasterName)) {
                    // Get the disabledFeature value
                    Object disabledFeatureObject = account.get("disabledFeature");

                    // Reset all buttons to enabled (default state)
                    leaderboardButton.setEnabled(true);
                    historyButton.setEnabled(true);
                    createQuizButton.setEnabled(true);
                    deleteQuizButton.setEnabled(true);
                    editQuizButton.setEnabled(true);
                    profileButton.setEnabled(true);

                    // Check if disabledFeature is an array or single string
                    switch (disabledFeatureObject) {
                        case JSONArray disabledFeaturesArray -> {
                            // Disable buttons based on the array contents
                            for (Object feature : disabledFeaturesArray) {
                                String featureName = (String) feature;

                                switch (featureName) {
                                    case "Leaderboard" ->
                                        leaderboardButton.setEnabled(false);
                                    case "History" ->
                                        historyButton.setEnabled(false);
                                    case "CreateQuiz" ->
                                        createQuizButton.setEnabled(false);
                                    case "DeleteQuiz" ->
                                        deleteQuizButton.setEnabled(false);
                                    case "EditQuiz" ->
                                        editQuizButton.setEnabled(false);
                                    case "Profile" ->
                                        profileButton.setEnabled(false);
                                }
                            }
                        }
                        case String string -> {
                            // Handle disabledFeature as a single string (fallback for older format)
                            Disabled_Feature = string;

                            switch (Disabled_Feature) {
                                case "None" -> {
                                    // All buttons remain enabled
                                }
                                case "Leaderboard" ->
                                    leaderboardButton.setEnabled(false);
                                case "History" ->
                                    historyButton.setEnabled(false);
                                case "CreateQuiz" ->
                                    createQuizButton.setEnabled(false);
                                case "DeleteQuiz" ->
                                    deleteQuizButton.setEnabled(false);
                                case "EditQuiz" ->
                                    editQuizButton.setEnabled(false);
                                case "Profile" ->
                                    profileButton.setEnabled(false);
                            }
                        }
                        default -> {
                        }
                    }

                    break; // Exit loop once the matching account is found
                }
            }
        } catch (IOException | ParseException e) {
            // Log the exception for debugging

        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new GameMaster("TestName", "Testss").setVisible(true); // Replace "TestName" with any string for testing
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JLabel WelcomeMessage;
    private javax.swing.JButton createQuizButton;
    private javax.swing.JButton deleteQuizButton;
    private javax.swing.JButton editQuizButton;
    private javax.swing.JButton historyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton leaderboardButton;
    private javax.swing.JButton profileButton;
    // End of variables declaration//GEN-END:variables
}
