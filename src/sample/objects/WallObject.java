package sample.objects;

import sample.enums.GameObjectType;
import sample.abstracts.AbstractGameObject;
import sample.abstracts.Coordinate;

public class WallObject extends AbstractGameObject {
    public WallObject(Coordinate coordinate){
        super.setImage(super.getImageIcon("src/sample/images/wall.png"));
        super.setType(GameObjectType.WALL);
        super.setCoordinate(coordinate);
    }
}
