package app.ProductsManagment;

import app.Classes.DataBaseConnection;
import app.ProductsManagment.Edite.EditeApplication;
import app.ProductsManagment.Edite.EditeController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import app.Classes.Funs;

public class ProductsController implements Initializable {



    public TextField nameField;
    public TextField priceField;

    public TextField codeField;
    public TextField searchField;

    public TableView<product> table;
    public TableColumn<product ,String> nameCol;
    public TableColumn<product,String> priceCol;
   // public TableColumn<product,String> qntCol;
    public TableColumn<product,String> codeCol;
    //public TableColumn<product,String> dateCol;
    public TableColumn<product, HBox> actionsCol;




    @FXML
    public void addProduct(){
        String name = nameField.getText();
        String price = priceField.getText();

        String code = codeField.getText();

        if (name.isEmpty()){
            Funs.Err("لا يمكنك ترك خانه الاسم فارغه", Alert.AlertType.ERROR);
            return;
        }

        if (price.isEmpty()){
            Funs.Err("لا يمكنك ترك خانه السعر فارغه", Alert.AlertType.ERROR);
            return;
        }else if(!Funs.isDouble(price)) {
            Funs.Err("خانه السعر يجب ان تحتوى على ارقام فقط", Alert.AlertType.ERROR);

           return;
        }



        DataBaseConnection dataBaseConnection = new DataBaseConnection(DataBaseConnection.dbPath);

        if (!code.isEmpty()) {

            List<Map<String,String>> list = dataBaseConnection.select("select name from product where code = '"+code+"';");
            if (!list.isEmpty()){
                Funs.Err("كود الماسح مستخدم فى منتج " + list.getFirst().get("name")  , Alert.AlertType.ERROR);

                return;
            }

        }
        nameField.setText("");
        priceField.setText("");

        codeField.setText("");
//        nameField.setText("");
        dataBaseConnection.excute("insert into product(name,unitePrice,code) values ('"+name+"',"+price+",'"+code+"');");
        Funs.Err("تم اضافه المنتج بنجاح", Alert.AlertType.CONFIRMATION);
        TableRefreash();

    }
    public ObservableList<product> observableList(){
        DataBaseConnection dataBaseConnection = new DataBaseConnection(DataBaseConnection.dbPath);

        ObservableList<product> observableList = FXCollections.observableArrayList();
        List<Map<String,String>> list = dataBaseConnection.select("select * from product;");
        for (Map<String,String> map: list){
            observableList.add(new product(map,this));
        }

        return observableList;
    }

    public ObservableList<product> observableList(String s){
        DataBaseConnection dataBaseConnection = new DataBaseConnection(DataBaseConnection.dbPath);

        ObservableList<product> observableList = FXCollections.observableArrayList();
        List<Map<String,String>> list = dataBaseConnection.select("select * from product where name like '%"+s+"%';");
        for (Map<String,String> map: list){
            observableList.add(new product(map,this));
        }

        return observableList;
    }

    public void TableRefreash(){
        table.getItems().clear();
        table.setItems(observableList());


    }
    public void search(){
        table.getItems().clear();
        table.setItems(observableList(searchField.getText()));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
//        qntCol.setCellValueFactory(new PropertyValueFactory<>("qnt"));
        codeCol.setCellValueFactory(new PropertyValueFactory<>("code"));
        actionsCol.setCellValueFactory(new PropertyValueFactory<>("actions"));
        TableRefreash();
    }

    public class product{
        public String name;
        public String price;
        public String qnt;
        public String code;
        public HBox actions;
        product(Map<String,String> map,ProductsController productsController){
            setName(map.get("name"));
            setPrice(map.get("unitePrice"));
            setCode(map.get("code"));
            setQnt(map.get("qnt"));
            Button deleteBtn = new Button("حذف");
            Button editeBtn = new Button("تعديل");

            editeBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Stage stage = new Stage();

                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.initOwner(table.getScene().getWindow());

                    EditeApplication editeApplication = new EditeApplication(map.get("id"),productsController);
                    System.out.println(map.get("name"));
                    try {
                        editeApplication.start(stage);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }
            });
            deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (Funs.promb("هل تريد حذف هذا المنتج")) {
                        DataBaseConnection dataBaseConnection = new DataBaseConnection(DataBaseConnection.dbPath);
                        dataBaseConnection.excute("delete from product where id = " + map.get("id") + ";");
                        TableRefreash();
                    }
                }
            });


            HBox acs = new HBox();
            acs.setSpacing(3);
            acs.getChildren().addAll(deleteBtn,editeBtn);

            setActions(acs);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getQnt() {
            return qnt;
        }

        public void setQnt(String qnt) {
            this.qnt = qnt;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public HBox getActions() {
            return actions;
        }

        public void setActions(HBox actions) {
            this.actions = actions;
        }
    }
}
