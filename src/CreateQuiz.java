
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public final class CreateQuiz extends javax.swing.JFrame {

    private String title, category, question, opt1, opt2, opt3, opt4, correctanswer;
    private int numberOfQuizToEnter = 0; // Total number of questions for the quiz
    private final JSONArray newQuizArray = new JSONArray(); // Stores questions for the current quiz
    private static final JSONParser jsonParser = new JSONParser();
    private static final String FILE_PATH = "src/QuizData.json";
    private final String gameMasterName;
    private final String adminName;
    private final String usname;
    private final ButtonGroup answerGroup;
    private int currentQuestionIndex = -1; // Tracks the currently displayed question
    private static final String DEFAULT_CATEGORY = "Select a Category";

    public CreateQuiz(String adminName, String gameMasterName, String usname) {
        initComponents();

        this.adminName = adminName;
        this.gameMasterName = gameMasterName;
        this.usname = usname;

        // Group radio buttons for selecting the correct answer
        answerGroup = new ButtonGroup();
        answerGroup.add(option1Button);
        answerGroup.add(option2Button);
        answerGroup.add(option3Button);
        answerGroup.add(option4Button);

        resetAllFields();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        categorySelection = new javax.swing.JComboBox<>();
        labelquestioncounter = new javax.swing.JLabel();
        questionField = new javax.swing.JTextField();
        option1Button = new javax.swing.JRadioButton();
        option1Field = new javax.swing.JTextField();
        option2Button = new javax.swing.JRadioButton();
        option3Button = new javax.swing.JRadioButton();
        option4Button = new javax.swing.JRadioButton();
        option2Field = new javax.swing.JTextField();
        option3Field = new javax.swing.JTextField();
        option4Field = new javax.swing.JTextField();
        saveQuizButton = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        numberOfQuestionsLabel = new javax.swing.JLabel();
        questionAmount = new javax.swing.JComboBox<>();
        inputButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        quizTitle = new javax.swing.JTextField();
        previousQuestionButton = new javax.swing.JButton();
        nextQuestionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Create Quiz");

        jLabel2.setText("Category:");

        categorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Category", "Math", "Science", "History", "English" }));
        categorySelection.setActionCommand("");
        categorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorySelectionActionPerformed(evt);
            }
        });

        labelquestioncounter.setText("Question #1:");

        questionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionFieldActionPerformed(evt);
            }
        });

        buttonGroup.add(option1Button);
        option1Button.setText("Option #1:");
        option1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ButtonActionPerformed(evt);
            }
        });

        option1Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1FieldActionPerformed(evt);
            }
        });

        buttonGroup.add(option2Button);
        option2Button.setText("Option #2:");
        option2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(option3Button);
        option3Button.setText("Option #3:");
        option3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3ButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(option4Button);
        option4Button.setText("Choice #4:");
        option4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4ButtonActionPerformed(evt);
            }
        });

        option2Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2FieldActionPerformed(evt);
            }
        });

        saveQuizButton.setText("Save");
        saveQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveQuizButtonActionPerformed(evt);
            }
        });

        Back.setText("<");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        numberOfQuestionsLabel.setText("# of Questions");

        questionAmount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        questionAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionAmountActionPerformed(evt);
            }
        });

        inputButton.setText("Input");
        inputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Quiz Title: ");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(labelquestioncounter)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(Back)
                                    .addGap(126, 126, 126)
                                    .addComponent(jLabel1))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(categorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(numberOfQuestionsLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(questionAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(inputButton))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(previousQuestionButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(nextQuestionButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(saveQuizButton)
                                    .addGap(40, 40, 40))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(option2Button)
                                        .addComponent(option3Button)
                                        .addComponent(option1Button))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(questionField)
                                        .addComponent(option3Field)
                                        .addComponent(option2Field)
                                        .addComponent(option1Field)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(option4Button)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(option4Field)))
                            .addGap(22, 22, 22))))
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(quizTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Back))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(quizTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(categorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberOfQuestionsLabel)
                    .addComponent(questionAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputButton))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelquestioncounter)
                    .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option1Button)
                    .addComponent(option1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option2Button)
                    .addComponent(option2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option3Button)
                    .addComponent(option3Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option4Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(option4Button))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveQuizButton)
                    .addComponent(nextQuestionButton)
                    .addComponent(previousQuestionButton))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void option1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ButtonActionPerformed
        correctanswer = option1Field.getText();
    }//GEN-LAST:event_option1ButtonActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        resetAllFields();
        if (adminName != null && !adminName.isEmpty()) {
            Administrator admin = new Administrator(adminName, usname);
            admin.setVisible(true);
        } else if (gameMasterName != null && !gameMasterName.isEmpty()) {
            GameMaster g = new GameMaster(gameMasterName, usname);
            g.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void option4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4ButtonActionPerformed
        correctanswer = option4Field.getText();
    }//GEN-LAST:event_option4ButtonActionPerformed

    private void option2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ButtonActionPerformed

        correctanswer = option2Field.getText();
    }//GEN-LAST:event_option2ButtonActionPerformed

    private void saveQuizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveQuizButtonActionPerformed
        validateAndSaveQuiz();
    }//GEN-LAST:event_saveQuizButtonActionPerformed

    private void questionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_questionFieldActionPerformed

    private void option2FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_option2FieldActionPerformed

    private void option3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3ButtonActionPerformed
        correctanswer = option3Field.getText();
    }//GEN-LAST:event_option3ButtonActionPerformed

    private void savequizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savequizActionPerformed

    }//GEN-LAST:event_savequizActionPerformed

    private void categorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorySelectionActionPerformed


    }//GEN-LAST:event_categorySelectionActionPerformed

    private void inputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputButtonActionPerformed
        title = quizTitle.getText().trim();

        try {
            numberOfQuizToEnter = Integer.parseInt((String) questionAmount.getSelectedItem());
        } catch (NumberFormatException e) {
            showMessage("Invalid number of questions selected.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (DEFAULT_CATEGORY.equals(categorySelection.getSelectedItem())) {
            showMessage("You must select a category.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (title.isEmpty() || numberOfQuizToEnter <= 0) {
            showMessage("Please input a quiz title and number of questions.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        currentQuestionIndex = 0;
        newQuizArray.clear();
        labelquestioncounter.setText("Question #1");
        toggleInputFields(true);
        updateNavigationButtons();
        saveQuizButton.setEnabled(true);
        showMessage("Ready to enter " + numberOfQuizToEnter + " questions.", "Quiz Setup", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_inputButtonActionPerformed

    private void questionAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionAmountActionPerformed


    }//GEN-LAST:event_questionAmountActionPerformed

    private void option1FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_option1FieldActionPerformed

    private void previousQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousQuestionButtonActionPerformed
        saveCurrentQuestion(true); // Validate and save the current question
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            loadQuestion(currentQuestionIndex);
        }
        updateNavigationButtons(); // Ensure proper button state
    }//GEN-LAST:event_previousQuestionButtonActionPerformed

    private void nextQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionButtonActionPerformed
        saveCurrentQuestion(true); // Validate and save the current question
        if (currentQuestionIndex < newQuizArray.size() - 1) {
            currentQuestionIndex++;
            loadQuestion(currentQuestionIndex);
        } else if (currentQuestionIndex < numberOfQuizToEnter - 1) {
            clearFields();
            currentQuestionIndex++;
            labelquestioncounter.setText("Question #" + (currentQuestionIndex + 1));
        } else {
            showMessage("You have reached the last question.", "Navigation Error", JOptionPane.WARNING_MESSAGE);
        }
        updateNavigationButtons();
    }//GEN-LAST:event_nextQuestionButtonActionPerformed

    private void resetAllFields() {
        quizTitle.setText("");
        quizTitle.setEnabled(true);
        categorySelection.setSelectedIndex(0);
        categorySelection.setEnabled(true);
        questionAmount.setSelectedIndex(0);
        questionAmount.setEnabled(true);
        inputButton.setEnabled(true);
        clearFields();
        newQuizArray.clear();
        currentQuestionIndex = -1;
        toggleInputFields(false);
        saveQuizButton.setEnabled(false);
        updateNavigationButtons();
    }

    private void updateNavigationButtons() {
        previousQuestionButton.setEnabled(currentQuestionIndex > 0);
        nextQuestionButton.setEnabled(currentQuestionIndex < numberOfQuizToEnter - 1);
        saveQuizButton.setEnabled(currentQuestionIndex == numberOfQuizToEnter - 1 && newQuizArray.size() == numberOfQuizToEnter);
    }

    private void loadQuestion(int index) {
        if (index < 0 || index >= newQuizArray.size()) {
            return;
        }

        JSONObject questionObject = (JSONObject) newQuizArray.get(index);
        questionField.setText((String) questionObject.getOrDefault("question", ""));
        option1Field.setText((String) questionObject.getOrDefault("option1", ""));
        option2Field.setText((String) questionObject.getOrDefault("option2", ""));
        option3Field.setText((String) questionObject.getOrDefault("option3", ""));
        option4Field.setText((String) questionObject.getOrDefault("option4", ""));

        String correctAnswer = (String) questionObject.getOrDefault("answer", null);
        if (correctAnswer != null) {
            if (correctAnswer.equalsIgnoreCase(option1Field.getText())) {
                answerGroup.setSelected(option1Button.getModel(), true);
            } else if (correctAnswer.equalsIgnoreCase(option2Field.getText())) {
                answerGroup.setSelected(option2Button.getModel(), true);
            } else if (correctAnswer.equalsIgnoreCase(option3Field.getText())) {
                answerGroup.setSelected(option3Button.getModel(), true);
            } else if (correctAnswer.equalsIgnoreCase(option4Field.getText())) {
                answerGroup.setSelected(option4Button.getModel(), true);
            }
        } else {
            answerGroup.clearSelection();
        }
        labelquestioncounter.setText("Question #" + (index + 1));
    }

    private void saveCurrentQuestion(boolean validate) {
        if (currentQuestionIndex < 0 || currentQuestionIndex >= numberOfQuizToEnter) {
            return;
        }

        if (validate && !validateQuestionInput()) {
            return;
        }

        JSONObject questionObject = new JSONObject();
        questionObject.put("questionnumber", currentQuestionIndex + 1);
        questionObject.put("question", questionField.getText().trim());
        questionObject.put("option1", option1Field.getText().trim());
        questionObject.put("option2", option2Field.getText().trim());
        questionObject.put("option3", option3Field.getText().trim());
        questionObject.put("option4", option4Field.getText().trim());

        // Save the selected correct answer
        if (option1Button.isSelected()) {
            questionObject.put("answer", option1Field.getText().trim());
        } else if (option2Button.isSelected()) {
            questionObject.put("answer", option2Field.getText().trim());
        } else if (option3Button.isSelected()) {
            questionObject.put("answer", option3Field.getText().trim());
        } else if (option4Button.isSelected()) {
            questionObject.put("answer", option4Field.getText().trim());
        } else {
            questionObject.put("answer", null); // No option selected
        }

        // Update or add the question to the array
        if (currentQuestionIndex < newQuizArray.size()) {
            newQuizArray.set(currentQuestionIndex, questionObject); // Update existing question
        } else {
            newQuizArray.add(questionObject); // Add new question
        }
    }

    private boolean validateQuestionInput() {
        category = (String) categorySelection.getSelectedItem();
        question = questionField.getText().trim();
        opt1 = option1Field.getText().trim();
        opt2 = option2Field.getText().trim();
        opt3 = option3Field.getText().trim();
        opt4 = option4Field.getText().trim();

        // Fetch the correct answer dynamically
        if (option1Button.isSelected()) {
            correctanswer = opt1;
        } else if (option2Button.isSelected()) {
            correctanswer = opt2;
        } else if (option3Button.isSelected()) {
            correctanswer = opt3;
        } else if (option4Button.isSelected()) {
            correctanswer = opt4;
        } else {
            correctanswer = null;
        }

        if (DEFAULT_CATEGORY.equals(category) || question.isEmpty() || opt1.isEmpty() || opt2.isEmpty() || opt3.isEmpty() || opt4.isEmpty()) {
            showMessage("Please complete all fields and select a valid answer.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!areOptionsUnique(opt1, opt2, opt3, opt4)) {
            showMessage("Options must be unique.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (correctanswer == null || !Arrays.asList(opt1, opt2, opt3, opt4).contains(correctanswer)) {
            showMessage("The correct answer must match one of the options.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean areOptionsUnique(String... options) {
        return Arrays.stream(options).distinct().count() == options.length;
    }

    private void clearFields() {
        questionField.setText("");
        option1Field.setText("");
        option2Field.setText("");
        option3Field.setText("");
        option4Field.setText("");
        answerGroup.clearSelection();
    }

    private void saveQuizToFile() {
        try {
            JSONObject root = new JSONObject(); // Root object for JSON
            JSONArray quizzes = new JSONArray(); // Array to store all quizzes

            // Check if file exists and load existing data
            File file = new File(FILE_PATH);
            if (file.exists() && file.length() > 0) {
                try (FileReader reader = new FileReader(FILE_PATH)) {
                    Object parsedObject = jsonParser.parse(reader);
                    if (parsedObject instanceof JSONObject jSONObject) { // Ensure the content is a valid JSON object
                        root = jSONObject;
                        quizzes = (JSONArray) root.getOrDefault("Quizzes", new JSONArray());
                    } else {
                        Logger.getLogger(CreateQuiz.class.getName()).log(Level.WARNING, "Invalid JSON structure in file. Initializing new data.");
                    }
                } catch (IOException | ParseException e) {
                    Logger.getLogger(CreateQuiz.class.getName()).log(Level.WARNING, "Error reading or parsing file. Initializing new data.", e);
                }
            }

            // Create a new quiz object with the current session data
            JSONObject newQuiz = new JSONObject();
            newQuiz.put("QuizTitle", quizTitle.getText().trim()); // Save the text content of the quiz title
            newQuiz.put("Creator", gameMasterName);
            newQuiz.put("Category", category);
            newQuiz.put("Questions", newQuizArray);
            quizzes.add(newQuiz); // Add the new quiz to the array

            // Update the root object and write to the file
            root.put("Quizzes", quizzes);
            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                writer.write(root.toJSONString());
            }
        } catch (IOException e) {
            showMessage("Failed to save the quiz.", "Save Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CreateQuiz.class.getName()).log(Level.SEVERE, "Error saving quiz.", e);
        }
    }

    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    private void validateAndSaveQuiz() {
        // Ensure all questions are saved
        saveCurrentQuestion(true);

        // Check if the quiz is ready to be saved (all questions entered)
        if (newQuizArray.size() != numberOfQuizToEnter) {
            showMessage("Please complete all " + numberOfQuizToEnter + " questions before saving.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validate each question
        for (int i = 0; i < newQuizArray.size(); i++) {
            currentQuestionIndex = i;
            loadQuestion(currentQuestionIndex); // Load each question for validation
            if (!validateQuestionInput()) {
                showMessage("Validation failed for Question #" + (i + 1), "Validation Error", JOptionPane.WARNING_MESSAGE);
                return; // Stop saving if validation fails
            }
        }

        // Save the quiz to the file
        saveQuizToFile();
        resetAllFields(); // Reset fields after saving
        showMessage("Quiz saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void toggleInputFields(boolean enable) {
        questionField.setEnabled(enable);
        option1Field.setEnabled(enable);
        option2Field.setEnabled(enable);
        option3Field.setEnabled(enable);
        option4Field.setEnabled(enable);
        option1Button.setEnabled(enable);
        option2Button.setEnabled(enable);
        option3Button.setEnabled(enable);
        option4Button.setEnabled(enable);
        saveQuizButton.setEnabled(enable);
        labelquestioncounter.setEnabled(enable);
        nextQuestionButton.setEnabled(enable);
        previousQuestionButton.setEnabled(enable);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                CreateQuiz createQuiz = new CreateQuiz("AdminName", "GameMasterName", "Username");
                createQuiz.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Failed to initialize the application: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JComboBox<String> categorySelection;
    private javax.swing.JButton inputButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelquestioncounter;
    private javax.swing.JButton nextQuestionButton;
    private javax.swing.JLabel numberOfQuestionsLabel;
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
    private javax.swing.JTextField questionField;
    private javax.swing.JTextField quizTitle;
    private javax.swing.JButton saveQuizButton;
    // End of variables declaration//GEN-END:variables

}
