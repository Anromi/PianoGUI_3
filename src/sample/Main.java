package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*
        ScrollBar scrollBarY = new ScrollBar();
        scrollBarY.setMin(0);
        scrollBarY.setMax(260);
        scrollBarY.setValue(100);
        scrollBarY.setOrientation(Orientation.VERTICAL);
        scrollBarY.setTranslateY(20);
        
        ScrollBar scrollBarX = new ScrollBar();
        scrollBarX.setMin(0);
        scrollBarX.setMax(260);
        scrollBarX.setValue(100);
        */
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Piano");
        primaryStage.setScene(new Scene(root, 1213, 333));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
