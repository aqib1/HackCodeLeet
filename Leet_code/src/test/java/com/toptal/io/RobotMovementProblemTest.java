package com.toptal.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotMovementProblemTest {

    @Test
    public void should_Return_Invalid_Response_When_Empty_Table() {
        Assertions.assertSame(-1, RobotMovementProblem.solution(new String[]{}));
    }

    @Test
    public void should_Return_Invalid_Response_When_Null_Table() {
        Assertions.assertSame(-1, RobotMovementProblem.solution(null));
    }

    @Test
    public void should_Return_Success_Response_Valid0_Table() {
        RobotMovementProblem.clean();
        Assertions.assertSame(9, RobotMovementProblem.solution(
                new String[]{
                        "...X.",
                        ".X..X",
                        "X...X",
                        "..X.."
                }
        ));
    }

    @Test
    public void should_Return_Success_Response_Valid_Table() {
        RobotMovementProblem.clean();
        Assertions.assertSame(15, RobotMovementProblem.solution(
                new String[]{
                        "....X..",
                        "X......",
                        ".....X.",
                        "......."
                }
        ));
    }

    @Test
    public void should_Return_Success_Response_Empty_String_Table() {
        Assertions.assertSame(-1, RobotMovementProblem.solution(
                new String[]{""}
        ));
    }

    @Test
    public void should_Return_Success_Response_Single_Character_String_Table() {
        RobotMovementProblem.clean();
        Assertions.assertSame(1, RobotMovementProblem.solution(
                new String[]{"."}
        ));
    }
}
