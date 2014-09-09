package subtitles.player;

import java.io.*;
import java.util.concurrent.Executors;
import javax.swing.*;
import subtitleFile.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Future;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.border.Border;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miroshko
 */
public class ApplicationForm extends javax.swing.JFrame {

    int screenWidth;
    int screenHeight;
    private File currentFile;
    private TimedTextObject timedText;
    private int currentPosition = 0;
    private int resolution = 10; // ms
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private Future schedulerFuture;
   
    /**
     * Creates new form ApplicationForm
     */
    public ApplicationForm() {
        initComponents();
        
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        screenWidth = gd.getDisplayMode().getWidth();
        screenHeight = gd.getDisplayMode().getHeight();
        int margin = 150;
        int height = 150;
       
        subtitleFrame.setBounds(
                margin,
                screenHeight - margin - height,
                screenWidth - 2 * margin,
                height
        );
        
        subtitleFrame.setBackground(new Color(0,0,0,0));
        subtitleContainerLabel.setBackground(new Color(0,0,0,0));
        subtitleContainerLabel.setOpaque(false);
        subtitleFrame.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subtitleFileChooser = new javax.swing.JFileChooser();
        subtitleFrame = new javax.swing.JFrame();
        translucent1 = new subtitles.player.Translucent();
        subtitleContainerLabel = new javax.swing.JLabel();
        openSubtitleFile = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        playButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        progressSlider = new javax.swing.JSlider();
        timePositionLabel = new javax.swing.JLabel();

        subtitleFrame.setAlwaysOnTop(true);
        subtitleFrame.setBackground(new java.awt.Color(255, 0, 142));
        subtitleFrame.setUndecorated(true);

        subtitleContainerLabel.setBackground(new java.awt.Color(172, 188, 40));
        subtitleContainerLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        subtitleContainerLabel.setForeground(new java.awt.Color(236, 231, 37));
        subtitleContainerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subtitleContainerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                subtitleContainerLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                subtitleContainerLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                subtitleContainerLabelMousePressed(evt);
            }
        });
        subtitleContainerLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                subtitleContainerLabelMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout translucent1Layout = new javax.swing.GroupLayout(translucent1);
        translucent1.setLayout(translucent1Layout);
        translucent1Layout.setHorizontalGroup(
            translucent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(translucent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subtitleContainerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );
        translucent1Layout.setVerticalGroup(
            translucent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(translucent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subtitleContainerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout subtitleFrameLayout = new javax.swing.GroupLayout(subtitleFrame.getContentPane());
        subtitleFrame.getContentPane().setLayout(subtitleFrameLayout);
        subtitleFrameLayout.setHorizontalGroup(
            subtitleFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(translucent1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );
        subtitleFrameLayout.setVerticalGroup(
            subtitleFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(translucent1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        openSubtitleFile.setText("Open");
        openSubtitleFile.setToolTipText("");
        openSubtitleFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openSubtitleFileActionPerformed(evt);
            }
        });

        status.setText("No file is open");
        status.setToolTipText("");

        playButton.setText("▶");
        playButton.setToolTipText("");
        playButton.setEnabled(false);
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        pauseButton.setText("▐▐");
        pauseButton.setToolTipText("");
        pauseButton.setEnabled(false);
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        progressSlider.setMaximum(200);
        progressSlider.setValue(0);
        progressSlider.setEnabled(false);
        progressSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                progressSliderMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                progressSliderMouseReleased(evt);
            }
        });
        progressSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                progressSliderStateChanged(evt);
            }
        });

        timePositionLabel.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        timePositionLabel.setText("0:00");
        timePositionLabel.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(openSubtitleFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timePositionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openSubtitleFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(timePositionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void openSubtitleFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openSubtitleFileActionPerformed
        int returnVal = subtitleFileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            currentFile = subtitleFileChooser.getSelectedFile();
            OpenCurrentFile();
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_openSubtitleFileActionPerformed
    
    private String formatTime(int milliseconds) {
        int seconds = (int) (milliseconds / 1000) % 60;
        int minutes = (int) ((milliseconds / (1000*60)) % 60);
        int hours   = (int) ((milliseconds / (1000*60*60)) % 24);
        String formatted = String.format("%02d:%02d", minutes, seconds);
        if (hours > 0) {
            formatted = String.format("%d:", hours) + formatted;
        }
        return formatted;
    }
    
    private String getTextOnCurrentPosition() {
        int prevKey = timedText.captions.firstKey();
        for(int key: timedText.captions.keySet()) {
            if(key > currentPosition) {
              break;  
            }
            prevKey = key;
        }
        Caption currCaption = timedText.captions.get(prevKey);
        if (currCaption.start.getMseconds() < currentPosition &&
            currCaption.end.getMseconds() > currentPosition) {
                return currCaption.content;
        }
        return "";
    }

    private void play() {
        schedulerFuture = scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                currentPosition += resolution;
                reflectPosition();
            }        
        }, 0, resolution, TimeUnit.MILLISECONDS);

        pauseButton.setEnabled(true);
        playButton.setEnabled(false);
    }
    
    private void reflectPosition() {
        progressSlider.setValue(currentPosition);
        String text = "<html>" + getTextOnCurrentPosition() + "</html>";
        timePositionLabel.setText(formatTime(currentPosition));
        if (text.compareTo(subtitleContainerLabel.getText()) != 0) {
            // Graphics g = subtitleFrame.getGraphics();
            // g.clearRect(0, 0, 250, 250);
            
            subtitleContainerLabel.setText(text);
        }
    }
    
    private void pause() {
        if (schedulerFuture != null) {
            schedulerFuture.cancel(true);
        }
        pauseButton.setEnabled(false);
        playButton.setEnabled(true);
    }
    
    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        play();
    }//GEN-LAST:event_playButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        pause();
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void progressSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_progressSliderStateChanged
        currentPosition = progressSlider.getValue();
        reflectPosition();
    }//GEN-LAST:event_progressSliderStateChanged

    boolean pausedOnMousePressed;
    private void progressSliderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_progressSliderMousePressed
        pausedOnMousePressed = schedulerFuture == null || schedulerFuture.isCancelled();
        if (!pausedOnMousePressed)
            pause();
    }//GEN-LAST:event_progressSliderMousePressed

    private void progressSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_progressSliderMouseReleased
        if (!pausedOnMousePressed)
            play();
    }//GEN-LAST:event_progressSliderMouseReleased

    private void subtitleContainerLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subtitleContainerLabelMouseEntered
        Border border = BorderFactory.createLineBorder(Color.yellow, 3);
        subtitleContainerLabel.setBorder(border);
    }//GEN-LAST:event_subtitleContainerLabelMouseEntered

    private void subtitleContainerLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subtitleContainerLabelMouseExited
        // Border border = BorderFactory.createLineBorder(Color.yellow, 3);
        subtitleContainerLabel.setBorder(null);
        
    }//GEN-LAST:event_subtitleContainerLabelMouseExited

    int posX;
    int posY;
    
    private void subtitleContainerLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subtitleContainerLabelMousePressed
        // TODO add your handling code here:
      posX = evt.getX();
      posY = evt.getY();
    }//GEN-LAST:event_subtitleContainerLabelMousePressed

    private void subtitleContainerLabelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subtitleContainerLabelMouseDragged
        subtitleFrame.setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
    }//GEN-LAST:event_subtitleContainerLabelMouseDragged

    
    private void enableControls() {
        playButton.setEnabled(true);
        pauseButton.setEnabled(false);
        progressSlider.setEnabled(true);
    }
    
    private void disableControls() {
        
    }
   

    private void OpenCurrentFile() {
        status.setText(String.format("Opened file: %s", currentFile.getName()));
        FormatSRT srt = new FormatSRT();
        try {
            InputStream is = new FileInputStream(currentFile);
            timedText = srt.parseFile(currentFile.getAbsolutePath(), is);
            int length = timedText.captions.lastEntry().getValue().end.getMseconds();
            progressSlider.setMaximum(length);
            progressSlider.setValue(0);
            pause();
            enableControls();
            // subtitleForm = new SubtitleWindow();
            // subtitleForm.setVisible(true);
        } catch (IOException e) {
            status.setText("Error opening file");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ApplicationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton openSubtitleFile;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton playButton;
    private javax.swing.JSlider progressSlider;
    private javax.swing.JLabel status;
    private javax.swing.JLabel subtitleContainerLabel;
    private javax.swing.JFileChooser subtitleFileChooser;
    private javax.swing.JFrame subtitleFrame;
    private javax.swing.JLabel timePositionLabel;
    private subtitles.player.Translucent translucent1;
    // End of variables declaration//GEN-END:variables
}
