import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	/*
	 * Complete the twoTwo function below.
	 */
	static int twoTwo(String a) {
		Node root = new Node('-');
		for (int i = 0; i <= 800; i++) {
			String s = String.valueOf(BigInteger.valueOf(2).pow(i));
			Node temp = root;
			for (int j = 0; j < s.length(); j++) {
				temp = temp.get(s.charAt(j));
			}
			temp.followings.put('*', new Node('-'));

		}
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			Node node = root;
			for (int j = i; j < a.length(); j++) {
				if (!node.followings.containsKey(a.charAt(j))) {
					break;
				}
				node = node.followings.get(a.charAt(j));
				if (node.followings.containsKey('*')) {
					count++;
				}
			}
		}

		return count;
	}

	private static class Node {
		Character c;
		HashMap<Character, Node> followings = new HashMap<>();

		public Node(Character c) {
			this.c = c;
		}

		public Node get(Character key) {
			return followings.computeIfAbsent(key, Node::new);
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(scanner.nextLine().trim());

		for (int tItr = 0; tItr < t; tItr++) {
			String a = scanner.nextLine();

			int result = twoTwo(a);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();
	}
}
