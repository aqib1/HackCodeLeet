package com.test.web3labs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MahamAlgorithm {


    // 1- close < open
    // 2- open < n
    // 3- open == close == n

  // ((())), (())(), -----
    public List<String> list; // FIFO
    public Stack<String> lifo;


    public List<String> generatgeParams(int n) {
        list = new ArrayList<>();
        lifo = new Stack<>();
        parenthesis(0, 0, n);
        return list;
    }

    public void parenthesis(int closeCount, int openCount, int n) {
        if(n == openCount && openCount == closeCount) {
            list.add(String.join("", lifo));
            return;
        }
        if(openCount < n) {
            lifo.push("(");
            parenthesis(closeCount, openCount + 1, n);
            lifo.pop();
        }

        if(closeCount < openCount) {
            lifo.push(")");
            parenthesis(closeCount + 1, openCount, n);
            lifo.pop();
        }


    }

    public static void main(String[] args) {

        MahamAlgorithm algorith = new MahamAlgorithm();
        System.out.println(algorith.generatgeParams(3));

    }

}
