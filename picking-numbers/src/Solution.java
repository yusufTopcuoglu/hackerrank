import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {


	public static int pickingNumbers(List<Integer> a) {
		HashMap<Integer, Integer> countingMap = new HashMap<>();

		for (Integer aInt :	a) {
			countingMap.put(aInt, countingMap.getOrDefault(aInt, 0) + 1);
			countingMap.put(aInt-1, countingMap.getOrDefault(aInt-1, 0) + 1);
		}

		return countingMap.values().stream().max(Integer::compareTo).orElse(-1);
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		int result = Result.pickingNumbers(a);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
