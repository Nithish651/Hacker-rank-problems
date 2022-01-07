package com.interviewPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxMin {
	
	
	public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int result = maxMin(k, arr);

        System.out.println(result);

        bufferedReader.close();
        
	}

	private static int maxMin(int k, List<Integer> arr) {
		Collections.sort(arr);
		int minDiff = Integer.MAX_VALUE;
		for(int i=0; i <= arr.size() - k; i++) {
			int diff = arr.get(i+k-1) - arr.get(i);
			minDiff = (minDiff > diff)?diff:minDiff;			
		}
		return minDiff;
	}

}
