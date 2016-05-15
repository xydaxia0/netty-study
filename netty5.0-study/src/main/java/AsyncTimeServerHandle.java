import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Xavier on 2016/5/4.
 */
public class AsyncTimeServerHandle implements Runnable {

    private int port;

    CountDownLatch countDownLatch;

    AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public AsyncTimeServerHandle(int port) {
        this.port = port;
        try {
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("The time server is start in port : " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        countDownLatch = new CountDownLatch(1);
        doAccept();
        try {
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void doAccept() {
        asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandle());
    }
}
