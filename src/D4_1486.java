import java.util.Scanner;

/**
 * 
 * @author Ming 
 * 1486. 장훈이의 높은 선반 
 * 2018.02.05
 *
 */
public class D4_1486 {
	static int n, b, ans, total;
	static int[] a;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int k = 1; k <= t; k++) {
			n = sc.nextInt();
			b = sc.nextInt();
			a = new int[n + 1];

			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

			total = Integer.MAX_VALUE;
			ans = 0;

			for (int j = 0; j < n; j++) {
				getSub(a[j], j);
			}

			System.out.println("#" + k + " " + ans);
		}

	}

	private static void getSub(int sum, int num) {
		if (num == n) {
			return;
		}

		if (sum >= b) {
			if (total > sum) {
				total = sum;
				ans = total - b;
			}
			return;
		}

		getSub(sum + a[num + 1], num + 1);
		getSub(sum, num + 1);

	}

}
