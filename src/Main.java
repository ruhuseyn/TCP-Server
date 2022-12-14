import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

public class Main {

    private static DataOutputStream dataOutputStream = null;
    private static DataOutputStream dataInputStream = null;


    public static void main(String[] args) {
        // Here we define Server Socket running on port 900
        try (ServerSocket serverSocket
                     = new ServerSocket(900)) {
            System.out.println(
                    "Server is Starting in Port 900");
            // Accept the Client request using accept method
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected");
            dataInputStream = new DataOutputStream(
                    clientSocket.getOutputStream());

            // Here we call receiveFile define new for that
            // file
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
            dataInputStream.write(readBytes(""+"C:\\Users\\Rufet Huseynov\\Desktop\\pic.png"));
            dataInputStream.close();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // receive file function is start here



    public static void writeBytes(String fileName, byte[] data) throws Exception {
        FileOutputStream fop = new FileOutputStream(fileName);
        fop.write(data);
        fop.flush();
        fop.close();
        System.out.println("Done.");
    }

    public static byte[] readBytes(String fileName) throws Exception {
        File file = new File(fileName);
        try (FileInputStream fileInputStream = new FileInputStream(file);) {
            byte[] bytesArray = new byte[(int) file.length()];
            fileInputStream.read(bytesArray);
            return bytesArray;
        }
    }

}