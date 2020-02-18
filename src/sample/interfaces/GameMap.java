package sample.interfaces;

public interface GameMap {
    int getHeight();

    int getWidth();

    boolean saveMap(Object source);

    boolean loadMap(Object  source);

    int getTimeLimit();
}
