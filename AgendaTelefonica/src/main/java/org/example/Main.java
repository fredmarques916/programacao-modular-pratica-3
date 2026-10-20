package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n--- MENU DA AGENDA ---");
            System.out.println("(a) Adicionar contato");
            System.out.println("(b) Remover contato");
            System.out.println("(c) Buscar contato por nome");
            System.out.println("(d) Buscar contato por email");
            System.out.println("(e) Buscar contato por telefone");
            System.out.println("(f) Consultar tamanho da Agenda");
            System.out.println("(g) Finalizar");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine().trim().toLowerCase();

            switch (opcao) {
                case "a" -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.println("Tipo de contato: (1) Pessoal (2) Profissional (3) Emergência");
                    String tipo = scanner.nextLine();

                    switch (tipo) {
                        case "1" -> {
                            System.out.print("Data de Aniversário: ");
                            String niver = scanner.nextLine();
                            System.out.print("Parentesco: ");
                            String parentesco = scanner.nextLine();
                            agenda.adicionarContato(new ContatoPessoal(nome, email, telefone, niver, parentesco));
                            System.out.println("Contato Pessoal adicionado com sucesso!");
                        }
                        case "2" -> {
                            System.out.print("Empresa: ");
                            String empresa = scanner.nextLine();
                            System.out.print("Cargo: ");
                            String cargo = scanner.nextLine();
                            agenda.adicionarContato(new ContatoProfissional(nome, email, telefone, empresa, cargo));
                            System.out.println("Contato Profissional adicionado com sucesso!");
                        }
                        case "3" -> {
                            System.out.print("Grau de Prioridade (1 a 5): ");
                            int prioridade = Integer.parseInt(scanner.nextLine());
                            System.out.print("Observação: ");
                            String obs = scanner.nextLine();
                            agenda.adicionarContato(new ContatoEmergencia(nome, email, telefone, prioridade, obs));
                            System.out.println("Contato de Emergência adicionado com sucesso!");
                        }
                        default -> System.out.println("Tipo inválido. Contato não adicionado.");
                    }
                }
                case "b" -> {
                    System.out.print("Digite o nome do contato para remover: ");
                    String nomeRemover = scanner.nextLine();
                    boolean removido = agenda.removerContato(nomeRemover);
                    if (removido) {
                        System.out.println("Contato excluído com sucesso.");
                    } else {
                        System.out.println("Erro: Contato não encontrado.");
                    }
                }
                case "c" -> {
                    System.out.print("Digite o nome: ");
                    String nomeBusca = scanner.nextLine();
                    Contato cNome = agenda.buscarPorNome(nomeBusca);
                    if (cNome != null) cNome.exibirDados();
                    else System.out.println("Contato não encontrado.");
                }
                case "d" -> {
                    System.out.print("Digite o email: ");
                    String emailBusca = scanner.nextLine();
                    Contato cEmail = agenda.buscarPorEmail(emailBusca);
                    if (cEmail != null) cEmail.exibirDados();
                    else System.out.println("Contato não encontrado.");
                }
                case "e" -> {
                    System.out.print("Digite o telefone: ");
                    String telBusca = scanner.nextLine();
                    Contato cTel = agenda.buscarPorTelefone(telBusca);
                    if (cTel != null) cTel.exibirDados();
                    else System.out.println("Contato não encontrado.");
                }
                case "f" -> {
                    System.out.println("Tamanho atual da agenda: " + agenda.getQuantidadeContatos() + " contato(s).");
                }
                case "g" -> {
                    System.out.println("Encerrando a agenda...");
                    rodando = false;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}