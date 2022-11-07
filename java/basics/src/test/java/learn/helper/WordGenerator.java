package learn.helper;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class WordGenerator {

    public static Stream<Arguments> generateAnagramWords() {
        return Stream.of(
                Arguments.of("chien", "niche"),
                Arguments.of("arbre", "barre")
        );

    }

    public static Stream<Arguments> generateBadAnagramWords() {
        return Stream.of(
                Arguments.of("chien", "nicha"),
                Arguments.of("arbre", "barra"),
                Arguments.of("chien", "loups"),
                Arguments.of("chiien", "chieen"),
                Arguments.of("y", "barra"),
                Arguments.of("abre", "barres")

        );

    }
}
