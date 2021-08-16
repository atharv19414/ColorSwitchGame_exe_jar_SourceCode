package MainPage;

import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable {
    private static Database d;

    private ArrayList<DataStore> dataBaseList;

    private int totalStar;
    private int bestScore;

    public Database(){
        dataBaseList = new ArrayList<DataStore>();
        totalStar = 0;
        bestScore = 0;
    }

    public void addData(DataStore d) {
        dataBaseList.add(d);
    }

    public void removeData(DataStore d){
        if(dataBaseList.contains(d)){
            dataBaseList.remove(d);
        }
    }

    public ArrayList<DataStore> getDataBaseList() {
        return dataBaseList;
    }

    public int getTotalStar() {
        return totalStar;
    }

    public void setTotalStar(int totalStar) {
        this.totalStar = totalStar;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int currentScore){
        if(currentScore>bestScore){
            bestScore = currentScore;
        }
    }
}
