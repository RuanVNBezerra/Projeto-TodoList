package com.todo.View;

import java.util.List;
import java.util.Scanner;

import com.todo.Models.Tarefa;
import com.todo.Models.Usuario;


public class TarefaView {

    private Scanner scanner =
            new Scanner(System.in);

    public Usuario criarUsuario() {

        System.out.println(
                "=== Cadastro do Usuário ==="
        );

        System.out.print(
                "Nome: "
        );

        String nome =
                scanner.nextLine();

        System.out.print(
                "Email: "
        );

        String email =
                scanner.nextLine();

        return new Usuario(
                1,
                nome,
                email
        );
    }

    public void mostrarMenu() {

        System.out.println("\n=== TO-DO LIST ===");

        System.out.println("1 - Criar tarefa");

        System.out.println("2 - Listar tarefas");

        System.out.println("3 - Concluir tarefa");

        System.out.println("0 - Sair");
    }

    public int lerOpcao() {

        System.out.print("Escolha: ");

        return scanner.nextInt();
    }

    public String lerTitulo() {

        scanner.nextLine();

        System.out.print("Título: ");

        return scanner.nextLine();
    }

    public String lerDescricao() {

        System.out.print("Descrição: ");

        return scanner.nextLine();
    }

    public int lerIdTarefa() {

        System.out.print("ID da tarefa: ");

        return scanner.nextInt();
    }

    public void listarTarefas(
            List<Tarefa> tarefas) {

        if (tarefas.isEmpty()) {

            System.out.println("Nenhuma tarefa cadastrada.");

            return;
        }

        for (Tarefa tarefa : tarefas) {

            System.out.println(tarefa);
        }
    }
}
