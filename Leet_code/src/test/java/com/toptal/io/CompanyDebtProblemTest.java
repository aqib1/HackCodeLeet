package com.toptal.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompanyDebtProblemTest {

    @Test
    public void should_Return_Zero_When_Input_Empty() {
        Assertions.assertSame(0, CompanyDebtProblem.solution(new int[]{}));
    }

    @Test
    public void should_Return_Zero_When_Input_Null() {
        Assertions.assertSame(0, CompanyDebtProblem.solution(null));
    }

    @Test
    public void should_Return_1_When_Input_Is_Valid() {
        Assertions.assertSame(1, CompanyDebtProblem.solution(new int[]{10, -10, -1, -1, 1, 1}));
    }

    @Test
    public void should_Return_2_When_Input_Is_Valid() {
        Assertions.assertSame(2, CompanyDebtProblem.solution(new int[]{10, -10, -10, -1, 1, 1}));
    }

    @Test
    public void should_Return_0_When_Input_Is_Valid() {
        Assertions.assertSame(0, CompanyDebtProblem.solution(new int[]{10, -1, 1, 1}));
    }

    @Test
    public void should_Return_3_When_Input_Is_Valid() {
        Assertions.assertSame(3, CompanyDebtProblem.solution(new int[]{5, 5, -11, -11, -13, 2}));
    }

    @Test
    public void should_Return_0_When_Input_Is_Single_Positive() {
        Assertions.assertSame(0, CompanyDebtProblem.solution(new int[]{5}));
    }

    @Test
    public void should_Return_1_When_Input_Is_Single_Negative() {
        Assertions.assertSame(1, CompanyDebtProblem.solution(new int[]{-5}));
    }
}
