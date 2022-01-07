package com.interviewPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinimumAbsoluteDifference {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
     
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int result =minimumAbsoluteDifference(arr);

      System.out.println(result);

        bufferedReader.close();
      
		
	}

	private static int minimumAbsoluteDifference(List<Integer> arr) {
		//The solution timed out. must be optimised/
		//int minDiff = Integer.MAX_VALUE;
		
		//for(int i=0; i < arr.size(); i++) {
			//for(int j=i+1; j<arr.size(); j++) {
				//int currentDiff = Math.abs(arr.get(i)-arr.get(j));
				//minDiff = (minDiff > currentDiff)? currentDiff : minDiff; 
			//}
		//}
		//return minDiff;
		int minDiff = Integer.MAX_VALUE;
		Collections.sort(arr);
		for(int i=0; i< arr.size()-1; i++) {
			int currentDiff = Math.abs(arr.get(i) - arr.get(i+1));
			minDiff = Math.min(minDiff, currentDiff);
		}
		return minDiff;
	}

}
