package vadya;

import java.util.Iterator;

public class Hyeta implements Iterable<Character>, Iterator<Character> {
    private char[] chars;
    private int index;

    public Hyeta(int size) {
        chars = new char[size];
    }

    public char[] getChars() {
        return chars;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public Iterator<Character> iterator() {
        index = chars.length - 1;
        return this;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public Character next() {
        if(!hasNext())
            return null;

        return chars[index--];
    }
}
