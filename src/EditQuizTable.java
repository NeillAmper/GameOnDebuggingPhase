
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.HashSet;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EditQuizTable extends javax.swing.JFrame {

    private static final String[] FILE_PATH = {"src/QuizData.json", "src/UserData.json"};
    private final String adminName;
    private final String gameMasterName;
    private final String usname;

    public EditQuizTable(String adminName, String gameMasterName, String usname, String selectedQuizTitle) {
        this.adminName = adminName;
        this.gameMasterName = (gameMasterName != null) ? gameMasterName : ""; // Default to empty string
        this.usname = usname;
        initComponents();
        loadQuizzesByCreator();
        populateCategorySelection(); // Populates category combo box with available categories
        loadCategoryQuizzes(); // Loads quizzes based on the selected category
        addSearchListener(); // Adds listener to search field for live updates
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        QuizTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        CategorySelection = new javax.swing.JComboBox<>();
        EditButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        QuizTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title", "Creator", "Category"
            }
        ));
        QuizTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                QuizTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(QuizTable);

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        CategorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Science", "Math", "History", "English" }));
        CategorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategorySelectionActionPerformed(evt);
            }
        });

        EditButton.setText("Edit");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        BackButton.setText("<");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CategorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(41, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EditButton)
                .addGap(82, 82, 82))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(BackButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(BackButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CategorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditButton)
                .addGap(12, 12, 12))
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

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        if (adminName != null && !adminName.isEmpty()) {
            // Navigate back to Administrator.java for adminName
            Administrator admin = new Administrator(adminName, usname);
            admin.setVisible(true);
        } else if (gameMasterName != null && !gameMasterName.isEmpty()) {
            // Navigate back to GameMaster.java for gameMasterName
            GameMaster g = new GameMaster(gameMasterName, usname);
            g.setVisible(true);
        }

        this.setVisible(false); // Close the current CreateQuiz window
    }//GEN-LAST:event_BackButtonActionPerformed

    private void CategorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategorySelectionActionPerformed
        loadCategoryQuizzes(); // WHEN CATEGORY IS CHANGED, RELOAD QUIZZES
    }//GEN-LAST:event_CategorySelectionActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int selectedRow = QuizTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a quiz to edit.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Safely retrieve the quiz title
        Object value = QuizTable.getValueAt(selectedRow, 0);
        if (value == null || value.toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "The selected quiz title is empty or invalid.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String selectedTitle = value.toString().trim();

        // Validate if the quiz exists in QuizData.json
        try (FileReader reader = new FileReader(FILE_PATH[0])) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            boolean quizExists = false;
            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;
                if (selectedTitle.equals(quiz.get("QuizTitle"))) {
                    quizExists = true;
                    break;
                }
            }

            if (!quizExists) {
                JOptionPane.showMessageDialog(this, "The selected quiz does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Failed to validate the quiz. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Pass the selected quiz title to the EditQuiz constructor
        EditQuiz editQuiz = new EditQuiz(selectedTitle, adminName, gameMasterName, usname);
        editQuiz.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_EditButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // Optional: Handle search field enter key
    }//GEN-LAST:event_searchFieldActionPerformed

    private void QuizTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_QuizTableAncestorAdded
        // Optional: Handle table ancestor events
    }//GEN-LAST:event_QuizTableAncestorAdded

    private void populateCategorySelection() {
        try (FileReader reader = new FileReader(FILE_PATH[0])) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");
            Set<String> categories = new HashSet<>();

            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;
                Object categoryObj = quiz.get("Category");
                if (categoryObj != null) {
                    categories.add(categoryObj.toString());
                }
            }

            CategorySelection.removeAllItems();
            CategorySelection.addItem("All");
            for (String category : categories) {
                CategorySelection.addItem(category);
            }

            CategorySelection.setSelectedItem("All");
            loadCategoryQuizzes();

        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Failed to load categories.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCategoryQuizzes() {
        DefaultTableModel model = (DefaultTableModel) QuizTable.getModel();
        model.setRowCount(0); // Clear current table data

        try (FileReader reader = new FileReader(FILE_PATH[0])) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            Object selectedItem = CategorySelection.getSelectedItem();
            if (selectedItem == null) {
                return; // No category selected yet
            }

            String selectedCategory = selectedItem.toString();
            String keyword = searchField.getText().toLowerCase();
            boolean isAdmin = isAdminUser();

            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;

                if (doesQuizMatchFilters(quiz, selectedCategory, keyword, isAdmin)) {
                    model.addRow(new Object[]{
                        quiz.get("QuizTitle"),
                        quiz.get("Creator"),
                        quiz.get("Category")
                    });
                }
            }
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Failed to load quizzes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addSearchListener() {
        if (searchField != null) {
            searchField.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    loadCategoryQuizzes();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    loadCategoryQuizzes();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    loadCategoryQuizzes();
                }
            });
        }
    }

    private void loadQuizzesByCreator() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(new FileReader(FILE_PATH[0]));
            JSONArray quizzes = (JSONArray) data.get("Quizzes");

            DefaultTableModel model = (DefaultTableModel) QuizTable.getModel();
            model.setRowCount(0);

            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;

                // Null check for gameMasterName to avoid NullPointerException
                if (gameMasterName != null && gameMasterName.equals(quiz.get("Creator"))) {
                    model.addRow(new Object[]{
                        quiz.get("QuizTitle"),
                        quiz.get("Creator"),
                        quiz.get("Category")
                    });
                }
            }
        } catch (IOException | ParseException e) {
            Logger.getLogger(EditQuizTable.class.getName()).log(Level.SEVERE, "Error loading quizzes by creator", e);
            JOptionPane.showMessageDialog(this, "Failed to load quizzes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isAdminUser() {
        if (adminName == null || adminName.isEmpty()) {
            return false;
        }

        try (FileReader reader = new FileReader(FILE_PATH[1])) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray users = (JSONArray) root.get("Accounts");

            for (Object obj : users) {
                JSONObject user = (JSONObject) obj;
                String username = user.get("username").toString();
                String type = user.get("type").toString();

                if (adminName.equals(username)) {
                    return type.equalsIgnoreCase("Administrator");
                }
            }
        } catch (IOException | ParseException e) { // Log the exception
            // Log the exception
            JOptionPane.showMessageDialog(this, "Error reading user data.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    private boolean doesQuizMatchFilters(JSONObject quiz, String selectedCategory, String keyword, boolean isAdmin) {
        String title = quiz.get("QuizTitle").toString().toLowerCase();
        String creator = quiz.get("Creator").toString().toLowerCase();
        String category = quiz.get("Category").toString().toLowerCase();

        // Filter by category
        boolean categoryMatch = selectedCategory.equals("All") || category.equals(selectedCategory.toLowerCase());

        // Filter by keyword
        boolean keywordMatch = keyword.isEmpty()
                || title.contains(keyword)
                || creator.contains(keyword)
                || category.contains(keyword);

        // Filter by creator if not admin
        boolean creatorMatch = isAdmin || creator.equals(gameMasterName.toLowerCase());

        return categoryMatch && keywordMatch && creatorMatch;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox<String> CategorySelection;
    private javax.swing.JButton EditButton;
    private javax.swing.JTable QuizTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables

}
