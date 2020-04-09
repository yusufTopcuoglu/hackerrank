import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	// Complete the stringSimilarity function below.
	static long stringSimilarity(String inputString) {
		long[] z = zFunction(inputString);
		return Arrays.stream(z).sum() + inputString.length();

	}

	private static long[] zFunction(String inputString) {
		int inputSize = inputString.length();
		long[] z = new long[inputSize];
		int left = 0, right = 0;
		for (int i = 1; i < inputSize; i++) {
			if (i > right) {
				left = right = i;
				while (right < inputSize && inputString.charAt(right-left) == inputString.charAt(right)) {
					right++;
				}
				z[i] = right-left;
				right--;
			} else {
				int k = i-left;
				if (z[k] < right-i+1) {
					z[i] = z[k];
				} else {
					left = i;
					while (right < inputSize && inputString.charAt(right-left) == inputString.charAt(right)) right++;
					z[i] = right-left; right--;
				}
			}
		}
		return z;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String s = scanner.nextLine();

			long result = stringSimilarity(s);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
