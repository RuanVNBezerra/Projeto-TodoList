package com.todo.Models;

public class Tarefa {

    private int id;
    private String titulo;
    private String descricao;
    private boolean concluida;
    private Usuario usuario;

    public Tarefa(int id, String titulo, String descricao, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.usuario = usuario;
        this.concluida = false;
    }

    public void concluir() {
        this.concluida = true;
    }

    public void editar(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", concluida=" + concluida +
                ", usuario=" + usuario.getNome() +
                '}';
    }
}
