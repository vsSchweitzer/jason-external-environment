package br.ufsc.vsschweitzer.thesis.Testing;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufsc.vsschweitzer.thesis.configuration.ConfigurationReader;
import br.ufsc.vsschweitzer.thesis.configuration.EnvironmentConfiguration;
import br.ufsc.vsschweitzer.thesis.messaging.AgentMessageInterpreter;
import br.ufsc.vsschweitzer.thesis.messaging.Messenger;
import br.ufsc.vsschweitzer.thesis.messaging.message.ActMessage;
import br.ufsc.vsschweitzer.thesis.messaging.message.ActResponseMessage;

public class CommucationTest {

	static String ip = "127.0.0.1";
	static int port = 10000;

	public static void main(String args[]) throws Exception {
		ArrayList<String> x = new ArrayList<String>();
		x.add("1");
		x.add("2");
		x.add("3");
		System.out.println(AgentMessageInterpreter.messageToJson(new ActMessage("ag1", "run", x)));
		//System.out.println(AgentMessageInterpreter.messageToJson(new ActResponseMessage()));
		
/*
		EnvironmentConfiguration conf = ConfigurationReader.getConfiguration();

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
		*/
	}

}
