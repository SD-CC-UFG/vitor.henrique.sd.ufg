import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

	public class Interfaceimpl extends UnicastRemoteObject implements Interface {
	 
		public Interfaceimpl() throws RemoteException {
			super();
	    }
		double saldo,credito = 0;
	 

		@Override
		public double Saldo_Medio(double saldo) throws RemoteException {
				if(saldo>0 && saldo<200) {
					return credito = 0;
				}
				else if(saldo > 200 && saldo<400) {
					return credito = saldo * 0.2;
				}
				else if(saldo > 400 && saldo < 600) {
					return credito = saldo*0.3;
				}
				else
				return credito = saldo* 0.4;
		}
		
		
		
		
	}