import java.util.Scanner;

/**
 * 
 * @author Ming 
 * 2115. [���� SW �����׽�Ʈ] ����ä�� 
 * 2018.02.01 3:50 ~ 2018.02.12
 * �κ����� ���鶧, sub(i, j - 1, 0, 0, 0);
 * 2���� ������ �ִ밪 ���� ��, visit Ȱ���ϰ� g2�� x������ 0���Ͱ� �ƴ϶� g1�� x�� ����!
 *
 */

public class SW_2115 {
	static int n, m, c, total, ans;
	static int[][] a;
	static int[][] maxi;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int k = 1; k <= t; k++) {
			n = sc.nextInt();
			m = sc.nextInt();
			c = sc.nextInt();
			a = new int[n + 1][n + 1];
			maxi = new int[n + 1][n + 1];
			visit = new boolean[n + 1][n + 1];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= n - m; j++) {
					sub(i, j - 1, 0, 0, 0);
					maxi[i][j] = total;
					total = 0;
				}

			}
			ans = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= n - m; j++) {
					ans = Math.max(ans, MaxCalc(i, j));
				}
			}

			System.out.println("#" + k + " " + ans);
			confirm();
		}
	}

	private static int MaxCalc(int x, int y) {
		int g1 = maxi[x][y];
		int g2 = 0;

		for (int j = y; j < y + m; j++) {
			visit[x][j] = true;
		}

		for (int i = x; i < n; i++) {
			for (int j = 0; j <= n - m; j++) {
				if (!visit[i][j]) {
					g2 = Math.max(g2, maxi[i][j]);
				}
			}
		}
		return g1 + g2;

	}

	private static void init() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visit[i][j] = false;
			}
		}
	}

	private static void confirm() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(maxi[i][j] + " ");
			}
			System.out.println();
		}
	}

	// sub(������, ���ۿ�, ������, ������, �κ����� ����)
	private static void sub(int i, int j, int multi, int sum, int num) {
		// �κ����� ���� ����
		if (num > m) {
			return;
		}

		// ������ ����
		if (sum > c) {
			return;
		}

		total = Math.max(total, multi);

		sub(i, j + 1, multi + (a[i][j + 1] * a[i][j + 1]), sum + a[i][j + 1], num + 1); // ���� ���� �����ϴ� ���
		sub(i, j + 1, multi, sum, num + 1); // ���� ���� �������� �ʴ� ���
	}

}
