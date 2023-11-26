import java.util.Scanner;
import java.util.Random;

public class PasswordManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("请选择操作：");
            System.out.println("1.加密");
            System.out.println("2.解密");
            System.out.println("3.判断密码强度");
            System.out.println("4.密码生成");
            System.out.println("5.退出");
            System.out.print("请输入选项序号：");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        encryptPassword(scanner);  // 调用加密密码方法
                        break;
                    case 2:
                        decryptPassword(scanner);   // 调用解密密码方法
                        break;
                    case 3:
                        checkPasswordStrength(scanner);   // 调用判断密码强度方法
                        break;
                    case 4:
                        generatePassword(scanner);  // 调用生成密码方法
                        break;
                    case 5:
                        System.out.println("谢谢使用！");
                        break;
                    default:
                        System.out.println("无效的选项，请重新输入。");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("无效的选项，请重新输入。");
            }
            System.out.println();
        } while (choice != 5);
    }
//加密方法
    public static void encryptPassword(Scanner scanner) {
        System.out.print("请输入要加密的密码：");
        String password = scanner.nextLine();
        String encryptedPassword = "";
        for (int i = 0; i < password.length(); i++) {
            int ascii = password.charAt(i);
            ascii += i + 1 + 3;
            encryptedPassword += (char) ascii;
        }
        encryptedPassword = swapFirstAndLastChar(encryptedPassword); // 调用交换首尾字符方法
        encryptedPassword = reverseString(encryptedPassword);  //调用翻转字符串方法
        System.out.println("加密后的密码为：" + encryptedPassword);
    }
//解密方法
    public static void decryptPassword(Scanner scanner) {
        System.out.print("请输入要解密的密码：");
        String encryptedPassword = scanner.nextLine();
        encryptedPassword = reverseString(encryptedPassword); //调用翻转字符串方法
        encryptedPassword = swapFirstAndLastChar(encryptedPassword); // 调用交换首尾字符方法
        String password = "";
        for (int i = 0; i < encryptedPassword.length(); i++) {
            int ascii = encryptedPassword.charAt(i);
            ascii -= i + 1 + 3;
            password += (char) ascii;
        }
        System.out.println("解密后的密码为：" + password);
    }
//这个是判断密码强度方法
    public static void checkPasswordStrength(Scanner scanner) {
        System.out.print("请输入要判断强度的密码：");
        String password = scanner.nextLine();
        if (password.length() < 8) {
            System.out.println("密码强度为：弱");
        } else if (password.matches("^[0-9]+$") || password.matches("^[a-zA-Z]+$")) {
            System.out.println("密码强度为：弱");
        } else if (password.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).+$")) {
            System.out.println("密码强度为：中");
        } else if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).+$")) {
            System.out.println("密码强度为：强");
        } else {
            System.out.println("无法判断密码强度。");
        }
    }
//这个是生成密码方法
    public static void generatePassword(Scanner scanner) {
        System.out.print("请输入要生成的密码长度：");
        int length = Integer.parseInt(scanner.nextLine());
        String password = "";
        Random random = new Random();
        while (password.length() < length) {
            int type = random.nextInt(3);
            if (type == 0) {
                password += (char) (random.nextInt(10) + '0');
            } else if (type == 1) {
                password += (char) (random.nextInt(26) + 'a');
            } else {
                password += (char) (random.nextInt(26) + 'A');
            }
        }
        System.out.println("生成的密码为：" + password);
    }
//交换首尾字符方法
    public static String swapFirstAndLastChar(String str) {
        if (str.length() <= 1) {
            return str;
        }
        char[] chars = str.toCharArray();
        char temp = chars[0];
        chars[0] = chars[chars.length - 1];
        chars[chars.length - 1] = temp;
        return new String(chars);
    }
//反转字符串方法
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
//邓佳戎和何文浩的修改1212121212