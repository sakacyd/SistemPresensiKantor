package com.main;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class MainSceneController {
    private SistemPresensiKantor mainApp;

    @FXML
    private TextField tfjumlah;

    public void setMainApp(SistemPresensiKantor mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void btnNextClicked(ActionEvent event) {
        // Mendapatkan jumlah employee yang dimasukkan dari tfjumlah
        String inputJumlahKaryawan = tfjumlah.getText();

        // Memeriksa apakah input kosong atau tidak
        if (inputJumlahKaryawan.isEmpty()) {
            showAlert("Error", "Harap isi semua kolom.");
            return;
        }

        try {
            int jumlahKaryawan = Integer.parseInt(inputJumlahKaryawan);
            mainApp.loadDetailScene(jumlahKaryawan);
        } catch (NumberFormatException e) {
            showAlert("Error", "Harap masukkan angka yang valid.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metode utilitas untuk menampilkan peringatan
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        // Terapkan stylesheet ke alert
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/com/main/Styling.css").toExternalForm());

        alert.show();
    }
}