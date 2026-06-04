package com.todo;

import com.todo.Controller.TarefaController;
import com.todo.Repository.TarefaRepository;
import com.todo.Service.TarefaService;
import com.todo.View.TarefaView;

public class Main {

    public static void main(String[] args) {

        TarefaRepository repository = new TarefaRepository();

        TarefaService service = new TarefaService(repository);

        TarefaView view = new TarefaView();

        TarefaController controller = new TarefaController(service,view);

        controller.iniciarSistema();
    }
}