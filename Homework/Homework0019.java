import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework0019 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<PrivateTest> aClass = PrivateTest.class;
        Object o = aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"网站到底");
        Method getname = aClass.getMethod("getName");
        Object invoke = getname.invoke(o);
        System.out.println(invoke);
    }
}
class PrivateTest{
    private String name ="helloKitty";

    public String getName() {
        return name;
    }
}
