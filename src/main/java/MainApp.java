import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import wordGraph.WordGraph;

public class MainApp {

	private static final String dictionaryFileName = "words.txt";

	public static void main(String[] args) throws IOException {
		System.out.println("Enter start word: ");
		Scanner scannerFromWord = new Scanner(System.in);
		String fromword = scannerFromWord.next();

		System.out.println("Enter end word: ");
		Scanner scannerToWord = new Scanner(System.in);
		String toword = scannerToWord.next();

		WordGraph wordgraph = new WordGraph(dictionaryFileName);

		System.out.println(">>>>>>>>>>>>> step1: word graph prepared? ");
		System.out.println(wordgraph.populateWordGraph(fromword, toword) ? "Yes" : "No");
		System.out.println(">>>>>>>>>>>>> step2: word chain possible? ");
		List<String> wordChain = wordgraph.getWordChain(fromword, toword);
		System.out.println(wordChain.isEmpty() ? "No" : "Yes");
		if (!wordChain.isEmpty()) {
			System.out.println(">>>>>>>>>>>>> step3: word chain : ");
			for (String word : wordChain) {
				System.out.print(word + " ");
			}
		}

		scannerFromWord.close();
		scannerToWord.close();
	}
}
