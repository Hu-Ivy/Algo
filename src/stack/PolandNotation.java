package stack;

import java.util.*;

public class PolandNotation {

    public static void main(String[] args) {
        String midExpression = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        List<String> midE = getListString(midExpression);
        System.out.println("中序表达式"+midE);
        System.out.println("---------Result-------------");
        List<String> result = parseInfixExpression(midE);
        System.out.println(result);
        System.out.println("----------------------------");
        //先将表达式放入到arraylist中，好遍历
//        String expression = "3 4 + 5 * 6 -";
//
//        List<String> list = getListString(expression);
//        System.out.println(list);
//        System.out.println("-----Result-------");
//        System.out.println(cal(list));

    }


    public static List<String> parseInfixExpression(List<String> list) {
        //1.定义两个栈,第二个栈只用来存储，可以用arraylist替代。
        Stack<String> operStack = new Stack<>();
        List<String> result = new ArrayList<>();

        for (String item :
                list) {
            //2.如果是一个数，则入栈result
            if (item.matches("\\d+")) {
                result.add(item);
            } else if (item.equals("(")) {
                //3.先处理括号，优先级最高
                operStack.push(item);
                //不为空则判断优先级
            } else if (item.equals(")")) {
                while (!operStack.peek().equals("(")) {
                    result.add(operStack.pop());
                }
                operStack.pop();
            }else {
                //比较运算符优先级,空了就不能弹了
                while (!operStack.isEmpty()&&OperationPrio.getValue(item)<=OperationPrio.getValue(operStack.peek())) {
                    result.add(operStack.pop());
                }
                //最后压入栈
                operStack.push(item);
            }
        }
        while (!operStack.isEmpty()) {
            result.add(operStack.pop());
        }

        return result;
    }

    public static List<String> getListString(String expression) {
        String[] splits = expression.split(" ");
        List<String> list = new ArrayList<>();

        Collections.addAll(list, splits);
        return list;
    }

    public static int cal(List<String> list) {
        int num1;
        int num2;
        int res = 0;
        Stack<String> stack = new Stack<>();
        for (String item :
                list) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());

                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        throw new RuntimeException("wrong expression...");
                }
                stack.push("" + res);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
class OperationPrio {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String oper) {
        int result = 0;
        if (oper.equals("*") || oper.equals("/")) {
            return 1;
        }else if (oper.equals("+")||oper.equals("-")) {
            return 0;
        }else {
            return -1;
        }
    }
}