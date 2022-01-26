package cinemaNetwork;

public class Advertisement extends DatabaseObject implements Displayable{
    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Advertisement(String name, int duration) {
        super(name);
        this.duration = duration;
    }

    public void play(){
    }
}
