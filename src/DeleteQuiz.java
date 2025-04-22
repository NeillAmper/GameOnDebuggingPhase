
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DeleteQuiz extends javax.swing.JFrame {

    private static final String FILE_PATH = "src/QuizData.json";
    private final Stack<DeletedQuiz> deletedQuizzesStack = new Stack<>(); // Stack to store deletion history
    private final String adminName;
    private final String gameMasterName;
    private final String usname;
    private boolean isUndoDialogShown = false; // Flag to prevent duplicate dialogs

    public DeleteQuiz(String adminName, String gameMasterName, String usname) {
        this.adminName = adminName;
        this.gameMasterName = gameMasterName;
        this.usname = usname;
        initComponents();
        initializeListeners();
        populateCategorySelection();

        // Ensure a category is selected before loading quizzes
        if (CategorySelection.getSelectedItem() != null) {
            loadCategoryQuizzes();
        }

        addSearchListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BackButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        CategorySelection = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        QuizTable = new javax.swing.JTable();
        DeleteButton = new javax.swing.JButton();
        undoButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackButton.setText("<");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Delete Quiz");

        CategorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Math", "Science", "History", "English" }));
        CategorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategorySelectionActionPerformed(evt);
            }
        });

        QuizTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Creator", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(QuizTable);

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        undoButton.setText("Undo");
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(undoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DeleteButton)
                .addGap(57, 57, 57))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(CategorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(BackButton)
                            .addGap(116, 116, 116)
                            .addComponent(jLabel1))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(BackButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CategorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteButton)
                    .addComponent(undoButton))
                .addGap(48, 48, 48))
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
            Administrator admin = new Administrator(adminName, usname);
            admin.setVisible(true);
        } else if (gameMasterName != null && !gameMasterName.isEmpty()) {
            GameMaster g = new GameMaster(gameMasterName, usname);
            g.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void CategorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategorySelectionActionPerformed
        loadCategoryQuizzes();
    }//GEN-LAST:event_CategorySelectionActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // Show confirmation dialog only once
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this quiz?",
                "Confirm Quiz Deletion",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            int row = QuizTable.getSelectedRow();
            if (row == -1) {
                // Silently return if no quiz is selected
                JOptionPane.showMessageDialog(this, "No quiz selected.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String quizTitle = (String) QuizTable.getValueAt(row, 0);
            String creator = (String) QuizTable.getValueAt(row, 1);
            String category = (String) QuizTable.getValueAt(row, 2);

            if (!creator.equals(gameMasterName)) {
                JOptionPane.showMessageDialog(this, "You can only delete quizzes you created.", "Access Denied", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try (FileReader reader = new FileReader(FILE_PATH)) {
                JSONParser parser = new JSONParser();
                JSONObject root = (JSONObject) parser.parse(reader);
                JSONArray quizzes = (JSONArray) root.get("Quizzes");

                for (int i = 0; i < quizzes.size(); i++) {
                    JSONObject quiz = (JSONObject) quizzes.get(i);
                    if (quizTitle.equals(quiz.get("QuizTitle"))
                            && creator.equals(quiz.get("Creator"))
                            && category.equals(quiz.get("Category"))) {
                        deletedQuizzesStack.push(new DeletedQuiz(quiz, row));
                        quizzes.remove(i);
                        break;
                    }
                }

                try (FileWriter writer = new FileWriter(FILE_PATH)) {
                    writer.write(root.toJSONString());
                }

                ((DefaultTableModel) QuizTable.getModel()).removeRow(row);
                JOptionPane.showMessageDialog(this, "Quiz deleted successfully!");

            } catch (IOException | ParseException e) {
                JOptionPane.showMessageDialog(this, "Error deleting quiz.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Show a confirmation message for canceling the operation
            JOptionPane.showMessageDialog(this, "User addition canceled.", "Canceled", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        // Check if the stack is empty
        if (deletedQuizzesStack.isEmpty()) {
            if (!isUndoDialogShown) {
                isUndoDialogShown = true; // Set flag to true
                JOptionPane.showMessageDialog(this, "Nothing to undo.", "Undo Error", JOptionPane.WARNING_MESSAGE);
            }
            return; // Exit early
        }

        // Reset the flag since there is something to undo
        isUndoDialogShown = false;

        // Proceed with undo logic if the stack is not empty
        DeletedQuiz lastDeleted = deletedQuizzesStack.pop();

        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            // Add the last deleted quiz back to the JSON file
            quizzes.add(lastDeleted.getQuiz());

            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                writer.write(root.toJSONString());
            }

            // Reinsert the row in the table
            ((DefaultTableModel) QuizTable.getModel()).insertRow(lastDeleted.getRowIndex(), new Object[]{
                lastDeleted.getQuiz().get("QuizTitle"),
                lastDeleted.getQuiz().get("Creator"),
                lastDeleted.getQuiz().get("Category")
            });

            JOptionPane.showMessageDialog(this, "Undo successful!");

        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Failed to undo delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_undoButtonActionPerformed

    private void populateCategorySelection() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            Set<String> categories = new HashSet<>();
            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;
                categories.add((String) quiz.get("Category"));
            }

            CategorySelection.removeAllItems();
            CategorySelection.addItem("All");
            for (String category : categories) {
                CategorySelection.addItem(category);
            }

            if (CategorySelection.getItemCount() > 0) {
                CategorySelection.setSelectedIndex(0);
            }

        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error loading categories.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCategoryQuizzes() {
        String selectedCategory = (String) CategorySelection.getSelectedItem();

        if (selectedCategory == null) {
            return;
        }

        String searchText = searchField.getText().trim().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) QuizTable.getModel();
        model.setRowCount(0);

        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;
                String title = (String) quiz.get("QuizTitle");
                String creator = (String) quiz.get("Creator");
                String category = (String) quiz.get("Category");

                // Show all quizzes if the user is an Administrator
                boolean isAdmin = adminName != null && !adminName.isEmpty();
                boolean matchesCreator = isAdmin || creator.equals(gameMasterName);

                boolean matchesCategory = "All".equals(selectedCategory) || category.equalsIgnoreCase(selectedCategory);
                boolean matchesSearch = title.toLowerCase().contains(searchText) || category.toLowerCase().contains(searchText);

                if (matchesCreator && matchesCategory && matchesSearch) {
                    model.addRow(new Object[]{title, creator, category});
                }
            }

        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error loading quizzes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addSearchListener() {
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

    // ✅ ADDED METHOD: Filters quiz table based on search query
    private void initializeListeners() {
        // Listener for Back button to navigate back to the main screen
        BackButton.addActionListener(this::BackButtonActionPerformed);

        // Listener for category selection changes to reload quizzes
        CategorySelection.addActionListener(this::CategorySelectionActionPerformed);

        // Listener for delete button to delete a selected quiz
        DeleteButton.addActionListener(this::DeleteButtonActionPerformed);

        // Listener for undo button to undo the last deletion
        undoButton.addActionListener(this::undoButtonActionPerformed);

        // Add a search listener for the searchField to filter quizzes dynamically
        addSearchListener();
    }

    private static class DeletedQuiz {

        private final JSONObject quiz;
        private final int rowIndex;

        public DeletedQuiz(JSONObject quiz, int rowIndex) {
            this.quiz = quiz;
            this.rowIndex = rowIndex;
        }

        public JSONObject getQuiz() {
            return quiz;
        }

        public int getRowIndex() {
            return rowIndex;
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new DeleteQuiz("Test", "Testss", "Testsss").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox<String> CategorySelection;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTable QuizTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables
}
