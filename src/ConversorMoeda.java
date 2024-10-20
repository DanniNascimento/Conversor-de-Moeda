import java.util.Scanner;

public class ConversorMoeda {
    public static void main(String[] args) { // Aqui o 'args' é mantido, pois faz parte da assinatura padrão do método main
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Entrada da moeda de origem
            System.out.print("Digite o código da moeda de origem (ou '0' para sair): ");
            String moedaOrigem = scanner.next().toUpperCase();
            if (moedaOrigem.equals("0")) {
                System.out.println("Programa encerrado.");
                break;
            }

            // Entrada da moeda de destino
            System.out.print("Digite o código da moeda de destino: ");
            String moedaDestino = scanner.next().toUpperCase();

            // Entrada do valor a ser convertido
            System.out.print("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();

            // Chamada do método 'converterMoeda' da classe 'Conversao'
            Conversao.converterMoeda(moedaOrigem, moedaDestino, valor);

            // Pergunta se o usuário deseja continuar ou sair
            System.out.print("Deseja realizar outra conversão? (1 para continuar, 0 para sair): ");
            int continuar = scanner.nextInt();
            if (continuar == 0) {
                System.out.println("Obrigado por usar o Conversor de Moedas.");
                break;
            }
        }
        scanner.close();
    }
}