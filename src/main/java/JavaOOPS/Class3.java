package JavaOOPS;

public class Class3 extends Class4 {
    static int a;

    public Class3(int i) {
        super(i);
        a=i;
    }

    public static int increment(){
        a=a+1;
        return a;
    }

    public static int decrement(){
        a=a-1;
        return a;
    }
}
