package cinemaNetwork;

public class Seance extends DatabaseObject {
    private Date date;
    private Movie movie;
    private Hall hall;
    private double price;

    public Seance(String name, int id, Date date, Movie movie, Hall hall, double price) {
        super(name, id);
        this.date = date;
        this.movie = movie;
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

}
