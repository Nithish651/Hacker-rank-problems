package com.interviewPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DynamicArray {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int q = Integer.parseInt(firstMultipleInput[1]);

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(Collectors.toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> result = dynamicArray(n, queries);
		System.out.println(result);

		bufferedReader.close();

	}

	private static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		List<Integer> result = new ArrayList<>();
		List<List<Integer>> seqList = new ArrayList<List<Integer>>();

		for (int i = 0; i < n; i++) {
			seqList.add(new ArrayList<Integer>());
		}

		int lastAnswer = 0;
		for (List<Integer> query : queries) {
			switch (query.get(0)) {
			case 1:
				int index1 = ((query.get(1) ^ lastAnswer) % n);
				List<Integer> se = seqList.get(index1);
				se.add(query.get(2));
				break;

			case 2:
				int index2 = ((query.get(1) ^ lastAnswer) % n);
				List<Integer> seq = seqList.get(index2);
				int colIndex = query.get(2) % seq.size();
				lastAnswer = seq.get(colIndex);
				result.add(lastAnswer);
				break;

			}
		}
		return result;
	}

}
