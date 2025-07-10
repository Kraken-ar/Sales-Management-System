package app.Classes;

import app.Index.IndexApplication;
import app.Invoices.InvoicesApplication;
import app.ProductsManagment.ProductApplication;
import app.ProductsManagment.ProductsController;
import app.Sales.SalesApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class SideBarController {

    public VBox sideBar;

    @FXML
    public void GoToProducts() throws IOException {
        Stage stage = (Stage) sideBar.getScene().getWindow();

        // Preserve window properties
        double width = stage.getWidth();
        double height = stage.getHeight();
        double xPos = stage.getX();
        double yPos = stage.getY();
        boolean isFullScreen = stage.isFullScreen();

        // Load new scene
        ProductApplication productApplication = new ProductApplication();
        productApplication.start(stage);

        // Reapply window properties after scene switch
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(xPos);
        stage.setY(yPos);
        stage.setFullScreen(isFullScreen);
    }
    @FXML
    public void GoToHome() throws IOException {
        Stage stage = (Stage) sideBar.getScene().getWindow();

        // Preserve window properties
        double width = stage.getWidth();
        double height = stage.getHeight();
        double xPos = stage.getX();
        double yPos = stage.getY();
        boolean isFullScreen = stage.isFullScreen();

        // Reapply window properties after scene switch
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(xPos);
        stage.setY(yPos);
        stage.setFullScreen(isFullScreen);
        // Load new scene
        IndexApplication indexApplication = new IndexApplication();
        indexApplication.start(stage);


    }

    public void GoToSales() throws IOException {
        Stage stage = (Stage) sideBar.getScene().getWindow();

        // Preserve window properties
        double width = stage.getWidth();
        double height = stage.getHeight();
        double xPos = stage.getX();
        double yPos = stage.getY();
        boolean isFullScreen = stage.isFullScreen();

        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(xPos);
        stage.setY(yPos);
        stage.setFullScreen(isFullScreen);
        // Load new scene
        SalesApplication salesApplication = new SalesApplication();
        salesApplication.start(stage);

        // Reapply window properties after scene switch

    }

    public void GoToInvoices() throws IOException {
        Stage stage = (Stage) sideBar.getScene().getWindow();

        // Preserve window properties
        double width = stage.getWidth();
        double height = stage.getHeight();
        double xPos = stage.getX();
        double yPos = stage.getY();
        boolean isFullScreen = stage.isFullScreen();

        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(xPos);
        stage.setY(yPos);
        stage.setFullScreen(isFullScreen);
        // Load new scene
        InvoicesApplication invoicesApplication = new InvoicesApplication();
        invoicesApplication.start(stage);

        // Reapply window properties after scene switch

    }

}
