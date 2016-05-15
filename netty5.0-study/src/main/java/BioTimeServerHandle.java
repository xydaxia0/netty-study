import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Xavier on 2016/5/3.
 */
public class BioTimeServerHandle implements Runnable {

    private Socket socket;

    public BioTimeServerHandle(Socket socket) {
        this.socket = socket;
    }


    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            String currentTime = null;
            String body = null;
            while (true) {
                System.out.println("Before handle READ");
                body = in.readLine();
                System.out.println("body " + body);
                if (body == null) {
                    break;
                }
                System.out.println("The time server receive order : " + body);
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)? new java.util.Date().toString() : "BAD ORDER";
                out.println(currentTime);
                System.out.println("After handle READ");
            }
        } catch (Exception e) {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            if (out != null) {
                out.close();
                out = null;
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                socket= null;
            }
        }
    }
}
