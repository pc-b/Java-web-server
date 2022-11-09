import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class SimpleServer {
    public static void main(String[] args) throws Exception {
        System.out.println("Listening for connection on port 8080...");
        final ServerSocket server = new ServerSocket(8080);
        while (true) {
            try (Socket socket = server.accept()) {
                Date date = new Date();
                String s = "This is my web server";
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + date + "\n" + s;
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}
