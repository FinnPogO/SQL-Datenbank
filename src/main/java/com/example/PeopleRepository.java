package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.People;

@Repository
public class PeopleRepository {

    // Methode zum Herstellen der Verbindung zur Datenbank
    private Connection connect() {
        String url = "jdbc:sqlite:people.db"; // Verbindungsinformationen zur SQLite-Datenbank, hier wird eine lokale Datenbank "people.db" verwendet
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url); // Herstellung der Verbindung zur Datenbank
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Methode zum Hinzufügen einer Person zur Datenbank
    public void addPerson(People person) {
        String sql = "INSERT INTO people (first_name, last_name, age) VALUES (?, ?, ?)"; // SQL-Statement zum Einfügen von Daten in die Datenbank

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, person.getFirstName()); // Setzen der Werte für die Parameter im SQL-Statement
            pstmt.setString(2, person.getLastName());
            pstmt.setString(3, person.getDateOfBirth());
            pstmt.executeUpdate(); // Ausführen des SQL-Statements
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Methode zum Abrufen aller Personen aus der Datenbank
    public List<People> getAllPeople() {
        return null; // Hier wird eine leere Liste zurückgegeben, die in der Implementierung noch mit den tatsächlichen Daten aus der Datenbank gefüllt werden muss
    }

    // Weitere Methoden zum Abrufen, Aktualisieren und Löschen von Personen aus der Datenbank können hier implementiert werden
}
