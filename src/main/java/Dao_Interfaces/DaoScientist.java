package Dao_Interfaces;

import Tables.Scientist;

public interface DaoScientist {
    void save(Scientist scientist);
    String printAll();
}
