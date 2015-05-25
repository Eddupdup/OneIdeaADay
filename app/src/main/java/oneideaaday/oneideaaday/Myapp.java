package oneideaaday.oneideaaday;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by GER Telecom on 23/05/2015.
 */
public class Myapp extends Application {

    private String userName = "userName" ;
    private int xp = 0;
    private int level = 1;
    private int xpmax = level*80;
    private boolean alreadyConnected = false;
    private boolean xpfact1delivered = false;
    private boolean xpfact2delivered = false;
    private boolean xpfact3delivered = false;
    private boolean used = false;
    private boolean Notifications = true;
    private ArrayList<String> favoris ;

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

    //Fact 1

    public boolean setfact1delivered (boolean xpfact1delivered) {
        this.xpfact1delivered = xpfact1delivered;
        return this.xpfact1delivered;
    }

    public boolean getfact1delivered () {
        return xpfact1delivered;
    }

    //Fact 2

    public boolean setfact2delivered (boolean xpfact2delivered) {
        this.xpfact2delivered = xpfact2delivered;
        return this.xpfact2delivered;
    }

    public boolean getfact2delivered () {
        return xpfact2delivered;
    }

    //Fact 3

    public boolean setfact3delivered (boolean xpfact3delivered) {
        this.xpfact3delivered = xpfact3delivered;
        return this.xpfact3delivered;
    }

    public boolean getfact3delivered () {
        return xpfact3delivered;
    }

    public boolean getUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean getNotifications() {
        return Notifications;
    }

    public void setNotifications(boolean notifications) {
        Notifications = notifications;
    }

    public ArrayList<String> getFavoris() {
        return favoris;
    }

    public void setFavoris(ArrayList<String> favoris) {
        this.favoris = favoris;
    }

    public void addFavoris (java.lang.String string) {
        favoris.add(string);
    }

    public void clearFavoris () {
        favoris.clear();
    }

    public void deleteFavoris (int i) {
        favoris.remove(i);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        xpmax = 80*level;
    }

    public void addLevel (int level) {
        this.level = this.level + level;
        xpmax = xpmax + level*80;
    }

    public int levelis() {
        level = mod (xp,80);
        return level;
    }

    public int getXpmax() {
        return xpmax;
    }

    public void setXpmax(int xpmax) {
        this.xpmax = xpmax;
    }

    public void addXpmax(int xp ) {
        this.xpmax = this.xpmax + xp;
    }

    private int mod(int x, int y)
    {
        int result = x % y;
        if (result < 0)
            result += y;
        return result;
    }
}
