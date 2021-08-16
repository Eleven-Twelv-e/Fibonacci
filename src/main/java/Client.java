import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{
    @Override
    public void run() {
        try {
            // Определяем сокет сервера
            Socket socket = new Socket("127.0.0.1", 23444);
            // Получаем входящий и исходящий потоки информации
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                 Scanner scanner = new Scanner(System.in)) {
                String msg;
                System.out.println("Вас приветствует сервер по расчету числа Фибоначчи");
                while (true) {
                    System.out.println("Введите номер n-ого члена для расчета");
                    msg = scanner.nextLine();
                    out.println(msg);
                    if ("end".equals(msg)) break;
                    System.out.println("SERVER: " + in.readLine());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
