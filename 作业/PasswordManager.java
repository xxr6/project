package 作业;

import java.util.Random;
import java.util.Scanner;

class PasswordManager {
    private static final int OFFSET = 3;
    private static final int MAX_LENGTH = 16;

    public void encryptPassword() {
        System.out.println("======================");
        System.out.println("欢迎使用密码管理系统");
        System.out.println("======================");
        System.out.print("请输入要加密的数字密码：");
        Scanner sc = new Scanner(System.in);
        String password = sc.next();
        String encryptedPassword = encrypt(password);
        System.out.println("加密后的结果是:" + encryptedPassword);
        System.out.println("按任意键返回");
        String word = sc.next();
        if (!word.isEmpty()) {
            return;
        }
    }

    public void decryptPassword() {
        System.out.println("======================");
        System.out.println("欢迎使用密码管理系统");
        System.out.println("======================");
        System.out.print("请输入要解密的数字密码：");
        Scanner sc = new Scanner(System.in);
        String encryptedPassword = sc.next();
        String decryptedPassword = decrypt(encryptedPassword);
        System.out.println("解密后的结果是:" + decryptedPassword);
        System.out.println("按任意键返回");
        String word = sc.next();
        if (!word.isEmpty()) {
            return;
        }
    }

    public void checkPasswordStrength() {
        System.out.println("======================");
        System.out.println("欢迎使用密码管理系统");
        System.out.println("======================");
        System.out.print("请输入密码：");
        Scanner sc = new Scanner(System.in);
        String password = sc.next();
        String passwordStrength = checkPasswordStrength(password);
        System.out.println("密码强度为:" + passwordStrength);
        System.out.println("按任意键返回");
        String word = sc.next();
        if (!word.isEmpty()) {
            return;
        }
    }

    public void generatePassword() {
        System.out.println("======================");
        System.out.println("欢迎使用密码管理系统");
        System.out.println("======================");
        System.out.print("请输入一个不小于3的密码长度：");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String generatedPassword = generatePassword(length);
        System.out.println("生成的随机密码为:" + generatedPassword);
        System.out.println("按任意键返回");
        String word = sc.next();
        if (!word.isEmpty()) {
            return;
        }
    }

    private String encrypt(String password) {
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (Integer.valueOf(chars[i]) + i + 1 + OFFSET);
        }
        char temp = chars[0];
        chars[0] = chars[chars.length - 1];
        chars[chars.length - 1] = temp;
        return new StringBuilder(new String(chars)).reverse().toString();
    }

    private String decrypt(String encryptedPassword) {
        char[] chars = new StringBuilder(encryptedPassword).reverse().toString().toCharArray();
        char temp = chars[0];
        chars[0] = chars[chars.length - 1];
        chars[chars.length - 1] = temp;
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (Integer.valueOf(chars[i]) - i - 1 - OFFSET);
        }
        return new String(chars);
    }

    private String checkPasswordStrength(String password) {
        // 判断密码长度
        if (password.length() < 8) {
            return "Weak";
        }

        // 判断是否只有一种字符类型
        boolean hasNumber = false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
        }

        // 判断密码强度
        if (hasNumber && (hasLowerCase || hasUpperCase)) {
            if (hasLowerCase && hasUpperCase) {
                return "Strong";
            } else {
                return "Medium";
            }
        } else {
            return "Weak";
        }
    }

    private String generatePassword(int length) {
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String digitChars = "0123456789";

        StringBuilder password = new StringBuilder();
        Random random = new Random();

        // 至少包含一个大写字母、一个小写字母、一个数字
        password.append(uppercaseChars.charAt(random.nextInt(uppercaseChars.length())));
        password.append(lowercaseChars.charAt(random.nextInt(lowercaseChars.length())));
        password.append(digitChars.charAt(random.nextInt(digitChars.length())));

        // 生成剩余长度的随机字符
        for (int i = 0; i < length - 3; i++) {
            String allChars = uppercaseChars + lowercaseChars + digitChars;
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // 将密码的字符顺序随机打乱
        char[] passwordChars = password.toString().toCharArray();
        for (int i = 0; i < passwordChars.length; i++) {
            int randomIndex = random.nextInt(passwordChars.length);
            char temp = passwordChars[i];
            passwordChars[i] = passwordChars[randomIndex];
            passwordChars[randomIndex] = temp;
        }

        return new String(passwordChars);
    }
}