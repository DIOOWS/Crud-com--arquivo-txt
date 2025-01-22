import java.util.Scanner;

public class Usuario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
             System.out.println("\n--- Sistema CRUD ---");
            System.out.println("1. Adicionar usuário");
            System.out.println("2. Listar usuários");
            System.out.println("3. Atualizar usuário");
            System.out.println("4. Deletar usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao){
                case 1 -> adicionarUsuario(scanner);
                case 2 -> listarUsuarios();
                case 3 -> atualizarUsuario(scanner);
                case 4 -> deletarUsuario(scanner);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }


        }


    }
}
