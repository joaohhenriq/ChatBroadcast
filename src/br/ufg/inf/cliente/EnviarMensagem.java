package br.ufg.inf.cliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EnviarMensagem implements Runnable {

	private Socket servidor;
	
	public EnviarMensagem(Socket servidor) {
		this.servidor = servidor;
	}

	@Override
	public void run() {

		try {
			Scanner leitor = new Scanner(System.in);
			PrintWriter saidaServidor = new PrintWriter(this.servidor.getOutputStream(), true);
			
			do{
				String texto = leitor.nextLine();
				saidaServidor.println("Joao: " + texto);
			}while(true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
