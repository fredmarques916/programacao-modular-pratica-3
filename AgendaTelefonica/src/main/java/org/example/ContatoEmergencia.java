package org.example;

public class ContatoEmergencia extends Contato {
    private int grauPrioridade; // 1 a 5
    private String observacao;

    public ContatoEmergencia(String nome, String email, String telefone, int grauPrioridade, String observacao) {
        super(nome, email, telefone);
        this.grauPrioridade = Math.max(1, Math.min(5, grauPrioridade)); // Garante valor de 1 a 5
        this.observacao = observacao;
    }

    public int getGrauPrioridade() { return grauPrioridade; }
    public void setGrauPrioridade(int grauPrioridade) { this.grauPrioridade = Math.max(1, Math.min(5, grauPrioridade)); }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("  -> [Emergência] Prioridade: " + grauPrioridade + " | Observação: " + observacao);
    }
}