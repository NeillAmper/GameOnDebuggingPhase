
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Quiz extends javax.swing.JFrame {

    public static int score = 0;
    public static int maxscore = 0;
    private final String playerName;
    private final String usname;
    private final String quizData;
    private String correctanswer = ""; // Ensure initialization
    private static final String[] FILE_PATH = {"src/QuizData.json", "src/UserData.json"};
    private int index = 0;
    private final String selectedQuiz;
    private javax.swing.Timer questionTimer;
    private int timeLeft = 300;  // 5-minute timer per question
    private final List<JSONObject> scenarioList = new ArrayList<>();
    private final List<JSONObject> answerLog = new ArrayList<>(); // Log of question answers
    private JSONArray scenariosArray;
    private final String category; // Add a new member variable

    public Quiz(String playerName, String quizData, String selectedQuiz, String usname, String category) {
        initComponents();
        this.playerName = playerName;
        this.usname = usname;
        this.quizData = quizData;
        this.selectedQuiz = selectedQuiz;
        this.category = category; // Store the category
        loadQuizData();
        loadScenarios();
        showStartScenario();
        loadNextQuestion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        questionLabel = new javax.swing.JLabel();
        quizDetailsLabel = new javax.swing.JLabel();
        option1 = new javax.swing.JToggleButton();
        option2 = new javax.swing.JToggleButton();
        option3 = new javax.swing.JToggleButton();
        option4 = new javax.swing.JToggleButton();
        nextButton = new javax.swing.JButton();
        completeButton = new javax.swing.JButton();
        timerLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        questionLabel.setText("Question");

        quizDetailsLabel.setText("Quiz Details");

        buttonGroup1.add(option1);
        option1.setText("Option 1");
        option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(option2);
        option2.setText("Option 2");
        option2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(option3);
        option3.setText("Option 3");
        option3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(option4);
        option4.setText("Option 4");
        option4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4ActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        completeButton.setText("Complete");
        completeButton.setEnabled(false);
        completeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeButtonActionPerformed(evt);
            }
        });

        timerLabel.setText("Timer");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(questionLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(cancelButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(timerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quizDetailsLabel)
                .addGap(112, 112, 112))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(option1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(option2)
                        .addGap(61, 61, 61))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(nextButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(option3)
                        .addGap(45, 45, 45)
                        .addComponent(option4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(completeButton)))
                .addGap(125, 125, 125))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(cancelButton)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timerLabel)
                    .addComponent(quizDetailsLabel))
                .addGap(59, 59, 59)
                .addComponent(questionLabel)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(option1)
                            .addComponent(option2)
                            .addComponent(option3)
                            .addComponent(option4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextButton)
                            .addComponent(completeButton))
                        .addGap(56, 56, 56))))
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

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if (buttonGroup1.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Please select an answer.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String selected = null;
        if (option1.isSelected()) {
            selected = option1.getText();
        }
        if (option2.isSelected()) {
            selected = option2.getText();
        }
        if (option3.isSelected()) {
            selected = option3.getText();
        }
        if (option4.isSelected()) {
            selected = option4.getText();
        }

        // Check if the answer is correct
        boolean correct = checkAnswer(selected);
        showEndScenario(correct);

        // Increment score if correct
        if (correct) {
            score++;
        }

        if (questionTimer != null) {
            questionTimer.stop();
        }
        loadNextQuestion();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ActionPerformed

    }//GEN-LAST:event_option1ActionPerformed

    private void option2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ActionPerformed


    }//GEN-LAST:event_option2ActionPerformed

    private void option3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3ActionPerformed


    }//GEN-LAST:event_option3ActionPerformed

    private void option4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4ActionPerformed


    }//GEN-LAST:event_option4ActionPerformed

    private void completeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeButtonActionPerformed
        try {
            // Save quiz results when completed
            saveQuizResults();

            // Prepare data to pass to QuizResult
            JSONArray answers = new JSONArray();
            for (JSONObject answer : answerLog) {
                JSONObject formattedAnswer = new JSONObject();
                formattedAnswer.put("question", answer.get("question"));
                formattedAnswer.put("selectedAnswer", answer.get("selectedAnswer"));
                formattedAnswer.put("correctAnswer", answer.get("correctAnswer"));

                // Add evaluation (correct/incorrect)
                boolean isCorrect = (boolean) answer.get("isCorrect");
                formattedAnswer.put("result", isCorrect ? "correct" : "incorrect");

                answers.add(formattedAnswer);
            }

            String quizTitle = selectedQuiz; // Use the selected quiz title
            String creator = getQuizCreator(quizTitle); // Fetch the quiz creator
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd, hh:mm a"));

            JOptionPane.showMessageDialog(this, "Quiz Completed!");

            // Navigate to QuizResult screen
            this.setVisible(false);
            new QuizResult(playerName, quizData, score, maxscore, selectedQuiz, usname, answers, quizTitle, creator, timestamp).setVisible(true);

        } catch (IOException | ParseException e) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, "Error saving quiz results", e);
            JOptionPane.showMessageDialog(this, "Failed to save quiz results.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_completeButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // Display a confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to cancel the current quiz? Your progress will not be saved.",
                "Cancel Quiz",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        // If the user confirms, cancel the quiz
        if (confirm == JOptionPane.YES_OPTION) {
            // Stop the timer if it is running
            if (questionTimer != null) {
                questionTimer.stop();
            }

            // Reset progress variables
            score = 0;
            maxscore = 0;
            index = 0;
            scenarioList.clear();
            answerLog.clear();

            // Close the current quiz window
            this.dispose();

            // Navigate back to the QuizSelection screen with the correct arguments
            new QuizSelection(playerName, quizData, selectedQuiz, usname).setVisible(true);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void loadQuizData() {
        try {
            // Load the quiz data from QuizData.json
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader(FILE_PATH[0]);
            JSONObject root = (JSONObject) parser.parse(reader); // Parse the root JSON object

            // Extract the "Quizzes" array
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            // Loop through the quizzes and find the selected quiz
            for (Object obj : quizzes) {
                JSONObject quizEntry = (JSONObject) obj;
                if (quizEntry.get("QuizTitle").equals(selectedQuiz)) { // Match the selected quiz title
                    // Extract the QuizTitle, Creator, and Category
                    String quizTitle = (String) quizEntry.get("QuizTitle");
                    String creator = (String) quizEntry.get("Creator");
                    String category = (String) quizEntry.get("Category");

                    // Set the information in the quizIdLabel
                    quizDetailsLabel.setText("Title: " + quizTitle + " | Creator: " + creator + " | Category: " + category);

                    // Extract the Questions array
                    JSONArray questions = (JSONArray) quizEntry.get("Questions");

                    // Add questions to the scenarioList and set maxscore
                    for (Object questionObj : questions) {
                        JSONObject questionData = (JSONObject) questionObj;
                        scenarioList.add(questionData);
                        maxscore++; // Increment the score count
                    }
                    break; // Exit after finding the selected quiz
                }
            }
        } catch (IOException | ParseException e) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private boolean checkAnswer(String selectedAnswer) {
        if (selectedAnswer == null || correctanswer == null) {
            return false; // If either is null, the answer is incorrect
        }
        return selectedAnswer.equals(correctanswer); // Compare selected answer with the correct answer
    }

    private void loadNextQuestion() {
        if (index < scenarioList.size()) {
            if (questionTimer != null) {
                questionTimer.stop();
            }

            JSONObject currentScenario = scenarioList.get(index);
            questionLabel.setText((String) currentScenario.get("question"));
            option1.setText((String) currentScenario.get("option1"));
            option2.setText((String) currentScenario.get("option2"));
            option3.setText((String) currentScenario.get("option3"));
            option4.setText((String) currentScenario.get("option4"));

            // Clear toggle button selection
            buttonGroup1.clearSelection();

            // Ensure correctanswer is assigned
            correctanswer = (String) currentScenario.get("answer");
            if (correctanswer == null) {
                correctanswer = ""; // Prevent null pointer issues
            }

            timeLeft = 300;
            startTimer();

            index++;
        } else {
            completeButton.setEnabled(true);
            nextButton.setEnabled(false);
            JOptionPane.showMessageDialog(this, "You have completed the quiz!", "Complete", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void startTimer() {
        timeLeft = 300;

        if (questionTimer != null) {
            questionTimer.stop();
        }

        questionTimer = new javax.swing.Timer(1000, e -> {
            if (timeLeft > 0) {
                timeLeft--;
                timerLabel.setText("Time Left: " + timeLeft + "s");
            } else {
                JOptionPane.showMessageDialog(this, "Time's up!");
                loadNextQuestion();
            }
        });
        questionTimer.start();
    }

    private void loadScenarios() {
        try {
            // Load the scenarios from QuizData.json
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader(FILE_PATH[0]);
            JSONObject root = (JSONObject) parser.parse(reader);

            // Extract the "Scenarios" array
            scenariosArray = (JSONArray) root.get("Scenarios");

            // Handle empty or null scenarios array
            if (scenariosArray == null || scenariosArray.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No scenarios available in the quiz data.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Randomize the order of scenarios
            List<Object> tempList = new ArrayList<>();
            for (Object scenario : scenariosArray) {
                tempList.add(scenario);
            }
            Collections.shuffle(tempList); // Shuffle the list to randomize scenarios
            scenariosArray = new JSONArray();
            scenariosArray.addAll(tempList); // Add the shuffled scenarios back to scenariosArray

        } catch (IOException | ParseException e) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, "Error loading scenarios", e);
            JOptionPane.showMessageDialog(this, "Failed to load scenarios. Check QuizData.json file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showStartScenario() {
        if (scenariosArray != null && !scenariosArray.isEmpty()) {
            // Select a random startScenario
            Random random = new Random();
            JSONObject randomScenario = (JSONObject) scenariosArray.get(random.nextInt(scenariosArray.size()));
            String startScenario = (String) randomScenario.get("startScenario");

            // Display the scenario in a JOptionPane with auto-close
            JOptionPane scenarioPane = new JOptionPane(startScenario, JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = scenarioPane.createDialog(this, "Start Scenario");
            dialog.setModal(false);
            dialog.setVisible(true);

            // Create a timer to close the dialog after 10 seconds
            javax.swing.Timer timer = new javax.swing.Timer(10000, e -> dialog.dispose());
            timer.setRepeats(false); // Ensure the timer only runs once
            timer.start();
        } else {
            JOptionPane.showMessageDialog(this, "No start scenario available.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void showEndScenario(boolean correct) {
        if (scenariosArray != null && !scenariosArray.isEmpty() && index - 1 < scenariosArray.size()) {
            // Get the current scenario
            JSONObject currentScenario = (JSONObject) scenariosArray.get(index - 1);
            JSONObject endScenarios = (JSONObject) currentScenario.get("endScenarios");
            String endScenarioMessage = correct ? (String) endScenarios.get("correct") : (String) endScenarios.get("wrong");

            // Display the end scenario in a JOptionPane with auto-close
            JOptionPane scenarioPane = new JOptionPane(endScenarioMessage, JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = scenarioPane.createDialog(this, "End Scenario");
            dialog.setModal(false);
            dialog.setVisible(true);

            // Create a timer to close the dialog after 10 seconds
            javax.swing.Timer timer = new javax.swing.Timer(10000, e -> dialog.dispose());
            timer.setRepeats(false); // Ensure the timer only runs once
            timer.start();
        } else {
            JOptionPane.showMessageDialog(this, "No end scenario available.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void saveQuizResults() throws IOException, ParseException {
        // Create the history entry
        JSONObject historyData = new JSONObject();
        historyData.put("evaluation", score == maxscore ? "pass" : "fail"); // Result: pass or fail
        historyData.put("score", score + "/" + maxscore); // Score in the format x/y
        historyData.put("creator", getQuizCreator(selectedQuiz)); // Creator of the quiz
        historyData.put("category", category); // Use the category passed from QuizSelection
        historyData.put("quizTitle", selectedQuiz); // Title of the quiz
        historyData.put("player", playerName); // Player name
        historyData.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd, hh:mm a"))); // Timestamp

        // Add the answers to the history entry
        JSONArray answers = new JSONArray();
        for (JSONObject answer : answerLog) {
            JSONObject formattedAnswer = new JSONObject();
            formattedAnswer.put("question", answer.get("question"));
            formattedAnswer.put("selectedAnswer", answer.get("selectedAnswer"));
            formattedAnswer.put("correctAnswer", answer.get("correctAnswer"));

            // Add evaluation (correct/incorrect)
            boolean isCorrect = (boolean) answer.get("isCorrect");
            formattedAnswer.put("result", isCorrect ? "correct" : "incorrect");

            answers.add(formattedAnswer);
        }
        historyData.put("answers", answers);

        // Load existing user data from UserData.json
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(FILE_PATH[1]);
        JSONObject userData = (JSONObject) parser.parse(reader);

        // Add the history entry to the "History" array
        JSONArray historyArray = (JSONArray) userData.get("History");
        if (historyArray == null) {
            historyArray = new JSONArray();
            userData.put("History", historyArray); // Initialize if it doesn't exist
        }
        historyArray.add(historyData);

        // Only update the "Standing" category if the evaluation is "pass"
        if ("pass".equals(historyData.get("evaluation"))) {
            JSONArray standingArray = (JSONArray) userData.get("Standing");
            if (standingArray == null) {
                standingArray = new JSONArray();
                userData.put("Standing", standingArray); // Initialize if it doesn't exist
            }
            updateStanding(standingArray);
        }

        // Save the updated user data back to UserData.json
        try (FileWriter writer = new FileWriter(FILE_PATH[1])) {
            writer.write(userData.toJSONString());
        }

        JOptionPane.showMessageDialog(this, "Quiz Results Saved!");

        // Navigate to QuizResult and pass the results
        String quizTitle = selectedQuiz;
        String creator = getQuizCreator(quizTitle);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd, hh:mm a"));

        this.setVisible(false);
        new QuizResult(playerName, quizData, score, maxscore, selectedQuiz, usname, answers, quizTitle, creator, timestamp).setVisible(true);
    }

    private String getQuizCreator(String quizTitle) {
        try {
            // Load the quiz data from QuizData.json
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader(FILE_PATH[0]);
            JSONObject root = (JSONObject) parser.parse(reader);

            // Extract the "Quizzes" array
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            // Find the quiz with the matching title
            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;
                if (quiz.get("QuizTitle").equals(quizTitle)) {
                    return (String) quiz.get("Creator"); // Return the creator
                }
            }
        } catch (IOException | ParseException e) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, e);
        }
        return "Unknown"; // Default value if creator not found
    }

    private void updateStanding(JSONArray standingArray) {
        boolean updated = false;

        // Iterate through the "Standing" array to find the player and category
        for (Object obj : standingArray) {
            JSONObject standingEntry = (JSONObject) obj;
            if (standingEntry.get("player").equals(playerName) && standingEntry.get("category").equals(category)) {
                // Update the quizzesDone count and timestamp
                int quizzesDone = ((Long) standingEntry.get("quizzesDone")).intValue();
                standingEntry.put("quizzesDone", quizzesDone + 1);
                standingEntry.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd, hh:mm a")));
                updated = true;
                break;
            }
        }

        // If no matching entry is found, add a new entry
        if (!updated) {
            JSONObject newStandingEntry = new JSONObject();
            newStandingEntry.put("category", category);
            newStandingEntry.put("quizzesDone", 1);
            newStandingEntry.put("player", playerName);
            newStandingEntry.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd, hh:mm a")));
            standingArray.add(newStandingEntry);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Quiz("Player1", "Test", "SampleCategory", "Testss", "Trial").setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton completeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nextButton;
    private javax.swing.JToggleButton option1;
    private javax.swing.JToggleButton option2;
    private javax.swing.JToggleButton option3;
    private javax.swing.JToggleButton option4;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel quizDetailsLabel;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}
