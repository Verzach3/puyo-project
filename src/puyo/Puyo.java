package puyo;

import java.awt.*;

class Puyo {

    private int color = 0;
    private int x = 0;
    private int y = 0;
    private boolean landStatus = false;
    private int drawX;
    private int drawY;

    // Color 0:Blue - 1:Green - 2:Gray - 3:Purple - 4:Red - 5:Yellow
    Puyo(int color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    Puyo(int drawX, int drawY){
        this.drawX = drawX;
        this.drawY = drawY;
    }

    Puyo(int color, int x, int y, boolean landingStatus) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.landStatus = landingStatus;
    }

    public String getColorAsString() {

        switch (color) {
        case 0:
            return "#";
        case 1:
            return "%";
        case 2:
            return "$";
        case 3:
            return "+";
        case 4:
            return "&";
        case 5:
            return "-";
        default:
            return null;
        }
    }

    public int getColor() {
        return color;
    }

    public int getX(){
        return x - 1;
    }

    public int getY(){
        return y - 1;
    }

    public boolean getLandingStatus(){
        return landStatus;
    }

    public boolean isLandStatus() {
        return landStatus;
    }

    public void setLandStatus(boolean landStatus) {
        this.landStatus = landStatus;
    }

    public int getDrawX() {
        return drawX;
    }

    public void setDrawX(int drawX) {
        this.drawX = drawX;
    }

    public int getDrawY() {
        return drawY;
    }

    public void setDrawY(int drawY) {
        this.drawY = drawY;
    }

    public void drawComponent(Graphics2D g){
        g.fillOval(drawX, drawY, 40, 40);
    }
}
