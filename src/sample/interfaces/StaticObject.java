package sample.interfaces;

import javafx.scene.image.Image;
import sample.enums.GameObjectType;
import sample.abstracts.Coordinate;

public interface StaticObject {
    Image getImage();

    Coordinate getCoordinate();

    GameObjectType getType();
}
