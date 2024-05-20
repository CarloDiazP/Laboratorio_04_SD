package Propuesto2;

import java.rmi.Naming;
import java.util.Scanner;

public class CreditCardClient {
  public static void main(String[] args) {
    try {
      CreditCardSystem creditCardSystem = (CreditCardSystem) Naming.lookup("rmi://localhost/CreditCardSystem");
      Scanner sc = new Scanner(System.in);

      String card;

      System.out.print("Ingrese su número de tarjeta: ");
      card = sc.nextLine();

      if (!creditCardSystem.validateCard(card)) {
        System.out.println("Tarjeta inválida");
        sc.close();
        return;
      }

      boolean running = true;
      int option;
      double precio;

      while (running) {
        System.out.print("1. Consultar crédito\n2. Realizar compra\n3. Salir\nOpción: ");
        option = sc.nextInt();

        switch (option) {
          case 1:
            System.out.println("Tu crédito es de " + creditCardSystem.getBalance(card));
            break;

          case 2:
            System.out.println("Ingrese precio de compra: ");
            precio = sc.nextDouble();
            if (!creditCardSystem.chargeCard(card, precio)) {
              System.out.println("Compra no válida.");
              break;
            }
            System.out.println("Crédito actualizado: " + creditCardSystem.getBalance(card));
            break;

          case 3:
            running = false;
            break;

          default:
            System.out.println("Ingrese una opción válida.");
        }

      }
      sc.close();
    } catch (Exception e) {
      System.err.println("Client exception: " + e.toString());
      e.printStackTrace();
    }
  }
}