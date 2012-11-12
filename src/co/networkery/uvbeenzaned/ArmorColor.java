package co.networkery.uvbeenzaned;

public enum ArmorColor {
    BLACK(1973019),
    RED(11743532),
    GREEN(3887386),
    BROWN(5320730),
    BLUE(2437522),
    PURPLE(8073150),
    CYAN(2651799),
    SILVER(2651799),
    GRAY(4408131),
    PINK(14188952),
    LIME(4312372),
    YELLOW(14602026),
    LIGHT_BLUE(6719955),
    MAGENTA(12801229),
    ORANGE(15435844),
    WHITE(15790320);
 
    private int    color;
 
    private ArmorColor(int color){
        this.color = color;
    }
 
    public int getColor(){
        return color;
    }
}