package com.test.web3labs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {

    // we need to solve using backtracking
    // we need to take two count openCount (counting open braces)
    // and closeCount (counting close braces). we need to make sure
    // that closeCount is less than openCount and openCount should
    // less than n (number of pairs required). We need to backtrack
    // using recursion and terminate when openCount == closeCount == n

    private List<String> result;
    private Stack<String> parenStack;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        parenStack = new Stack<>();
        parenthesis(n,0, 0);
        return result;
    }

    private void parenthesis(int n, int openCount, int closeCount) {
        if(n == openCount && openCount == closeCount) {
            result.add(String.join("", parenStack));
            return;
        }

        if(openCount < n) {
            parenStack.push("(");
            parenthesis(n, openCount + 1, closeCount);
            parenStack.pop();
        }

        if(closeCount < openCount) {
            parenStack.push(")");
            parenthesis(n, openCount, closeCount + 1);
            parenStack.pop();
        }
    }

    public static void main(String[] args) {
//        System.out.println(generateParenthesis(1));
    }
}
