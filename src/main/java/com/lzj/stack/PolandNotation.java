package com.lzj.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 计算逆波兰表达式（即后缀表达式）。
 *
 * @Author Sakura
 * @Date 2019/10/6 11:55
 */
public class PolandNotation {
    public static void main(String[] args) {
        // 中缀 (3+4)*5-6 --> 后缀 34+5*6- = 29
        // 中缀 4*5-8+60+8/2 --> 后缀 45*8-60+82/+ = 76
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        List<String> symbolList = expressionSplit(suffixExpression);
        System.out.println("后缀表达式为：" + symbolList);
        int res = calculate(symbolList);
        System.out.println("计算结果为：" + res);
    }

    /**
     * 计算。
     * <p>
     * 计算逆波兰表达式只需要一个stack就可以，不需要区分数栈和符号栈。
     *
     * @param ls 切割后缀表达式集合。
     * @return 计算结果。
     */
    private static int calculate(List<String> ls) {
        int res = 0;
        Stack<Integer> stack = new Stack();
        for (String str : ls) {
            if (str.matches("\\d+")) { // 如果是数字，直接入栈。
                stack.push(Integer.parseInt(str));
            } else {
                int num1 = stack.pop(); // 如果是符号，栈顶和次顶元素出栈，和符号做运算，结果再入栈。
                int num2 = stack.pop();
                switch (str) {
                    case "+":
                        res = num2 + num1;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num2 * num1;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        throw new RuntimeException("未知的运算符");
                }
                stack.push(res);
            }
        }
        return res; // 集合遍历结束，返回栈中的计算结果。
    }

    /**
     * 后缀表达式切割。
     *
     * @param expression 后缀表达式。
     * @return 数字和运算符集合。
     */
    private static List<String> expressionSplit(String expression) {
        String[] strs = expression.split(" ");
        return Arrays.asList(strs);
    }

}
