package Tables;

import lombok.Data;

public @Data
class University {
    private int id;
    private String name;

    private String country;

    private String city;

    @Override
    public String toString() {
        return String.format(" %d %s %s %s %s %s %s%n",id, "Name:", name, "Country:", country, "City:", city);
    }
}
