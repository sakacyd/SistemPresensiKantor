package com.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SistemPresensiKantor extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        loadMainScene();

        // Mengambil scene yang terkait dengan primaryStage
        Scene scene = primaryStage.getScene();

        // Menambahkan file CSS ke scene
        scene.getStylesheets().add(getClass().getResource("/com/main/Styling.css").toExternalForm());
    }

    // Method untuk kembali ke MainScene setelah 10 detik
    public void goToMainSceneAfterDelay() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(() -> {
            try {
                // Tutup stage yang sedang berjalan
                Platform.runLater(() -> primaryStage.close());
                Platform.runLater(() -> {
                    try {
                        loadMainScene(); // Kembali ke MainScene setelah 10 detik
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } finally {
                executorService.shutdown();
            }
        }, 1, TimeUnit.SECONDS);
    }

    // Metode untuk memuat MainScene.fxml
    private void loadMainScene() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/main/MainScene.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Sistem Presensi Kantor");
        primaryStage.setScene(new Scene(root, 600, 400));

        // Dapatkan pengontrol untuk MainScene dan tetapkan ini sebagai referensinya
        MainSceneController mainSceneController = loader.getController();
        mainSceneController.setMainApp(this);

        primaryStage.show();
    }

    // Metode untuk memuat DetailScene.fxml
    public void loadDetailScene(int numberOfEmployees) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/main/DetailScene.fxml"));
        Parent root = loader.load();

        // Dapatkan pengontrol untuk DetailScene dan tetapkan ini sebagai referensinya
        DetailSceneController detailSceneController = loader.getController();
        detailSceneController.setNumberOfEmployees(numberOfEmployees);
        detailSceneController.setMainApp(this);

        primaryStage.getScene().setRoot(root); // Setel tampilan ke stage yang ada

        primaryStage.show();
    }

    // Metode untuk memuat OutputScene.fxml
    public void loadOutputScene(String allEmployeeDetails, int numberOfEmployees) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/main/OutputScene.fxml"));
        Parent root = loader.load();

        // Dapatkan pengontrol untuk OutputScene
        OutputSceneController outputSceneController = loader.getController();

        // Atur referensi SistemPresensiKantor ke OutputSceneController
        outputSceneController.setSistemPresensiKantor(this); // 'this' merujuk pada instansi SistemPresensiKantor saat
                                                             // ini

        // Atur detail employee
        outputSceneController.setAllEmployeeDetails(allEmployeeDetails);

        // Modifikasi visibilitas scrollbar berdasarkan numberOfEmployees
        if (numberOfEmployees < 3) {
            outputSceneController.setScrollBarVisibility(false);
        } else {
            outputSceneController.setScrollBarVisibility(true);
        }

        primaryStage.getScene().setRoot(root); // Atur tampilan ke stage yang sudah ada
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Object getDetailSceneController() {
        return null;
    }
}