package ru.parsentev.task_017;

import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class CashMachine {
    private static final Logger log = getLogger(CashMachine.class);

    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
    }

    public List<List<Integer>> exchange(int note) {
        throw new UnsupportedOperationException();
    }

    public int[] changeNote(int note) {
        int[] changes = new int[3];
        int i = 0;
        while (note > 0) {
            note -= values[i] * (changes[i] = Math.floorDiv(note, values[i]));
            i++;
        }
        return changes;
    }
}
