import java.io.*;

public class Solution {

	static final int TRANSITION_YEAR = 1918;

	// Complete the dayOfProgrammer function below.
	private static String dayOfProgrammer(int year) {
		if (year == TRANSITION_YEAR) {
			return "26.09.1918";
		}

		try {
			Calender calender = CalenderFactory.createCalender(year);
			return calender.getDate();

		} catch (IllegalArgumentException e) {
			return "Illegal argument, year must be in range [1700, 2700]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int year = Integer.parseInt(bufferedReader.readLine().trim());

		String result = dayOfProgrammer(year);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
