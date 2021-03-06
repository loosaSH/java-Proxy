package about_proxy.dynamic_proxy;

import org.omg.CORBA.portable.InvokeHandler;
import sun.rmi.runtime.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by solie_h on 2018/2/7.
 */
public class ProxyHandler implements InvocationHandler {

    private Object tar;


    public Object bind(Object tar)
    {
        this.tar = tar;
        //绑定该类实现的所有接口，取得代理类
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(), tar.getClass().getInterfaces(), this);
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;
        //这里就可以进行所谓的AOP编程了
        //在调用具体函数方法前，执行功能处理
        System.out.println("start time:"+System.currentTimeMillis());
        result = method.invoke(tar,args);
        //在调用具体函数方法后，执行功能处理
        System.out.println("end time:"+System.currentTimeMillis());
        return result;

    }




}

