package br.com.meli;

public class Circuit {
    private String description;
    private boolean isUnderageAllowed;
    private int circuitLength;
    private int regularPrice;
    private int underAgePrice;
    private RaceCategory raceCategory;

    public Circuit(String description, boolean isUnderageAllowed, int regularPrice, RaceCategory raceCategory, int circuitLength) {
        this.description = description;
        this.isUnderageAllowed = isUnderageAllowed;
        this.regularPrice = regularPrice;
        this.raceCategory = raceCategory;
        this.circuitLength = circuitLength;
    }

    public int getPrice(boolean isCompetitorUnderage) {
        if (isCompetitorUnderage && isUnderageAllowed){
            return underAgePrice;
        }
        return regularPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isUnderageAllowed() {
        return isUnderageAllowed;
    }

    public void setUnderageAllowed(boolean underageAllowed) {
        this.isUnderageAllowed = underageAllowed;
    }

    public int getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(int regularPrice) {
        this.regularPrice = regularPrice;
    }

    public RaceCategory getRaceTypes() {
        return raceCategory;
    }

    public void setRaceTypes(RaceCategory raceCategory) {
        this.raceCategory = raceCategory;
    }

    public int getCircuitLength() {
        return circuitLength;
    }

    public void setCircuitLength(int circuitLength) {
        this.circuitLength = circuitLength;
    }

    public int getUnderAgePrice() {
        return underAgePrice;
    }

    public void setUnderAgePrice(int underAgePrice) {
        this.underAgePrice = underAgePrice;
    }

    public RaceCategory getRaceCategory() {
        return raceCategory;
    }

    public void setRaceCategory(RaceCategory raceCategory) {
        this.raceCategory = raceCategory;
    }
}
