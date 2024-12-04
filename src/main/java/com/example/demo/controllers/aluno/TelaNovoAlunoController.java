package com.example.demo.controllers.aluno;

import com.example.demo.entities.Aluno;
import com.example.demo.repositories.AlunoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

@Controller
public class TelaNovoAlunoController {

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

    private AlunoRepository alunoRepository;

    public TelaNovoAlunoController(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @FXML
    protected void onSalvarButtonClick() {
        Aluno aluno = new Aluno();
        aluno.setNome(nomeTextField.getText());
        aluno.setEmail(emailTextField.getText());
        aluno.setEndereco(enderecoTextField.getText());
        aluno.setCpf(cpfTextField.getText());
        alunoRepository.save(aluno);

        nomeTextField.clear();
        emailTextField.clear();
        enderecoTextField.clear();
        cpfTextField.clear();
        mensagemLabel.setText("Aluno salvo com sucesso!");
    }

}
