package com.lzj.stack;

/**
 * 栈实践，计算器。
 * <p>
 * 使用数组模拟的栈实现单位数的计算器。
 * <p>
 * 注意：
 * 此版本只能计算单位数，不能计算多位数。
 *
 * @Author Sakura
 * @Date 2019/10/5 17:00
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "20*5-20*4+1";

        ArrayStack numStack = new ArrayStack(10); // 数字栈
        ArrayStack operStack = new ArrayStack(10); // 操作符栈。
        int num1;
        int num2;
        int oper;
        int index = 0;
        char ch; // 临时变量，存放表达式中当前的值。
        String keepNum = "";

        // 1、遍历表达式中的字符。
        while (true) {
            ch = expression.charAt(index); // 都是char，'3'入栈后其实是数字51。如数字栈前要减去48.

            if (isNum(ch)) { // 为数字
                keepNum += ch;

                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum)); // 入数字栈。因为存放的都是ascii码，ascii和数字相差48，减去才是真正的表达式中数字。
                } else {
                    if (!isNum(expression.charAt(index + 1))) { // 判断下一个字符是否为数字，如果是，继续扫描，不是则如数字栈。
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = ""; // 一定要记得清空！！！
                    }
                }
            } else { // 为操作符
                if (operStack.isEmpty()) { // 判断操作符栈是否为空
                    operStack.push(ch);
                } else { // 操作符栈非空，则和栈顶操作符比较优先级
                    if (operPriority(ch) <= operPriority(operStack.peek())) {
                        // 如果当前操作符优先级小于等于栈顶操作符，就要一直做顺序运算，直到操作符栈清空。
                        while (!operStack.isEmpty()) {
                            num1 = numStack.pop(); // 数字栈出栈两个。
                            num2 = numStack.pop();
                            oper = operStack.pop(); // 符号栈栈顶操作符出栈。
                            int res = calcule(num1, num2, oper); // 计算。
                            numStack.push(res); // 计算结果继续放回数字栈。
                        }
                        operStack.push(ch); // 当前操作符入栈。
                    } else {
                        // 当前操作符优先级大于栈顶操作符，直接入栈。
                        operStack.push(ch);
                    }
                }
            }

            index++;
            if (index >= expression.length()) { // 表达式遍历结束，优先级的计算结束。
                break;
            }
        }

        // 表达式扫描完毕，就顺序的从数字栈和操作符栈中pop出相应的数和符号，并运行。
        while (true) { // 开始计算最终结果。
            if (operStack.isEmpty()) { // 当操作符栈为空时，整个表达式才计算完成。
                break;
            }
            num1 = numStack.pop(); // 数字栈出栈两个。
            num2 = numStack.pop();
            oper = operStack.pop(); // 符号栈栈顶操作符出栈。
            int res = calcule(num1, num2, oper); // 计算。
            numStack.push(res); // 计算结果继续放回数字栈。
        }
        System.out.printf("表达式 %s = %d ", expression, numStack.pop());
    }

    /**
     * 自定义操作符的优先级。
     * <p>
     * 返回值越大优先级越高。
     *
     * @return * 和 / 优先级是 1； + 和 - 优先级是 0。
     */
    private static int operPriority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 检查是否为数字还是操作符。
     *
     * @param value 待检查的值。
     * @return value为数字返回true，为操作符返回false。
     */
    private static boolean isNum(char value) {
        return value != '+' && value != '-' && value != '*' && value != '/';
    }

    /**
     * 操作。
     *
     * @param num1 从数字栈出栈的第一个值。
     * @param num2 从数字栈出栈的第二个值。
     * @param oper 从操作符栈出栈的操作符。
     * @return 计算结果。
     */
    private static int calcule(int num1, int num2, int oper) {
        int res;
        switch (oper) {
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1; // 注意顺序，数字栈的第二个值在前面。
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                throw new RuntimeException("不正确的操作符");
        }
        return res;
    }
}