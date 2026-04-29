package com.example.demo.controller;

public class Item {
    private String id;
    private String nome;
    private String descricao;

    // Construtor vazio (necessário para deserialização JSON)
    public Item() {
    }

    // Construtor completo
    public Item(String id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
