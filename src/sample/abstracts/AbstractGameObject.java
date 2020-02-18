package sample.abstracts;

import javafx.scene.Node;
import javafx.scene.image.Image;
import sample.enums.GameObjectType;
import sample.interfaces.StaticObject;

import java.net.URISyntaxException;
import java.util.Objects;

public class AbstractGameObject implements StaticObject {
    private GameObjectType type;
    private Coordinate coordinate;
    private Image image = getImageIcon("../src/sample/images/noicon.png");
    public AbstractGameObject(){
    }

    protected Image getImageIcon(String path){
            return new Image(getClass().getResource("../images/noicon.png").toExternalForm());
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public Coordinate getCoordinate() {
        return  coordinate;
    }

    @Override
    public GameObjectType getType() {
        return type;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setType(GameObjectType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractGameObject)) return false;
        AbstractGameObject that = (AbstractGameObject) o;
        return getType() == that.getType() &&
                Objects.equals(getCoordinate(), that.getCoordinate()) &&
                Objects.equals(getImage(), that.getImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getCoordinate(), getImage());
    }

    @Override
    public String toString() {
        return "AbstractGameObject{" +
                "type=" + type +
                ", coordinate=" + coordinate +
                ", image=" + image +
                '}';
    }
}
