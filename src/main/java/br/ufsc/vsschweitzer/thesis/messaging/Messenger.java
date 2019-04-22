package br.ufsc.vsschweitzer.thesis.messaging;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import br.ufsc.vsschweitzer.thesis.exceptions.ConnectionNotOpenException;

/**
 * Class responsible for connecting to a TCP server and sending messages.
 */
public class Messenger implements Closeable {

	boolean isOpen = false;
	Socket socket;

	String ip;
	int port;
	
	/**
	 * Constructor for a messenger that can stabilish connections via TCP.
	 *
	 * @param ip   ip address of the TCP server.
	 * @param port the port of the TCP server.
	 */
	public Messenger(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	/**
	 * Opens a connection with the server.
	 */
	public void open() throws UnknownHostException, IOException {
		socket = new Socket(ip, port);
		isOpen = true;
	}

	/**
	 * Sends a message to the connected server.
	 *
	 * @param message the message to send.
	 * @throws ConnectionNotOpenException when the connection is not open.
	 * @throws IOException                if there was a problem sending the message
	 *                                    to the server.
	 */
	public void send(String message) throws ConnectionNotOpenException, IOException {
		if (isOpen) {
			OutputStream output = socket.getOutputStream();
			byte[] toSend = message.getBytes();
			output.write(toSend);
		} else {
			throw new ConnectionNotOpenException();
		}
	}

	/**
	 * Waits foe a message from the connected server.
	 *
	 * @return the message received.
	 * @throws ConnectionNotOpenException when the connection is not open.
	 * @throws IOException                if there was a problem sending the message
	 *                                    to the server.
	 */
	public String listen() throws ConnectionNotOpenException, IOException {
		if (isOpen) {
			InputStream input = socket.getInputStream();

			// byte[] receivedBytes = new byte[1024];
			// input.read(receivedBytes);
			byte[] receivedBytes = input.readAllBytes();
			String receivedMsg = new String(receivedBytes);

			return receivedMsg;
		} else {
			throw new ConnectionNotOpenException();
		}
	}

	/**
	 * Closes the connection with the server.
	 *
	 */
	public void close() throws IOException {
		if (isOpen) {
			socket.close();
			isOpen = false;
		}
	}

}
