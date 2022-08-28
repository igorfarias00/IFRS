/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimeiroProjetoBanco;

import java.util.Scanner;

/**
 *
 * @author SAMSUNG
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int a = 0;
        
        do {
            System.out.println("Menu");
            System.out.println("1 - Inserir Aluno");
            System.out.println("2 - Atualizar Aluno");
            System.out.println("3 - Excluir Aluno");
            System.out.println("4 - Visualizar Alunos");
            System.out.println("5 - Sair");
            System.out.println("Digite sua opção:");

            a = sc.nextInt();

            switch (a) {
                case 1: {
                    Aluno alu = new Aluno();
                    try {
                        System.out.println("Digite a matrícula: ");
                        alu.setRa(sc.nextInt());

                        System.out.println("Digite o nome: ");
                        alu.setNome(sc.next());

                        System.out.println("Digite o Endereço: ");
                        alu.setEndereco(sc.next());

                        System.out.println("Digite o Telefone: ");
                        alu.setTelefone(sc.next());

                        System.out.println("Digite o Email: ");
                        alu.setEmail(sc.next());

                        System.out.println("Digite o RG: ");
                        alu.setRg(sc.next());

                        System.out.println("Digite o CPF: ");
                        alu.setCpf(sc.next());

                        alu.inserir();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                } 
                case 2: {
                    Aluno alu = new Aluno();
                    try {
                        System.out.println("Digite a matrícula: ");
                        alu.setRa(sc.nextInt());

                        System.out.println("Digite o nome: ");
                        alu.setNome(sc.next());

                        System.out.println("Digite o Endereço: ");
                        alu.setEndereco(sc.next());

                        System.out.println("Digite o Telefone: ");
                        alu.setTelefone(sc.next());

                        System.out.println("Digite o Email: ");
                        alu.setEmail(sc.next());

                        System.out.println("Digite o RG: ");
                        alu.setRg(sc.next());

                        System.out.println("Digite o CPF: ");
                        alu.setCpf(sc.next());

                        alu.atualizar();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                } 
                case 3: {
                    Aluno alu = new Aluno();
                    
                    try {
                        System.out.println("Digite a matrícula: ");
                        alu.setRa(sc.nextInt());

                        alu.excluir();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    
                    break;
                } 
                case 4: {
                    Aluno alu = new Aluno();
                    
                    try {
                        System.out.println("Alunos: ");
                        alu.consultar();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                } 
                default: {
                    System.out.println("Digite uma opção válida!!!");
                }
            }
        } while (a != 3);
    }

    
}
