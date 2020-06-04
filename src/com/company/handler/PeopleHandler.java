package com.company.handler;

import com.company.object.MethodName;
import com.company.object.People;
import com.company.object.PeopleImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PeopleHandler implements InvocationHandler {

    private final People original = new PeopleImpl();

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        if(MethodName.isEquals(method.getName(), MethodName.TALKING, MethodName.STUDYING)){
            method.invoke(original, objects);
            System.out.println(">> 스태미너를 사용합니다.");
        }else if(MethodName.isEquals(method.getName(), MethodName.EATING)){
            method.invoke(original, objects);
            System.out.println(">> 스태미너가 증가합니다.");
        }

        System.out.println(">>>>> 활동을 종료합니다.");
        return null;
    }
}
