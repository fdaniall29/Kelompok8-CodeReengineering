public class MovieRental {
    private String movieName;
    private Date startDate;
    private Date endDate;

    public MovieRental(String movieName, Date startDate, Date endDate) {
        this.movieName = movieName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getMovieName() {
        return movieName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
