import controllers.MainWindowController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        primaryStage.setScene(new Scene(parent));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Наряд на выполнение работ");
        primaryStage.show();
    }
}
