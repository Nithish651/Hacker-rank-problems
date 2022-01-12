package com.interviewPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FullCountingSort {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        int n = Integer.parseInt(bufferedReader.readLine().trim());

	        List<List<String>> arr = new ArrayList<>();
	        
	        

	        IntStream.range(0, n).forEach(i -> {
	            try {
	                arr.add(
	                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	                        .collect(Collectors.toList())
	                );
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        });

	        countSort(arr);

	        bufferedReader.close();
	}

	private static void countSort(List<List<String>> arr) {
		StringBuffer [] buffArr = new StringBuffer[100];
		
		for(int i=0; i < 100; i++) {
			buffArr[i] = new StringBuffer();
		}
		
		int n = arr.size();
		for(int i=0; i < arr.size(); i++) {
			buffArr[Integer.parseInt(arr.get(i).get(0))].append((i < n/2) ? "- " : arr.get(i).get(1)+" "); 
		}
		
		for(int i=0; i < 100; i++) {
			System.out.print(buffArr[i].toString());
		}
	}

}
