import java.util.Scanner;

/**
 * 
 * @author Ming 
 * 2115. [모의 SW 역량테스트] 벌꿀채취 
 * 2018.02.01 3:50 ~ 2018.02.12
 * 부분집합 만들때, sub(i, j - 1, 0, 0, 0);
 * 2개의 집합의 최대값 구할 때, visit 활용하고 g2의 x범위는 0부터가 아니라 g1의 x값 부터!
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

	// sub(시작행, 시작열, 제곱합, 벌꿀합, 부분집합 갯수)
	private static void sub(int i, int j, int multi, int sum, int num) {
		// 부분집합 갯수 제한
		if (num > m) {
			return;
		}

		// 벌꿀합 제한
		if (sum > c) {
			return;
		}

		total = Math.max(total, multi);

		sub(i, j + 1, multi + (a[i][j + 1] * a[i][j + 1]), sum + a[i][j + 1], num + 1); // 다음 값을 포함하는 경우
		sub(i, j + 1, multi, sum, num + 1); // 다음 값을 포함하지 않는 경우
	}

}
