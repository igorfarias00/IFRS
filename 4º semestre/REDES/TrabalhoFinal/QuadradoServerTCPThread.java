import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

class QuadradoThread extends Thread {
	Socket clientSocket;
	AtomicInteger votosBiscoito;
	AtomicInteger votosBolacha;

	QuadradoThread(Socket cs, AtomicInteger votosBolacha, AtomicInteger votosBiscoito) {
		clientSocket = cs;
		this.votosBolacha = votosBolacha;
		this.votosBiscoito = votosBiscoito;
	}

	public void run() {
		try {
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

			String serverReturn;
			String votacao = "[1] PARA VOTAR EM BOLACHA [2] PARA VOTAR EM BISCOITO";

			outToClient.writeBytes(votacao + "\n");

			String clientNumber = inFromClient.readLine();
			int voto = Integer.parseInt(clientNumber);

			System.out.println("Received: " + clientNumber);

			if (voto == 1) {
				votosBolacha.incrementAndGet();
			} else if (voto == 2) {
				votosBiscoito.incrementAndGet();
			}

			while (true) {
				serverReturn = "[" + votosBolacha + "] votos para Bolacha [" + votosBiscoito + "] votos para Biscoito";
				Thread.sleep(5000);
				outToClient.writeBytes(serverReturn + "\n");
				outToClient.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class QuadradoServerTCPThread {
	public static void main(String[] args) {
		ServerSocket welcomeSocket = null;
		AtomicInteger votosBolacha = new AtomicInteger(0);
		AtomicInteger votosBiscoito = new AtomicInteger(0);

		try {
			welcomeSocket = new ServerSocket(9000);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		while (true) {
			Socket connectionSocket = null;
			try {
				connectionSocket = welcomeSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}

			QuadradoThread thread = new QuadradoThread(connectionSocket, votosBolacha, votosBiscoito);
			thread.start();
		}
	}
}
