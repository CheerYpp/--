package ypp.SpringFlow.flowDome.Common;

import net.sf.cglib.proxy.Enhancer;

public class SysUtil {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setUseCache(true);
        enhancer.setSuperclass(User.class);
        enhancer.setCallback(new MethodInterceptorImpl());
        User user = (User)enhancer.create();
        user.setName("张三");
        System.out.println(user.getName());
    }
}
