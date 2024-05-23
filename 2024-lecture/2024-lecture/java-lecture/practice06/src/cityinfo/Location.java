package cityinfo;

public class Location {
    private String city;
    private double longitude;
    private double latitude;

    public Location(String city, double longitude, double latitude) {
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getCity() {
        return city;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
