package app.Sales;

import app.Classes.DataBaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class SalesController implements Initializable {

    public TableView salesTable;
    public TableColumn<Sale,String> nameCol;
    public TableColumn<Sale,String> priceCol;
    public TableColumn<Sale,String> qntCol;
    public TableColumn<Sale,String> totalCol;
    public TableColumn<Sale,String> invoiceCol;
    public TableColumn<Sale,String> dateCol;
    public DatePicker startField;
    public DatePicker endField;

    public Label productsLable;
    public Label qntLable;
    public Label totalLable;




    ObservableList<Sale> observableList(){
        ObservableList<Sale> saleObservableList = FXCollections.observableArrayList();
        DataBaseConnection dataBaseConnection  = new DataBaseConnection(DataBaseConnection.dbPath);
        List<Map<String,String>> list = dataBaseConnection.select("select * from sale;");
        if (!list.isEmpty()){
            for (Map<String,String> map:list){
                saleObservableList.add(new Sale(map));
            }
        }

        return saleObservableList;
    }

    ObservableList<Sale> observableList(String Start_Date,String End_Date){
        ObservableList<Sale> saleObservableList = FXCollections.observableArrayList();
        DataBaseConnection dataBaseConnection  = new DataBaseConnection(DataBaseConnection.dbPath);
        List<Map<String,String>> list = dataBaseConnection.select("SELECT * FROM sale WHERE created_at BETWEEN '" + Start_Date + " 00:00:00' AND '" + End_Date + " 23:59:59';");
        if (!list.isEmpty()){
            for (Map<String,String> map:list){
                saleObservableList.add(new Sale(map));
            }
        }

        return saleObservableList;
    }

    public void setStatistcs(){
        ObservableList<Sale> observableList = salesTable.getItems();
        int productsQnt = 0;
        int totalQnt = 0;
        double totalPrice = 0;
        for (Sale s:observableList){
            productsQnt++;
            totalQnt += Integer.parseInt(s.qnt);
            totalPrice+= Double.parseDouble(s.total);
        }

        productsLable.setText(productsQnt+"");
        qntLable.setText(totalQnt+"");
        totalLable.setText(String.format("%.2f EGP",totalPrice));
    }

    public void loadAll(){
        salesTable.getItems().clear();
        salesTable.setItems(observableList());
        setStatistcs();
    }

    public void filter(){
       salesTable.getItems().clear();
       salesTable.setItems(observableList(startField.getValue().toString(),endField.getValue().toString()));
       setStatistcs();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        qntCol.setCellValueFactory(new PropertyValueFactory<>("qnt"));
        totalCol.setCellValueFactory(new PropertyValueFactory<>("total"));
        invoiceCol.setCellValueFactory(new PropertyValueFactory<>("invoice"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        loadAll();
    }

    public class Sale {
        String name;
        String price;
        String qnt;
        String total;
        String invoice;
        String date;

        Sale(Map<String ,String> map){
            name = map.get("product_name");
            price = map.get("unitePrice");
            qnt = map.get("qnt");
            double tot = (double) (Integer.parseInt(qnt)*Double.parseDouble(price));
            total =String.format("%.2f",tot) ;
            invoice = map.get("invoice_id");
            date = map.get("created_at");
        }


        public String getName() {
            return name;
        }

        public String getPrice() {
            return price;
        }

        public String getQnt() {
            return qnt;
        }

        public String getTotal() {
            return total;
        }

        public String getInvoice() {
            return invoice;
        }

        public String getDate() {
            return date;
        }
    }
}
