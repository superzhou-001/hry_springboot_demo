package interview;

import java.lang.reflect.Field;

/**
 * 在不改变对象的情况下将 abc 改为abcd
 * */
public class Test01 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s1 = new String("abc");
        // 在这中间可以添加N行代码，但是必须保证s引用的指向不变，最终输出abcd
        // 错误： s1.replaceAll("abc", "abcd");
        // 考点反射
        Field value = s1.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(s1, "abcd".toCharArray());

        System.out.println(s1);
    }
}
