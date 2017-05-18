package com.example.thalassemia.Models;

/**
 * Created by Tousif on 1/18/2017.
 */

public class Student {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {

        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {

        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {

        Gender = gender;
    }

    public String Name;
    public String Email;
    public String Password;
    public String Gender;
}
