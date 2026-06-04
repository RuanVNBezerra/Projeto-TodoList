package com.todo.Repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.todo.Models.Tarefa;

public class TarefaRepository {

    private static final String CAMINHO_ARQUIVO =
            "dados/tarefas.txt";

    private List<Tarefa> tarefas;

    public TarefaRepository() {

        tarefas = new ArrayList<>();

        carregarArquivo();
    }

    public void salvarTarefa(Tarefa tarefa) {

        tarefas.add(tarefa);

        salvarArquivo();
    }

    public List<Tarefa> listarTarefas() {

        return tarefas;
    }

    public int gerarId() {

        int maiorId = 0;

        for (Tarefa tarefa : tarefas) {

            if (tarefa.getId() > maiorId) {

                maiorId = tarefa.getId();
            }
        }

        return maiorId + 1;
    }

    public void salvarArquivo() {

        File pasta = new File("dados");

        if (!pasta.exists()) {

            pasta.mkdir();
        }

        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter(CAMINHO_ARQUIVO))) {

            for (Tarefa tarefa : tarefas) {

                bw.write(
                        tarefa.getId() + ";" +
                        tarefa.getTitulo() + ";" +
                        tarefa.getDescricao() + ";" +
                        tarefa.isConcluida()
                );

                bw.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Erro ao salvar tarefas."
            );
        }
    }

    public void carregarArquivo() {

        File arquivo =
                new File(CAMINHO_ARQUIVO);

        if (!arquivo.exists()) {

            return;
        }

        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(arquivo))) {

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] dados =
                        linha.split(";");

                int id =
                        Integer.parseInt(dados[0]);

                String titulo =
                        dados[1];

                String descricao =
                        dados[2];

                boolean concluida =
                        Boolean.parseBoolean(
                                dados[3]
                        );

                Tarefa tarefa =
                        new Tarefa(
                                id,
                                titulo,
                                descricao,
                                null
                        );

                if (concluida) {

                    tarefa.concluir();
                }

                tarefas.add(tarefa);
            }

        } catch (IOException e) {

            System.out.println(
                    "Erro ao carregar tarefas."
            );
        }
    }
}