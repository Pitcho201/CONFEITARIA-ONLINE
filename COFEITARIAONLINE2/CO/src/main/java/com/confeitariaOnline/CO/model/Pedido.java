package com.confeitariaOnline.CO.model;

import javax.persistence.*;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clienteNome;

    private String clienteEmail;

    @Column(length = 500)
    private String descricaoPersonalizada;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public String getDescricaoPersonalizada() {
        return descricaoPersonalizada;
    }

    public void setDescricaoPersonalizada(String descricaoPersonalizada) {
        this.descricaoPersonalizada = descricaoPersonalizada;
    }
}
