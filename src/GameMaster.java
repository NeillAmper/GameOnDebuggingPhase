
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

        jPanel1 = new javax.swing.JPanel();
        WelcomeMessage = new javax.swing.JLabel();
        createQuizButton = new javax.swing.JButton();
        deleteQuizButton = new javax.swing.JButton();
        editQuizButton = new javax.swing.JButton();
        leaderboardButton = new javax.swing.JButton();
        historyButton = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        WelcomeMessage.setText("Welcome, Game Master (...)!");

        createQuizButton.setText("Create Quiz");
        createQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createQuizButtonActionPerformed(evt);
            }
        });

        deleteQuizButton.setText("Delete Quiz");
        deleteQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteQuizButtonActionPerformed(evt);
            }
        });

        editQuizButton.setText("Edit Quiz");
        editQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editQuizButtonActionPerformed(evt);
            }
        });

        leaderboardButton.setText("Leaderboard");
        leaderboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderboardButtonActionPerformed(evt);
            }
        });

        historyButton.setText("History");
        historyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyButtonActionPerformed(evt);
            }
        });

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        profileButton.setText("Profile");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(WelcomeMessage))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(leaderboardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editQuizButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteQuizButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(historyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(createQuizButton)
                            .addComponent(profileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(WelcomeMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createQuizButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteQuizButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editQuizButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(leaderboardButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyButton)
                .addGap(7, 7, 7)
                .addComponent(profileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Logout)
                .addContainerGap(31, Short.MAX_VALUE))
        );

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton leaderboardButton;
    private javax.swing.JButton profileButton;
    // End of variables declaration//GEN-END:variables
}
