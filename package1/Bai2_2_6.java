package package1;

//2.2.6
import java.util.Scanner;
import java.lang.Math;

public class Bai2_2_6 {
  public static void main(String[] args) {
  	
      Scanner scan = new Scanner(System.in);

      System.out.println("1. Pt bac 1");
      System.out.println("2. He pt tuyen tinh 2 an");
      System.out.println("3. Pt bac 2");
      System.out.print("Chon: ");
      int choice = scan.nextInt();
      System.out.println("===========================");
      switch (choice) {
          case 1:{
              System.out.println("Pt: ax + b = 0");
              System.out.print("Nhap a: ");
              double a = scan.nextDouble();
              System.out.print("Nhap b: ");
              double b = scan.nextDouble();

              if (a == 0) 
              	System.out.println("Vo nghiem" );
              else 
              	System.out.println("x = " + -b/a);
              break;
          }
          case 2:{
              System.out.println("Pt 1: a11x + a12 = b1");
              System.out.println("Pt 2: a22x + a22 = b2");
              System.out.print("Nhap a11: ");
              double a11 = scan.nextDouble();
              System.out.print("Nhap a12: ");
              double a12 = scan.nextDouble();
              System.out.print("Nhap b1: ");
              double b1 = scan.nextDouble();
              System.out.print("Nhap a21: ");
              double a21 = scan.nextDouble();
              System.out.print("Nhap a22: ");
              double a22 = scan.nextDouble();
              System.out.print("Nhap b2: ");
              double b2 = scan.nextDouble();

              double D = a11 * a22 - a21 * a12;
              double D1 = b1 * a22 - b2 * a12;
              double D2 = a11 * b2 - a21 * b1;

              if (D != 0) 
              	System.out.println("x = " + D1/D + " y = " + D2/D);
              else {
                  if (D1 == 0 && D2 == 0) 
                  	System.out.println("Vo so nghiem");
                  else if (D1 != 0 || D2 != 0) 
                  	System.out.println("Vo nghiem");
              }
              break;
          }
          case 3:{
              System.out.println("Pt ax^2 + bx + c = 0");
              System.out.print("Nhap a: ");
              double a = scan.nextDouble();
              System.out.print("Nhap b: ");
              double b = scan.nextDouble();
              System.out.print("Nhap c: ");
              double c = scan.nextDouble();

              if (a == 0){
                  if (b == 0){
                      if (c == 0) System.out.println("Vo so nghiem");
                      else System.out.println("Vo nghiem");
                  }
                  else System.out.println("x = " + -c/b );
              }
              else {
                  double delta = b*b - 4*a*c;
                  if (delta < 0) 
                  	System.out.println("Vo nghiem");
                  else if (delta == 0) System.out.println("x1 = x2 = " + -b/(2*a));
                  else {
                      double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                      double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                      System.out.println("x1 = " + x1 + " x2 = " + x2);
                  }
              }
              break;
          }
      }
      scan.close();
  }
}
