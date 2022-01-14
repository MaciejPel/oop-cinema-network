package cinemaNetwork;

public class Date {
    private int day;
    private int month;
    private int year;
    private Integer hour;
    private Integer minute;

    public Date(int year, int month, int day, Integer hour, Integer minute) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public String toString(){
        return this.getYear()+"-"+this.getMonth()+"-"+this.getDay()+" "+(this.getHour()==null?"00":this.getHour())+":"+(this.getMinute()==null?"00":this.getMinute());
    }
}
