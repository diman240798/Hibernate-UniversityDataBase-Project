package Tables;


import lombok.Data;

public @Data
class Scientist {
    private int id;
    private String name;
    private String surname;
    private String country;
    private String birthDate;
    private String deathDate;


       @Override
    public String toString() {
        return String.format(" %d %s %s %s %s %s %s %s %s %s %s%n",
                id, "Name:", name, "Surname:",surname, "Country:", country, "BirthDate:",birthDate,"DeathDate:", deathDate);
    }
}
