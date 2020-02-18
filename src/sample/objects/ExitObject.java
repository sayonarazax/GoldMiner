package sample.objects;

import sample.enums.GameObjectType;
import sample.abstracts.AbstractGameObject;
import sample.abstracts.Coordinate;

public class ExitObject extends AbstractGameObject {
    public ExitObject(Coordinate coordinate){
        super.setImage(super.getImageIcon("sample/images/exit.gif"));
        super.setType(GameObjectType.EXIT);
        super.setCoordinate(coordinate);
    }
}
