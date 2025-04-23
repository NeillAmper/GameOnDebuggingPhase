
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.swing.table.DefaultTableModel;

public final class QuizResult extends javax.swing.JFrame {

    private final String playerName;
    private final String usname;
    private final String category;
    private final int maxScore;
    private final int finalScore;
    private final String quizData;
    private final JSONArray answers; // Store the answers passed from Quiz.java
    private final String quizTitle; // Quiz Title
    private final String creator; // Quiz Creator
    private final String timestamp; // Timestamp for the quiz

    public QuizResult(String playerName, String quizData, int finalScore, int maxScore, String category, String usname, JSONArray answers, String quizTitle, String creator, String timestamp) {
        // Initialize fields and UI components
        this.quizData = quizData;
        this.playerName = playerName;
        this.usname = usname;
        this.finalScore = finalScore;
        this.maxScore = maxScore;
        this.category = category;
        this.answers = answers;
        this.quizTitle = quizTitle;
        this.creator = creator;
        this.timestamp = timestamp;

        initComponents();
        displayResults(); // Populate the results table
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        congratulatoryMessage = new javax.swing.JLabel();
        MenuButton = new javax.swing.JButton();
        LeaderboardButton = new javax.swing.JButton();
        RetryButton = new javax.swing.JButton();
        quizDetailsLabel = new javax.swing.JLabel();
        categoryUI = new javax.swing.JLabel();
        scoreUI = new javax.swing.JLabel();
        timestampLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("QUIZ DONE!");

        scoreLabel.setText("Score:");

        congratulatoryMessage.setText("Good Job!");

        MenuButton.setText("Menu");
        MenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });

        LeaderboardButton.setText("Leaderboard");
        LeaderboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaderboardButtonActionPerformed(evt);
            }
        });

        RetryButton.setText("Retry");
        RetryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetryButtonActionPerformed(evt);
            }
        });

        quizDetailsLabel.setText("Quiz Details");
        quizDetailsLabel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                quizDetailsLabelAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        timestampLabel.setText("Timestamp");

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Question", "Selected Answer", "Correct Answer", "Result"
            }
        ));
        jScrollPane1.setViewportView(resultTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(quizDetailsLabel)
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoryUI, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scoreUI, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(timestampLabel)
                        .addGap(154, 154, 154)
                        .addComponent(congratulatoryMessage)
                        .addGap(99, 99, 99)
                        .addComponent(scoreLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(MenuButton)
                                .addGap(146, 146, 146)
                                .addComponent(LeaderboardButton)
                                .addGap(95, 95, 95)
                                .addComponent(RetryButton)))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(categoryUI, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(quizDetailsLabel)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scoreLabel)
                    .addComponent(congratulatoryMessage)
                    .addComponent(timestampLabel))
                .addGap(7, 7, 7)
                .addComponent(scoreUI, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MenuButton)
                    .addComponent(LeaderboardButton)
                    .addComponent(RetryButton))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void RetryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetryButtonActionPerformed
        this.setVisible(false);
        new QuizSelection(playerName, "Player", "Player", usname).setVisible(true);
    }//GEN-LAST:event_RetryButtonActionPerformed

    private void LeaderboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaderboardButtonActionPerformed
        this.setVisible(false);
        new Leaderboard(playerName, quizData, "Player", "GameMaster").setVisible(true);
    }//GEN-LAST:event_LeaderboardButtonActionPerformed

    private void MenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuButtonActionPerformed
        Player p = new Player(playerName, "Player", 1, 2, "Player", usname);
        p.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_MenuButtonActionPerformed

    private void quizDetailsLabelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_quizDetailsLabelAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_quizDetailsLabelAncestorAdded

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            String playerName = "JohnDoe";
            String quizData = "Science";
            int finalScore = 2;
            int maxScore = 3;
            String category = "Science";
            String usname = "testUser";
            String quizTitle = "General Science Quiz";
            String creator = "QuizMaster";
            String timestamp = "2025-04-19, 07:25 PM";

            JSONArray answers = new JSONArray();
            JSONObject answer1 = new JSONObject();
            answer1.put("question", "What is the capital of France?");
            answer1.put("selectedAnswer", "Paris");
            answer1.put("correctAnswer", "Paris");
            answer1.put("result", "correct");
            answers.add(answer1);

            JSONObject answer2 = new JSONObject();
            answer2.put("question", "What is 2 + 2?");
            answer2.put("selectedAnswer", "4");
            answer2.put("correctAnswer", "4");
            answer2.put("result", "correct");
            answers.add(answer2);

            JSONObject answer3 = new JSONObject();
            answer3.put("question", "What is the boiling point of water?");
            answer3.put("selectedAnswer", "80 degrees");
            answer3.put("correctAnswer", "100 degrees");
            answer3.put("result", "incorrect");
            answers.add(answer3);

            new QuizResult(playerName, quizData, finalScore, maxScore, category, usname, answers, quizTitle, creator, timestamp).setVisible(true);
        });
    }

    private void displayResults() {
        // Set dynamic labels
        quizDetailsLabel.setText("Title: " + quizTitle + " | Creator: " + creator + " | Category: " + category);
        scoreLabel.setText("Score: " + finalScore + " / " + maxScore); // Display total score dynamically
        timestampLabel.setText("Timestamp: " + (timestamp != null ? timestamp : "N/A")); // Display timestamp dynamically

        // Populate the resultTable
        DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
        model.setRowCount(0); // Clear existing rows

        for (Object answerObj : answers) {
            JSONObject answer = (JSONObject) answerObj;
            String question = (String) answer.get("question");
            String selectedAnswer = (String) answer.get("selectedAnswer");
            String correctAnswer = (String) answer.get("correctAnswer");
            String result = (String) answer.get("result");

            model.addRow(new Object[]{question, selectedAnswer, correctAnswer, result});
        }

        // Set dynamic congratulatory message
        String message = getCongratulatoryMessage(finalScore, maxScore);
        congratulatoryMessage.setText(message);
    }

    private String getCongratulatoryMessage(int score, int maxScore) {
        double percentage = ((double) score / maxScore) * 100;

        if (percentage <= 20) {
            return "Better luck next time! Keep learning and improving.";
        } else if (percentage <= 50) {
            return "Good effort! You're making progress.";
        } else if (percentage <= 80) {
            return "Great job! You're doing really well.";
        } else {
            return "Outstanding! You're a true quiz genius!";
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LeaderboardButton;
    private javax.swing.JButton MenuButton;
    private javax.swing.JButton RetryButton;
    private javax.swing.JLabel categoryUI;
    private javax.swing.JLabel congratulatoryMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel quizDetailsLabel;
    private javax.swing.JTable resultTable;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel scoreUI;
    private javax.swing.JLabel timestampLabel;
    // End of variables declaration//GEN-END:variables
}
