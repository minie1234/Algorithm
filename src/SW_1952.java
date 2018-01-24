import java.util.Scanner;

/**
 * 
 * @author Ming
 * 1952. [모의 SW 역량테스트] 수영장
 */

public class SW_1952 {

	static int[] day;
	static int[] month;
	static int[] plan;
	static int[] d;
	static int ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int k = 0;

		while (k++ < t) {

			// 각 비용
			int cday = sc.nextInt();
			int cmonth = sc.nextInt();
			int cthree = sc.nextInt();
			int cyear = sc.nextInt();

			// 이용권 배열
			plan = new int[13];
			day = new int[13];
			month = new int[13];
			d = new int[13];

			// 이용 계획
			for (int i = 1; i <= 12; i++) {
				plan[i] = sc.nextInt();
			}

			// 이용권 비용
			for (int i = 1; i <= 12; i++) {
				if (plan[i] != 0) {
					month[i] = cmonth;
				}
				day[i] = plan[i] * cday;
				day[i] = Math.min(month[i], day[i]);
			}

			// 최소 비용 계산
			for (int i = 1; i <= 2; i++) {
				d[i] = d[i - 1] + day[i];
			}

			for (int i = 3; i <= 12; i++) {
				d[i] = Math.min(d[i - 1] + day[i], cthree + d[i - 3]);
			}

			// year과 비교
			ans = Math.min(d[12], cyear);
			System.out.println("#" + k + " " + ans);
		}
	}

}
