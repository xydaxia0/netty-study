/**
 * Created by Xavier on 2016/5/4.
 */
public class NioTimeClient {

    public static void main(String[] args) {
        int port = 8080;
        new Thread(new TimeClientHandle("127.0.0.1", 8080)).start();
    }

}
