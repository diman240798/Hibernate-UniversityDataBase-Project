package Tables;

import lombok.Data;

public @Data
class WhereScientistLearnt {

    private University university;
    private Scientist scientist;
    private int id;


    @Override
    public String toString() {
        return String.format(" %d %s %s %s %s %s%n",
                id,"Scientist Name:",scientist.getName(),scientist.getSurname(),"University Name:",university.getName());
    }
}
