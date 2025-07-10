package app.Index;

import app.Classes.DataBaseConnection;
import app.Classes.Funs;
import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class IndexContoller implements Initializable {


    public FlowPane productsContainer;
    public TableView<sale> invoiceTable;
    public TableColumn<sale,String> nameCol;
    public TableColumn<sale,Integer> qntCol;
    public TableColumn<sale,String> priceCol;
    public TableColumn<sale,String> totalCol;

    public TextField barcodeField;

    public Label totalPurch;

    private StringBuilder barcodeBuffer = new StringBuilder();



    public void loadProducts(){
        String query = "select id,name from product where code = '';";
        DataBaseConnection dataBaseConnection = new DataBaseConnection(DataBaseConnection.dbPath);
        List<Map<String,String>> list = dataBaseConnection.select(query);
        if (list != null && !list.isEmpty()){
            for (Map<String,String> map:list){
                Button button = new Button(map.get("name"));
                button.setUserData(map.get("id"));
                button.setPrefHeight(66);
                button.setMaxWidth(Double.MAX_VALUE);
                button.setFont(Font.font("system", FontWeight.BOLD,13));
                button.setFocusTraversable(false);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println(button.getUserData());
                        addSale((String) button.getUserData());
                    }
                });
                productsContainer.getChildren().add(button);
            }
        }
    }



    public void addSale(String id){

        ObservableList<sale> observableList = invoiceTable.getItems();
//        invoiceTable.getItems().clear();

        for (sale s : observableList){

            if (s.id.equals(id)){


               s.setQnt( s.getQnt() + 1);

//                invoiceTable.setItems(observableList);
                invoiceTable.refresh();
                calculateTotal();
                return;
            }
        }

        observableList.add(new sale(id));

        invoiceTable.setItems(observableList);
        calculateTotal();

    }



    public void calculateTotal(){
        ObservableList<sale> observableList = invoiceTable.getItems();
        double sum = 0;
        for (sale s :observableList){
            sum += Double.parseDouble( s.getTotal());

        }
        totalPurch.setText(sum+"");
    }
    public void removeAll(){
        invoiceTable.getItems().clear();
        calculateTotal();
    }
    public void removeLast(){
        ObservableList<sale> observableList = invoiceTable.getItems();
        if (!observableList.isEmpty()) {
            observableList.removeLast();
            invoiceTable.refresh();
        }
        calculateTotal();
    }

    public void save_invoice(){
        DataBaseConnection dataBaseConnection = new DataBaseConnection(DataBaseConnection.dbPath);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        int invoice_id = dataBaseConnection.insert("insert into invoice(created_at) values ('" + timestamp + "');");
//       try {
//            invoice_id =
//       }catch (Exception e){
//           Funs.Err(e.toString(), Alert.AlertType.ERROR);
//       }

       ObservableList<sale> observableList = invoiceTable.getItems();
        System.out.println(observableList.size());
       if (!observableList.isEmpty()){
           for (sale s : observableList){
               s.SaveSale(invoice_id+"");
           }

           removeAll();

       }
       }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        qntCol.setCellValueFactory(new PropertyValueFactory<>("qnt"));
        totalCol.setCellValueFactory(new PropertyValueFactory<>("total"));
        ObservableList<sale> observableList = FXCollections.observableArrayList();
        invoiceTable.setItems(observableList);

        calculateTotal();
        loadProducts();

        // Buffer to store the scanned barcode characters
        StringBuilder barcodeBuffer = new StringBuilder();

        Platform.runLater(() -> {
            Scene scene = invoiceTable.getScene();
            barcodeField.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode() == KeyCode.ENTER){
                        String code = barcodeField.getText();
                        if (!code.isEmpty()){
                            DataBaseConnection dataBaseConnection = new DataBaseConnection(DataBaseConnection.dbPath);
                            List<Map<String,String>> list = dataBaseConnection.select("select id from product where code = '"+code+"'");
                            System.out.println("the code is : "+code);
                            if (!list.isEmpty()){
                                System.out.println("found");
                                Map<String,String> map = list.getFirst();
                                addSale(map.get("id"));

                            }else
                                System.out.println("Not found");
                        }else{}
                        barcodeField.setText("");


                    }else  if (event.getCode() == KeyCode.ESCAPE) {
                        removeAll();
                    } else if (event.getCode() == KeyCode.BACK_SPACE) {
                        removeLast();
                    } else if (event.getCode() == KeyCode.SHIFT)
                        save_invoice();
                }
            });
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode() == KeyCode.ESCAPE) {
                        removeAll();
                    } else if (event.getCode() == KeyCode.BACK_SPACE) {
                        removeLast();
                    } else if (event.getCode() == KeyCode.SHIFT) {
                        save_invoice();
                    } else {
                        // Append characters to the buffer (assuming the scanner sends them as text)

                    }
                }
            });
        });
    }


    public class sale{
        String id;
        String name;
        SimpleIntegerProperty qnt;
        SimpleDoubleProperty price;




        SimpleStringProperty total;

      public   sale(String id){
            this.id = id;
            DataBaseConnection dataBaseConnection = new DataBaseConnection(DataBaseConnection.dbPath);
            Map<String,String> map = dataBaseConnection.select("select name,unitePrice from product where id = "+id+";").getFirst();
            name =  map.get("name");
            price = new SimpleDoubleProperty(Double.parseDouble(map.get("unitePrice")));


            qnt = new SimpleIntegerProperty(1);
            total = new SimpleStringProperty( ( (Double) (qnt.get() * price.get())) +"");


        }

        public void SaveSale(String invoice_id){
          DataBaseConnection dataBaseConnection = new DataBaseConnection(DataBaseConnection.dbPath);
          String query = "insert into sale(product_name,unitePrice,qnt,invoice_id,product_id) values (?,?,?,?,?);";

          Connection connection = dataBaseConnection.getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,getName());
                statement.setString(2,getPrice());
                statement.setString(3,getQnt()+"");
                statement.setString(4,invoice_id);
                statement.setString(5,id);
                statement.execute();

            } catch (SQLException e) {
                System.out.println(e.toString());
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
            }
        }

        public void updateQnt(){

        }

        public String getName() {
            return name;
        }

        public String getPrice() {
            return price.get() + "";
        }

        public Integer getQnt() {
            return qnt.get();
        }

        public String getTotal() {
            return total.get() ;
        }

        public void setQnt(int qnt) {
            this.qnt.set(qnt);
            total = new SimpleStringProperty( ( (Double) (getQnt() * price.get())) +"");
        }


    }
}
