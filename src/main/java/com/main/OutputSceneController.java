package com.main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.application.Platform;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class OutputSceneController {

    @FXML
    private Label lblOutput;

    @FXML
    private Label lblCountdown;

    @FXML
    private ScrollPane scrollPane;

    private int countdown = 10;
    private SistemPresensiKantor sistemPresensiKantor;

    private Timeline timeline;

    public void setAllEmployeeDetails(String allEmployeeDetails) {
        lblOutput.setText(allEmployeeDetails);
    
        countdown = 10;
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            lblCountdown.setText("Kembali ke MainScene dalam: " + countdown + " detik");
    
            if (countdown <= 0) {
                stopCountdownAndGoToMainScene();
            } else {
                countdown--;
            }
        }));
        timeline.setCycleCount(11);
        timeline.play();
    
        timeline.setOnFinished(event -> stopCountdownAndGoToMainScene());
    }

    public void setScrollBarVisibility(boolean isVisible) {
        if (scrollPane != null) {
            if (isVisible) {
                scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            } else {
                scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            }
        }
    }

    private void stopCountdownAndGoToMainScene() {
        if (timeline != null) {
            timeline.stop();
        }

        Platform.runLater(() -> {
            if (sistemPresensiKantor != null) {
                sistemPresensiKantor.goToMainSceneAfterDelay();
            } else {
                System.err.println("Error: sistemPresensiKantor adalah null");
            }
        });
    }

    public void setSistemPresensiKantor(SistemPresensiKantor sistemPresensiKantor) {
        this.sistemPresensiKantor = sistemPresensiKantor;
    }
}