package project;
import java.util.*;
public class Cipher{
    private int num;

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
    public void encryption(){ //加密
		//将数的个位和十位交换位置
        swap();
        int c1=weishu(num);
		//每位数都加上5，且对10求余
        int password = addFiveToDigits(num);
        password*=2;
		//反转位数
        password = reverseDigits(password);
        int c2=weishu(password);
            while(c1!=c2){
                password*=10;
                c2++;
            }
        System.out.println("加密结果：" + password);
    }
    public int addFiveToDigits(int num) {
        int digitsAdded = 0;
        int multiplier = 1;
        while (num > 0) {
            int digit = (num % 10 + 5) % 10;
            num /= 10;
            digitsAdded += digit * multiplier;
            multiplier *= 10;
        }
        return digitsAdded;
    }
    public int reverseDigits(int number) { //反转数字
        int reversedNumber = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            number /= 10;

            reversedNumber = reversedNumber * 10 + lastDigit;
        }
        return reversedNumber;
    }
    public int weishu(int number){ //统计位数
        int count=0;
        while(number!=0){
            number /=10;
            count++;
        }
        return count;
    }
    public void swap(){ //交换个位和十位
        int temp=num%100;
        int a=(temp%10)*10;
        a+=temp/10;
        num-=temp;
        num+=a;
    }
    public void decrypt(){ //解密
        int c1=weishu(num);
        int ming= reverseDigits(num);
        ming/=2;
        ming = subFiveToDigits(ming);
        int temp=ming%100;
        int a=(temp%10)*10;
        a+=temp/10;
        ming-=temp;
        ming+=a;
        int c2=weishu(ming);
        while(c1!=c2){
            int cnt=1;
            int t=c2;
            while(t!=0){
                cnt*=10;
                t--;
            }
            ming+=(5*cnt);
            c2++;
        }
        System.out.println("解密结果：" + ming);
    }
    public int subFiveToDigits(int num) {
        int digitsSubed = 0;
        int multiplier = 1;
        while (num > 0) {
            int digit =( (num % 10 +10) - 5 ) %10;
            num /= 10;
            digitsSubed += digit * multiplier;
            multiplier *= 10;
        }
        return digitsSubed;
    }
}
