public class Rental {
    private String rentalLabel;
    private Date startDate;
    private Date endDate;
    
    public Rental(String rentalLabel, Date startDate, Date endDate) {
        this.rentalLabel = rentalLabel;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public String getRentalLabel() {
        return rentalLabel;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }
}
