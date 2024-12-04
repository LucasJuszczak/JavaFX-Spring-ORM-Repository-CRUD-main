package com.example.demo.controllers.professor;

import com.example.demo.repositories.ProfessorRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaNovoProfessorController {

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField enderecoTextField;

    @FXML
    private TextField cpfTextField;

    @FXML
    private Label mensagemLabel;

    private ProfessorRepository professorRepository;

    
}
