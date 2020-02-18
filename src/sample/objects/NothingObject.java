package sample.objects;

import sample.enums.GameObjectType;
import sample.abstracts.AbstractGameObject;
import sample.abstracts.Coordinate;

public class NothingObject extends AbstractGameObject {
    public NothingObject(Coordinate coordinate){
        super.setType(GameObjectType.NOTHING);
        super.setCoordinate(coordinate);
    }
}
