package Tables;

import lombok.Data;

public @Data
class ReasonGettingNobelPrz {
    private int id;
    private String date;
    private String field;
    private String reason;
    private Scientist scientist;

    @Override
    public String toString() {
        return String.format(" %d %s %s %s %s %s %s %s %s %s%n",
                id,"Scientist Name:", scientist.getName(), scientist.getSurname(), "Reason:", reason,"Field:",field,"Date:",date);
    }

}
