import java.util.Scanner;
import java.util.Random;

public class PasswordManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("��ѡ�������");
            System.out.println("1.����");
            System.out.println("2.����");
            System.out.println("3.�ж�����ǿ��");
            System.out.println("4.��������");
            System.out.println("5.�˳�");
            System.out.print("������ѡ����ţ�");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        encryptPassword(scanner);  // ���ü������뷽��
                        break;
                    case 2:
                        decryptPassword(scanner);   // ���ý������뷽��
                        break;
                    case 3:
                        checkPasswordStrength(scanner);   // �����ж�����ǿ�ȷ���
                        break;
                    case 4:
                        generatePassword(scanner);  // �����������뷽��
                        break;
                    case 5:
                        System.out.println("ллʹ�ã�");
                        break;
                    default:
                        System.out.println("��Ч��ѡ����������롣");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("��Ч��ѡ����������롣");
            }
            System.out.println();
        } while (choice != 5);
    }
//���ܷ���
    public static void encryptPassword(Scanner scanner) {
        System.out.print("������Ҫ���ܵ����룺");
        String password = scanner.nextLine();
        String encryptedPassword = "";
        for (int i = 0; i < password.length(); i++) {
            int ascii = password.charAt(i);
            ascii += i + 1 + 3;
            encryptedPassword += (char) ascii;
        }
        encryptedPassword = swapFirstAndLastChar(encryptedPassword); // ���ý�����β�ַ�����
        encryptedPassword = reverseString(encryptedPassword);  //���÷�ת�ַ�������
        System.out.println("���ܺ������Ϊ��" + encryptedPassword);
    }
//���ܷ���
    public static void decryptPassword(Scanner scanner) {
        System.out.print("������Ҫ���ܵ����룺");
        String encryptedPassword = scanner.nextLine();
        encryptedPassword = reverseString(encryptedPassword); //���÷�ת�ַ�������
        encryptedPassword = swapFirstAndLastChar(encryptedPassword); // ���ý�����β�ַ�����
        String password = "";
        for (int i = 0; i < encryptedPassword.length(); i++) {
            int ascii = encryptedPassword.charAt(i);
            ascii -= i + 1 + 3;
            password += (char) ascii;
        }
        System.out.println("���ܺ������Ϊ��" + password);
    }
//������ж�����ǿ�ȷ���
    public static void checkPasswordStrength(Scanner scanner) {
        System.out.print("������Ҫ�ж�ǿ�ȵ����룺");
        String password = scanner.nextLine();
        if (password.length() < 8) {
            System.out.println("����ǿ��Ϊ����");
        } else if (password.matches("^[0-9]+$") || password.matches("^[a-zA-Z]+$")) {
            System.out.println("����ǿ��Ϊ����");
        } else if (password.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).+$")) {
            System.out.println("����ǿ��Ϊ����");
        } else if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).+$")) {
            System.out.println("����ǿ��Ϊ��ǿ");
        } else {
            System.out.println("�޷��ж�����ǿ�ȡ�");
        }
    }
//������������뷽��
    public static void generatePassword(Scanner scanner) {
        System.out.print("������Ҫ���ɵ����볤�ȣ�");
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
        System.out.println("���ɵ�����Ϊ��" + password);
    }
//������β�ַ�����
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
//��ת�ַ�������
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
//�˼��ֺͺ��ĺƵ��޸�1212121212