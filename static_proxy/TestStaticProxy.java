package about_proxy.static_proxy;

/**
 * Created by solie_h on 2018/2/7.
 */
public class TestStaticProxy {

    public static void main(String args[]) {
//        Subject sub = new RealSubject();
        Subject sub = new SubjectProxy();
        sub.doSomething();
    }
}
