package interview;

import com.sun.corba.se.impl.orbutil.CacheTable;

public class HookFunction {
    public static void main(String[] args) {
        HookFunction hook = new HookFunction();
        System.out.println(hook.mainFunction());
    }

    public int mainFunction() {
       return hookFunction(2, new CacheLoadble() {
           @Override
           public int load() {
               return 2;
           }

           @Override
           public int load2() {
               return 0;
           }
       });
    }

    public int hookFunction(int num, CacheLoadble locadble) {
        int c = locadble.load();
        return num + c;
    }
}
