package be.fgov.sfpd.theseos;


import lombok.extern.slf4j.Slf4j;

import java.lang.Character;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
class SimpleCharacterCounter implements CharacterCounter {

    public CharacterCounterResult count(CharacterCounterRequest request) {
        log.debug("Parameters {}", request);
        if (request == null || request.sentence() == null) {
            log.debug("rezquest is null please .. {}", request);
            return new CharacterCounterResult(null);
        }
        String sentence = request.sentence();
        Map<Character, Long> characterRepetitionPerCharacter = IntStream.range(0, sentence.length())
                .mapToObj(sentence::charAt)
                .map(Character::toUpperCase)
                .filter(character -> !Character.isSpaceChar(character))
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting())
                );
        List<be.fgov.sfpd.theseos.Character> characters = characterRepetitionPerCharacter.entrySet()
                .stream()
                .map(entry -> new be.fgov.sfpd.theseos.Character(entry.getKey(), entry.getValue()))
                .toList();
        return new CharacterCounterResult(characters);
    }


}
