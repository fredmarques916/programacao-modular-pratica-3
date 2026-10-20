package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bilheteria {
    private List<Ingresso> listaIngressos;

    public Bilheteria() {
        this.listaIngressos = new ArrayList<>();
    }

    public void adicionarIngresso(Ingresso ingresso) {
        listaIngressos.add(ingresso);
    }

    public boolean removerIngresso(int codigo) {
        Ingresso ingresso = buscarIngresso(codigo);
        if (ingresso != null) {
            listaIngressos.remove(ingresso);
            return true;
        }
        return false;
    }

    public Ingresso buscarIngresso(int codigo) {
        for (Ingresso ing : listaIngressos) {
            if (ing.getCodigo() == codigo) {
                return ing;
            }
        }
        return null;
    }

    public void listarIngressos() {
        if (listaIngressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado na bilheteria.");
            return;
        }
        for (Ingresso ing : listaIngressos) {
            // Devido ao polimorfismo, cada classe filha executa sua própria versão deste método
            ing.exibirInformacoesBasicas();
            System.out.println("---------------------------------------------------");
        }
    }

    public double calcularArrecadacaoTotal() {
        double total = 0;
        for (Ingresso ing : listaIngressos) {
            total += ing.calcularValorFinal();
        }
        return total;
    }

    public void listarBeneficiosIngressos() {
        if (listaIngressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado na bilheteria.");
            return;
        }
        for (Ingresso ing : listaIngressos) {
            System.out.println("Ingresso [" + ing.getCodigo() + "] - " + ing.getNomeEvento() + ": " + ing.obterBeneficios());
        }
    }
}