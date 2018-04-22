package wordGraph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import common.Dictionary;

public class WordGraph {

	private Map<String, LinkedList<String>> wordsAdjecency;

	Map<String, String> visited = new HashMap<>();

	private String dictionaryFileName;

	public WordGraph(String fileName) {
		this.wordsAdjecency = new HashMap<>();
		this.dictionaryFileName = fileName;
	}

	public Map<String, LinkedList<String>> getWordsAdjecency() {
		return wordsAdjecency;
	}

	public boolean populateWordGraph(String fromWord, String toWord) throws IOException {
		if (fromWord.length() != toWord.length()) {
			return false;
		}

		Dictionary.loadWords(fromWord.length(), this.dictionaryFileName);

		Queue<String> q = new LinkedList<>();
		q.add(fromWord);

		while (!q.isEmpty() && !(fromWord = q.poll()).equals(toWord)) {
			LinkedList<String> neighbours = (LinkedList<String>) Dictionary.getNeighbours(fromWord);
			for (String eachNeighbour : neighbours) {
				if (!visited.containsKey(eachNeighbour)) {
					visited.put(eachNeighbour, fromWord);
					q.add(eachNeighbour);

					this.addWordNode(fromWord, eachNeighbour);
				}
			}
		}

		return this.wordsAdjecency.isEmpty() ? false : true;
	}

	public void addWordNode(String parentWord, String childWord) {
		LinkedList<String> neighbours;// = new LinkedList<>();
		if (this.wordsAdjecency.get(parentWord) == null || this.wordsAdjecency.get(parentWord).isEmpty()) {
			neighbours = new LinkedList<>();
			neighbours.add(childWord);
			this.wordsAdjecency.put(parentWord, neighbours);
		} else {
			neighbours = this.wordsAdjecency.get(parentWord);
			neighbours.add(childWord);
		}
	}

	public List<String> getWordChain(String fromWord, String toWord) {
		List<String> wordchain = new ArrayList<>();
		if (!visited.containsKey(toWord)) {
			return Collections.emptyList();
		}
		String each = toWord;
		while (!each.equals(fromWord)) {
			wordchain.add(each);
			each = visited.get(each);
		}
		wordchain.add(fromWord);

		Collections.reverse(wordchain);
		return wordchain;
	}

}
