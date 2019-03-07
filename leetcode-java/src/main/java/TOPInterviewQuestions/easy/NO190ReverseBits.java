package TOPInterviewQuestions.easy;

public class NO190ReverseBits {

//    去掉最后一位          | (101101->10110)           | x shr 1
//    在最后加一个0         | (101101->1011010)         | x shl 1
//    在最后加一个1         | (101101->1011011)         | x shl 1+1
//    把最后一位变成1       | (101100->101101)          | x or 1
//    把最后一位变成0       | (101101->101100)          | x or 1-1
//    最后一位取反          | (101101->101100)          | x xor 1
//    把右数第k位变成1      | (101001->101101,k=3)      | x or (1 shl (k-1))
//    把右数第k位变成0      | (101101->101001,k=3)      | x and not (1 shl (k-1))
//    右数第k位取反         | (101001->101101,k=3)      | x xor (1 shl (k-1))
//    取末三位              | (1101101->101)            | x and 7
//    取末k位               | (1101101->1101,k=5)       | x and (1 shl k-1)
//    取右数第k位           | (1101101->1,k=4)          | x shr (k-1) and 1
//    把末k位变成1          | (101001->101111,k=4)      | x or (1 shl k-1)
//    末k位取反             | (101001->100110,k=4)      | x xor (1 shl k-1)
//    把右边连续的1变成0    | (100101111->100100000)    | x and (x+1)
//    把右起第一个0变成1    | (100101111->100111111)    | x or (x+1)
//    把右边连续的0变成1    | (11011000->11011111)      | x or (x-1)
//    取右边连续的1         | (100101111->1111)         | (x xor (x+1)) shr 1
//    去掉右起第一个1的左边 | (100101000->1000)         | x and (x xor (x-1))

    public static void main(String[] args) {
        System.out.println(new NO190ReverseBits().reverseBits(43261596));
    }

    /*
    *   位运算
    *   （）
     * @Date 下午1:25 2019/3/7
     * 复杂度：
     * beats：100%
     **/
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int sum=0;
        for(int i=0;i<32;i++){
            System.out.println(n/2+"->"+n%2+"->"+sum);
            sum=(sum<<1)|(n & 1);
            n=n>>1;
        }
        return sum;
    }
}
