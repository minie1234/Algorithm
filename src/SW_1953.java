import java.util.*;

/**
 * 
 * @author Ming  
 * 1953.[모의 SW 역량테스트] 탈주범 검거 
 * 2018.01.24 18:20 ~ 20:40 1h 20s
 */
class Pair {
	int x, y, time;

	Pair(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

public class SW_1953 {

	static int n, m, sx, sy, L, ans, cnt;
	static int[][] a;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visit;
	static Queue<Pair> q = new LinkedList<Pair>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int k = 1; k <= t; k++) {

			n = sc.nextInt();
			m = sc.nextInt();
			sx = sc.nextInt();
			sy = sc.nextInt();
			L = sc.nextInt();
			a = new int[n + 1][m + 1];
			visit = new boolean[n + 1][m + 1];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			ans = 0;
			visit[sx][sy] = true;
			q.add(new Pair(sx, sy, 1));
			bfs();
			calc();
			ans = cnt;
			System.out.println("#" + k + " " + ans);
			//confirm();
		}
	}

	private static void calc() {
		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visit[i][j]) {
					cnt++;
				}
			}
		}
	}

	private static void confirm() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(visit[i][j] + "      ");
			}
			System.out.println();
		}

	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			int time = p.time;

			for (int k = 0; k < 4; k++) {

				// 현재 파이프별 방향 전환
				int dir = a[x][y];
				if (dir == 0) {
					continue;
				} else if (dir == 2 && (k == 2 || k == 3)) {
					continue;
				} else if (dir == 3 && (k == 0 || k == 1)) {
					continue;
				} else if (dir == 4 && (k == 1 || k == 2)) {
					continue;
				} else if (dir == 5 && (k == 0 || k == 2)) {
					continue;
				} else if (dir == 6 && (k == 0 || k == 3)) {
					continue;
				} else if (dir == 7 && (k == 1 || k == 3)) {
					continue;
				}

				int nx = x + dx[k];
				int ny = y + dy[k];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || a[nx][ny] == 0) {
					continue;
				}

				int d = a[nx][ny];

				// 다음 칸과 연결 여부 확인
				if (k == 0) { // 상
					if (d != 1 && d != 2 && d != 5 && d != 6) {
						continue;
					}
				} else if (k == 1) { // 하
					if (d != 1 && d != 2 && d != 4 && d != 7) {
						continue;
					}
				} else if (k == 2) { // 좌
					if (d != 1 && d != 3 && d != 4 && d != 5) {
						continue;
					}
				} else if (k == 3) { // 우
					if (d != 1 && d != 3 && d != 6 && d != 7) {
						continue;
					}
				}

				if (time >= L) {
					continue;
				}

				visit[nx][ny] = true;
				q.add(new Pair(nx, ny, time + 1));
			}
		}
	}
}
