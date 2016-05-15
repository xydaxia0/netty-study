/**
 * Created by Xavier on 2016/5/3.
 */
public class NioTimeServer {

    public static void main(String[] args) {
        int port = 8080;
        MultiTimeServer timeServer = new MultiTimeServer(port);
        new Thread(timeServer, "NIO").start();
    }

}
