package com.example.demo.controllers.aluno;

import com.example.demo.entities.Aluno;
import com.example.demo.repositories.AlunoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

@Controller
public class TelaEditarAlunoController {

    @FXML
    private TextField idAlunoTextField;

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

    private Aluno alunoEditando;

    public TelaEditarAlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @FXML
    protected void onBuscarAlunoButtonClick() {
        alunoRepository.findById(Integer.parseInt(idAlunoTextField.getText())).ifPresentOrElse(
                aluno -> {
                    nomeTextField.setText(aluno.getNome());
                    emailTextField.setText(aluno.getEmail());
                    enderecoTextField.setText(aluno.getEndereco());
                    cpfTextField.setText(aluno.getCpf());
                    mensagemLabel.setText("");
                    alunoEditando = aluno;
                },
                () -> {
                    mensagemLabel.setText("Aluno não encontrado");
                    alunoEditando = null;
                }
        );
    }

    @FXML
    protected void onSalvarButtonClick() {
        if (alunoEditando != null) {
            alunoEditando.setNome(nomeTextField.getText());
            alunoEditando.setEmail(emailTextField.getText());
            alunoEditando.setEndereco(enderecoTextField.getText());
            alunoEditando.setCpf(cpfTextField.getText());
            alunoRepository.save(alunoEditando);
            mensagemLabel.setText("Aluno salvo com sucesso");
        } else {
            mensagemLabel.setText("Aluno não encontrado");
        }
    }

}
