import java.util.Scanner;

/**
 * 
 * @author Ming
 * 1265. [S/W 문제해결 응용] 9일차 - 달란트2
 */

public class D5_1265 {
   static long[][] cache;

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      int k = 1;
      while (k <= t) {
         int n = sc.nextInt();
         int p = sc.nextInt();
         cache = new long[n + 1][p + 1];

         System.out.println("#" + k + " " + candyDivide(n, p));
         k++;
      }

   }

   private static long candyDivide(int n, int p) {
      if (cache[n][p] != 0) {
         return cache[n][p];
      }

      if (p == 1) {
         return cache[n][p] = n;
      }

      long ans = 0;
      for (int a = 1; a <= n - p + 1; a++) {
         long tmp = a * candyDivide(n - a, p - 1);
         if (tmp > ans) {
            
            
            ans = tmp;
         }
      }
      return cache[n][p] = ans;

   }

}