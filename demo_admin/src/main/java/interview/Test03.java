package interview;

import java.sql.SQLOutput;
/*
    在Interger类中，存在一个静态内部类IntegerCache,该类中存在一个Integer cache[], 并且存在一个static块，
    会在加载类的时候执行，会将-128至127这些数字提前生成Intger对象，并缓存在cache数组中，
    当我们在定义Integer数字时，会调用Integer的valueOf方法， valueOf方法会判断所定义的数字是否在-128至127之间，
    如果存在则直接从cache数组中获取Integer对象，如果超过,则生成一个新的Integer对象
*/
public class Test03 {
    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        System.out.println(i1 == i2); // true
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4); // false


    }
}
