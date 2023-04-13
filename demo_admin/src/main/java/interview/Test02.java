package interview;

public class Test02 {

    public static void main(String[] args) {
        String s1 = new String("abc");// 2个对象 String对象 堆里
        String s2 = "abc";// 字符串常量对象--- 字符串常量池
        String s3 = s1.intern();
        // String 对象的intern方法，首先会检查字符串常量池中是否存在abc,
        // 如果存在则返回该字符串引用，如果不存在，则把abc添加到字符串常量池中， 并返回该字符串引用
        System.out.println("---"+(s2 == s3));



    }
}
