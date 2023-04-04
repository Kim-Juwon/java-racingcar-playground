package domain.wrapper;

public class Location {
    private int location;

    private Location(int location) {
        this.location = location;
    }

    public static Location createWithZero() {
        return new Location(0);
    }

    public int getLocation() {
        return location;
    }

    public boolean hasSameLocation(int location) {
        return this.location == location;
    }

    public void addOne() {
        ++location;
    }
}
