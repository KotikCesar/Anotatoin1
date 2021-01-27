import java.lang.reflect.Method;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface Test {
    int a();
    int b();


class Summa {
    @Test(a = 2, b = 5)
    public static void test(int a, int b) {
        System.out.println("result = " + (a + b));
    }
}

 public class Annotation {
    public static void main(String[] args) {
        try {
            Class<?> cl = Summa.class;
            Method method = cl.getMethod("test", int.class, int.class);
            if (method.isAnnotationPresent(Test.class)) {

                Test math = method.getAnnotation(Test.class);
                method.invoke(null, math.a(), math.b());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
} }
