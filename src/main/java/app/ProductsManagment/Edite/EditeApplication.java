package app.ProductsManagment.Edite;

import app.ProductsManagment.ProductApplication;
import app.ProductsManagment.ProductsController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EditeApplication extends Application {

    private String id;
    private ProductsController productsController;
    public EditeApplication(String id, ProductsController productsController){
        this.id = id;
        this.productsController = productsController;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EditeApplication.class.getResource("edite-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(scene);
        primaryStage.show();
        EditeController editeController = fxmlLoader.getController();
        editeController.setId(id);
        editeController.productsController = productsController;
        Platform.runLater(()->{
            editeController.loadData();
        });

    }
}
