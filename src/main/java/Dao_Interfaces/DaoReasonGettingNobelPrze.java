package Dao_Interfaces;


import Tables.ReasonGettingNobelPrz;

public interface DaoReasonGettingNobelPrze {
    void save(ReasonGettingNobelPrz reasonGettingNobelPrize, String scientistID);
    String printAll();
}
