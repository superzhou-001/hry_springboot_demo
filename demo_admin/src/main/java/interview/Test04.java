package interview;

/*
 String、 StringBuffer、StringBuilder 区别
 1、String 是不可变的， 如果尝试修改, 会新生成一个字符串对象， 而 StringBuffer和 StringBuilder是可变的
 2、StringBuffer是线程安全的、 StringBuilder是线程不安全的，所以在单线程环境下StringBuilder效率会更高
 */

/*
 ArrayList和LinkedList区别
 * 1、底层数据结构不同， ArrayList底层基于数组实现的， LinkedList底层是基于链表实现的  ---双端队列
     ArrayList 在扩容的时候插入效率会慢
 * 2、由于底层数据结构不同，它们所适用的场景也不同，ArrayList更适合随机查找，LinkedList更适合删除和添加
     查询、添加、删除的时间复杂度不同
 * 3、另外ArrayList和LinkedList都实现了List接口，但是LinkedList还额外实现了Deque接口，所以LinkedList还可以当做队列来使用
 * */

/*
 CopyOnWriteArrayList的底层原理是怎样的
 * 1、CopuOnWriteArrayList内部也是用数组来实现的，在向CopyOnWriteArrayList添加元素时，会复制一个新的数组，
      写操作在新数组上进行，读操作在原数组上执行
   2、并且，写操作会加锁，防止出现并发写入丢失数据的问题 （线程安全）
   3、写操作结束之后会把原数组指向新数组
   4、CopuOnWriteArrayList允许在写操作时来读取数据，大大提高了读的性能，因此适合读多写少的应用场景，
     但是CopuOnWriteArrayList会比较占用内存，同时可能读到的数据不是实时最新的数据，所以不适合实时性要求高的场景
 *
 * */

/*
  HashMap的扩容机制
  1.7版本 --- 数组 + 链表
    1、先生成数组
    2、遍历老数组中的每个位置上的链表的每个元素
    3、取每个元素的key, 并基于新数组的长度，计算出每个元素在新数组中的下标
    4、将元素添加到新数组中
    5、所有元素转移完了之后、将新数组赋值给HashMap对象的tabile属性

  1.8版本 --- 数组 O(1) + 链表O(n) + 红黑树O(logN)
    链表长度为8的时候 会转为红黑树， 为什么是8 因为数学有个 泊松分布概率
    1、先生成数组
    2、遍历老数组中的每个位置上的链表或者红黑树
    3、如果是链表，则直接将链表中的每个元素重新计算下标，并添加到新数组中去
    4、如果是红黑树，则先遍历红黑树，先计算出红黑树中每个元素对应在新数组中的下标位置
       a、统计每个下标位置的元素个数
       b、如果该位置下的元素个数超过了8，则生成一个新的红黑树，并将根节点添加到新数组对应的位置
       c、如果该位置下的元素个数没有超过8，那么则生成一个链表，并将链表的头节点添加到新数组的对应位置
    5、所有元素转移完了之后、将新数组赋值给HashMap对象的tabile属性
*/

/*
    ConcurrentHashMap的扩容机制
    ConcurrentHashMap 插的时候要检查东西很多（各种cas判断），则效率相对来说慢
    ConcurrentHashMap 解决读取效率 高并发使用
    1.7版本
      1、1.7版本的 ConcurrentHashMap是基于Segment分段实现的
      2、每个Segment相当于一个小型的HashMap
      3、每个Segment内部会进行扩容，和HashMap的扩容逻辑类似
      4、先生成新的数组，然后转移元素到新数组中
      5、扩容的判断也是每个Segment内部单独判断的，判断是否超过阈值
    1.8版本
      1、1.8版本的ConcurrentHashMap不在基于Segment实现
      2、当某个线程进行put时，如果发现ConcurrentHashMap正在进行扩容那么该线程一起扩容
      3、如果某个线程put时，发现没有正在扩容，则将key-value添加到ConcurrentHashMap中，然后判断是否超过阈值，
         超过了则进行扩容
      4、ConcurrentHashMap是支持多个线程同时扩容的
      5、扩容钱也是先生成一个新数组
      6、在转移元素时，先将原数组分组，将每组分给不同的线程来进行元素的转移, 每个线程负责一组或者多组的元素转移工作
      ConcurrentHashMap 类似于HashMap的扩容逻辑类似
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test04 {
    public static void main(String[] args) {
        String s = "abc";
        s = "abcd";
        ArrayList<String> list = new ArrayList<>(); // 线程不安全 数组
        LinkedList<String> list1 = new LinkedList<>(); // 链表
        CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<>(); // 线程安全 写时加锁



    }

}
