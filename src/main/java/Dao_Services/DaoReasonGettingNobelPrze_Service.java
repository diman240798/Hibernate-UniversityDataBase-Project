package Dao_Services;

import Dao_Interfaces.DaoReasonGettingNobelPrze;
import Tables.ReasonGettingNobelPrz;
import Tables.Scientist;
import executeProgram.ExecuteProgram;
import javaFX_files.controllers.Checking_static_Methods;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DaoReasonGettingNobelPrze_Service implements DaoReasonGettingNobelPrze {
    /**
     * Create list of ReasonGettingNobelPrz
     */
    List<ReasonGettingNobelPrz> reasonGettingNobelPrzs = null;

    @Override
    public void save(ReasonGettingNobelPrz reasonGettingNobelPrize, String scientistID) {
        /**
         * Get Open Session
         */
        Session session = ExecuteProgram.session.openSession();
        try {
            /*
             Begin Transaction
              */
            session.beginTransaction();
            /**
             * Find Scientist
             */
            Query querySCN = session.createQuery("from Scientist ");
            Scientist scientist = Checking_static_Methods.checkIfThereIsScientist(scientistID, querySCN.list());

            /**
             * If scientist Not Found ,
             * Then Rollback
             */
            if (scientist == null) {
                session.getTransaction().rollback();
            } else {
                /**
                 * If Scientist found, Then (Save)
                 */
                reasonGettingNobelPrize.setScientist(scientist);
                // Save
                session.save(reasonGettingNobelPrize);

                /**
                 * Commit Transaction
                 */
                session.getTransaction().commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
            /**
             * Case Exception Rollback Transaction
             */
            session.getTransaction().rollback();
        } finally {
            /**
             * Finally Close Session
             */
            session.close();
        }
    }

    @Override
    public String printAll() {
        // Get Open Session
        Session session = ExecuteProgram.session.openSession();

        Query query = session.createQuery("from ReasonGettingNobelPrz ");
        reasonGettingNobelPrzs = query.list();

        /**
         Close Session
         */
        session.close();

        return reasonGettingNobelPrzs.toString();
    }
}
