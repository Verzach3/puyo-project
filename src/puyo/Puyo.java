package puyo;

class Puyo {

    private int color;
    private int x;
    private int y;
    private boolean isLanded = false;

    // Color 0:Blue - 1:Green - 2:Gray - 3:Purple - 4:Red - 5:Yellow
    Puyo(int color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    Puyo(int color, int x, int y, boolean landingStatus) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.isLanded = landingStatus;
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
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean getLandingStatus(){
        return isLanded;
    }
}
