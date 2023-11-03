package project;
import java.util.Scanner;
public class main{
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("欢迎来到密码加解密系统");
            while (true) {
                System.out.println("请选择操作：");
                System.out.println("1. 加密");
                System.out.println("2. 解密");
                System.out.println("3. 退出系统");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("请输入一个要加密的数字：");
                        int num = scanner.nextInt();
                        Cipher ci = new Cipher();
                        ci.setNum(num);
                        ci.encryption();
                        break;
                    case 2:
                        System.out.println("请输入一个要解密的数字：");
                        num = scanner.nextInt();
                        Cipher ci1 = new Cipher();
                        ci1.setNum(num);
                        ci1.decrypt();
                        break;
                    case 3:
                        System.out.println("谢谢使用，再见！");
                        System.exit(0);
                    default:
                        System.out.println("输入无效，请输入正确的选项。");
                }
            }
        }
}//添加注释
//添加注释
