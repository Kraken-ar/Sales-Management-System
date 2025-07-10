package app.Invoices;

import app.Classes.DataBaseConnection;
import app.Classes.Funs;
import app.Sales.SalesController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class InvoicesController implements Initializable {

    public TableView<Invoice> invoiceTable;
    public TableColumn<Invoice,String> idCol;
//    public TableColumn<Invoice,Integer> typesCol;

    public TableColumn<Invoice,Double> totalCol;
    public TableColumn<Invoice,String> dateCol;
    public TableColumn<Invoice, HBox> actionsCol;
    public TableColumn<Invoice, VBox> saleNameCol;
    public TableColumn<Invoice, VBox> salePriceCol;
    public TableColumn<Invoice, VBox> saleQntCol;
    public TableColumn<Invoice, VBox> saleActionsCol;

    public TextField searchField;
    public DatePicker startField;
    public DatePicker endField;

    public Label qntLable;
    public Label totalLable;

    ObservableList<Invoice> observableList(){
        ObservableList<Invoice> observableList = FXCollections.observableArrayList();
        DataBaseConnection dataBaseConnection = new DataBaseConnection(DataBaseConnection.dbPath);
        List<Map<String,String>> list = dataBaseConnection.select("select * from invoice order by created_at DESC;");
        for (Map<String,String> map: list){
            observableList.add(new Invoice(map,dataBaseConnection));
        }
        return observableList;


    }
    ObservableList<Invoice> observableList(String s){
        ObservableList<Invoice> observableList = FXCollections.observableArrayList();
        DataBaseConnection dataBaseConnection = new DataBaseConnection(DataBaseConnection.dbPath);
        List<Map<String,String>> list = dataBaseConnection.select("select * from invoice where id = "+s+" order by created_at DESC;");
        for (Map<String,String> map: list){
            observableList.add(new Invoice(map,dataBaseConnection));
        }
        return observableList;


    }
    ObservableList<Invoice> observableList(String StartDate,String EndDate){
        ObservableList<Invoice> observableList = FXCollections.observableArrayList();
        DataBaseConnection dataBaseConnection = new DataBaseConnection(DataBaseConnection.dbPath);
        List<Map<String,String>> list = dataBaseConnection.select("select * from invoice where created_at BETWEEN '" + StartDate + " 00:00:00' AND '" + EndDate + " 23:59:59' order by created_at DESC;");
        for (Map<String,String> map: list){
            observableList.add(new Invoice(map,dataBaseConnection));
        }
        return observableList;


    }


    public void loadAll(){
        invoiceTable.getItems().clear();
        invoiceTable.setItems(observableList());
        searchField.setText("");
        startField.setValue(null);
        endField.setValue(null);
        setStatistcs();
    }
    public void search(){
        invoiceTable.getItems().clear();
        invoiceTable.setItems(observableList(searchField.getText()));
        setStatistcs();
    }
    public void filter(){
        invoiceTable.getItems().clear();
        invoiceTable.setItems(observableList(startField.getValue().toString(),endField.getValue().toString()));
        setStatistcs();
    }

    public void setStatistcs(){
        ObservableList<Invoice> observableList = invoiceTable.getItems();

        int totalQnt = 0;
        double totalPrice = 0;
        for (Invoice s:observableList){
            totalQnt++;

            totalPrice+= s.getTotal();
        }


        qntLable.setText(totalQnt+"");
        totalLable.setText(String.format("%.2f EGP",totalPrice));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
//        typesCol.setCellValueFactory(new PropertyValueFactory<>("types"));
//        qntCol.setCellValueFactory(new PropertyValueFactory<>("qnt"));
        totalCol.setCellValueFactory(new PropertyValueFactory<>("total"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        actionsCol.setCellValueFactory(new PropertyValueFactory<>("actions"));

        saleNameCol.setCellValueFactory(new PropertyValueFactory<>("saleName"));
        salePriceCol.setCellValueFactory(new PropertyValueFactory<>("salePrice"));
        saleQntCol.setCellValueFactory(new PropertyValueFactory<>("saleQnt"));
        saleActionsCol.setCellValueFactory(new PropertyValueFactory<>("saleActions"));

        loadAll();
        setStatistcs();
    }

   public class Invoice{
        String id;
        Integer types = 0;
        Integer qnt = 0;
        Double total = 0.0;
        String date ;
        HBox actions = new HBox();
       VBox saleName = new VBox();
       VBox salePrice = new VBox();
       VBox saleQnt = new VBox();
       VBox saleActions = new VBox();

        Invoice(Map<String,String> map,DataBaseConnection dataBaseConnection){
            this.id = map.get("id");



                List<Map<String,String>> sales = dataBaseConnection.select("select * from sale where invoice_id = "+id+";");
                types = sales.size();
                date = map.get("created_at");
                Label nameLable;
                Label priceLable;
                Label qntLable;
                boolean flage = true;
                for (Map<String,String> sale : sales){
                    nameLable = new Label(sale.get("product_name"));
                    priceLable = new Label(sale.get("unitePrice"));
                    qntLable = new Label(sale.get("qnt"));



                    nameLable.setMaxHeight(Double.MAX_VALUE);
                    priceLable.setMaxHeight(Double.MAX_VALUE);
                    qntLable.setMaxHeight(Double.MAX_VALUE);

                    nameLable.setMaxWidth(Double.MAX_VALUE);
                    nameLable.setPrefWidth(Double.MAX_VALUE);

                    priceLable.setMaxWidth(Double.MAX_VALUE);
                    priceLable.setPrefWidth(Double.MAX_VALUE);

                    qntLable.setMaxWidth(Double.MAX_VALUE);
                    qntLable.setPrefWidth(Double.MAX_VALUE);

                    nameLable.setAlignment(Pos.CENTER);
                    priceLable.setAlignment(Pos.CENTER);
                    qntLable.setAlignment(Pos.CENTER);

                    if (flage){
                        nameLable.setBackground(Background.fill(Paint.valueOf("#d5d8de")));
                        priceLable.setBackground(Background.fill(Paint.valueOf("#d5d8de")));
                        qntLable.setBackground(Background.fill(Paint.valueOf("#d5d8de")));
                    }
                    flage = !flage;

                    saleName.getChildren().add(nameLable);
                    salePrice.getChildren().add(priceLable);
                    saleQnt.getChildren().add(qntLable);
                    saleName.setVgrow(nameLable, Priority.ALWAYS);
                    salePrice.setVgrow(priceLable, Priority.ALWAYS);
                    saleQnt.setVgrow(qntLable, Priority.ALWAYS);

                    Button deleteSale = new Button("حذف");
                    deleteSale.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String query = "delete from sale where id = "+sale.get("id") +";";
                            if (Funs.promb("هل تريد حذف هذا العنصر")){
                                dataBaseConnection.excute(query);
                                loadAll();
                            }


                        }
                    });
                    Button increaseSale = new Button("+");
                    Button discreaseSale = new Button("-");

                    increaseSale.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String query = "update sale set qnt = " + (Integer.parseInt(sale.get("qnt")) +1)+" where id = "+sale.get("id")+";";
                            dataBaseConnection.excute(query);
                            loadAll();
                        }
                    });

                    discreaseSale.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            String query;

                            int q = Integer.parseInt(sale.get("qnt"));
                            if (q == 1){
                                if (sales.size() == 1){
                                    query = "delete from invoice where id = "+id +";";
                                    if (Funs.promb("هل تريد حذف هذا العنصر سيتم حذف الفاتوره")){
                                        dataBaseConnection.excute(query);
                                        query = "delete from sale where id = "+sale.get("id") +";";
                                        dataBaseConnection.excute(query);
                                        loadAll();
                                    }
                                }else {
                                    query = "delete from sale where id = "+sale.get("id") +";";
                                    if (Funs.promb("هل تريد حذف هذا العنصر")){
                                        dataBaseConnection.excute(query);
                                        loadAll();
                                    }
                                }

                            }else {
                                query = "update sale set qnt = " + (Integer.parseInt(sale.get("qnt")) -1)+" where id = "+sale.get("id")+";";
                                dataBaseConnection.excute(query);
                                loadAll();
                            }

                        }
                    });
                    saleActions.getChildren().add( new HBox( deleteSale,discreaseSale,increaseSale));

                    qnt += Integer.parseInt(sale.get("qnt"));
                    total += Double.parseDouble(sale.get("unitePrice")) * Double.parseDouble(sale.get("qnt")) ;
                }

                Button deleteBtn = new Button("حذف");
                deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (Funs.promb("هل تريد حذف هذه الفاتوره برقم "+id)){

                            dataBaseConnection.excute("delete from invoice where id = "+id+";");
                            dataBaseConnection.excute("delete from sale where invoice_id = "+id+";");
                            loadAll();

                        }

                    }

                });

                actions.getChildren().addAll(deleteBtn);
            }

        public String getId() {
            return id;
        }

        public Integer getTypes() {
            return types;
        }

        public Integer getQnt() {
            return qnt;
        }

        public Double getTotal() {
            return total;
        }

        public String getDate() {
            return date;
        }

        public HBox getActions() {
            return actions;
        }

       public VBox getSaleName() {
           return saleName;
       }

       public VBox getSalePrice() {
           return salePrice;
       }

       public VBox getSaleQnt() {
           return saleQnt;
       }

       public VBox getSaleActions() {
           return saleActions;
       }
   }

}
