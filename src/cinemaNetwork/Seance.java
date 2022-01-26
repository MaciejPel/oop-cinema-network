package cinemaNetwork;

import java.util.ArrayList;

public class Seance extends DatabaseObject {
    private Date date;
    private Movie movie;
    private ArrayList<Advertisement> advertisements;
    private Hall hall;
    private double price;

    public Seance(String name, Date date, Movie movie, ArrayList<Advertisement> advertisements, Hall hall, double price) {
        super(name);
        this.date = date;
        this.movie = movie;
        this.advertisements = advertisements;
        this.hall = hall;
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public ArrayList<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(ArrayList<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public void addAdvertisement(Advertisement advertisement){
        this.advertisements.add(advertisement);
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return "[\n\tID: "+ this.getId() + "\n\tType: " + this.getClass().getSimpleName() + "\n\tName: " + this.getName()+ "\n\tMovie: " + (this.getMovie()==null?"":this.getMovie().toString())+ "\n\tDate: " + this.getDate().toString()+ "\n\tHall: " + (this.getHall()==null?"":this.getHall().toString()) + "\n\tPrice: " + this.getPrice()+"\n]";
    }
}
