package Propuesto2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class CreditCardSystemImpl extends UnicastRemoteObject implements CreditCardSystem {

  private Map<String, Double> cardDatabase;

  protected CreditCardSystemImpl() throws RemoteException {
    super();
    cardDatabase = new HashMap<>();

    registerCard("1234-5678-9101-1121", 500.0);
    registerCard("1111-2222-3333-4444", 1000.0);
    registerCard("5555-6666-7777-8888", 800.0);
  }

  @Override
  public void registerCard(String cardNumber, double balance) throws RemoteException {
    cardDatabase.put(cardNumber, balance);
  }

  @Override
  public boolean validateCard(String cardNumber) throws RemoteException {
    return cardDatabase.containsKey(cardNumber);
  }

  @Override
  public double getBalance(String cardNumber) throws RemoteException {
    return cardDatabase.getOrDefault(cardNumber, 0.0);
  }

  @Override
  public boolean chargeCard(String cardNumber, double amount) throws RemoteException {
    if (validateCard(cardNumber)) {
      double balance = cardDatabase.get(cardNumber);
      if (balance >= amount) {
        cardDatabase.put(cardNumber, balance - amount);
        return true;
      }
    }
    return false;
  }
}
