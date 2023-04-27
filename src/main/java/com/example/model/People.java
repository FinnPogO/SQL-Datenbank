package com.example.model;

public class People {
    private String firstName; // Vorname
    private String lastName; // Nachname
    private String dateOfBirth; // Geburtsdatum
    
    public People(String firstName, String lastName, String dateOfBirth) {
       setFirstName(firstName); // Setzen des Vornamens
       setLastName(lastName); // Setzen des Nachnamens
       setDateOfBirth(null); // Setzen des Geburtsdatums auf null
    }
 
    public String getFirstName() {
       return firstName; // Rückgabe des Vornamens
    }
    public void setFirstName(String firstName) {
       this.firstName = firstName; // Setzen des Vornamens
    }
    public String getLastName() {
       return lastName; // Rückgabe des Nachnamens
    }
    public void setLastName(String lastName) {
       this.lastName = lastName; // Setzen des Nachnamens
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth; // Setzen des Geburtsdatums
    }
    public String getDateOfBirth() {
        return dateOfBirth; // Rückgabe des Geburtsdatums
    }
 
    @Override
    public String toString() {
       return "Person{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", dateOfBirth=" + dateOfBirth +
               '}'; // Rückgabe einer formatierten Zeichenkette mit Vorname, Nachname und Geburtsdatum
    }
}
