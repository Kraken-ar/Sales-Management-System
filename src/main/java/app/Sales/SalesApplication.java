package app.Sales;

import app.Index.IndexApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SalesApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SalesApplication.class.getResource("sales-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


//jpackage --input . --name SalesManagementApp --main-jar SalesManagment.jar --main-class app.Index.Index  --module-path "C:\Program Files\Java\javafx-sdk-22.0.2\lib" --add-modules javafx.controls,javafx.fxml --type exe --icon "C:\Users\hp\Downloads\cash-register.ico"

//java --module-path "C:\Program Files\Java\javafx-sdk-22.0.2\lib" --add-modules javafx.controls,javafx.fxml -jar SalesManagment.jar


//jpackage --input . --name SalesManagementApp --main-jar SalesManagment.jar --main-class app.Index.IndexApplication  --module-path "C:\Program Files\Java\javafx-sdk-22.0.2\binlib" --add-modules javafx.controls,javafx.fxml --type exe --icon "C:\Users\hp\Downloads\cash-register.ico"