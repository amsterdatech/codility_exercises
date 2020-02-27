package com.company;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class SolutionTest {

    @Test
    public void sample1() {
        String deckA = "A586QK";
        String deckB = "JJ653K";

        int result = new Solution().solution(deckA, deckB);

        assertThat(result, Is.is(4));
    }

    @Test
    public void sample2() {
        String deckA = "23A84Q";
        String deckB = "K2Q25J";

        int result = new Solution().solution(deckA, deckB);

        assertThat(result, Is.is(4));
    }
}