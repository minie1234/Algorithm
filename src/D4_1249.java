import java.util.*;

/**
 * 
 * @author Ming
 * 1249. [S/W 문제해결 응용] 4일차 - 보급로
 * 2018.01.27 9:30 ~ 11:00 1h 30s
 *
 */

public class D4_1249 {
	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, sx, sy, ex, ey;
	static int[][] a;
	static int[][] visit;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static Queue<Pair> q = new LinkedList<Pair>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int k = 1; k <= t; k++) {
			n = sc.nextInt();

			a = new int[n + 1][n + 1];
			visit = new int[n + 1][n + 1];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visit[i][j] = Integer.MAX_VALUE;
				}
			}
			sc.nextLine();
			for (int i = 0; i < n; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < n; j++) {
					a[i][j] = s.charAt(j) - '0';
				}
			}

			ex = n - 1;
			ey = n - 1;
			sx = 0;
			sy = 0;

			q.add(new Pair(sx, sy));
			visit[sx][sy] = 0;

			bfs();
			//confirm();
			System.out.println("#" + k + " " + visit[ex][ey]);
		}
	}

	private static void confirm() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(visit[i][j] + "   ");
			}
			System.out.println();
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}

				if (visit[nx][ny] > visit[x][y] + a[nx][ny]) {
					visit[nx][ny] = visit[x][y] + a[nx][ny];
					q.add(new Pair(nx, ny));

				}
			}

		}
	}

}
