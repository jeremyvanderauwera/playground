package be.fgov.sfpd.theseos;

public class CharacterCounterFactory {
    private CharacterCounterFactory() {}

    private static class Holder {
        static final CharacterCounter INSTANCE = new SimpleCharacterCounter();
    }

    public static CharacterCounter getCharacterCounter() {
        return Holder.INSTANCE;
    }
}

