package Dao_Interfaces;


import Tables.University;

public interface DaoUniversity {
    void save(University university);
    String printAll();
}
