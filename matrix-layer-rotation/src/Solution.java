import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

	static int circleCount;

	// Complete the matrixRotation function below.
	static void matrixRotation(List<List<Integer>> matrix, int r) {
		int m = matrix.size();
		int n = matrix.get(0).size();

		circleCount = Math.min(m, n) / 2;

		// get outer circles of matrix
		List<List<Integer>> outerCircles = getOuterCircles(matrix);

		// reverse each outer circle
		for (List<Integer> circle : outerCircles) {
			Collections.rotate(circle, -r);
		}

		// rebuild the matrix from outer circle lists
		List<List<Integer>> rotatedMatrix = constructMatrixFromOuterCircles(m, n, outerCircles);

		printMatrix(rotatedMatrix);
	}

	private static List<List<Integer>> constructMatrixFromOuterCircles(int m, int n, List<List<Integer>> outerCircles) {
		List<List<Integer>> matrix = getMatrixOf(m, n);


		for (int i = 0; i < circleCount; i++, m--, n--) {
			List<Integer> circle = outerCircles.get(i);
			int verticalCount = m - i - 2;
			int horizontalCount = n - i;

			for (int j = i, k = 0; j < n; j++, k++) {
				matrix.get(i).set(j, circle.get(k));
			}

			for (int j = i + 1, k = horizontalCount; j < m - 1; j++, k++) {
				matrix.get(j).set(n - 1, circle.get(k));
			}

			for (int j = i, k = 2 * horizontalCount + verticalCount - 1; j < n; j++, k--) {
				matrix.get(m - 1).set(j, circle.get(k));
			}

			for (int j = i + 1, k = circle.size() - 1; j < m - 1; j++, k--) {
				matrix.get(j).set(i, circle.get(k));
			}
		}

		return matrix;
	}

	private static List<List<Integer>> getMatrixOf(int m, int n) {
		List<List<Integer>> matrix = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				row.add(0);
			}
			matrix.add(row);
		}
		return matrix;
	}


	static List<List<Integer>> getOuterCircles(List<List<Integer>> matrix) {
		List<List<Integer>> outerCircles = new ArrayList<>(circleCount);
		for (int i = 0; i < circleCount; i++) {
			outerCircles.add(getOuterCircle(matrix));
			int m = matrix.size();
			int n = matrix.get(0).size();

			// remove border from list
			matrix.remove(0);
			matrix.remove(m - 2);
			for (int j = 0; j < m - 2; j++) {
				matrix.get(j).remove(0);
				matrix.get(j).remove(n - 2);
			}
		}

		return outerCircles;
	}

	static void printMatrix(List<List<Integer>> matrix) {
		int m = matrix.size();
		int n = matrix.get(0).size();

		for (List<Integer> row : matrix) {
			for (int j = 0; j < n; j++) {
				System.out.print(row.get(j) + " ");
			}
			System.out.println();
		}
		System.out.println();

	}


	static List<Integer> getOuterCircle(List<List<Integer>> matrix) {
		int m = matrix.size();
		int n = matrix.get(0).size();

		// add up border
		List<Integer> outerCircle = new ArrayList<>(matrix.get(0));

		//add right border
		for (int i = 1; i < m - 1; i++) {
			outerCircle.add(matrix.get(i).get(n - 1));
		}

		// add revere of bottom border
		List<Integer> lastRow = matrix.get(m - 1);
		Collections.reverse(lastRow);
		outerCircle.addAll(lastRow);

		// add reverse of left border
		for (int i = m - 2; i > 0; i--) {
			outerCircle.add(matrix.get(i).get(0));
		}

		return outerCircle;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int m = Integer.parseInt(mnr[0]);

		int n = Integer.parseInt(mnr[1]);

		int r = Integer.parseInt(mnr[2]);

		List<List<Integer>> matrix = new ArrayList<>();

		IntStream.range(0, m).forEach(i -> {
			try {
				matrix.add(
						Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
								.map(Integer::parseInt)
								.collect(toList())
				);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		matrixRotation(matrix, r);

		bufferedReader.close();
	}
}
