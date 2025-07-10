package app.ProductsManagment.Edite;

import app.Classes.DataBaseConnection;
import app.Classes.Funs;
import app.ProductsManagment.ProductsController;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import app.Classes.Funs;

public class EditeController {
    public String id;
    public ProductsController productsController;


    public TextField nameField;
    public TextField priceField;

    public TextField codeField;



    public void loadData(){
        DataBaseConnection dataBaseConnection = new DataBaseConnection(DataBaseConnection.dbPath);
        List<Map<String,String>> list = dataBaseConnection.select("select * from product where id = "+id+";");
        Map<String,String> map;
        if (list != null && !list.isEmpty()) {
            map = list.getFirst();
            nameField.setText(map.get("name"));
            priceField.setText(map.get("unitePrice"));

            codeField.setText(map.get("code"));
        }else {
            System.out.println("Null List");
        }

    }

public void edite(){
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

//        nameField.setText("");
    String query = "update product set name = ? ,  unitePrice = "+price+", code = ? where id="+id+";";
    Connection connection = dataBaseConnection.getConnection();
    try {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,name);
        statement.setString(2,code);

        statement.execute();

    } catch (SQLException e) {
        Funs.Err("البينات غير صحيحه", Alert.AlertType.ERROR);

    }
    loadData();
    Funs.Err("تم تعديل المنتج بنجاح", Alert.AlertType.CONFIRMATION);
   productsController.TableRefreash();

}


    public void setId(String id) {
        this.id = id;
    }
}
