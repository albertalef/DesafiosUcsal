package br.ucsal;

import java.util.Scanner;

public class Interpreter {
	private static Scanner sc = new Scanner(System.in);

	public static void main( String[] args ) {
		String command = sc.nextLine();

		System.out.print("To char array: ");
		char[] commandInCharArray = command.toCharArray();
		for(char letter : commandInCharArray) System.out.print("[" + letter + "] \n");

		String trimmedCommand = trim(command);
		System.out.println("Trimmed: [" + trimmedCommand + "]");

		String withoutPipeCommand = removeRepetitiveSpaces(trimmedCommand);
		System.out.println("Without repetitive spaces: [" + withoutPipeCommand + "]");

		String uppercasedCommand = toUpperCaseString(withoutPipeCommand);
		System.out.println("To uppercase: " + uppercasedCommand);

		String[] params = splitString(uppercasedCommand, ' ');

		System.out.print("In array: ");
		for(String param : params) System.out.print("[" + param + "] ");

		String[] allCommands = {"somar", "subtrair", "multiplicar", "dividir"};

		Integer index = findInStringArray(allCommands, params[0]);

		if(index == null) {
			System.out.println("Problema");
		}

		sc.close();
	}
	private static Integer findInStringArray(String[] stringArray, String text){
		Integer index = null;
		for(int i = 0; i < stringArray.length; i++) if(stringArray[i].equalsIgnoreCase(text)) index = i;
		return index;
	}

	private static String removeRepetitiveSpaces( String text ) {
		boolean spaceFound = false;

		char[] textCharArray = text.toCharArray();
		String result = "";

		for(char letter : textCharArray) {
			if(letter == 32) {
				if(!spaceFound) {
					result += letter;
					spaceFound = true;
				}
				continue;
			}
			result += letter;
			spaceFound = false;
		}
		return result;
	}
	private static String trim( String text ) {
		String trimmedStartCommand = trimStartString(text);
		String trimmedEndCommand = trimEndString(trimmedStartCommand);
		return reverseString(trimmedEndCommand);
	}
	private static String trimStartString( String text){
		boolean letterFound = false;
		String result = "";

		for(char letter : text.toCharArray()) {
			if(letter == 32 && !letterFound) continue;
			result += letter;
			letterFound = true;
		}
		return result;
	}
	private static String trimEndString( String text){
		boolean letterFound = false;
		String result = "";

		char[] trimmedStartCommandInCharArray = text.toCharArray();

		for(int i = trimmedStartCommandInCharArray.length - 1; i >= 0; i--) {
			char letter = trimmedStartCommandInCharArray[i];
			if(letter == 32 && !letterFound) continue;
			result += letter;
			letterFound = true;
		}
		return result;
	}
	private static String reverseString(String text){
		String result = "";
		char[] trimmedEndCommandToCharArray = text.toCharArray();

		for(int i = trimmedEndCommandToCharArray.length - 1; i >= 0; i--) result += trimmedEndCommandToCharArray[i];

		return result;
	}
	private static String toUpperCaseString(String text){
		String result = "";

		for(char letter : text.toCharArray()) {
			char newLetter = letter;

			if(letter >= 97 && letter <= 122) newLetter -= 32;

			result += newLetter;
		}
		return result;
	}
	private static String[] splitString(String text, char letter){
		int numberOfSpaces = getCharsCount(text, letter);
		String[] params = new String[numberOfSpaces + 1];

		int actualLetterIndex = 0;
		for(int i = 0; i <= numberOfSpaces; i++) {
			String param = "";

			while(actualLetterIndex < text.length()){
				char actualLetter = text.toCharArray()[actualLetterIndex++];
				if(actualLetter == letter) break;
				param += actualLetter;
			}
			params[i] = param;
		}
		return params;
	}
	private static int getCharsCount(String text, char letter){
		int numberOfSpaces = 0;
		for(char actualLetter : text.toCharArray()) if(actualLetter == letter) numberOfSpaces++;
		return numberOfSpaces;
	}
}
