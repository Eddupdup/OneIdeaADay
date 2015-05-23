package oneideaaday.oneideaaday;

import android.app.Application;

/**
 * Created by GER Telecom on 23/05/2015.
 */
public class Myapp extends Application {

    private int xp;
    private boolean alreadyConnected = false;

    public int getXp() {
        return xp;
    }

    public void setXp(int xp){
        this.xp=xp;
    }

    public void setzero (){
        this.xp = 0;
    }

    public int addxp (int xp) {
        this.xp = this.xp + xp;
        return this.xp;
    }

    public boolean isAlreadyConnected() {
        return alreadyConnected;
    }

    public boolean setAlreadyConnected (boolean alreadyConnected){
        this.alreadyConnected = alreadyConnected;
        return this.alreadyConnected;
    }




}
