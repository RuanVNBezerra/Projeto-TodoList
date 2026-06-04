package com.todo.Service;

import java.util.List;

import com.todo.Models.Tarefa;
import com.todo.Models.Usuario;
import com.todo.Repository.TarefaRepository;


public class TarefaService {

    private TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {

        this.repository = repository;
    }

    public void criarTarefa(
            String titulo,
            String descricao,
            Usuario usuario) {

        if (titulo == null ||
                titulo.isBlank()) {

            System.out.println("Título inválido.");

            return;
        }

        int id = repository.gerarId();

        Tarefa tarefa =new Tarefa(
                        id,
                        titulo,
                        descricao,
                        usuario );

        repository.salvarTarefa(tarefa);
    }

    public List<Tarefa> listarTarefas() {

        return repository.listarTarefas();
    }

    public void concluirTarefa(
            int id) {

        for (Tarefa tarefa :
                repository.listarTarefas()) {

            if (tarefa.getId() == id) {

                tarefa.concluir();

                repository.salvarArquivo();

                return;
            }
        }

        System.out.println(
                "Tarefa não encontrada.");
    }
}