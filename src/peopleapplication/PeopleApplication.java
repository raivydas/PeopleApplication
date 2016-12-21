/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peopleapplication;

/**
 *
 * @author Raivydas
 */

import java.util.*;

public class PeopleApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonDAO pd = new PersonDAO();
        List<Person> pl = pd.getPeopleList("Petraitis");
        System.out.println(pl);
    }

}
