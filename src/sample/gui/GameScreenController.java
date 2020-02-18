package sample.gui;

import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import sample.interfaces.DrawableMap;
import sample.interfaces.GameMap;
import sample.objects.maps.FSGameMap;

import java.net.URL;
import java.util.ResourceBundle;

public class GameScreenController implements Initializable {
    public GridPane gridPaneMap;

    public void setMap(DrawableMap map){
        map.drawMap();
        gridPaneMap = (GridPane) map.getMap();
        gridPaneMap.setVisible(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
