package Dao_Services;



import Dao_Interfaces.DaoUniversity;
import Tables.University;
import executeProgram.ExecuteProgram;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DaoUniversity_Service implements DaoUniversity {

    /**
     * List of Universities
     */
    private List<University> listOfUniversities = null;

    @Override
    public void save(University university) {
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
            session.save(university);
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

        Query query = session.createQuery("from University ");
        listOfUniversities = query.list();
        /**
         Close Session
         */
        session.close();

        return listOfUniversities.toString();
    }
}
