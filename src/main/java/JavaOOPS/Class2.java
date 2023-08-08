package JavaOOPS;

import org.testng.annotations.Test;


public class Class2 extends Class1 {
    @Test
    public void test() {
        doThis();
        Class3 object = new Class3(3);
        System.out.println(Class3.increment());
        System.out.println(Class3.decrement());
        System.out.println(Class3.multiplyTwo());

    }


}
