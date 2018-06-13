package Dao_Services;

import Dao_Interfaces.DaoWhereScientistLearnt;
import Tables.Scientist;
import Tables.University;
import Tables.WhereScientistLearnt;
import executeProgram.ExecuteProgram;
import javaFX_files.controllers.Checking_static_Methods;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DaoWhereScientistLearnt_Service implements DaoWhereScientistLearnt{
    /**
     * Create List WhereScientistLearnt
     */
    List<WhereScientistLearnt> listWhereScientistLearnt = null;
    @Override
    public void save(WhereScientistLearnt whereScientistLearnt, String scientistID, String universityID) {
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
             * Find University
             */
            Query queryUN = session.createQuery("from University ");
            University university = Checking_static_Methods.checkIfThereIsUniversity(universityID, queryUN.list());

            /**
             * If one or both Of them Not Found ,
             * Then Rollback
             */
            if (scientist == null || university == null) {
                session.getTransaction().rollback();
            } else {
                /**
                 * If they Both found, Then (Save)
                 */

                // Add
                whereScientistLearnt.setScientist(scientist);
                whereScientistLearnt.setUniversity(university);
                // Save
                session.save(whereScientistLearnt);

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

        Query query = session.createQuery("from WhereScientistLearnt ");
        listWhereScientistLearnt = query.list();

        /**
         Close Session
         */
        session.close();

        return listWhereScientistLearnt.toString();
    }
}
