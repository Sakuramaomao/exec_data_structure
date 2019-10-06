package com.lzj.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式计算器。（即后缀表达式计算器）
 *
 * 运算符包括加减乘除和括号。
 *
 * @Author Sakura
 * @Date 2019/10/6 11:55
 */
public class PolandNotation {
    public static void main(String[] args) {
        // 中缀 (3+4)*5-6 --> 后缀 34+5*6- = 29
        // 中缀 4*5-8+60+8/2 --> 后缀 45*8-60+82/+ = 76

        // 中缀转后缀表达式 2 * ( 4 + 1 ) - 5 --> 2 4 1 + * 5 -
        String expression = "2*(4+1)-5+2*5";
        // 中缀表达式转化为中缀集合。
        List<String> infixList = toInfixExpression(expression);
        System.out.println("中缀转中缀集合：" + infixList);

        // 中缀集合转化为后缀表达式集合
        List<String> suffixList = toSuffixExpression(infixList);
        System.out.println("后缀表达式为：" + suffixList);

        int res = calculate(suffixList);
        System.out.println("计算结果为：" + res);
    }

    /**
     * 中缀集合转化为后缀表达式集合。
     *
     * @param infixList 中缀集合。
     * @return 后缀表达式集合。
     */
    private static List<String> toSuffixExpression(List<String> infixList) {
        Stack<String> symbolStack = new Stack<>(); // 操作符栈
        List<String> suffixList = new ArrayList<>(); // 结果集。因为结果集只有增加操作，使用List集合代替栈更方便。

        // 从左到右扫描中缀表达式
        for (String item : infixList) {
            if (item.matches("\\d+")) { // 数字直接入结果集。
                suffixList.add(item);
            } else if ("(".equals(item)) { // 操作符为左括号直接入栈。
                symbolStack.push(item);
            } else if (")".equals(item)) { // 右括号要出栈。
                while (!"(".equals(symbolStack.peek())) {
                    suffixList.add(symbolStack.pop());
                }
                symbolStack.pop(); // 消除左括号。
            } else {
                // 如果操作符栈栈顶为空或者是左括号则直接入栈。
                if (!symbolStack.isEmpty() && !"(".equals(symbolStack.peek())) {
                    // 如果符号栈非空，且item优先级小于栈顶元素，则一直出栈到结果集中。
                    while (!symbolStack.isEmpty() && Operation.getPriority(item) <= Operation.getPriority(symbolStack.peek())) {
                        suffixList.add(symbolStack.pop());
                    }
                }
                symbolStack.push(item);
            }
        }
        // 将符号栈中剩余的元素都添加到结果集中。
        while (!symbolStack.isEmpty()) {
            suffixList.add(symbolStack.pop());
        }

        return suffixList;
    }

    /**
     * 中缀表达式转为中缀表达式集合。
     *
     * @param expression 中缀表达式。
     * @return 中缀表达式集合。
     */
    private static List<String> toInfixExpression(String expression) {
        int index = 0;
        String item = "";
        char ch;
        List<String> res = new ArrayList();
        int len = expression.length();
        while (true) {
            if (index > len - 1) break;
            ch = expression.charAt(index);
            if (ch < 48 || ch > 57) { // 如果是操作符，直接添加。
                res.add(ch + "");
                index++;
            } else { // 如果是数字，就要累加直到遇到操作符。
                item = "";
                while (index <= len - 1 && expression.charAt(index) >= 48 && expression.charAt(index) <= 57) {
                    item += expression.charAt(index);
                    index++;
                }
                res.add(item);
            }
        }
        return res;
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
}

/**
 * 定义操作符优先级。
 */
class Operation {
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MULT = 2;
    private static final int DIV = 2;

    public static int getPriority(String oper) {
        int res = 0;
        switch (oper) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MULT;
                break;
            case "/":
                res = DIV;
                break;
            default:
                throw new RuntimeException("未知的操作符");
        }
        return res;
    }
}
