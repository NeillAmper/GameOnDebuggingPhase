
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EditQuiz extends javax.swing.JFrame {

    private static final String FILE_PATH = "src/QuizData.json";
    private static final JSONParser jsonParser = new JSONParser();
    private final String adminName;
    private final String gameMasterName;
    private final String usname;
    private ButtonGroup answerGroup = new ButtonGroup();
    private final JSONArray quizArray = new JSONArray(); // Stores questions for the current quiz

    private int currentQuestionIndex = -1; // Tracks the currently displayed question

    public EditQuiz(String selectedQuizTitle, String adminName, String gameMasterName, String usname) {
        this.adminName = adminName; // Ensure adminName is always initialized
        this.gameMasterName = gameMasterName;
        this.usname = usname;

        if (selectedQuizTitle == null || selectedQuizTitle.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No quiz title provided. Cannot edit quiz.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit early, but adminName is already initialized
        }

        initComponents();

        // Group radio buttons for selecting the correct answer
        answerGroup = new ButtonGroup();
        answerGroup.add(option1Button);
        answerGroup.add(option2Button);
        answerGroup.add(option3Button);
        answerGroup.add(option4Button);

        // Load quiz data from the selected quiz
        loadQuizData(selectedQuizTitle);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CorrectAnswer = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        editQuizTitle = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        categorySelection = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        questionCounterLabel = new javax.swing.JLabel();
        questionField = new javax.swing.JTextField();
        option1Button = new javax.swing.JRadioButton();
        option2Button = new javax.swing.JRadioButton();
        option3Button = new javax.swing.JRadioButton();
        saveQuizButton = new javax.swing.JButton();
        option4Button = new javax.swing.JRadioButton();
        option1Field = new javax.swing.JTextField();
        option2Field = new javax.swing.JTextField();
        option3Field = new javax.swing.JTextField();
        option4Field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        newQuizTitle = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        questionAmount = new javax.swing.JComboBox<>();
        inputButton = new javax.swing.JButton();
        quizTitleLabel = new javax.swing.JLabel();
        previousQuestionButton = new javax.swing.JButton();
        nextQuestionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editQuizTitle.setText("Edit Quiz");

        Back.setText("<");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel2.setText("Category:");

        categorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Math", "Science", "History", "English" }));

        jLabel3.setText("Quiz Title:");

        questionCounterLabel.setText("Question #1:");

        questionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionFieldActionPerformed(evt);
            }
        });

        CorrectAnswer.add(option1Button);
        option1Button.setText("Option #1:");

        CorrectAnswer.add(option2Button);
        option2Button.setText("Option #2:");
        option2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ButtonActionPerformed(evt);
            }
        });

        CorrectAnswer.add(option3Button);
        option3Button.setText("Option #3:");
        option3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3ButtonActionPerformed(evt);
            }
        });

        saveQuizButton.setText("Save");
        saveQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveQuizButtonActionPerformed(evt);
            }
        });

        CorrectAnswer.add(option4Button);
        option4Button.setText("Option #4:");
        option4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4ButtonActionPerformed(evt);
            }
        });

        option1Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1FieldActionPerformed(evt);
            }
        });

        jLabel4.setText("New Quiz Title:");

        jLabel1.setText("# of Questions");

        questionAmount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        inputButton.setText("Input");

        quizTitleLabel.setText("Quiz Title Label");

        previousQuestionButton.setText("Previous");
        previousQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousQuestionButtonActionPerformed(evt);
            }
        });

        nextQuestionButton.setText("Next");
        nextQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextQuestionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Back)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(quizTitleLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(newQuizTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(previousQuestionButton)
                        .addGap(18, 18, 18)
                        .addComponent(nextQuestionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveQuizButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(option4Button, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(option3Button, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(option2Button, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(option1Button, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(questionCounterLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(editQuizTitle, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(option2Field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(option3Field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(option1Field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(option4Field)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(categorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(questionAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(inputButton)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(editQuizTitle)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(Back))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(quizTitleLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newQuizTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(questionAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputButton))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionCounterLabel)
                    .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option1Button)
                    .addComponent(option1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option2Button)
                    .addComponent(option2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option3Button)
                    .addComponent(option3Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option4Button)
                    .addComponent(option4Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousQuestionButton)
                    .addComponent(nextQuestionButton)
                    .addComponent(saveQuizButton))
                .addContainerGap(18, Short.MAX_VALUE))
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

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
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
    }//GEN-LAST:event_BackActionPerformed

    private void option2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ButtonActionPerformed
        CorrectAnswer.clearSelection();
        option2Button.setSelected(true);
    }//GEN-LAST:event_option2ButtonActionPerformed

    private void saveQuizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveQuizButtonActionPerformed
        saveCurrentQuestion(); // Ensure the current question is saved

        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONObject root = (JSONObject) jsonParser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            for (Object obj : quizzes) {
                JSONObject quizObject = (JSONObject) obj;

                if (quizTitleLabel.getText().equals(quizObject.get("QuizTitle"))) {
                    quizObject.put("Category", categorySelection.getSelectedItem());
                    quizObject.put("Questions", quizArray);
                    break;
                }
            }

            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                writer.write(root.toJSONString());
                showMessage("Quiz updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException | ParseException e) {
            Logger.getLogger(EditQuiz.class.getName()).log(Level.SEVERE, "Error saving quiz data", e);
            showMessage("Error saving quiz data. Please try again.", "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveQuizButtonActionPerformed

    private void option3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3ButtonActionPerformed
        CorrectAnswer.clearSelection();
        option3Button.setSelected(true);
    }//GEN-LAST:event_option3ButtonActionPerformed

    private void option4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4ButtonActionPerformed
        CorrectAnswer.clearSelection();
        option4Button.setSelected(true);
    }//GEN-LAST:event_option4ButtonActionPerformed

    private void questionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_questionFieldActionPerformed

    private void option1FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1FieldActionPerformed
        CorrectAnswer.clearSelection();
        option1Button.setSelected(true);
    }//GEN-LAST:event_option1FieldActionPerformed

    private void previousQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousQuestionButtonActionPerformed
        saveCurrentQuestion(); // Save the current question before navigating
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            loadQuestion(currentQuestionIndex);
        } else {
            showMessage("This is the first question.", "Navigation Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_previousQuestionButtonActionPerformed

    private void nextQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionButtonActionPerformed
        saveCurrentQuestion(); // Save the current question before navigating
        if (currentQuestionIndex < quizArray.size() - 1) {
            currentQuestionIndex++;
            loadQuestion(currentQuestionIndex);
        } else {
            showMessage("This is the last question.", "Navigation Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_nextQuestionButtonActionPerformed

    private void loadQuizData(String selectedQuizTitle) {
        if (selectedQuizTitle == null || selectedQuizTitle.trim().isEmpty()) {
            showMessage("No quiz title provided for loading.", "Load Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONObject root = (JSONObject) jsonParser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            boolean quizFound = false;
            for (Object obj : quizzes) {
                JSONObject quizObject = (JSONObject) obj;

                if (selectedQuizTitle.equals(quizObject.get("QuizTitle"))) {
                    quizFound = true;

                    quizTitleLabel.setText(selectedQuizTitle);
                    categorySelection.setSelectedItem(quizObject.getOrDefault("Category", "Uncategorized"));

                    // Load questions into quiz array
                    JSONArray questions = (JSONArray) quizObject.getOrDefault("Questions", new JSONArray());
                    quizArray.clear();
                    quizArray.addAll(questions);

                    if (quizArray.isEmpty()) {
                        showMessage("The selected quiz has no questions to edit.", "No Questions", JOptionPane.WARNING_MESSAGE);
                    } else {
                        currentQuestionIndex = 0;
                        loadQuestion(currentQuestionIndex); // Load the first question
                    }
                    break;
                }
            }

            if (!quizFound) {
                showMessage("The selected quiz could not be found.", "Load Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException | ParseException e) {
            Logger.getLogger(EditQuiz.class.getName()).log(Level.SEVERE, "Error loading quiz data", e);
            showMessage("Error loading quiz data. Please try again.", "Load Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadQuestion(int index) {
        if (index < 0 || index >= quizArray.size()) {
            showMessage("No more questions to load.", "Navigation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JSONObject questionObject = (JSONObject) quizArray.get(index);

        // Safely populate fields
        questionField.setText(questionObject.getOrDefault("question", "").toString());
        option1Field.setText(questionObject.getOrDefault("option1", "").toString());
        option2Field.setText(questionObject.getOrDefault("option2", "").toString());
        option3Field.setText(questionObject.getOrDefault("option3", "").toString());
        option4Field.setText(questionObject.getOrDefault("option4", "").toString());

        // Set the correct answer
        String correctAnswer = questionObject.getOrDefault("answer", "").toString();
        if (correctAnswer.equals(option1Field.getText())) {
            answerGroup.setSelected(option1Button.getModel(), true);
        } else if (correctAnswer.equals(option2Field.getText())) {
            answerGroup.setSelected(option2Button.getModel(), true);
        } else if (correctAnswer.equals(option3Field.getText())) {
            answerGroup.setSelected(option3Button.getModel(), true);
        } else if (correctAnswer.equals(option4Field.getText())) {
            answerGroup.setSelected(option4Button.getModel(), true);
        }

        // Update the question counter
        questionCounterLabel.setText("Question #" + (index + 1));
    }

    private void saveCurrentQuestion() {
        if (currentQuestionIndex < 0) {
            showMessage("No question selected to save.", "Save Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JSONObject questionObject = new JSONObject();

        // Safely retrieve field values
        questionObject.put("question", questionField.getText() != null ? questionField.getText().trim() : "");
        questionObject.put("option1", option1Field.getText() != null ? option1Field.getText().trim() : "");
        questionObject.put("option2", option2Field.getText() != null ? option2Field.getText().trim() : "");
        questionObject.put("option3", option3Field.getText() != null ? option3Field.getText().trim() : "");
        questionObject.put("option4", option4Field.getText() != null ? option4Field.getText().trim() : "");

        // Save the selected correct answer
        if (option1Button.isSelected()) {
            questionObject.put("answer", questionObject.get("option1"));
        } else if (option2Button.isSelected()) {
            questionObject.put("answer", questionObject.get("option2"));
        } else if (option3Button.isSelected()) {
            questionObject.put("answer", questionObject.get("option3"));
        } else if (option4Button.isSelected()) {
            questionObject.put("answer", questionObject.get("option4"));
        }

        // Update the quiz array
        if (currentQuestionIndex < quizArray.size()) {
            quizArray.set(currentQuestionIndex, questionObject);
        } else {
            quizArray.add(questionObject);
        }
    }

    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new EditQuiz("Sample Quiz", "GameMaster", "testUser", "testss").setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.ButtonGroup CorrectAnswer;
    private javax.swing.JComboBox<String> categorySelection;
    private javax.swing.JLabel editQuizTitle;
    private javax.swing.JButton inputButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField newQuizTitle;
    private javax.swing.JButton nextQuestionButton;
    private javax.swing.JRadioButton option1Button;
    private javax.swing.JTextField option1Field;
    private javax.swing.JRadioButton option2Button;
    private javax.swing.JTextField option2Field;
    private javax.swing.JRadioButton option3Button;
    private javax.swing.JTextField option3Field;
    private javax.swing.JRadioButton option4Button;
    private javax.swing.JTextField option4Field;
    private javax.swing.JButton previousQuestionButton;
    private javax.swing.JComboBox<String> questionAmount;
    private javax.swing.JLabel questionCounterLabel;
    private javax.swing.JTextField questionField;
    private javax.swing.JLabel quizTitleLabel;
    private javax.swing.JButton saveQuizButton;
    // End of variables declaration//GEN-END:variables
}
