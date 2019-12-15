import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	/*
	 * Complete the pageCount function below.
	 */
	private static int pageCount(int n, int p) {
		if (p > n/2) {
			if (n % 2 == 0) {
				if (p % 2 != 0)
					p = p - 1;
			}

			return (n - p) / 2;
		} else {
			return p/2;
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int p = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int result = pageCount(n, p);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
