import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
	
		public double  Saldo_Medio(double saldo)throws RemoteException;
}