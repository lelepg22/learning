package learn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import static org.junit.jupiter.api.Assertions.*;

class TestWordPlay {   //Nommage convention OK(success) et KO(breaking)
                       //TDD TEST DRIVEN DEVELOPMENT
    //par impair

    @Test
    void isPalindromeWordOk() {
        String word = "hannah";

        boolean ok = WordPlay.isPalindromeWord(word);
        boolean ok2 = WordPlay.isPalindromeWord("ana");
        boolean ok3 = WordPlay.isPalindromeWord("kayak");

        System.out.println(ok);
        assertTrue(ok && ok2 && ok3);
    }

    @ParameterizedTest    //test avec des parametres
    @ValueSource(strings = {"ko", "y", "banane" })          //source de parametre dans le cas une tableau de string
    void isPalindromeWordKo(String word) {
        // String word  = "ko";
        boolean ok = WordPlay.isPalindromeWord(word);
        assertFalse(ok);


    }


    @ParameterizedTest
    @MethodSource("learn.helper.WordGenerator#generateAnagramWords")
    void isAnagramOk(String word1, String word2) {

//        String word1 = "ko";
//        String word2 = "ok";
        boolean ok = WordPlay.isAnagram(word1, word2);
        boolean ok2 = WordPlay.isAnagram("chien", "niche");
        boolean ok3 = WordPlay.isAnagram("ironique", "onirique");

        assertTrue(ok && ok2 && ok3);
    }

    @ParameterizedTest
    @MethodSource("learn.helper.WordGenerator#generateBadAnagramWords")
    void isAnagramKo(String word1, String word2) {
//        String word1 = "kok";
//        String word2 = "ok";
        boolean ok = WordPlay.isAnagram(word1, word2);
        boolean ok2 = WordPlay.isAnagram("banane", "banana");
        assertFalse(ok && ok2);
    }

}