
import java.awt.HeadlessException;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;

public class Leaderboard extends javax.swing.JFrame {

    private final String adminName;
    private final String gameMasterName;
    private final String playerName;
    private final String usname;
    private final DefaultTableModel tableModel;
    private static final String[] FILE_PATH = {"src/QuizData.json", "src/UserData.json"};
    private boolean isLoadingCategories = false;

    public Leaderboard(String adminName, String gameMasterName, String playerName, String usname) {
        this.adminName = adminName;
        this.gameMasterName = gameMasterName;
        this.playerName = playerName;
        this.usname = usname;
        initComponents();
        tableModel = (DefaultTableModel) leaderboardTable.getModel();
        loadCategories();
        loadAllLeaderboardData();
        addSearchListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        categorySelection = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        leaderboardTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Leaderboard");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        categorySelection.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        categorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Math", "Science", "History", "English" }));
        categorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorySelectionActionPerformed(evt);
            }
        });
        jPanel1.add(categorySelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 62, 160, 40));

        leaderboardTable.setBackground(new java.awt.Color(102, 153, 255));
        leaderboardTable.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        leaderboardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Rank", "Title", "Player", "Quizzes Done", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(leaderboardTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 600, 370));

        backButton.setBackground(new java.awt.Color(102, 204, 255));
        backButton.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 0, 0));
        backButton.setText("<");
        backButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 40));

        searchField.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jPanel1.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 62, 160, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Leaderboard BG.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 790, 560));

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
            // Check if adminName is not null or empty
            if (adminName != null && !adminName.isEmpty()) {
                // Navigate back to Administrator with adminName and usname
                new Administrator(adminName, usname).setVisible(true);
            } // Check if gameMasterName is not null or empty
            else if (gameMasterName != null && !gameMasterName.isEmpty()) {
                // Navigate back to GameMaster with gameMasterName and usname
                new GameMaster(gameMasterName, usname).setVisible(true);
            } // Check if playerName is not null or empty
            else if (playerName != null && !playerName.isEmpty()) {
                // Navigate back to Player with appropriate parameters
                new Player(playerName, "Player", 1, 2, "Player", usname).setVisible(true);
            } else {
                // Display an error message if no valid user type is found
                JOptionPane.showMessageDialog(this, "No valid user type found to navigate back.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (HeadlessException e) {
            // Handle unexpected exceptions and provide feedback to the user
            JOptionPane.showMessageDialog(this, "Error navigating back: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Dispose the current frame to return to the previous one
            this.dispose();
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void categorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorySelectionActionPerformed
        // Skip if categories are still being loaded
        if (isLoadingCategories) {
            return;
        }

        String selectedCategory = (String) categorySelection.getSelectedItem();
        if (selectedCategory != null) {
            // Force reload by explicitly calling filterByCategory
            filterByCategory(selectedCategory);
        }
    }//GEN-LAST:event_categorySelectionActionPerformed

   

    private void loadAllLeaderboardData() {
        try (FileReader reader = new FileReader(FILE_PATH[1])) { // Use FILE_PATH[1] for UserData.json
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // Ensure "Standing" exists and is not null
            JSONArray standing = (JSONArray) jsonObject.get("Standing");
            if (standing == null) {
                JOptionPane.showMessageDialog(this, "Leaderboard data is empty.", "Information", JOptionPane.INFORMATION_MESSAGE);
                tableModel.setRowCount(0); // Clear the table
                return;
            }

            List<JSONObject> allData = new ArrayList<>();
            for (Object obj : standing) {
                JSONObject entry = (JSONObject) obj;
                allData.add(entry); // Add all entries without filtering
            }

            // Clear the table and load all data into it
            tableModel.setRowCount(0); // Clear existing data from the table
            loadLeaderBoard(allData); // Load all data into the table
        } catch (IOException | ParseException ex) {
            JOptionPane.showMessageDialog(this, "Error loading leaderboard data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void filterByCategory(String selectedCategory) {
        try (FileReader reader = new FileReader(FILE_PATH[1])) { // Use FILE_PATH[1] for UserData.json
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // Ensure "Standing" exists and is not null
            JSONArray standing = (JSONArray) jsonObject.get("Standing");
            if (standing == null) {
                JOptionPane.showMessageDialog(this, "Leaderboard data is empty.", "Information", JOptionPane.INFORMATION_MESSAGE);
                tableModel.setRowCount(0); // Clear the table
                return;
            }

            List<JSONObject> filtered = new ArrayList<>();
            for (Object obj : standing) {
                JSONObject entry = (JSONObject) obj;
                String category = (String) entry.get("category");

                // If "All" is selected, include all entries
                if ("All".equalsIgnoreCase(selectedCategory)) {
                    filtered.add(entry);
                } else if (category != null && selectedCategory.equalsIgnoreCase(category)) {
                    // Filter by the selected category
                    filtered.add(entry);
                }
            }

            // Clear the table and reload data
            tableModel.setRowCount(0); // Clear existing data from the table
            loadLeaderBoard(filtered); // Load new data into the table
        } catch (IOException | ParseException ex) {
            JOptionPane.showMessageDialog(this, "Error filtering leaderboard: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadLeaderBoard(List<JSONObject> dataList) {
        tableModel.setRowCount(0);

        // Sort the data by quizzesDone in descending order
        dataList.sort((a, b) -> Long.compare((long) b.get("quizzesDone"), (long) a.get("quizzesDone")));

        int rank = 1;
        for (JSONObject obj : dataList) {
            // Determining rank titles
            String title = switch (rank) {
                case 1 ->
                    "Platinum";
                case 2 ->
                    "Gold";
                case 3 ->
                    "Silver";
                default ->
                    "Bronze";
            };

            Object quizzesDoneObj = obj.get("quizzesDone");
            long quizzesDone = (quizzesDoneObj instanceof Number) ? ((Number) quizzesDoneObj).longValue() : 0L;

            Object player = obj.get("player");
            Object category = obj.get("category");

            // Add all entries to the leaderboard table
            tableModel.addRow(new Object[]{
                rank, // Rank column
                title, // Title column
                player != null ? player.toString() : "", // Player name
                quizzesDone, // Number of quizzes done
                category != null ? category.toString() : "" // Category column
            });

            rank++;
        }
    }

    private void addSearchListener() {
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String keyword = searchField.getText().trim().toLowerCase();
                if (keyword.isEmpty()) {
                    loadAllLeaderboardData();
                } else {
                    searchQuizzes(keyword);
                }
            }
        });
    }

    private void searchQuizzes(String keyword) {
        try (FileReader reader = new FileReader(FILE_PATH[1])) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray leaderboard = (JSONArray) jsonObject.get("Standing");

            List<Object[]> matchedRows = new ArrayList<>();
            String keywordLower = keyword.toLowerCase(); // Convert keyword to lowercase for case-insensitive searching

            int rank = 1;
            for (Object obj : leaderboard) {
                JSONObject entry = (JSONObject) obj;

                String title = switch (rank) {
                    case 1 ->
                        "Platinum";
                    case 2 ->
                        "Gold";
                    case 3 ->
                        "Silver";
                    default ->
                        "Bronze";
                };

                String player = (String) entry.get("player");
                String category = (String) entry.get("category");
                long quizzesDone = (entry.get("quizzesDone") instanceof Number)
                        ? ((Number) entry.get("quizzesDone")).longValue()
                        : 0L;

                // Convert each field to lower case string
                String rankStr = String.valueOf(rank).toLowerCase();
                String titleStr = title.toLowerCase();
                String playerStr = player != null ? player.toLowerCase() : "";
                String quizzesDoneStr = String.valueOf(quizzesDone);
                String categoryStr = category != null ? category.toLowerCase() : "";

                // Check if keyword is in ANY field (partial match)
                boolean match = rankStr.contains(keywordLower)
                        || titleStr.contains(keywordLower)
                        || playerStr.contains(keywordLower)
                        || quizzesDoneStr.contains(keywordLower)
                        || categoryStr.contains(keywordLower);

                if (match) {
                    matchedRows.add(new Object[]{
                        rank,
                        title,
                        player != null ? player : "",
                        quizzesDone,
                        category != null ? category : ""
                    });
                }

                rank++;
            }

            // Update the table with matched rows
            tableModel.setRowCount(0);
            for (Object[] row : matchedRows) {
                tableModel.addRow(row);
            }

        } catch (IOException | ParseException ex) {
            JOptionPane.showMessageDialog(this, "Error loading search results: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCategories() {
        isLoadingCategories = true;

        try {
            // Populate fixed categories
            categorySelection.removeAllItems();
            categorySelection.addItem("All");
            categorySelection.addItem("Math");
            categorySelection.addItem("Science");
            categorySelection.addItem("History");
            categorySelection.addItem("English");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading categories: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            isLoadingCategories = false;
        }
    }

    // Main method for testing
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Leaderboard("Player", "GameMaster", "Admin", "Test").setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> categorySelection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable leaderboardTable;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
