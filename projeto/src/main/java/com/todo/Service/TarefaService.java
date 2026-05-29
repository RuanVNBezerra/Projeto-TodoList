package com.todo.Service;

import model.Tarefa;
import model.Usuario;
import repository.TarefaRepository;

import java.util.List;

public class TarefaService {

    private TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public void criarTarefa(String titulo, String descricao, Usuario usuario) {

        if (titulo == null || titulo.isEmpty()) {
            System.out.println("Título inválido.");
            return;
        }

        int id = repository.gerarId();

        Tarefa tarefa = new Tarefa(id, titulo, descricao, usuario);

        repository.salvarTarefa(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return repository.listarTarefas();
    }

    public void concluirTarefa(int id) {

        for (Tarefa tarefa : repository.listarTarefas()) {

            if (tarefa.getId() == id) {
                tarefa.concluir();
                return;
            }
        }

        System.out.println("Tarefa não encontrada.");
    }
}