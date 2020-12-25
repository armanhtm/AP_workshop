import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Arman Hatami
 * @version 1.0
 * single server method
 */
public class Server {

    public static void main(String[] args) {

        try (ServerSocket welcomingSocket = new ServerSocket(7657)) {
            System.out.print("Server started.\nWaiting for a client ... ");
            try (Socket connectionSocket = welcomingSocket.accept()) {
                System.out.println("client accepted!");
                OutputStream out = connectionSocket.getOutputStream();
                InputStream in = connectionSocket.getInputStream();
                byte[] buffer = new byte[2048];
                String messages = " ";
                String temp;
                while (true) {
                    int read = in.read(buffer);
                    try {
                        temp = new String(buffer, 0, read);
                    } catch (Exception e) {
                        break;
                    }
                    System.out.println("RECEIVE from client : " + temp);
                    messages += temp;
                    out.write(messages.getBytes());
                    System.out.println("SENT to client : " + messages);
                }
                System.out.print("All messages sent.\nClosing client ... ");
            } catch (IOException ex) {
                System.err.println(ex);
            }
            System.out.print("done.\nClosing server ... ");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println("done.");
    }
}

