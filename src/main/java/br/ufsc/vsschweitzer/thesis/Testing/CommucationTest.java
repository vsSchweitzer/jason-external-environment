package br.ufsc.vsschweitzer.thesis.Testing;

import java.util.Scanner;

import br.ufsc.vsschweitzer.thesis.messaging.Messenger;

public class CommucationTest {

	static String ip = "127.0.0.1";
	static int port = 10000;

	public static void main(String args[]) throws Exception {
		Scanner scanner = new Scanner(System.in);

		scanner.nextLine();
		Messenger messenger = new Messenger(ip, port);
		System.out.println("Messenger criado");

		scanner.nextLine();
		messenger.open();
		System.out.println("Messenger aberto");

		String msg = scanner.nextLine();
		messenger.send(msg);
		System.out.println("Mensagem enviada");

		scanner.nextLine();
		String receivedMsg = messenger.listen();
		System.out.println("Messenger recebida: " + receivedMsg);

		scanner.nextLine();
		messenger.close();
		System.out.println("Messenger fechado");

		scanner.close();
	}

}
