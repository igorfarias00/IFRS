import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class QuadradoClientTCP {
    public static void main(String[] argv) throws Exception {
        String number = null;
        String serverReturn = null;

        BufferedReader inFromUser;
        Socket clientSocket;
        DataOutputStream outToServer;
        BufferedReader inFromServer;

        while (true) {
            inFromUser = new BufferedReader(new InputStreamReader(System.in));
            clientSocket = new Socket("localhost", 9000);
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//            StringBuilder serverResponse = new StringBuilder();
//            String line;
//
//            while ((line = inFromServer.readLine()) != null) {
//                serverResponse.append(line).append("\n");
//            }
//
//            System.out.println(serverResponse.toString());

            System.out.println("A votação vai começar");

            serverReturn = inFromServer.readLine();
            System.out.println(serverReturn);

            System.out.println("Escolha o seu candidato:");

            number = inFromUser.readLine();
            outToServer.writeBytes(number + '\n');
            outToServer.flush();


            while (true) {
                System.out.println("231321");
                inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                Thread.sleep(5000);
                serverReturn = inFromServer.readLine();
                System.out.println("FROM SERVER: " + serverReturn);
            }
        }
    }
}
