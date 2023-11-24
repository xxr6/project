

import java.util.InputMismatchException;

import java.util.Scanner;

public class homework {
    public static void main(String[] args) {
        PasswordManager passwordManager = new PasswordManager();

        while (true) {
            System.out.println("======================");
            System.out.println("欢迎使用密码管理系统");
            System.out.println("======================");
            System.out.println("请选择操作");
            System.out.println("1.加密");
            System.out.println("2.解密");
            System.out.println("3.判断密码强度");
            System.out.println("4.密码生成");
            System.out.println("5.退出");
            System.out.println("请输入选项序号：");
            Scanner sc = new Scanner(System.in);
            try {
                int choose = sc.nextInt();
                switch (choose) {
                    case 1:
                        passwordManager.encryptPassword();
                        break;
                    case 2:
                        passwordManager.decryptPassword();
                        break;
                    case 3:
                        passwordManager.checkPasswordStrength();
                        break;
                    case 4:
                        passwordManager.generatePassword();
                        break;
                    case 5:
                        return;
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("请输入正确的数字");
            }
        }
    }
}

