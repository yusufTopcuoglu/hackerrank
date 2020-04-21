import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the gridSearch function below.
	static String gridSearch(String[] G, String[] P) {
		int gridRow = G.length, gridColumn = G[0].length();
		int patternRow = P.length, patternColumn = P[0].length();

		for (int i = 0; i <= gridRow - patternRow; i++) {
			for (int j = 0; j <= gridColumn - patternColumn; j++) {
				boolean broken = false;
				for (int k = 0; k < patternRow; k++) {
					for (int l = 0; l < patternColumn; l++) {
						if (G[i + k].charAt(j + l) != P[k].charAt(l)) {
							broken = true;
							break;
						}
					}
					if (broken) {
						break;
					}
				}
				if (!broken) {
					return "YES";
				}
			}
		}
		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String[] RC = scanner.nextLine().split(" ");

			int R = Integer.parseInt(RC[0]);

			int C = Integer.parseInt(RC[1]);

			String[] G = new String[R];

			for (int i = 0; i < R; i++) {
				String GItem = scanner.nextLine();
				G[i] = GItem;
			}

			String[] rc = scanner.nextLine().split(" ");

			int r = Integer.parseInt(rc[0]);

			int c = Integer.parseInt(rc[1]);

			String[] P = new String[r];

			for (int i = 0; i < r; i++) {
				String PItem = scanner.nextLine();
				P[i] = PItem;
			}

			String result = gridSearch(G, P);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
