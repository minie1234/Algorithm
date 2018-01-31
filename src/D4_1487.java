import java.util.Scanner;

/**
 * 
 * @author Ming 
 * 1487. �κ� ���� �� ���ϱ� 
 * 2018.02.01 3:20 ~ 3:40 20s
 * 
 * sum>w �� ��� return�� �����༭ ���ѽð� �ʰ��� ������.
 *
 */
public class D4_1487 {
	static int n, w, cnt;
	static int[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int k = 1; k <= t; k++) {
			n = sc.nextInt();
			w = sc.nextInt();
			a = new int[n + 1];
			cnt = 0;

			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

			for (int i = 0; i < n; i++) {
				sub(i, a[i]);
			}

			System.out.println("#" + k + " " + cnt);
		}
	}

	private static void sub(int i, int sum) {
		// TODO Auto-generated method stub
		if (i == n) {
			return;
		}
		if (sum > w) {
			return;
		}
		if (sum == w) {
			cnt++;
			return;
		}

		sub(i + 1, sum + a[i + 1]);
		sub(i + 1, sum);

	}

}
