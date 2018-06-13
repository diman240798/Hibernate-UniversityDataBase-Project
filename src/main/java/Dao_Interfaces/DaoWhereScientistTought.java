package Dao_Interfaces;


import Tables.WhereScientistTought;

public interface DaoWhereScientistTought {
    void save(WhereScientistTought whereScientistTought,String scientistID, String universityID);
    String printAll();
}
