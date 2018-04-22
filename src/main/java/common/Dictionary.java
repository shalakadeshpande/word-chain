package common;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {

	private static List<String> wordList = new ArrayList<>();

	public static boolean loadWords(int wordLength, String fileName) throws IOException {

		// Get file from resources folder
		ClassLoader classLoader = Dictionary.class.getClassLoader();
		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			System.out.println("Not able to load dictionary file from resources");
			return false;
		}
		File file = new File(resource.getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String word = scanner.nextLine();
				if (word.length() == wordLength) {
					wordList.add(word);
				}
			}

			scanner.close();

		} catch (IOException e) {
			throw e;
		}

		return wordList.isEmpty() ? false : true;
	}

	public static List<String> getWordList() {
		return wordList;
	}

	public static List<String> getNeighbours(String fromWord) {
		LinkedList<String> neighboursList = new LinkedList<>();
		for (String eachDictionaryWord : wordList) {
			if (isNeighbour(eachDictionaryWord, fromWord)) {
				neighboursList.add(eachDictionaryWord);
			}
		}

		return neighboursList;
	}

	private static boolean isNeighbour(String eachDictionaryWord, String fromWord) {
		int diff = 0;
		for (int n = 0; n < eachDictionaryWord.length(); n++) {
			if (eachDictionaryWord.charAt(n) != fromWord.charAt(n)) {
				diff++;
			}
		}
		return (diff == 1) ? true : false;
	}

}
