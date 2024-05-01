import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Этот класс демонстрирует, как получить содержимое веб-страницы с использованием URLConnection в Java.
 */
public class Main2 {
    private static ByteBuffer buffer;

    public static void main(String[] args) {
        try {
            // Определяем URL веб-страницы для получения
            URL url = new URL("https://ocsaly.com");

            // Открываем соединение с указанным URL
            URLConnection urlConnection = url.openConnection();

            // Получаем InputStream из соединения URL
            InputStream inputStream = urlConnection.getInputStream();

            // Создаем ReadableByteChannel из InputStream
            ReadableByteChannel readableByteChannel = Channels.newChannel(inputStream);

            // Выделяем ByteBuffer для считывания данных
            ByteBuffer buffer = ByteBuffer.allocate(64);

            // Считываем данные из ReadableByteChannel в ByteBuffer
            // и выводим их в консоль
            while (readableByteChannel.read(buffer) > 0) {
                System.out.println(new String(buffer.array()));
                buffer.clear();
            }

            // Закрываем ReadableByteChannel
            readableByteChannel.close();

        } catch (IOException ioException) {
            // Обрабатываем любые исключения ввода-вывода, которые могут возникнуть в процессе
            System.out.println(ioException.getMessage());
        }
    }
}
