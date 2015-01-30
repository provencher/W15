import java.net.Socket;
import java.net.ServerSocket;
import java.util.Date;

class NetworkService{

  public void start(int port) {
    ServerSocket serverSocket = new ServerSocket(port);
    while (true) {
      // This will block until a connection comes in.
      Socket socket = serverSocket.accept();
      (new Handler(socket)).run();
    }
  }

  public static void main(String[] args) {
    (new NetworkService()).start(2020); 
  }
}

class Handler implements Runnable {
  Socket socket;
  Handler(Socket socket) {
    this.socket = socket;
  }
  public void run() {
    String message = (Thread.currentThread.getName() + "\n").getBytes;
    socket.getOutputStream.write(message);
    socket.getOutputStream.close();
  }
}