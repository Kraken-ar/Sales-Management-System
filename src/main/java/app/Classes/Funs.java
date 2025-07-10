package app.Classes;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Funs {

    public static void Err(String s, Alert.AlertType type) {
        ButtonType okButton = new ButtonType("الغاء");


        Alert alert = new Alert(type,s , okButton);
        alert.setHeaderText(null);

        // Apply inline styles to the alert dialog
        alert.show();
        // Set styles for the buttons

    }

    public static boolean promb(String msg){
        ButtonType okButton = new ButtonType("موافق");
        ButtonType cancleButton = new ButtonType("الغاء");

        Alert alert = new Alert(Alert.AlertType.WARNING,msg,okButton,cancleButton);
        alert.setHeaderText(null);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == okButton;

    }
    public static boolean isDouble(String s){
        try{
            double p = (double) Double.parseDouble(s);
            return true;
        }catch (Exception e){
            return false;
        }


    }

    public static boolean isInt(String s){
        try{
            int p = (int) Integer.parseInt(s);
            return true;
        }catch (Exception e){
            return false;
        }


    }

//    public static synchronized void playSound(final String url) {
//        new Thread(new Runnable() {
//            // The wrapper thread is unnecessary, unless it blocks on the
//            // Clip finishing; see comments.
//            public void run() {
//                try {
//
//                    Clip clip = AudioSystem.getClip();
//                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
//                            Main.class.getResourceAsStream("/path/to/sounds/" + url));
//                    clip.open(inputStream);
//                    clip.start();
//                } catch (Exception e) {
//                    System.err.println(e.getMessage());
//                }
//            }
//        }).start();
//    }
}
