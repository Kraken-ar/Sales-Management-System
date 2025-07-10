module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires  java.sql;


    opens app.Index to javafx.fxml;
    opens app.ProductsManagment to javafx.fxml;
    opens app.ProductsManagment.Edite to javafx.fxml;
    opens app.Sales to javafx.fxml;
    opens app.Invoices to javafx.fxml;

    exports app.Classes;
    exports app.Index;
    exports app.ProductsManagment;
    exports app.ProductsManagment.Edite;
    exports app.Sales;
    exports app.Invoices;
}