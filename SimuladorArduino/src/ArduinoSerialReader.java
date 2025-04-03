import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

public class ArduinoSerialReader {
    public static void main(String[] args) {
        SerialPort arduinoPort = SerialPort.getCommPort("COM3"); // Substitua pela porta do seu Arduino
        arduinoPort.setBaudRate(9600);
        
        if (arduinoPort.openPort()) {
            System.out.println("Conectado ao Arduino!");

            Scanner scanner = new Scanner(arduinoPort.getInputStream());
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] values = data.split(",");

                if (values.length == 2) {
                    String temperatura = values[0];
                    String gas = values[1];

                    System.out.println("================================");
                    System.out.println(" Leitura dos Sensores:");
                    System.out.println(" Temperatura: " + temperatura + "°C");
                    System.out.println(" Sensor de Gás: " + gas);

                    if (Integer.parseInt(gas) > 500) {
                        System.out.println("⚠️ ALERTA: Gás detectado!");
                    } else {
                        System.out.println("Nenhum gás detectado.");
                    }
                    System.out.println("================================");
                }
            }
        } else {
            System.out.println("Erro ao conectar com o Arduino.");
        }
    }
}
