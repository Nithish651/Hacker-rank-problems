package com.interviewPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MissingNumbers {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        List<Integer> result = missingNumbers(arr, brr);
        System.out.println(result);
        
        bufferedReader.close();
        
	}

	private static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
		List<Integer> missingNumbers = new ArrayList<>();
		Map<Integer, Integer> freqMap = new TreeMap<>();

		for (int i = 0; i < brr.size(); i++) {
			freqMap.put(brr.get(i), freqMap.getOrDefault(brr.get(i), 0) + 1);
		}

		for (int i = 0; i < arr.size(); i++) {
			freqMap.put(arr.get(i), freqMap.getOrDefault(arr.get(i), 0) - 1);
		}

		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {

			if (entry.getValue() > 0) {
				missingNumbers.add(entry.getKey());
			}

		}

		return missingNumbers;
	}

}
