/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EposSimple.Models;

/**
 *
 * @author tg
 */
public class User {

    private static int counter = 0;
    private int id;
    private String login;
    private int pin;
    private int role;

    public User(String login, int pin, int Role) {
        this.id = counter++;
        this.login = login;
        this.pin = pin;
        this.role = Role;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param Id the id to set
     */
    public void setId(int Id) {
        this.id = Id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param Login the login to set
     */
    public void setLogin(String Login) {
        this.login = Login;
    }

    /**
     * @return the pin
     */
    public int getPin() {
        return pin;
    }

    /**
     * @param Pin the pin to set
     */
    public void setPin(int Pin) {
        this.pin = Pin;
    }

    /**
     * @return the role
     */
    public int getRole() {
        return role;
    }

    /**
     * @param Role the role to set
     */
    public void setRole(int Role) {
        this.role = Role;
    }

    @Override
    public String toString() {
        return "[" + ((this.role == 1) ? "Sales Agent" : "Moderator") + "] " + this.login;
    }
}
