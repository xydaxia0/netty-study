import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by Xavier on 2016/5/4.
 */
public class AcceptCompletionHandle implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandle> {


    public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandle attachment) {
        attachment.asynchronousServerSocketChannel.accept(attachment, this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer, buffer, new ReadCompletionHandler(result));
    }

    public void failed(Throwable exc, AsyncTimeServerHandle attachment) {
        attachment.countDownLatch.countDown();
    }
}
