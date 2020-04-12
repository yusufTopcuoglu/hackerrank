import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {

	// Complete the findDigits function below.
	static int findDigits(int n) {
		List<Integer> digits = new ArrayList<>();
		HashMap<Integer, Boolean> lookUpMap = new HashMap<>();
		lookUpMap.put(0, false);
		int divisorCount = 0;
		int nCopy = n;
		while (nCopy > 0) {
			digits.add(nCopy % 10);
			nCopy /= 10;
		}

		for (int digit : digits) {
			if (lookUpMap.containsKey(digit)) {
				if (lookUpMap.get(digit)) {
					divisorCount++;
				}
			} else {
				boolean isDivisor = (n % digit) == 0;
				lookUpMap.put(digit, isDivisor);
				if (isDivisor) {
					divisorCount++;
				}
			}
		}

		return divisorCount;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int result = findDigits(n);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
