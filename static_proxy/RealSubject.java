package about_proxy.static_proxy;

/**
 * Created by solie_h on 2018/2/7.
 */
public class RealSubject implements Subject {

    @Override
    public void doSomething() {

        System.out.println("call doSomething()");

    }
}
