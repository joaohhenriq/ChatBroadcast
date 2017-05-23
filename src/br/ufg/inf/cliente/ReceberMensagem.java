package br.ufg.inf.cliente;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ReceberMensagem implements Runnable {

	private Socket servidor;
	
	public ReceberMensagem(Socket servidor) {
		this.servidor = servidor;
	}

	@Override
	public void run() {

		try {
			Scanner ouvirServidorr = new Scanner(servidor.getInputStream());
			do{
				String mensagem = ouvirServidorr.nextLine();
				System.out.println(mensagem);
			}while(true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
