import java.util.Scanner;

/**
 * 
 * @author Ming 
 * 2817. 부분 수열의 합 
 * 2018.02.01 2:30 ~ 3:00 30s
 *
 */

public class D3_2817 {
	static int n, k, cnt;
	static int[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x = 1; x <= t; x++) {
			n = sc.nextInt();
			k = sc.nextInt();
			a = new int[n + 1];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			cnt = 0;

			for (int i = 0; i < n; i++) {
				sub(i, a[i]);
			}

			System.out.println("#" + x + " " + cnt);
		}
	}

	private static void sub(int i, int sum) {
		if (i == n) {
			return;
		}
		if (sum == k) {
			cnt++;
			return;
		}
		sub(i + 1, sum + a[i + 1]);
		sub(i + 1, sum);
	}

}
