package ru.parsentev.task_017;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.slf4j.LoggerFactory.getLogger;

public class CashMachine {
    private static final Logger log = getLogger(CashMachine.class);

    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
    }

    public List<List<Integer>> exchange(int note) {
        List<List<Integer>> result = new ArrayList<>();
        for (int startIndex = 0; startIndex < values.length; startIndex++) {
            if (note == values[startIndex]) {
                result.add(singletonList(note));
            } else {
                result.addAll(generateChanges(note, startIndex));
            }
        }
        return result;
    }

    private List<List<Integer>> generateChanges(int note, int startIndex) {
        List<List<Integer>> combinations = new ArrayList<>();
        for (int j = startIndex; j < values.length; j++) {
            ArrayList<Integer> changes = new ArrayList<>();
            changes.add(values[startIndex]);
            int rest = note - values[startIndex];
            do {
                changes.add(values[j]);
            } while ((rest -= values[j]) > 0);
            combinations.add(changes);
        }
        return combinations;
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
