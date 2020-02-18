package sample.abstracts;

import javafx.scene.image.Image;
import sample.interfaces.MovingObject;

public abstract class AbstractMovingObject extends AbstractGameObject implements MovingObject {
    private Image imageLeft;
    private Image imageRight;
    private Image imageUp;
    private Image imageDown;

    @Override
    public Image getImageLeft() {
        return imageLeft;
    }

    @Override
    public Image getImageRight() {
        return imageRight;
    }

    @Override
    public Image getImageUp() {
        return imageUp;
    }

    @Override
    public Image getImageDown() {
        return imageDown;
    }

    public void setImageLeft(Image imageLeft) {
        this.imageLeft = imageLeft;
    }

    public void setImageRight(Image imageRight) {
        this.imageRight = imageRight;
    }

    public void setImageUp(Image imageUp) {
        this.imageUp = imageUp;
    }

    public void setImageDown(Image imageDown) {
        this.imageDown = imageDown;
    }
}
