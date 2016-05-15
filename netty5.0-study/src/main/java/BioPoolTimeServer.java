import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Xavier on 2016/5/3.
 */
public class BioPoolTimeServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new ArrayBlockingQueue(10));
            serverSocket = new ServerSocket(8080);
            System.out.println("Time Server Start port: 8080");
            Socket socket = null;
            while (true) {
                System.out.println("Before Accept");
                socket = serverSocket.accept();
                System.out.println("After Accept");
                threadPoolExecutor.execute(new BioTimeServerHandle(socket));
            }
        } finally {
            if (serverSocket != null) {
                System.out.printf("The time server close");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }

}
