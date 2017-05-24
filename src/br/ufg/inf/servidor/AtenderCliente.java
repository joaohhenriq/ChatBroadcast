package br.ufg.inf.servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class AtenderCliente implements Runnable{

	private Socket cli;
	
	public AtenderCliente(Socket cli) {
		this.cli = cli;
	}

	@Override
	public void run() {
		try {
			Scanner escutador = new Scanner(this.cli.getInputStream());
			
			do{
				String mensagem = escutador.nextLine();
				ServidorChat.distribuirMensagem(mensagem,this.cli);
			}while(true);
			
		} catch (IOException e) {
			ServidorChat.remover(cli);
		} catch (java.util.NoSuchElementException e) {
			ServidorChat.remover(cli);
		}
		
	}
	
	

}
