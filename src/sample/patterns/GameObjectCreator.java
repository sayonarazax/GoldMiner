package sample.patterns;

import sample.abstracts.AbstractGameObject;
import sample.abstracts.Coordinate;
import sample.enums.GameObjectType;
import sample.objects.*;

public class GameObjectCreator {
    private GameObjectCreator(){
    }

    private static GameObjectCreator instance;

    public static GameObjectCreator getInstance(){
        if(instance == null) instance = new GameObjectCreator();
        return instance;
    }

    public AbstractGameObject createObject(GameObjectType type, Coordinate coordinate) throws Exception {
        AbstractGameObject obj = null;

        switch (type){
            case NOTHING:
                obj = new NothingObject(coordinate);
                break;
            case EXIT:
                obj = new ExitObject(coordinate);
                break;
            case MONSTER:
                obj = new MonsterObject(coordinate);
                break;
            case GOLDMAN:
                obj = new GoldmanObject(coordinate);
                break;
            case TREASURE:
                obj = new TreasureObject(coordinate);
                break;
            case WALL:
                obj = new WallObject(coordinate);
                break;

                default:
                    throw new Exception("can't read object");
        }
        return obj;
    }


}
