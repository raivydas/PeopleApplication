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
public class Person {

    private int id;
    private String lastName;

    public Person() {
        id = 1;
        lastName = "";
    }

    public Person(int id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }

    public Person(String lastName) {
        this.id = 0;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return id + " " + lastName;
    }
}
