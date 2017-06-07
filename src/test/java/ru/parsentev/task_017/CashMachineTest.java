package ru.parsentev.task_017;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
@Ignore
public class CashMachineTest {
    @Test
    public void changeNote() throws Exception {
        CashMachine machine = new CashMachine(new int[]{10, 5, 1});
        Assert.assertArrayEquals(new int[]{1, 0, 0}, machine.changeNote(10));
        Assert.assertArrayEquals(new int[]{0, 1, 0}, machine.changeNote(5));
        Assert.assertArrayEquals(new int[]{0, 0, 1}, machine.changeNote(1));
        Assert.assertArrayEquals(new int[]{125, 1, 1}, machine.changeNote(1256));
    }

    @Test
    public void unchange() {
        CashMachine machine = new CashMachine(new int[] {1, 5, 10});
        List<List<Integer>> result = machine.exchange(1);
        assertThat(result, is(singletonList(singletonList(1))));
    }

    @Test
    public void change() {
        CashMachine machine = new CashMachine(new int[]{10, 5, 1});
        List<List<Integer>> result = machine.exchange(10);
        assertThat(
                result, is(
                        asList(
                                singletonList(10),
                                asList(5, 5),
                                asList(5, 1, 1, 1, 1, 1),
                                asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
                        )
                )
        );
    }


}