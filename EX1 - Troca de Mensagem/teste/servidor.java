package teste;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

// servidor tcp/ip

public class servidor {
	//sem tratamento 
	public static void main(String[] args) throws Exception{
		
		System.out.println("Iniciando conecao com o servidor");
	
		//Objeto ServerSocket para assosciar o servico a uma porta logica
		//os clientes irão estao estabelecer conexao utilizando endeeco ip e a porta do servidor
		
		ServerSocket server = new ServerSocket(2525);
		//invoquei o metodo accept() do objeto serverSocket para que o servidor passe a receber conexoes do cliente
		
		System.out.println("Aguardando Conexao dos Clientes.");
		
		//invoquei o metodo accept() do objeto serverSocket para que o servidor passe a receber conexoes do cliente
		//o metodo accept() espera novas conexoes, e quando for estabelecida ele retorna um objeto socket conectado ao cliente
		
		Socket socket = server.accept();
		
		// com o objeto socket podemos receber os dados do cliente.
		System.out.println("Conexao Estabelecida.");
		
		//InputStream do Cliente esta conetadodo ao OutputStream do Servidor e vice versa(Input do servidor ao output do cliente)
		//Quando um grava o outro le e vice versa
		
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();
		
		//Podemos transformar o InputStream que oferece leitura de bytes em um BufferedReader que oferece leitura de Strings
		
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		
		//tambem, podemos transformar um Outputsream q oferece gravacao de bytes em PrintStream que grava Strings
		
		PrintStream out = new PrintStream(output);
		//com tudo isso podemos ler mensagens do cliente e gravar para o cliente
		// Ou seja, a estrutura do servidor esta pronta
		
		// vamos implementar um logica q ecoa a mensagem recebidfa do cliente, se ele escrever fim a conexao termina.
		
		while(true) {
			String mensagem = in.readLine();
			System.out.println(""
					+ "Mensagem Recebida do Cliente "+ 
					socket.getInetAddress().getHostName() + 
					" :"+mensagem);
			
			// se a mensagem for fim, encerra o laco
			if("FIM".equals(mensagem)) {
				break;
			}
			
			out.println(mensagem);
		}
		
		//Ao final encerrar a conexao;
		System.out.println("Encerrando Conexao.");
		
		//fechando inputStream
		in.close();
		//fechadno outputStream
		out.close();
		
		//fechando socket
		socket.close();
		
		//Resumindo, este é um servidor de uma thead e atende apenas um cliente
		//quando o socket cliente grava, o socket server le
		
		System.out.println("Encerrando o Servidor.");
		
		//fechamos o serversocket
		server.close();
	}
	

}
