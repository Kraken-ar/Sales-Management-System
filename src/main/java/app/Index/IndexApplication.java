package app.Index;

import app.Classes.DataBaseConnection;
import app.Classes.DeviceInfo;
import app.Classes.Funs;
import app.Classes.LicenseManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IndexApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        if (!isLicenseValid()) {
           Funs.promb("البرنامج غير مفعل");

            System.exit(0);
        }


        FXMLLoader fxmlLoader = new FXMLLoader(IndexApplication.class.getResource("index-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("كاشير");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private static boolean isLicenseValid() throws FileNotFoundException {
        String key = DeviceInfo.getHardDiskSerialNumber();

        File lincesFile = new File(DataBaseConnection.rootPath +"license.key");
        if (lincesFile.exists()){
          String storedLicense ;
            Scanner scanner = new Scanner(lincesFile);
            storedLicense = scanner.nextLine();

            if (storedLicense.equals(LicenseManager.generateHash(key))){
                return true;
            }else
                return false;

        }else {
            return false;
        }
    }
}

