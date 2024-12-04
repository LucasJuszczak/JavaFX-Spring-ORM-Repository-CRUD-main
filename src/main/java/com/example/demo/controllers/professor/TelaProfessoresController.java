package com.example.demo.controllers.professor;

import com.example.demo.entities.Professor;
import com.example.demo.repositories.ProfessorRepository;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.springframework.stereotype.Controller;

@Controller
public class TelaProfessoresController {

    private ProfessorRepository professorRepository;

    @FXML
    private ListView<Professor> listaProfessor;

    public TelaProfessoresController(ProfessorRepository professorRepository) {this.professorRepository = professorRepository;}

    @FXML
    protected void onCarregarProfessorButtonClick(){
        professorRepository.findAll().forEach(professor -> {
            listaProfessor.getItems().add(professor.getNome());
        });
    }
}
