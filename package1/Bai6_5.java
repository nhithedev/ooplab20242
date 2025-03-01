package package1;

//6.5
import java.util.Arrays;
import java.util.Scanner;

public class Bai6_5 {
  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int sum = 0;
      float average = 0;
      
      System.out.print("Nhap n:  ");
      int size = scan.nextInt();
      int[] array = new int[size];

      System.out.print("Nhap cac phan tu: ");
      for (int i = 0; i < size; i++) {
          array[i] = scan.nextInt();
          sum += array[i];
      }
      average = (float) sum / array.length;

      insertionSort(array);
      
      System.out.println("Mang duoc sap xep: " + Arrays.toString(array));
      System.out.println("Trung binh cong cua mang: " + average);
      System.out.println("Tong cua mang: " + sum);

      scan.close();
  }

  public static void insertionSort(int[] array) {
      int n = array.length;
      for (int i = 1; i < n; i++) {
          int val = array[i];
          int j = i - 1;
          while (j >= 0 && array[j] > val) {
              array[j + 1] = array[j];
              j--;
          }
          array[j + 1] = val;
      }
  }
}