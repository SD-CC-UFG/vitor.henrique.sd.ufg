
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;


public class Cliente {
	

    public static void main(String[] args) throws NotBoundException,MalformedURLException,RemoteException {

    		double valor;
    	    Scanner input = new Scanner(System.in);
    		
    		System.out.println("Insira o valor do saldo medio do Cliente: ");
   		 	valor = input.nextDouble();
    		
    		 Interface inter = (Interface) Naming.lookup("rmi://localhost:1099/credito");
    		 
    		 valor = inter.Saldo_Medio(valor);
    		 }
    }
  
    
    
