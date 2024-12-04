package com.example.demo.controllers.professor;

import com.example.demo.entities.Professor;
import com.example.demo.repositories.ProfessorRepository;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


@Controller
public class TelaEditarProfessorController {

    @FXML
    private TextField idProfessorTextField;

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

    private Professor professorEditando;

    public TelaEditarProfessorController(ProfessorRepository professorRepository) {this.professorRepository = professorRepository;}

    @FXML
    protected void onBuscarProfessorButtonClick(){
        professorRepository.findById(Integer.parseInt(idProfessorTextField.getText())).ifPresentOrElse(
                professor -> {
                    nomeTextField.setText(professor.getNome());
                    emailTextField.setText(professor.getEmail());
                    enderecoTextField.setText(professor.getEndereco());
                    cpfTextField.setText(professor.getCpf());
                    mensagemLabel.setText("");
                    professorEditando = professor;
                },
                () -> {
                    mensagemLabel.setText("Professor não encontrado.");
                    professorEditando = null;
                }
        );
    }

    @FXML
    protected void onSalvarButtonClick(){
        if (professorEditando != null) {
            professorEditando.setNome(nomeTextField.getText());
            professorEditando.setEmail(emailTextField.getText());
            professorEditando.setEndereco(enderecoTextField.getText());
            professorEditando.setCpf(cpfTextField.getText());
            professorEditando.save(professorEditando);
            mensagemLabel.setText("Professor salvo com sucesso");
        } else {
            mensagemLabel.setText("Professor não encontrado");
        }
    }
}
