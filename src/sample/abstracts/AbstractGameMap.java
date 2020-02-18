package sample.abstracts;

import sample.enums.GameObjectType;
import sample.interfaces.GameMap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;

public abstract  class AbstractGameMap implements GameMap, Serializable {
    private static final long serialVersonUID = 1L;
    private String name;
    private int height;
    private int width;
    private int timeLimit;
    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap(GameObjectType.class);
    private boolean isGoldManExist;
    private boolean isExitExist;

    public boolean isGoldManExist() {
        return isGoldManExist;
    }

    public void setGoldManExist(boolean goldManExist) {
        isGoldManExist = goldManExist;
    }

    public boolean isExitExist() {
        return isExitExist;
    }

    public void setExitExist(boolean exitExist) {
        isExitExist = exitExist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void addGameObject(AbstractGameObject object){
        gameObjects.put(object.getCoordinate(), object);
        ArrayList<AbstractGameObject> tmpList = typeObjects.get(object.getType());

        if(tmpList == null){
            tmpList = new ArrayList<>();
        }

        tmpList.add(object);
        typeObjects.put(object.getType(), tmpList);

    }

    public AbstractGameObject getPriorityObject(AbstractGameObject firstObject, AbstractGameObject secondObject){
        return (firstObject.getType().getIndexPriority() > secondObject.getType().getIndexPriority()) ? firstObject : secondObject;
    }


    @Override
    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public boolean isValidMap() {
        return isExitExist && isGoldManExist;
    }

    public ArrayList<AbstractGameObject> getList(GameObjectType type) {
        return typeObjects.get(type);
    }

    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate){
        return gameObjects.get(coordinate);
    }

    public AbstractGameObject getObjectByCoordinate(int x, int y){
        return gameObjects.get(new Coordinate(x, y));
    }

    public Collection<AbstractGameObject> getAllGameObgects() {
        return gameObjects.values();
    }

}
