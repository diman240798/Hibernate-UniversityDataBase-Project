package Dao_Services;



import Dao_Interfaces.DaoScientist;
import Tables.Scientist;
import executeProgram.ExecuteProgram;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DaoScientist_Service implements DaoScientist {

    /**
     * List of Scientists
     */
    private List<Scientist> listOfScientists = null;

    @Override
    public void save(Scientist scientist) {
        // Get Open Session
        Session session = ExecuteProgram.session.openSession();
        try {
            /**
             Begin Transaction
             */
            session.beginTransaction();
           /*
              Save Scientist
             */
            session.save(scientist);
            /**
             * Commit Transaction
             */
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
           /*
               Case Execption RollBack Transaction
             */
            session.getTransaction().rollback();
        } finally {
            /**
             *  Close Session
             */

            session.close();
        }
    }

    @Override
    public String printAll() {
        // Get Open Session
        Session session = ExecuteProgram.session.openSession();

        Query query = session.createQuery("from Scientist ");
        listOfScientists = query.list();
        /**
         Close Session
         */
        session.close();

        return listOfScientists.toString();
    }
}
