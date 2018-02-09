package about_proxy.dynamic_proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by solie_h on 2018/2/7.
 */
public class TestDynamicProxy {

    public static void main(String args[]){
//        Subject sub = new RealSubject();
        ProxyHandler proxy = new ProxyHandler();
        //绑定该类实现的所有接口
        Subject sub = (Subject) proxy.bind(new RealSubject());
        String path = "/Users/solie_h/Downloads/TestProxy.class";
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0",RealSubject.class.getInterfaces());
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        sub.doSomething();

    }

}
