package com.test.web3labs;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    private static List<String> result = new ArrayList<>();
    public static void parenthesis(char str[], int pos, int n, int open, int close) {
        if(close == n)
        {
            // print the possible combinations
            String value = "";
            for(int i=0;i<str.length;i++)
               value = value.concat(Character.toString(str[i]));
            result.add(value);
            return;
        }
        else
        {
            if(open > close) {
                str[pos] = ')';
                parenthesis(str, pos+1, n, open, close+1);
            }
            if(open < n) {
                str[pos] = '(';
                parenthesis(str, pos+1, n, open+1, close);
            }
        }
    }

   public static void printParenthesis(char str[], int n)
    {
        if(n > 0)
            parenthesis(str, 0, n, 0, 0);
        return;
    }
    public static List<String> generateParenthesis(int n) {
        char [] strMargin = new char[2 * n];
        printParenthesis(strMargin, n);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
