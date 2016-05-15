import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Xavier on 2016/5/3.
 */
public class BioTimeServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Time Server Start port: 8080");
            Socket socket = null;
            while (true) {
                System.out.println("Before Accept");
                socket = serverSocket.accept();
                System.out.println("After Accept");
                new Thread(new BioTimeServerHandle(socket)).start();
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
