
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
        if (categorySelection.getSelectedItem() != null) {
            loadCategoryQuizzes();
        }

        addSearchListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        categorySelection = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        quizTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        undoButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setBackground(new java.awt.Color(51, 0, 204));
        backButton.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 0, 0));
        backButton.setText("<");
        backButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 110, 40));

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Delete Quiz");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        categorySelection.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        categorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Math", "Science", "History", "English" }));
        categorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorySelectionActionPerformed(evt);
            }
        });
        jPanel1.add(categorySelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 150, 40));

        quizTable.setBackground(new java.awt.Color(51, 0, 204));
        quizTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        quizTable.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        quizTable.setModel(new javax.swing.table.DefaultTableModel(
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
        quizTable.setCellSelectionEnabled(true);
        quizTable.setGridColor(new java.awt.Color(51, 0, 153));
        quizTable.setSelectionBackground(new java.awt.Color(51, 0, 153));
        jScrollPane1.setViewportView(quizTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 530, 300));

        deleteButton.setBackground(new java.awt.Color(51, 0, 204));
        deleteButton.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");
        deleteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, 160, 40));

        undoButton.setBackground(new java.awt.Color(51, 0, 204));
        undoButton.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        undoButton.setForeground(new java.awt.Color(255, 255, 255));
        undoButton.setText("Undo");
        undoButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });
        jPanel1.add(undoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 160, 40));

        searchField.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jPanel1.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 200, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GameOn! (Purple BG).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 790, 560));

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
        if (adminName != null && !adminName.isEmpty()) {
            Administrator admin = new Administrator(adminName, usname);
            admin.setVisible(true);
        } else if (gameMasterName != null && !gameMasterName.isEmpty()) {
            GameMaster g = new GameMaster(gameMasterName, usname);
            g.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void categorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorySelectionActionPerformed
        loadCategoryQuizzes();
    }//GEN-LAST:event_categorySelectionActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // Show confirmation dialog only once
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this quiz?",
                "Confirm Quiz Deletion",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            int row = quizTable.getSelectedRow();
            if (row == -1) {
                // Silently return if no quiz is selected
                JOptionPane.showMessageDialog(this, "No quiz selected.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String quizTitle = (String) quizTable.getValueAt(row, 0);
            String creator = (String) quizTable.getValueAt(row, 1);
            String category = (String) quizTable.getValueAt(row, 2);

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

                ((DefaultTableModel) quizTable.getModel()).removeRow(row);
                JOptionPane.showMessageDialog(this, "Quiz deleted successfully!");

            } catch (IOException | ParseException e) {
                JOptionPane.showMessageDialog(this, "Error deleting quiz.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Show a confirmation message for canceling the operation
            JOptionPane.showMessageDialog(this, "User addition canceled.", "Canceled", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

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
            ((DefaultTableModel) quizTable.getModel()).insertRow(lastDeleted.getRowIndex(), new Object[]{
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

            categorySelection.removeAllItems();
            categorySelection.addItem("All");
            for (String category : categories) {
                categorySelection.addItem(category);
            }

            if (categorySelection.getItemCount() > 0) {
                categorySelection.setSelectedIndex(0);
            }

        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error loading categories.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCategoryQuizzes() {
        String selectedCategory = (String) categorySelection.getSelectedItem();

        if (selectedCategory == null) {
            return;
        }

        String searchText = searchField.getText().trim().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) quizTable.getModel();
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

    private void initializeListeners() {
        // Listener for Back button to navigate back to the main screen
        backButton.addActionListener(this::backButtonActionPerformed);

        // Listener for category selection changes to reload quizzes
        categorySelection.addActionListener(this::categorySelectionActionPerformed);

        // Listener for delete button to delete a selected quiz
        deleteButton.addActionListener(this::deleteButtonActionPerformed);

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
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> categorySelection;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable quizTable;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables
}
