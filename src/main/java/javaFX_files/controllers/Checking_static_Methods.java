package javaFX_files.controllers;

import Tables.Scientist;
import Tables.University;

import java.util.List;

public class Checking_static_Methods {

    /**
     * This method check that ID Written Right
     *
     * @param some_id
     * @return
     */
    private static Integer check_and_get_ID(String some_id) {
        int id;
        try {
            id = Integer.parseInt(some_id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ID not Right");
            return null;
        }
        return id;

    }

    /**
     * This method checks that scientist exists
     * (Find scientist By _id)
     *
     * @param idOfScientist,listOfScientists
     * @return
     */
    public static Scientist checkIfThereIsScientist(String idOfScientist, List<Scientist> listOfScientists) {
        Integer id = check_and_get_ID(idOfScientist);

        if (!(id.equals(null))) {
            for (Scientist scientist : listOfScientists) {
                if (scientist.getId() == id) {
                    return scientist;
                }
            }
        }
        System.out.println("Scientist Not Found");
        return null;
    }


    /**
     * This method checks that university exists
     * (Find university By _id)
     *
     * @param idOfUniversity,listOfUniversities
     * @return
     */
    public static University checkIfThereIsUniversity(String idOfUniversity, List<University> listOfUniversities) {
        Integer id = check_and_get_ID(idOfUniversity);

        if (!(id.equals(null))) {
            for (University university : listOfUniversities) {
                if (university.getId() == id) {
                    return university;
                }
            }
        }
        System.out.println("University Not Found");
        return null;

    }
    /**
     * This method checks that Information Is Not Empty
     */
    public static  Boolean checkThatElementsIsNotEmpty(String[] elemets){
        Boolean not_Empty = true;
        for (String element:elemets) {
            if (element.isEmpty() == true){
                not_Empty =false;
            }
        }
        return not_Empty;
    }
}
