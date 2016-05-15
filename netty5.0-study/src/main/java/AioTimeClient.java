/**
 * Created by Xavier on 2016/5/4.
 */
public class AioTimeClient {

    public static void main(String[] args) {
        new Thread(new AsyncTimeClientHandle("127.0.0.1", 8080), "AIO").start();
    }

}
