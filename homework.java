package 作业;
import IO流.checkout;

import java.util.Scanner;
public class homework {
    private static final int OFFSET = 3;
    private static final int MAX_LENGTH = 16;
    public static void main(String[] args) {
        while (true){
            System.out.println("======================");
            System.out.println("欢迎使用密码管理系统");
            System.out.println("======================");
            System.out.println("请选择操作");
            System.out.println("1.加密");
            System.out.println("2.解密");
            System.out.println("3.退出");
            System.out.println("请输入选项序号：");
            Scanner sc=new Scanner(System.in);
            int choose=sc.nextInt();
            if (choose==1){
                System.out.println("======================");
                System.out.println("欢迎使用密码管理系统");
                System.out.println("======================");
                System.out.print("请输入要加密的数字密码：");
                String password=sc.next();

                System.out.println("加密后的结果是:"+encrypt(password));
                System.out.println("按任意键返回");
                String word=sc.next();
                if (word.length()!=0){
                    continue;
                }

            }else if (choose==2){
                System.out.println("======================");
                System.out.println("欢迎使用密码管理系统");
                System.out.println("======================");
                System.out.print("请输入要解密的数字密码：");
                String password=sc.next();
                System.out.println("解密后的结果是:"+decrypt(password));
                System.out.println("按任意键返回");
                String word=sc.next();
                if (word.length()!=0){
                    continue;
                }
            }else {
                return;
            }

        }


    }
        // 加密函数
        public static String encrypt(String password) {
            char[] chars = password.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) (Integer.valueOf(chars[i]) + i + 1 + OFFSET);
            }
            char temp = chars[0];
            chars[0] = chars[chars.length - 1];
            chars[chars.length - 1] = temp;
            return new StringBuilder(new String(chars)).reverse().toString();
        }
         // 解密函数
    public static String decrypt(String encryptedPassword) {
        char[] chars = new StringBuilder(encryptedPassword).reverse().toString().toCharArray();
        char temp = chars[0];
        chars[0] = chars[chars.length - 1];
        chars[chars.length - 1] = temp;
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (Integer.valueOf(chars[i]) - i - 1 - OFFSET);
        }
        return new String(chars);
    }

//来自许睿的修改
    


}
