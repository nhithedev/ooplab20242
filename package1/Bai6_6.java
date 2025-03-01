package package1;

//6.6
import java.util.Scanner;

public class Bai6_6 {
  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      System.out.print("Nhap so hang, so cot cua ma tran: ");
      int r = scan.nextInt();
      int c = scan.nextInt();

      int[][] matrice1 = new int[r][c];
      int[][] matrice2 = new int[r][c];
      int[][] ans = new int[r][c];

      System.out.println("Nhap ma tran 1: ");
      for (int i = 0; i < r; i++) {
          for (int j = 0; j < c; j++) {
              matrice1[i][j] = scan.nextInt();
          }
      }
      System.out.println("Nhap ma tran 2: ");
      for (int i = 0; i < r; i++) {
          for (int j = 0; j < c; j++) {
              matrice2[i][j] = scan.nextInt();
              ans[i][j] = matrice1[i][j] + matrice2[i][j];
          }
      }
      System.out.println("Tong 2 ma tran : ");
      for (int i = 0; i < r; i++) {
          for (int j = 0; j < c; j++) {
              System.out.print(ans[i][j] + " ");
          }
          System.out.println();
      }
    
      scan.close();

  }
}