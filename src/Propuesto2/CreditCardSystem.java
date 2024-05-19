package Propuesto2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CreditCardSystem extends Remote {
  void registerCard(String cardNumber, double balance) throws RemoteException;

  boolean validateCard(String cardNumber) throws RemoteException;

  double getBalance(String cardNumber) throws RemoteException;

  boolean chargeCard(String cardNumber, double amount) throws RemoteException;
}
