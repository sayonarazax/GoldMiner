package sample.interfaces;

import javafx.scene.image.Image;
import sample.enums.MoveDirection;
import sample.abstracts.AbstractGameObject;

public interface MovingObject extends StaticObject {
    void getMoveResult(AbstractGameObject objectNewCoordinate);

    abstract void move(MoveDirection direction);

    Image getImageLeft();
    Image getImageRight();
    Image getImageUp();
    Image getImageDown();
}
