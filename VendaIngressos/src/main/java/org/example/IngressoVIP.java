package org.example;

public class IngressoVIP extends Ingresso {
    private boolean acessoBackstage;
    private int numeroLounge;

    public IngressoVIP(int codigo, String nomeEvento, String setor, double valorBase, boolean acessoBackstage, int numeroLounge) {
        super(codigo, nomeEvento, setor, valorBase);
        this.acessoBackstage = acessoBackstage;
        this.numeroLounge = numeroLounge;
    }

    public boolean isAcessoBackstage() { return acessoBackstage; }
    public void setAcessoBackstage(boolean acessoBackstage) { this.acessoBackstage = acessoBackstage; }

    public int getNumeroLounge() { return numeroLounge; }
    public void setNumeroLounge(int numeroLounge) { this.numeroLounge = numeroLounge; }

    @Override
    public double calcularValorFinal() {
        return getValorBase() * 1.8; // Acréscimo de 80%
    }

    @Override
    public String obterBeneficios() {
        String beneficios = "Acesso privilegiado ao Lounge " + numeroLounge + ".";
        if (acessoBackstage) {
            beneficios += " Inclui acesso ao Backstage.";
        }
        return beneficios;
    }

    @Override
    public void exibirInformacoesBasicas() {
        super.exibirInformacoesBasicas();
        System.out.println("  -> [VIP] Valor Final: R$ " + String.format("%.2f", calcularValorFinal()));
    }
}