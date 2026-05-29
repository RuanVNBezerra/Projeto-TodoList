package com.todo.View;

import java.util.List;
import java.util.Scanner;

public class TarefaView {

    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {

        System.out.println("\n=== TO-DO LIST ===");
        System.out.println("1 - Criar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Concluir tarefa");
        System.out.println("0 - Sair");
    }

    public int lerOpcao() {

        System.out.print("Escolha uma opção: ");
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

    public void listarTarefas(List<Tarefa> tarefas) {

        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }
}
