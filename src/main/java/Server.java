import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    @Override
    public void run() {
        try {
            //  Занимаем порт, определяя серверный сокет
            ServerSocket servSocket = new ServerSocket(23444);

            while (true) {
                //  Ждем подключения клиента и получаем потоки для дальнейшей работы
                try (Socket socket = servSocket.accept();

                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {


                    String line;
                    while ((line = in.readLine()) != null) {
                        if (line.equals("end")) {

                            return;
                        }
                        // Пишем ответ
                        int parseNumber = Integer.parseInt(line);
                        out.println("Ваш член: " + Fibonacci.getFibonacci(parseNumber));
                        // Выход если от клиента получили end
                    }
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
