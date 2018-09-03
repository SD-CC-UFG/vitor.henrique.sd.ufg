package teste;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class cliente {
		
		//Sem tratamento de Excecao.
		public static void main(String []args) throws Exception {
			
		//Criando objeto Socket para estabelecer uma conexao com o servidor.
		
		System.out.println("Iniciando cliente.");
		
		System.out.println("Iniciando conexao com o servidor.");	
			
		//devemos informar o ip e a porta do servidor
		
		//como esta na mesma maquina usa-se localhost(127.0.0.1.)
		Socket socket = new Socket("localhost", 2525);
		
		System.out.println("Conexao Estabelecida.");
		
		//por meio do objeto socket, podemos enviar dados para o servidor
		//para isso precisamos trabalhar com objeto de entrada e saida de dados associados a conexao
		
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		PrintStream out = new PrintStream(output);
		
		// vamos implementar um logica q ecoa a mensagem recebidfa do cliente, se ele escrever fim a conexao termina.
		// se a mensagem for fim, encerra o laco
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("Digite uma mensagem: ");
			String mensagem = scanner.nextLine();
			
			out.println(mensagem);
			
			if("FIM".equals(mensagem)) {
				break;
			}
			
			mensagem = in.readLine();
			
			//imprima a mensagem no console
		
				System.out.println(
						"Mensagem recebida do servidor: "
						+mensagem);
		}
			System.out.println("Encerrando Conexao");
			
			in.close();
			
			out.close();
			
			socket.close();
			
			
			
		
		
		
		}
}
