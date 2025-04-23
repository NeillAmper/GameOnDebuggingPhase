
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplashScreen extends javax.swing.JFrame {

    public SplashScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Progressbar = new javax.swing.JProgressBar();
        LoadingValue = new javax.swing.JLabel();
        LoadingMsg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(790, 590));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("WELCOME!");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("To GameOn!");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        Progressbar.setBackground(new java.awt.Color(102, 153, 255));
        Progressbar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        getContentPane().add(Progressbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 490, 30));

        LoadingValue.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        LoadingValue.setForeground(new java.awt.Color(255, 255, 255));
        LoadingValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoadingValue.setText("0%");
        getContentPane().add(LoadingValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 80, 50));

        LoadingMsg.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        LoadingMsg.setForeground(new java.awt.Color(255, 255, 255));
        LoadingMsg.setText("Loading...");
        getContentPane().add(LoadingMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GameOn! Blue BG (Big Logo Ver.).png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            SplashScreen sp = new SplashScreen();
            sp.setVisible(true);

            Timer timer = new Timer(100, new ActionListener() {
                int progress = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    progress++;
                    sp.LoadingValue.setText(progress + "%");

                    if (progress == 20) {
                        sp.LoadingMsg.setText("Loading Assets");
                    }
                    if (progress == 50) {
                        sp.LoadingMsg.setText("Preparing stuff");
                    }
                    if (progress == 80) {
                        sp.LoadingMsg.setText("Almost there...");
                    }

                    sp.Progressbar.setValue(progress);

                    if (progress >= 100) {
                        ((Timer) e.getSource()).stop();
                        sp.dispose(); // Dispose of SplashScreen
                        SwingUtilities.invokeLater(() -> {
                            SignIn signIn = new SignIn("User", "Password");
                            signIn.setVisible(true);
                            signIn.revalidate();
                            signIn.repaint();
                        });
                    }
                }
            });

            timer.start();
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoadingMsg;
    private javax.swing.JLabel LoadingValue;
    private javax.swing.JProgressBar Progressbar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
