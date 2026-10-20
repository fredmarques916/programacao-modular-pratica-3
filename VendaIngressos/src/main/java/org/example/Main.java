package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bilheteria bilheteria = new Bilheteria();
        boolean executando = true;

        while (executando) {
            System.out.println("\n=== SISTEMA DE BILHETERIA ===");
            System.out.println("(a) Cadastrar ingresso");
            System.out.println("(b) Remover ingresso");
            System.out.println("(c) Buscar ingresso por código");
            System.out.println("(d) Listar todos os ingressos");
            System.out.println("(e) Calcular arrecadação total");
            System.out.println("(f) Listar benefícios dos ingressos");
            System.out.println("(g) Finalizar");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine().trim().toLowerCase();

            switch (opcao) {
                case "a" -> {
                    System.out.print("Código numérico: ");
                    int codigo = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nome do Evento: ");
                    String evento = scanner.nextLine();
                    System.out.print("Setor: ");
                    String setor = scanner.nextLine();
                    System.out.print("Valor Base (R$): ");
                    double valor = Double.parseDouble(scanner.nextLine());

                    System.out.println("Qual o tipo de Ingresso? (1) Comum (2) Estudante (3) VIP");
                    String tipo = scanner.nextLine();

                    switch (tipo) {
                        case "1" -> {
                            bilheteria.adicionarIngresso(new IngressoComum(codigo, evento, setor, valor));
                            System.out.println("Ingresso Comum cadastrado com sucesso!");
                        }
                        case "2" -> {
                            System.out.print("Instituição de Ensino: ");
                            String instituicao = scanner.nextLine();
                            bilheteria.adicionarIngresso(new IngressoEstudante(codigo, evento, setor, valor, instituicao));
                            System.out.println("Ingresso de Estudante cadastrado com sucesso!");
                        }
                        case "3" -> {
                            System.out.print("Número do Lounge: ");
                            int lounge = Integer.parseInt(scanner.nextLine());
                            System.out.print("Tem acesso ao Backstage? (S/N): ");
                            boolean backstage = scanner.nextLine().trim().equalsIgnoreCase("s");
                            bilheteria.adicionarIngresso(new IngressoVIP(codigo, evento, setor, valor, backstage, lounge));
                            System.out.println("Ingresso VIP cadastrado com sucesso!");
                        }
                        default -> System.out.println("Tipo inválido. O ingresso não foi cadastrado.");
                    }
                }
                case "b" -> {
                    System.out.print("Digite o código do ingresso a remover: ");
                    int codRemover = Integer.parseInt(scanner.nextLine());
                    if (bilheteria.removerIngresso(codRemover)) {
                        System.out.println("Ingresso removido com sucesso.");
                    } else {
                        System.out.println("Erro: Código não encontrado.");
                    }
                }
                case "c" -> {
                    System.out.print("Digite o código do ingresso: ");
                    int codBusca = Integer.parseInt(scanner.nextLine());
                    Ingresso ingresso = bilheteria.buscarIngresso(codBusca);
                    if (ingresso != null) {
                        System.out.println("\n--- Ingresso Encontrado ---");
                        ingresso.exibirInformacoesBasicas();
                    } else {
                        System.out.println("Erro: Código não encontrado.");
                    }
                }
                case "d" -> {
                    System.out.println("\n--- Lista de Ingressos ---");
                    bilheteria.listarIngressos();
                }
                case "e" -> {
                    double total = bilheteria.calcularArrecadacaoTotal();
                    System.out.println("Arrecadação Total: R$ " + String.format("%.2f", total));
                }
                case "f" -> {
                    System.out.println("\n--- Benefícios dos Ingressos ---");
                    bilheteria.listarBeneficiosIngressos();
                }
                case "g" -> {
                    System.out.println("Encerrando o sistema de bilheteria...");
                    executando = false;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}