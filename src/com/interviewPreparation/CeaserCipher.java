package com.interviewPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CeaserCipher {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = caesarCipher(s, k);

        System.out.println(result);

        bufferedReader.close();

	}

	private static String caesarCipher(String s, int k) {

		StringBuffer buf = new StringBuffer();

		for (char c : s.toCharArray()) {
			if (Character.isLetter(c)) {
				int code = (int) c;
				boolean isCap = code >= 65 && code <= 90;

				if (isCap) {
					buf.append((char) ((code - 65 + k) % 26 + 65));
				} else {
					buf.append((char) ((code - 97 + k) % 26 + 97));
				}
			} else {
				buf.append(c);
			}

		}
		return buf.toString();
	}
	
	

}
