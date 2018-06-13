package Dao_Interfaces;


import Tables.WhereScientistLearnt;

public interface DaoWhereScientistLearnt {
    void save(WhereScientistLearnt whereScientistLearnt,String scientistID, String universityID);
    String printAll();
}
