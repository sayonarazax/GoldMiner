package sample.objects.maps.gui;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import sample.abstracts.AbstractGameMap;
import sample.abstracts.AbstractGameObject;
import sample.abstracts.Coordinate;
import sample.enums.GameObjectType;
import sample.enums.LocationType;
import sample.interfaces.DrawableMap;
import sample.objects.NothingObject;
import sample.objects.WallObject;
import sample.objects.creators.MapCreator;

public class GridPaneMap implements DrawableMap {
    GridPane paneMap = new GridPane();

    private AbstractGameMap gameMap;

    private String[] columnNames;

    private AbstractGameObject[][] mapObjects;
    public GridPaneMap(LocationType type, Object source){
        gameMap = MapCreator.getInstance().createMap(type);
        gameMap.loadMap(source);

        updateObjectsArray();
    }

    private void fillEmptyMap(int width, int height) {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                mapObjects[y][x] = new NothingObject(new Coordinate(x, y));
            }
        }
    }

    public void updateObjectsArray(){
        mapObjects = new AbstractGameObject[gameMap.getHeight()][gameMap.getWidth()];

        fillEmptyMap(gameMap.getWidth(), gameMap.getHeight());
        for(AbstractGameObject object : gameMap.getAllGameObgects()) {
            if(!object.getType().equals(GameObjectType.NOTHING)) {
                int y = object.getCoordinate().getY();
                int x = object.getCoordinate().getX();
                if(!(mapObjects[y][x] instanceof NothingObject ) &&
                        !(mapObjects[y][x] instanceof WallObject)) {
                    AbstractGameObject tmpObject = mapObjects[y][x];
                    mapObjects[y][x] = gameMap.getPriorityObject(object, tmpObject);
                } else {
                    mapObjects[y][x] = object;
                }
            }
        }
    }

    @Override
    public Node getMap() {
        return  paneMap;
    }

    @Override
    public boolean drawMap() {
        for(int y = 0; y < gameMap.getHeight(); y++) {
            for(int x = 0; x < gameMap.getWidth(); x++) {
                Label label = new Label();
                System.out.println(x + " " + y);
                label.setGraphic(new ImageView(mapObjects[y][x].getImage()));
                paneMap.add(label, x, y);
            }
        }
        return true;
    }
}
