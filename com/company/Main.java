// Импортируйте необходимые классы для программы
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Определите главный класс для программы
public class Main {

    // Определите главный метод для программы
    public static void main(String[] args) throws IOException {

        // Создайте новый объект ServerSocket с номером порта 1092
        ServerSocket serverSocket = new ServerSocket(1092);

        // Примите соединение от клиента и сохраните его в переменной link
        Socket link = serverSocket.accept();

        // Создайте новый объект Scanner для чтения ввода от клиента
        Scanner input = new Scanner(link.getInputStream());

        // Создайте новый объект PrintWriter для отправки вывода клиенту
        PrintWriter output = new PrintWriter(link.getOutputStream());

        // Отправьте сообщение клиенту, указывающее, что сервер ожидает данных
        output.println("awaiting for data...");

        // Прочитайте строку ввода от клиента и сохраните ее в переменной myinput
        String myinput =  input.nextLine();

        // Закройте соединение с клиентом
        link.close();
    }
}