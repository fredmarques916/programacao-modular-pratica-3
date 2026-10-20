package org.example;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;
    private int quantidadeContatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
        this.quantidadeContatos = 0;
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        quantidadeContatos = contatos.size(); // Atualiza o tamanho
    }

    public boolean removerContato(String nome) {
        Contato contatoParaRemover = buscarPorNome(nome);
        if (contatoParaRemover != null) {
            contatos.remove(contatoParaRemover);
            quantidadeContatos = contatos.size(); // Atualiza o tamanho
            return true; // Exclusão bem-sucedida
        }
        return false; // Contato não encontrado
    }

    public Contato buscarPorNome(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    public Contato buscarPorEmail(String email) {
        for (Contato c : contatos) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }

    public Contato buscarPorTelefone(String telefone) {
        for (Contato c : contatos) {
            if (c.getTelefone().equals(telefone)) {
                return c;
            }
        }
        return null;
    }

    public int getQuantidadeContatos() {
        return quantidadeContatos;
    }
}