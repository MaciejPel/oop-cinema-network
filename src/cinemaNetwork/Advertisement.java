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

    @Override
    public String toString(){
        String s= "[\n\tID: "+ this.getId() + "\n\tType: " + this.getClass().getSimpleName() + "\n\tName/Title: " + this.getName() + "\n\tDirector: " + "\n\tDuration: " + this.getDuration();
        s+="\n]";
        return s;
    }
}
