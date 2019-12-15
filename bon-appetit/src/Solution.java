import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

	// Complete the bonAppetit function below.
	private static void bonAppetit(List<Integer> bill, int k, int b) {
		int totalPrice  = bill.stream().mapToInt(price -> price).sum();
		int commomShare = totalPrice - bill.get(k);
		int annasShare = commomShare / 2;

		if (b == annasShare) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println(b - annasShare);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");


		int k = Integer.parseInt(nk[1]);

		List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		int b = Integer.parseInt(bufferedReader.readLine().trim());

		bonAppetit(bill, k, b);

		bufferedReader.close();
	}
}
