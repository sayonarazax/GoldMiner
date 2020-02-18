package sample.objects;

import sample.enums.GameObjectType;
import sample.enums.MoveDirection;
import sample.abstracts.AbstractGameObject;
import sample.abstracts.AbstractMovingObject;
import sample.abstracts.Coordinate;

public class MonsterObject extends AbstractMovingObject {
    public MonsterObject(Coordinate coordinate){
        super.setType(GameObjectType.MONSTER);
        super.setImageDown(super.getImageIcon("sample/images/monster_down.jpg"));
        super.setImageUp(super.getImageIcon("sample/images/monster_up.jpg"));
        super.setImageLeft(super.getImageIcon("sample/images/monster_left.jpg"));
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
