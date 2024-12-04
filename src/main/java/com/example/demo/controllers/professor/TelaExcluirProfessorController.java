package com.example.demo.controllers.professor;

import com.example.demo.entities.Professor;
import com.example.demo.repositories.ProfessorRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

@Controller
public class TelaExcluirProfessorController {

    @FXML
    private TextField idProfessorTextField;

    @FXML
    private Label nomeProfessorLabel;

    @FXML
    private Label mensagemLabel;

    private ProfessorRepository professorRepository;

    public TelaExcluirProfessorController(ProfessorRepository professorRepository) { this.professorRepository = professorRepository; }

    private Professor professorSelecionadoParaExclusao;

    @FXML
    protected void onBuscarProfessorButtonClick(){
        professorRepository.findById(Integer.parseInt(idProfessorTextField.getText())).ifPresentOrElse(
                professor -> {
                    nomeProfessorLabel.setText(professor.getNome());
                    mensagemLabel.setText("");
                    professorSelecionadoParaExclusao = professor;
                },
                () -> {
                    nomeProfessorLabel.setText("");
                    mensagemLabel.setText("Professor não encontrado.");
                    professorSelecionadoParaExclusao = null;
                }
        );
    }

    @FXML
    protected void onExcluirProfessorButtonClick(){
        if(professorSelecionadoParaExclusao != null){
            professorRepository.delete(professorSelecionadoParaExclusao);
            mensagemLabel.setText("Professor excluído com sucesso.");
            nomeProfessorLabel.setText("");
            idProfessorTextField.setText("");
        } else {
            mensagemLabel.setText("Nenhum professor selecionado para exclusão");
        }
    }
}