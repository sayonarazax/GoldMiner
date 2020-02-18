package sample.objects;

import sample.enums.GameObjectType;
import sample.abstracts.AbstractGameObject;
import sample.abstracts.Coordinate;

public class TreasureObject extends AbstractGameObject {
    private int score = 5;

    public TreasureObject(Coordinate coordinate){
        super.setImage(super.getImageIcon("sample/images/gold.png"));
        super.setType(GameObjectType.TREASURE);
        super.setCoordinate(coordinate);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
