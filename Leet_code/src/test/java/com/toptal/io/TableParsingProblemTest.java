package com.toptal.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TableParsingProblemTest {

    @Test
    public void should_Return_Invalid_Input_Response_When_Empty_Table() {
        Assertions.assertSame(-1, TableParsingProblem.solution("", "abc"));
    }

    @Test
    public void should_Return_Invalid_Input_Response_When_Blank_Table() {
        Assertions.assertSame(-1, TableParsingProblem.solution(" ", "abc"));
    }

    @Test
    public void should_Return_Invalid_Input_Response_When_Null_Table() {
        Assertions.assertSame(-1, TableParsingProblem.solution(null, "abc"));
    }

    @Test
    public void should_Return_Invalid_Input_Response_When_Empty_Column() {
        Assertions.assertSame(-1, TableParsingProblem.solution("id,name,age,act.,room,dep.\n1,Jack,68,T,13,8\n17,Betty,28,F,15,7", ""));
    }

    @Test
    public void should_Return_Invalid_Input_Response_When_Blank_Column() {
        Assertions.assertSame(-1, TableParsingProblem.solution("id,name,age,act.,room,dep.\n1,Jack,68,T,13,8\n17,Betty,28,F,15,7", " "));
    }

    @Test
    public void should_Return_Invalid_Input_Response_When_Null_Column() {
        Assertions.assertSame(-1, TableParsingProblem.solution("id,name,age,act.,room,dep.\n1,Jack,68,T,13,8\n17,Betty,28,F,15,7", null));
    }


}
