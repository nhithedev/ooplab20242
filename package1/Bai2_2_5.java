package package1;

//2.2.5
import javax.swing.JOptionPane;

public class Bai2_2_5 {
  public static void main(String[] args) {
      String strNum1, strNum2, strNotification, operation;

      strNum1 = JOptionPane.showInputDialog(null,
              "Please input the first number:", 
              JOptionPane.INFORMATION_MESSAGE);

      strNum2 = JOptionPane.showInputDialog(null,
              "Please input the second number:", 
              JOptionPane.INFORMATION_MESSAGE);
      
      operation = JOptionPane.showInputDialog("Chon phep toan (cong, tru, nhan, chia):");
      
      double num1 = Double.parseDouble(strNum1);
      double num2 = Double.parseDouble(strNum2);
      double result;

      switch (operation.toLowerCase()) {
          case "cong":
              result = num1 + num2;
              strNotification = num1 + " + " + num2 + " = " + result;
              break;
          case "tru":
              result = num1 - num2;
              strNotification = num1 + " - " + num2 + " = " + result;
              break;
          case "nhan":
              result = num1 * num2;
              strNotification = num1 + " * " + num2 + " = " + result;
              break;
          case "chia":
              if (num2 != 0) {
                  result = num1 / num2;
                  strNotification = num1 + " / " + num2 + " = " + result;
              } else {
                  strNotification = "Khong chia duoc cho 0.";
              }
              break;
          default:
              strNotification = "Phep toan khong hop le!";
              break;
      }

      JOptionPane.showMessageDialog(null, strNotification,
              "Phep toan:", JOptionPane.INFORMATION_MESSAGE);

      System.exit(0);
  }
}