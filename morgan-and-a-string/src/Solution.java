import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the morganAndString function below.
	static String morganAndString(String a, String b) {
		StringBuilder result = new StringBuilder();
		int aIndex = 0;
		int bIndex = 0;
		int i, j;

		while (aIndex < a.length() && bIndex < b.length()) {
			if (a.charAt(aIndex) < b.charAt(bIndex)) {
				result.append(a.charAt(aIndex++));
				while (aIndex < a.length() && a.charAt(aIndex) == a.charAt(aIndex-1)) {
					result.append(a.charAt(aIndex++));
				}
			} else if (a.charAt(aIndex) > b.charAt(bIndex)) {
				result.append(b.charAt(bIndex++));
				while (bIndex < b.length() && b.charAt(bIndex) == b.charAt(bIndex-1)) {
					result.append(b.charAt(bIndex++));
				}
			} else {
				for (i = aIndex, j = bIndex ; i < a.length() && j < b.length(); i++, j++) {
					if (a.charAt(i) < b.charAt(j)) {
						result.append(a.charAt(aIndex++));
						while (aIndex < a.length() && a.charAt(aIndex) == a.charAt(aIndex-1)) {
							result.append(a.charAt(aIndex++));
						}
						break;
					}
					if (a.charAt(i) > b.charAt(j)) {
						result.append(b.charAt(bIndex++));
						while (bIndex < b.length() && b.charAt(bIndex) == b.charAt(bIndex-1)) {
							result.append(b.charAt(bIndex++));
						}
						break;
					}
				}

				if (i == a.length()) {
					result.append(b.charAt(bIndex++));
					while (bIndex < b.length() && b.charAt(bIndex) == b.charAt(bIndex-1)) {
						result.append(b.charAt(bIndex++));
					}
				} else if (j == b.length()){
					result.append(a.charAt(aIndex++));
					while (aIndex < a.length() && a.charAt(aIndex) == a.charAt(aIndex-1)) {
						result.append(a.charAt(aIndex++));
					}
				}
			}
		}

		if (aIndex < a.length()) {
			result.append(a.substring(aIndex));
		}
		if (bIndex < b.length()) {
			result.append(b.substring(bIndex));
		}


		return result.toString();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String a = scanner.nextLine();

			String b = scanner.nextLine();

			String result = morganAndString(a, b);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
