package wordGraph;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class WordGraphTest {
	WordGraph wordGraph;

	private static final String dictionaryFileName = "words.txt";

	@Before
	public void setUp() {
		this.wordGraph = new WordGraph(dictionaryFileName);
	}

	@Test
	public void shouldTestInit() {
		assertNotNull(this.wordGraph);
		assertNotNull(this.wordGraph.getWordsAdjecency());

	}

	@Test
	public void shouldTestPopulateWordGraph() throws IOException {
		String toword = "cat";
		String fromword = "dog";
		assertTrue(this.wordGraph.populateWordGraph(fromword, toword));
	}

	@Test
	public void shouldTestWorGraphForInvalidWords() throws IOException {
		String toword = "cater";
		String fromword = "dog";
		assertFalse(this.wordGraph.populateWordGraph(fromword, toword));
	}

	@Test
	public void shouldTestAddWordNode() {
		this.wordGraph.addWordNode("dog", "hog");
		Map<String, LinkedList<String>> adjecentWords = this.wordGraph.getWordsAdjecency();
		assertTrue(adjecentWords.get("dog").contains("hog"));
		this.wordGraph.addWordNode("dog", "fog");
		assertTrue(adjecentWords.get("dog").contains("fog"));
	}

	@Test
	public void shouldTestGetWordChain() throws IOException {
		String toword = "dog";
		String fromword = "cat";
		this.wordGraph.populateWordGraph(fromword, toword);
		assertFalse(this.wordGraph.getWordChain(fromword, toword).isEmpty());
		assertEquals(4, this.wordGraph.getWordChain(fromword, toword).size());

	}
	@Test
	public void shouldTestGetWordChainForAnotherSet() throws IOException {
		String toword = "peek";
		String fromword = "load";
		this.wordGraph.populateWordGraph(fromword, toword);
		assertFalse(this.wordGraph.getWordChain(fromword, toword).isEmpty());
		assertEquals(5, this.wordGraph.getWordChain(fromword, toword).size());

	}

	@Test
	public void shouldTestGetWordChainWhenChainNotFound() throws IOException {
		String toword = "god";
		String fromword = "dog";
		this.wordGraph.populateWordGraph(fromword, toword);
		assertTrue(this.wordGraph.getWordChain(fromword, toword).isEmpty());
		assertTrue(this.wordGraph.getWordChain(fromword, toword).isEmpty());

	}

}
