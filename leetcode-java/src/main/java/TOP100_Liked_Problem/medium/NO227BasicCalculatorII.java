package TOP100_Liked_Problem.medium;

import java.util.Stack;

public class NO227BasicCalculatorII {

    public static void main(String[] args) {
        System.out.println(new NO227BasicCalculatorII().calculate("1*2-3/4+5*6-7*8+9/10"));
    }

    /*
    *
     * @Date 下午3:20 2019/2/19
     * 复杂度：
     * beats：1.93%
     **/
    public int calculate(String s) {
        int[][] opArray= {
                {0,0,1,1},
                {0,0,1,1},
                {0,0,0,0},
                {0,0,0,0}
        };
        Stack<Character> opStack=new Stack<>();
        Stack<Integer> numStack=new Stack<>();
        char chs[]=s.toCharArray();
        boolean preIsNum=false;
        for(int i=0;i<s.length();i++){
            if(chs[i]==' ') continue;
            if(chs[i]<='9'&&chs[i]>='0'){
                if(preIsNum){
                    int preNum=numStack.pop();
                    preNum=preNum*10+chs[i]-'0';
                    numStack.push(preNum);
                }else numStack.push(chs[i]-'0');
                preIsNum=true;
            }else{
                preIsNum=false;
                System.out.println(chs[i]);
                int num1=0,num2=0;
                while(opStack.size()>0&&opArray[getPos(opStack.peek())][getPos(chs[i])]==0){
                    System.out.println(opStack.peek()+"?"+chs[i]);
                    char op=opStack.pop();
                    switch (op){
                        case '*':
                            num1=numStack.pop();
                            num2=numStack.pop();
                            numStack.push(num2*num1);
                            break;
                        case '/':
                            num1=numStack.pop();
                            num2=numStack.pop();
                            numStack.push(num2/num1);
                            break;
                        case '+':
                            num1=numStack.pop();
                            num2=numStack.pop();
                            numStack.push(num2+num1);
                            break;
                        case '-':
                            num1=numStack.pop();
                            num2=numStack.pop();
                            numStack.push(num2-num1);
                            break;
                    }
                }
                opStack.push(chs[i]);
            }
        }
        System.out.println(opStack.size()+"opstack");
        System.out.println(numStack.size()+"numstack");
        while(!opStack.isEmpty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            switch (opStack.pop()) {
                case '*':
                    numStack.push(num1 * num2);
                    break;
                case '/':
                    numStack.push(num2 / num1);
                    break;
                case '+':
                    numStack.push(num2 + num1);
                    break;
                case '-':
                    numStack.push(num2 - num1);
                    break;
            }
            System.out.println(numStack.peek());
        }
        return numStack.pop();
    }

    private int getPos(char ch){
        int pos;
        if(ch=='+'){
            pos=0;
        }else if(ch=='-'){
            pos=1;
        }else if(ch=='*'){
            pos=2;
        }else{
            pos=3;
        }
        return pos;
    }


    //TODO 优秀解决方案，不用栈
}
