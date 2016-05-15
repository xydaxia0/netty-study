/**
 * Created by Xavier on 2016/5/4.
 */
public class AioTimeServer {

    public static void main(String[] args) {
        int port = 8080;
        AsyncTimeServerHandle timeServerHandle = new AsyncTimeServerHandle(port);
        new Thread(timeServerHandle, "AIO").start();
    }

}
