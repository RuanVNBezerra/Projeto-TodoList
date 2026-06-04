package com.todo;

import com.todo.Service.TarefaService;

public class Main {

    public static void main(String[] args) {

        TarefaRepository repository = new TarefaRepository();

        TarefaService service = new TarefaService(repository);

        TarefaView view = new TarefaView();

        TarefaController controller = new TarefaController(
                        service,
                        view
                );

        controller.iniciarSistema();
    }
}