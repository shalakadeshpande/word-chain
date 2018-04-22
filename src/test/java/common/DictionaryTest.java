package common;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {
	Dictionary dictionary;
	String fileName = "words.txt";
	String invalidFileName = "words1.txt";
	String insufficientWords = "words_invalid.txt";

	@Before
	public void setUp() {
		dictionary = new Dictionary();
	}

	@Test
	public void shouldTestInitialisation() {
		assertNotNull(this.dictionary);
	}

	@Test
	public void shouldTestLoadWords() throws IOException {

		assertTrue(Dictionary.loadWords(3, fileName));
		assertTrue(Dictionary.getWordList().size() > 0);
	}

	@Test
	public void shouldTestLoadWordsForInvalidPath() throws IOException {
		assertFalse(Dictionary.loadWords(3, invalidFileName));
	}

//	@Test
	public void shouldTestInsufficientWords() throws IOException {
		assertFalse(Dictionary.loadWords(3, insufficientWords));
	}

	@Test
	public void shouldTestGetneighbours() throws IOException {
		Dictionary.loadWords(2, fileName);
		assertTrue(Dictionary.getNeighbours("is").size() > 0);
	}

}
