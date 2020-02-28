package com.company;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Task2Test {

    @Test
    public void sample1() {
        String[] T = {
                "test1a",
                "test2",
                "test1b",
                "test1c",
                "test3"
        };

        String[] R = {
                "Wrong answer",
                "OK",
                "Runtime error",
                "OK",
                "Time limit exceeded"
        };

        int result = new Task2().solution(T, R);

        assertThat(result, is(33));
    }

    @Test
    public void sample2() {
        String[] T = {
                "codility1",
                "codility3",
                "codility2",
                "codility4b",
                "codility4a"
        };

        String[] R = {
                "Wrong answer",
                "OK",
                "OK",
                "Runtime error",
                "OK"
        };

        int result = new Task2().solution(T, R);

        assertThat(result, is(50));
    }

    @Test
    public void sample3() {
        String[] T = {
                "sky1a",
                "sky1b",
                "sky2a",
                "sky2b",
                "sky2c",
                "sky2d",
                "sky2e",
                "sky3",
                "sky4",
                "sky5a",
                "sky5b",
                "sky5c"
        };

        String[] R = {
                "Wrong answer",
                "OK",
                "OK",
                "Runtime error",
                "OK",
                "Wrong answer",
                "OK",
                "OK",
                "OK",
                "OK",
                "OK",
                "OK",
        };

        int result = new Task2().solution(T, R);

        assertThat(result, is(60));
    }

    @Test
    public void sample4() {
        String[] T = {
                "test1a",
                "test2a",
                "test2b",
                "test1b",
                "test1c",
                "test3",
        };

        String[] R = {
                "Wrong answer",
                "OK",
                "OK",
                "Wrong answer",
                "OK",
                "OK",
        };

        int result = new Task2().solution(T, R);

        assertThat(result, is(66));
    }
}
