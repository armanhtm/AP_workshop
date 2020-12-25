import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try (Socket client = new Socket("127.0.0.1", 7660)) {
            System.out.println("Connected to server.");
            OutputStream out = client.getOutputStream();
            InputStream in = client.getInputStream();
            byte[] buffer = new byte[2048];
            Scanner input = new Scanner(System.in);
            String temp = input.nextLine();
            while(!temp.equals("over")) {
                out.write(temp.getBytes());
                System.out.println("SENT: " + temp);
                int read = in.read(buffer);
                System.out.println("RECEIVE: " + new String(buffer, 0, read));
                temp = input.nextLine();
            }
            System.out.print("All messages sent.\nClosing ... ");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println("done.");
    }
}

