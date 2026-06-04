package com.todo.Controller;

import com.todo.Models.Usuario;
import com.todo.Service.TarefaService;
import com.todo.View.TarefaView;

public class TarefaController {

    private TarefaService service;
    private TarefaView view;

    private Usuario usuario;

    public TarefaController(
            TarefaService service,
            TarefaView view) {

        this.service = service;
        this.view = view;
    }

    public void iniciarSistema() {

        usuario = view.criarUsuario();

        int opcao;

        do {

            view.mostrarMenu();

            opcao =
                    view.lerOpcao();

            switch (opcao) {

                case 1:

                    String titulo =
                            view.lerTitulo();

                    String descricao =
                            view.lerDescricao();

                    service.criarTarefa(
                            titulo,
                            descricao,
                            usuario
                    );

                    break;

                case 2:

                    view.listarTarefas(
                            service.listarTarefas()
                    );

                    break;

                case 3:

                    int id =
                            view.lerIdTarefa();

                    service.concluirTarefa(
                            id
                    );

                    break;

                case 0:

                    System.out.println(
                            "Encerrando sistema..."
                    );

                    break;

                default:

                    System.out.println(
                            "Opção inválida."
                    );
            }

        } while (opcao != 0);
    }
}