package sample.objects.creators;

import sample.abstracts.AbstractGameMap;
import sample.abstracts.AbstractGameObject;
import sample.enums.LocationType;
import sample.objects.maps.FSGameMap;

public class MapCreator {
    private MapCreator(){
    }

    private static MapCreator instance;

    public static MapCreator getInstance() {
        if(instance == null)
            instance = new MapCreator();
        return instance;
    }

    public AbstractGameMap createMap(LocationType type) {
        AbstractGameMap obj = null;

        switch(type) {
            case FS:
                obj = new FSGameMap();
                break;
            case DB:
                break;
            default:
                throw new IllegalArgumentException("Can't create map " + type);
        }
        return obj;
    }
}
