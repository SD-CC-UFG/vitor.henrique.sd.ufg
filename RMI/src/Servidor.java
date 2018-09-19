import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Servidor {
    public static void main(String[] args) throws RemoteException,NotBoundException{
       
    	try {
    		 LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
    		 
    		 Registry reg = LocateRegistry.getRegistry("localhost");
    		 
    		 Interface inter = new Interfaceimpl();
    		 
    		 Naming.rebind("credito", inter);
    		 System.out.println("----O Servidor está funcionando----");
    		 } catch (Exception e) { }
    		 } 
}