package com.example.demo.repositories;

import com.example.demo.entities.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
    List<Aluno> findByNome(String nome);
}
