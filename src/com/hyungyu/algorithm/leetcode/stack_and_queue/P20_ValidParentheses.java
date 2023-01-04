package com.hyungyu.algorithm.leetcode.stack_and_queue;

import java.util.Stack;

public class P20_ValidParentheses {

    public static void main(String[] args) {
//        String s = "()";
//        String s = "()[]{}";
        String s = "(]";
//        String s = "([)]";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        for (char tag : chars) {
            // '(' , '{' , '[' 일 경우 stack 에 담음
            if (isOpenTag(tag)) {
                characterStack.push(tag);
                continue;
            }
            // 아닐 경우 stack 이 비어있는지 확인
            if (characterStack.empty()) {
                return false;
            }
            // 해당 태그의 open tag 검색 후 마지막 open tag 와 비교
            if (isNotMatch(characterStack.pop(), tag)) {
                return false;
            }
        }
        return characterStack.empty();
    }

    public static boolean isOpenTag(char ch) {
        return switch (ch) {
            case '(', '{', '[' -> true;
            default -> false;
        };
    }

    public static boolean isNotMatch(char openTag, char closeTag) {
        if (openTag == '(' && closeTag != ')') {
            return true;
        }
        if (openTag == '{' && closeTag != '}') {
            return true;
        }
        return openTag == '[' && closeTag != ']';
    }
}
