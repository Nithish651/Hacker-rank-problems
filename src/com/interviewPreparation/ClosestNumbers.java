package com.interviewPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClosestNumbers {
	
	
    public static List<Integer> closestNumbers(List<Integer> arr) {
    	Map<Integer,List<Integer>> diffMap = new HashMap<>();
    	int minDiff = Integer.MAX_VALUE;
    	Collections.sort(arr);
    	for(int i=1; i < arr.size(); i++) {
    		int diff = arr.get(i) - arr.get(i-1);
    		if(minDiff >= diff) {
    			if(!diffMap.containsKey(diff)) {
    				List<Integer> temp = new ArrayList<>();
    				temp.add(arr.get(i-1));
    				temp.add(arr.get(i));
    				diffMap.put(diff, temp);
    			}else {
    				diffMap.get(diff).add(arr.get(i-1));
    				diffMap.get(diff).add(arr.get(i));
    			}
    			minDiff = diff;
    		}
    	}
    	return diffMap.get(minDiff);
    }
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<Integer> result = closestNumbers(arr);

       System.out.println( result.stream()
               .map(Object::toString)
               .collect(Collectors.joining(" "))
           + "\n");
           
        

        bufferedReader.close();
   
	}

}
