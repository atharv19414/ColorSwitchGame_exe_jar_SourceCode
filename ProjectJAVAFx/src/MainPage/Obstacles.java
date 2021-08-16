package MainPage;

import java.io.Serializable;

public abstract class Obstacles extends GameObjects implements Serializable {

    private double posX;
    private double posY;
    double angle;
    public Obstacles(double posX, double posY, double angle) {

        super(posX, posY);
        this.angle = angle;

    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}
