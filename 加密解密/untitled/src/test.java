public class test {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("abdba"));
        System.out.println(isPalindrome("abc"));
    }
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString(); // 反转字符串
        return str.equals(reversed); // 比较反转后的字符串与原来的字符串
    }
}
//许睿
// 邓佳戎修改代码
