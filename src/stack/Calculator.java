package stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "30+2*6-2";
        //数字栈
        ArrayStack numStack = new ArrayStack(10);
        //符号栈
        ArrayStack operStack = new ArrayStack(10);

        System.out.println(expression.length());
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch=' ';
        //用于拼接多位数
        String keepNum="";
        //循环扫描expression
        while(index<expression.length()) {
            ch = expression.substring(index,index+1).charAt(0);
            System.out.println(ch);
            //判断ch是什么然后做相应处理
            if (operStack.isOper(ch)) {
                //判断当前栈是否为空
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch)<operStack.priority(operStack.pick())) {
                        oper = operStack.pop();
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        numStack.push(numStack.cal(num1,num2,oper));
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }else {
                    operStack.push(ch);
                }
            }//是数字,判断多位数，则直接push
            else {
                //如果是数字直接入栈,'1'-48=1
                keepNum +=ch;
                if (index==expression.length()-1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    //但是最后以为了也不需要下一位判断了
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum="";
                    }
                }


            }

            index++;
        }
        System.out.println("计算结果");
        numStack.list();
        System.out.println("-------------");
        operStack.list();
        //最后弹出栈中的数字和符号
        while (!operStack.isEmpty()) {
            oper = operStack.pop();
            num1 = numStack.pop();
            num2 = numStack.pop();

            numStack.push(numStack.cal(num1,num2,oper));
        }

        System.out.println(numStack.pop());
    }
}
