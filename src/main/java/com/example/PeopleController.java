package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.People;

import java.sql.SQLException;
import java.util.List;



@Controller
public class PeopleController {

    private final PeopleRepository PeopleRepository; //// Instanzvariable für PeopleRepository

    @Autowired
    public PeopleController(PeopleRepository PeopleRepository) {
        this.PeopleRepository = PeopleRepository;  //// Konstruktor, der PeopleRepository-Objekt injiziert
    }

    @GetMapping("/people")
    public String showAllPeople(Model model) { //// Holt alle Personen aus der Datenbank über das PeopleRepository-Objekt
        List<People> people = PeopleRepository.getAllPeople(); //Fügt die Liste von Personen dem Model hinzu, um sie an die View zu übergeben
        model.addAttribute("people", people);
        return "people.html";
    }

    @GetMapping("/addperson")
    public String showAddPersonForm() {  //Rückgabe des Namens der View für das Hinzufügen einer Person
        return "addperson.html";
    }

    @PostMapping("/addperson")
    public String addPerson(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String dateOfBirth) { //Erzeugt ein neues People-Objekt mit den übergebenen Parametern
    People people = new People(firstName, lastName, dateOfBirth); // Fügt die erstellte Person der Datenbank hinzu über das PeopleRepository-Objekt
    PeopleRepository.addPerson(people);
    return "redirect:/people";
}

    // other controller methods for updating and deleting people...
}
