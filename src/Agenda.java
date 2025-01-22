import java.io.*;
import java.util.Scanner;

public class Agenda {
     // Definindo a constante CAMINHO_ARQUIVO
    private static final String CAMINHO_ARQUIVO = "usuarios.txt"; // Caminho do arquivo onde os usuários serão armazenados

// Método para adicionar um usuário
    static void creatUser(Scanner scanner){
        try(FileWriter fw =  new FileWriter(CAMINHO_ARQUIVO, true);
            BufferedWriter bw = new BufferedWriter(fw)){
             System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            System.out.print("Digite o email: ");
            String email = scanner.nextLine();
            bw.write(nome + ";" + idade + ";" + email);
            bw.newLine();
             System.out.println("Usuário adicionado com sucesso!");
        }catch (IOException e){
            System.out.println("Erro ao adicionar usuário: " + e.getMessage());
        }
    }

// Método para listar um usuário
    static void listUser(){
        try(BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))){
            String linha;
             System.out.println("\n--- Lista de Usuários ---");
             while ((linha = br.readLine()) != null){
                  System.out.println(linha);
             }
        }catch (IOException e ){
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
    }
// Método para atualizar um usuário
    static void updateUser(Scanner scanner){
        System.out.print("Digite o nome do usuário a ser atualizado: ");
        String nomeParaAtualizar = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            StringBuilder conteudoAtualizado = new StringBuilder();
            String linha;
            boolean usuarioEncontrado = false;

            while ((linha = br.readLine()) != null){
                if (linha.startsWith(nomeParaAtualizar + ";")){
                    System.out.println("Usuário encontrado: " + linha);
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Digite a nova idade: ");
                    int novaIdade = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o novo email: ");
                    String novoEmail = scanner.nextLine();

                     conteudoAtualizado.append(novoNome).append(";")
                                      .append(novaIdade).append(";")
                                      .append(novoEmail).append("\n");
                    usuarioEncontrado = true;

                }else {
                    conteudoAtualizado.append(linha).append("\n");
                }
            }
            if (usuarioEncontrado){
                 try (FileWriter fw = new FileWriter(CAMINHO_ARQUIVO)) {
                    fw.write(conteudoAtualizado.toString());
            }
                  System.out.println("Usuário atualizado com sucesso!");
        }else {
                System.out.println("Usuário não encontrado.");
            }

    }catch (IOException e){
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
        }
    }



// Método para deletar um usuário
    static void deleteUser(Scanner scanner){
        System.out.print("Digite o nome do usuário a ser deletado: ");
        String nomeParaDeletar = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            StringBuilder conteudoAtualizado = new StringBuilder();
            String linha;
            boolean usuarioEncontrado = false;

            while ((linha = br.readLine()) != null){
                if (linha.startsWith(nomeParaDeletar + ";")) {
                    System.out.println("Usuário deletado: " + linha);
                    usuarioEncontrado = true;
                }else {
                    conteudoAtualizado.append(linha).append("\n");
                }
            }
            if (usuarioEncontrado){
            try(FileWriter fw = new FileWriter(CAMINHO_ARQUIVO)){
                fw.write(conteudoAtualizado.toString());
            }
            System.out.println("Usuário deletado com sucesso!");
            }else {
                System.out.println("Usuário não encontrado.");
            }
        }catch (IOException e){
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
        }
    }


}
