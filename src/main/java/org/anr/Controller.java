package org.anr;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import javax.swing.text.StyledEditorKit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Controller {

    @FXML
    private HBox hBoxWhite;

    @FXML
    private HBox hBoxBlack;

    @FXML
    private Button addNoteWhite;

    @FXML
    private Button addNoteBlack;

    @FXML
    private Button clearNotes;

    Logger logger = Music.logger;
    int counterWhite = 52;
    int counterBlack = 36;
    int n = 0;
    Music dir;
    List<String> list = new ArrayList<>();
    int[] IntervalList = new int[] { // интервал между черными клавишами
            12, 22, 2, 20, 2, 2,
            22, 2, 22, 2, 2,
            22, 2, 20, 2, 2,
            22, 2, 22, 2, 2,
            22, 2, 20, 2, 2,
            22, 2, 20, 2, 2,
            22, 2, 20, 2, 2,
            22, 2, 20, 2, 2,
    };

    @FXML
    void initialize() {

        // добавление белых кнопок
        addNoteWhite.setOnAction(event -> {
            if (counterWhite >= 1) {
                logger.info("Белая кнопка добавлена! " + (counterWhite));
                Button button = new Button(String.valueOf(counterWhite));
                button.setPrefSize(20, 70);
                button.setStyle("-fx-text-fill: rgba(0,0,0,0)");

                // реализация кнопок
                button.setOnAction(event1 -> soundWhite(button.getText()));
                hBoxWhite.getChildren().add(button);
                counterWhite--;
            } // else вы лезает окно, что "Достигнуто максимальное количество клавишь!"  ????
        });

        // добавление черных кнопок
        addNoteBlack.setOnAction(event -> {
            if (counterBlack >= 1) {
                logger.info("Чёрная кнопка добавлена! " + (counterBlack));
                Button button = new Button(String.valueOf(counterBlack));
                button.setPrefSize(20, 30);
                button.setStyle("-fx-text-fill: rgba(255,0,0,0.5)");
                button.setStyle("-fx-background-color: black;");
                HBox.setMargin(button, new Insets(0, 0, 0, IntervalList[n]));
                n++;

                // реализация кнопок
                button.setOnAction(event1 -> soundBlack(button.getText()));
                hBoxBlack.getChildren().add(button);
                counterBlack--;
            } // else вы лезает окно, что "Достигнуто максимальное количество клавишь!"  ????
        });

        // удаление всех кнопок
        clearNotes.setOnAction(event -> {
            logger.info("Кнопки удалены!");
            hBoxWhite.getChildren().clear();
            hBoxBlack.getChildren().clear();
            counterWhite = 52;
            counterBlack = 36;
        });

    }

    private void soundWhite(String str) {
        dir = new Music("src/main/resources/note/note" + str + ".wav");
        dir.sound();
    }

    private void soundBlack(String str) {
        dir = new Music("src/main/resources/blackNote/blackNote" + str + ".wav");
        dir.sound();
    }
}
