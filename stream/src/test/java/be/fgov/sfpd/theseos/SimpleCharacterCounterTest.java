package be.fgov.sfpd.theseos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class SimpleCharacterCounterTest {

    SimpleCharacterCounter simpleCharacterCounter = new SimpleCharacterCounter();

    @Test
    public void given_twoRepetitionOfA_when_count_then_2AReturned() {
        String input = "AA";

        CharacterCounterResult result = simpleCharacterCounter.count(new CharacterCounterRequest(input));

        CharacterCounterResult expected = new CharacterCounterResult(singletonList(new Character('A', 2)));
        assertThat(result.characters())
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrderElementsOf(expected.characters());
    }

    @Test
    public void given_twoRepetitionOfAOneLowerCaseAndOneUpperCase_when_count_then_2AReturned() {
        String input = "Aa";

        CharacterCounterResult result = simpleCharacterCounter.count(new CharacterCounterRequest(input));

        CharacterCounterResult expected = new CharacterCounterResult(singletonList(new Character('A', 2)));
        assertThat(result.characters())
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrderElementsOf(expected.characters());
    }

    @Test
    public void given_1C2BAnd3A_when_count_then_2Band3AReturned() {
        String input = "caBBaa";

        CharacterCounterResult result = simpleCharacterCounter.count(new CharacterCounterRequest(input));

        CharacterCounterResult expected = new CharacterCounterResult(List.of(new Character('C', 1), new Character('A', 3), new Character('B', 2)));
        assertThat(result.characters())
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrderElementsOf(expected.characters());
    }

    @Test
    public void given_singleRepetitionOfCAndOneOfD_when_count_then_2Band3AReturned() {
        String input = "cd";

        CharacterCounterResult result = simpleCharacterCounter.count(new CharacterCounterRequest(input));

        CharacterCounterResult expected = new CharacterCounterResult(List.of(new Character('C', 1), new Character('D', 1)));
        assertThat(result.characters())
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrderElementsOf(expected.characters());
    }

    @Test
    public void given_noRepetitionOfA_when_count_then_emptyListOfCharactersReturned() {
        String input = "";

        CharacterCounterResult result = simpleCharacterCounter.count(new CharacterCounterRequest(input));

        CharacterCounterResult expected = new CharacterCounterResult(emptyList());
        assertThat(result.characters())
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrderElementsOf(expected.characters());
    }
}
