package sample.objects.maps;

import sample.abstracts.AbstractGameMap;

public class DBGameMap extends AbstractGameMap {
    @Override
    public boolean saveMap(Object source) {
        return false;
    }

    @Override
    public boolean loadMap(Object source) {
        return false;
    }

}
