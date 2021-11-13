package ypp.SpringFlow.flowDome.Common;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MethodInterceptorImpl implements MethodInterceptor {
    private Map<String,Object> map=new HashMap<String, Object>();
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String methodName = method.getName();
        if (methodName.contains("set")){
            map.put(methodName.substring(2),objects[0]);
            return null;
        }else if (methodName.contains("get")){
            if (!method.getReturnType().getName().equals("void")){
                return map.get(methodName.substring(2));
            }
        }
        return null;
    }
}




