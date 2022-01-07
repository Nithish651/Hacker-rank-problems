package com.interviewPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringPassword {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine().trim());
		String password = bufferedReader.readLine();
		int answer = minimumNumber(n, password);
		System.out.println(answer);
		bufferedReader.close();
	}

	private static int minimumNumber(int n, String password) {

		String specialCharacters = "!@#$%^&*()-+";
		boolean hasNumber = false, hasUpperCase = false, hasLowerCase = false, hasSpecialCharacter = false;
		int charactersToadd = 0;

		for (int i = 0; i < password.length()
				&& (!hasNumber || !hasUpperCase || !hasLowerCase || !hasSpecialCharacter); i++) {

			if (!hasNumber)
				hasNumber = Character.isDigit(password.charAt(i));

			if (!hasUpperCase)
				hasUpperCase = Character.isUpperCase(password.charAt(i));

			if (!hasLowerCase)
				hasLowerCase = Character.isLowerCase(password.charAt(i));

			if (!hasSpecialCharacter)
				hasSpecialCharacter = specialCharacters.indexOf(password.charAt(i)) != -1;

		}

		if (!hasNumber)
			charactersToadd++;

		if (!hasUpperCase)
			charactersToadd++;

		if (!hasLowerCase)
			charactersToadd++;

		if (!hasSpecialCharacter)
			charactersToadd++;
		if (password.length() < 6) {
			if (6 - password.length() >= charactersToadd) {
				charactersToadd = 6 - password.length();
			}
		}
		return charactersToadd;
	}

}
