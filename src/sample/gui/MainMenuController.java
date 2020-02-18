package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.enums.LocationType;
import sample.interfaces.DrawableMap;
import sample.objects.maps.gui.GridPaneMap;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    private Stage primaryStage;
    private GridPaneMap gridPaneMap = new GridPaneMap(LocationType.FS, "src/sample/filemaps/game.map");
    private MainMenuController mainMenuController;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private Parent gameScreen;
    private Stage gameScreenStage;
    private GameScreenController gameScreenController;


    @FXML
    Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            fxmlLoader.setLocation(getClass().getResource("game_screen_fxml.fxml"));
            gameScreen = fxmlLoader.load();
            gameScreenController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buttonActionPerformed(ActionEvent event){
        Button button = (Button) event.getSource();
        switch (button.getId()){
            case "startButton":
                gameScreenController.setMap(gridPaneMap);
                showGameDialog();
                break;
            case "exitButton":
                primaryStage = (Stage) button.getScene().getWindow();
                primaryStage.close();
        }
    }

    private void showGameDialog(){
        gameScreenStage = new Stage();
        gameScreenStage.setResizable(false);
        gameScreenStage.setTitle("Gold Miner");
        gameScreenStage.setScene(new Scene(gameScreen));
        gameScreenStage.initModality(Modality.WINDOW_MODAL);
        gameScreenStage.showAndWait();
    }
}
