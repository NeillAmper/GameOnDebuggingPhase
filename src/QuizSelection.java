
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.*;

public class QuizSelection extends javax.swing.JFrame {

    private final String playerName;
    private final String usname;
    private JSONArray quizzesArray;
    private static final String FILE_PATH = "src/QuizData.json";

    public QuizSelection(String playerName, String quizData, String selectedQuiz, String usname) {
        this.playerName = playerName;
        this.usname = usname;
        initComponents();
        setupLiveSearch(); // 👈 Add this
        loadQuizData();
        populateTable(quizzesArray);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        quizSelection = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        quizTable = new javax.swing.JTable();
        categorySelection = new javax.swing.JComboBox<>();
        searchField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        quizSelection.setText("Select a quiz!");

        startButton.setText("START GAME");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        Back.setText("<");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        quizTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Quiz Title", "Creator", "Category"
            }
        ));
        jScrollPane1.setViewportView(quizTable);

        categorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Math", "Science", "History", "English", " " }));
        categorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorySelectionActionPerformed(evt);
            }
        });

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(Back)
                            .addGap(102, 102, 102)
                            .addComponent(quizSelection))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(124, 124, 124)
                            .addComponent(startButton))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(categorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Back)
                    .addComponent(quizSelection))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        new Player(playerName, "Player", 1, 2, "Player", usname).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        int selectedRow = quizTable.getSelectedRow(); // Get the selected row from the table
        if (selectedRow != -1) {
            // Retrieve the quiz title and category from the selected row
            DefaultTableModel model = (DefaultTableModel) quizTable.getModel();
            String selectedQuizTitle = (String) model.getValueAt(selectedRow, 0);
            String selectedQuizCategory = (String) model.getValueAt(selectedRow, 2); // Get the category

            JSONObject chosenQuiz = null;

            // Find the corresponding JSON object from the loaded quizzes
            for (Object o : quizzesArray) {
                JSONObject quiz = (JSONObject) o;
                String title = (String) quiz.get("QuizTitle"); // Match the key from your JSON file
                if (title.equals(selectedQuizTitle)) {
                    chosenQuiz = quiz;
                    break;
                }
            }

            if (chosenQuiz != null) {
                // Pass the quiz title, category, and quiz data to the Quiz class
                new Quiz(playerName, chosenQuiz.toJSONString(), selectedQuizTitle, selectedQuizCategory, usname).setVisible(true);
                this.dispose(); // Close the current frame
            } else {
                JOptionPane.showMessageDialog(this, "Quiz not found.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a quiz.");
        }    }//GEN-LAST:event_startButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
    ////
    }//GEN-LAST:event_searchFieldActionPerformed

    private void categorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorySelectionActionPerformed
        String selectedCategory = (String) categorySelection.getSelectedItem();
        if (selectedCategory.equals("All")) {
            populateTable(quizzesArray);
            return;
        }

        JSONArray filtered = new JSONArray();
        for (Object o : quizzesArray) {
            JSONObject quiz = (JSONObject) o;
            String category = (String) quiz.get("Category");
            if (category.equalsIgnoreCase(selectedCategory)) {
                filtered.add(quiz);
            }
        }

        populateTable(filtered);
    }//GEN-LAST:event_categorySelectionActionPerformed

    private void loadQuizData() {
        try {
            JSONParser parser = new JSONParser();
            // Parse the JSON file
            JSONObject obj = (JSONObject) parser.parse(new FileReader(FILE_PATH));

            // Ensure "Quizzes" is correctly parsed as a JSONArray
            Object quizzes = obj.get("Quizzes");
            if (quizzes instanceof JSONArray jSONArray) {
                quizzesArray = jSONArray; // Cast safely to JSONArray
            } else {
                throw new ClassCastException("'Quizzes' is not a JSONArray in the JSON file.");
            }

            if (quizzesArray.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No quizzes found in the file.");
            }
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Failed to load quiz data: " + e.getMessage());
            quizzesArray = new JSONArray(); // Default to an empty array on error
        } catch (ClassCastException e) {
            JOptionPane.showMessageDialog(this, "Error: 'Quizzes' is not a valid JSONArray. Please check the JSON file structure.");
            quizzesArray = new JSONArray(); // Handle invalid structure
        }
    }

    private void populateTable(JSONArray array) {
        DefaultTableModel model = (DefaultTableModel) quizTable.getModel();
        model.setRowCount(0); // Clear existing rows

        for (Object o : array) {
            JSONObject quiz = (JSONObject) o;
            String title = (String) quiz.get("QuizTitle");
            String creator = (String) quiz.get("Creator");
            String category = (String) quiz.get("Category");
            model.addRow(new Object[]{title, creator, category});
        }

        if (array.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No quizzes found.");
        }
    }

    private void searchQuizzes(String keyword) {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray quizArray = (JSONArray) jsonObject.get("Quizzes");

            JSONArray filtered = new JSONArray(); // Use JSONArray instead of List
            String keywordLower = keyword.toLowerCase();

            for (Object obj : quizArray) {
                JSONObject quiz = (JSONObject) obj;

                String title = (String) quiz.get("QuizTitle");
                String creator = (String) quiz.get("Creator");
                String category = (String) quiz.get("Category");

                if ((title != null && title.toLowerCase().contains(keywordLower))
                        || (creator != null && creator.toLowerCase().contains(keywordLower))
                        || (category != null && category.toLowerCase().contains(keywordLower))) {
                    filtered.add(quiz); // Add directly to JSONArray
                }
            }

            populateTable(filtered); // Now it's a proper JSONArray

        } catch (IOException | ParseException ex) {
            JOptionPane.showMessageDialog(this, "Error loading search results: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setupLiveSearch() {
        searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                performSearch();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                performSearch();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                performSearch();
            }

            private void performSearch() {
                String keyword = searchField.getText().trim();
                if (!keyword.isEmpty()) {
                    searchQuizzes(keyword);
                } else {
                    populateTable(quizzesArray);
                }
            }
        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new QuizSelection("TestPlayer", "Testsss", "Tetss", "testing").setVisible(true); // Pass only the player name
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> categorySelection;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel quizSelection;
    private javax.swing.JTable quizTable;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
