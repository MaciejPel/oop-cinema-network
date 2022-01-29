package cinemaNetwork;

import java.util.ArrayList;

public class Movie extends DatabaseObject implements Displayable {

    private String title;
    private Date premiere;
    private ArrayList<Filmmaker> actors;
    private Filmmaker director;
    private int duration;
    private Genre genre;

    public Movie(String title, Date premiere, ArrayList<Filmmaker> actors, Filmmaker director, int duration, Genre genre) {
        super(title);
        this.title = title;
        this.premiere = premiere;
        this.actors = actors;
        this.director = director;
        this.duration = duration;
        this.genre = genre;
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

    public void addActor(Filmmaker filmmaker) {
        this.actors.add(filmmaker);
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

    @Override
    public boolean isFamilyFriendly() {
        return this.genre.getName() != "Horror" || this.genre.getName() != "Thriller";
    }

    @Override
    public String toString(){
        String s= "[\n\tID: "+ this.getId() + "\n\tType: " + this.getClass().getSimpleName() + "\n\tName/Title: " + this.getName() + "\n\tDate: " + this.getPremiere().toString()+ "\n\tDirector: " + (this.getDirector()==null?"":this.getDirector().toString())+ "\n\tDuration: " + this.getDuration()+"\n\tGenre: " + this.genre.getName();
        s+="\n\tActors: [";
        for(Filmmaker i: this.actors){
            s+= i.toString()+", ";
        }
        s+="]\n]";
        return s;
    }
}