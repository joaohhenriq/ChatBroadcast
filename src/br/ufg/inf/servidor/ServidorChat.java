package br.ufg.inf.servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorChat {

	private static List<Socket> clientes = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("Servidor conectado");
		
		do{
			Socket cli = servidor.accept();
			clientes.add(cli);
			new Thread(new AtenderCliente(cli)).start();
		}while(true);

	}
	
	public static void distribuirMensagem(String mensagem, Socket cli) throws IOException{
		
		for (Socket c : clientes) {
			PrintWriter pw = new PrintWriter(c.getOutputStream(),true);
			if (!(clientes.equals(cli))){
				pw.println(mensagem);
				System.out.println(mensagem);
			}
			
		}
	}

}
