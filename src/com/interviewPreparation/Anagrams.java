package com.interviewPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Anagrams {

	
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       
        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = anagram(s);
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

	}

	private static int anagram(String s) {

		int result = 0;

		if (s.length() % 2 != 0) {
			result = -1;
		} else {
			// frequency array for the alphabets.
			int[] freq = new int[26];

			for (int i = 0; i < s.length() / 2; i++) {
				freq[(int) s.charAt(i) - 97]++;
			}

			for (int i = s.length() / 2; i < s.length(); i++) {
				freq[(int) s.charAt(i) - 97]--;
			}

			for (int i = 0; i < 26; i++) {
				result += (freq[i] > 0) ? freq[i] : 0;
			}
		}
		return result;
	}
}
