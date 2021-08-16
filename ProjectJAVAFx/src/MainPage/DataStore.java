package MainPage;

import java.io.Serializable;
import java.util.ArrayList;

public class DataStore implements Serializable {

    private ArrayList<ArrayList<Double>> obstaclesList;
    private ArrayList<ArrayList<Double>> colorSwitchList;
    private ArrayList<ArrayList<Double>> starsList;
    private double posballX,posballY;
    private ArrayList<Double> BallRGB;
    private int currentStars;


    public DataStore(ArrayList<ArrayList<Double>> obstaclesList,ArrayList<ArrayList<Double>> colorSwitchList,ArrayList<ArrayList<Double>> starsList,double posballX,double posballY,ArrayList<Double> BallRGB) {
        this.obstaclesList = obstaclesList;
        this.colorSwitchList = colorSwitchList;
        this.starsList = starsList;
        this.posballX = posballX;
        this.posballY = posballY;
        this.BallRGB = BallRGB;
        this.currentStars = 0;

    }

    public ArrayList<ArrayList<Double>> getObstaclesList() {
        return obstaclesList;
    }

    public ArrayList<ArrayList<Double>> getColorSwitchList() {
        return colorSwitchList;
    }

    public ArrayList<ArrayList<Double>> getStarsList() {
        return starsList;
    }

    public double getPosballX() {
        return posballX;
    }

    public double getPosballY() {
        return posballY;
    }

    public ArrayList<Double> getBallRGB() {
        return BallRGB;
    }

    public int getCurrentStars() {
        return currentStars;
    }

    public void setCurrentStars(int currentStars) {
        this.currentStars = currentStars;
    }

    public void setPosballY(double posballY) {
        this.posballY = posballY;
    }


}
