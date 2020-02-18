package sample.objects;

import sample.enums.GameObjectType;
import sample.enums.MoveDirection;
import sample.abstracts.AbstractGameObject;
import sample.abstracts.AbstractMovingObject;
import sample.abstracts.Coordinate;

public class GoldmanObject extends AbstractMovingObject {
    public GoldmanObject(Coordinate coordinate){
        super.setType(GameObjectType.GOLDMAN);
        super.setImageDown(super.getImageIcon("sample/images/goldman_down.jpg"));
        super.setImageUp(super.getImageIcon("sample/images/goldman_up.jpg"));
        super.setImageLeft(super.getImageIcon("sample/images/goldman_left.jpg"));
        super.setImageRight(super.getImageIcon("sample/images/goldman_right.jpg"));
        super.setCoordinate(coordinate);
    }
    @Override
    public void getMoveResult(AbstractGameObject objectNewCoordinate) {

    }

    @Override
    public void move(MoveDirection direction) {

    }
}
