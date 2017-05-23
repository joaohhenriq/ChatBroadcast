package br.ufg.inf.cliente;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteChat {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket servidor = new Socket("localhost", 12345);
		
		new Thread(new EnviarMensagem(servidor)).start();
		new Thread(new ReceberMensagem(servidor)).start();
	}

}
