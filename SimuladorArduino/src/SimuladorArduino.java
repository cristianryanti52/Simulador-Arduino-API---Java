import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimuladorArduino {
    private static volatile String temperatura = "25.0"; // Valor inicial simulado
    private static volatile String gas = "300"; // Valor inicial simulado

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        // Thread 1: Simula a leitura "automática" do Arduino
        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(3000); // Simula tempo de leitura
                    System.out.println("Temperatura: " + temperatura + "°C");
                    System.out.println("Sensor de gás: " + gas);
                    
                    if (Integer.parseInt(gas) > 500) {
                        System.out.println("⚠️ ALERTA: Gás detectado!");
                    } else {
                        System.out.println("Nenhum gás detectado.");
                    }
                    
                    System.out.println("--------------------------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Thread 2: Permite inserir dados manualmente, mas sem mostrar no terminal
        executor.execute(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("\033[2K\r"); // Apaga a linha anterior no terminal
                String input = scanner.nextLine(); // Entrada oculta (não aparece no terminal)

                if (input.startsWith("T")) { // Exemplo: T27.5 -> Define temperatura
                    temperatura = input.substring(1);
                } else if (input.startsWith("G")) { // Exemplo: G450 -> Define gás
                    gas = input.substring(1);
                }
            }
        });

        executor.shutdown();
    }
}
