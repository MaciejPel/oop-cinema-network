package cinemaNetwork;

import java.util.ArrayList;

public class Movie extends DatabaseObject {
    private String title;
    private Date premiere;
    private ArrayList<Filmmaker> actors;
    private Filmmaker director;
    private int duration;

    public Movie(String name, String title, Date premiere, ArrayList<Filmmaker> actors, Filmmaker director, int duration) {
        super(name);
        this.title = title;
        this.premiere = premiere;
        this.actors = actors;
        this.director = director;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPremiere() {
        return premiere;
    }

    public void setPremiere(Date premiere) {
        this.premiere = premiere;
    }

    public ArrayList<Filmmaker> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Filmmaker> actors) {
        this.actors = actors;
    }

    public Filmmaker getDirector() {
        return director;
    }

    public void setDirector(Filmmaker director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}