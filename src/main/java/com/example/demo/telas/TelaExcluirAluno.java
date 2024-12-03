package com.example.demo.telas;

import com.example.demo.utils.AbridorJanela;
import org.springframework.stereotype.Component;

@Component
public class TelaExcluirAluno {

    AbridorJanela abridorJanela;

    public TelaExcluirAluno(AbridorJanela abridorJanela) {
        this.abridorJanela = abridorJanela;
    }

    public void abrir(){
        abridorJanela.abrirNovaJanela("/views/tela-excluir-aluno-view.fxml", "Novo Aluno", 300, 400);
    }

}