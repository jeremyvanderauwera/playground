package be.fgov.sfpd.theseos;

@FunctionalInterface
public interface CharacterCounter {

    CharacterCounterResult count(CharacterCounterRequest request);

}


