package cinemaNetwork;

public class Advertisement extends DatabaseObject implements Displayable{
    private int duration;
    private String description;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Advertisement(String name, int duration, String description) {
        super(name);
        this.duration = duration;
        this.description=description;
    }

    public boolean isFamilyFriendly() {
        return !this.description.contains("beer") && !this.description.contains("cigarettes") && !this.description.contains("alcohol");
    }

    @Override
    public String toString(){
        String s= "[\n\tID: "+ this.getId() + "\n\tType: " + this.getClass().getSimpleName() + "\n\tName/Title: " + this.getName() + "\n\tDirector: " + "\n\tDuration: " + this.getDuration()+ "\n\tDescription: " + this.getDescription();
        s+="\n]";
        return s;
    }
}
