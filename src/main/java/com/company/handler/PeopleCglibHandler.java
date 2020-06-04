package com.company.handler;

import com.company.object.MethodName;
import com.company.object.People;
import com.company.object.PeopleImpl;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class PeopleCglibHandler implements InvocationHandler {

    private final PeopleImpl original;

    public PeopleCglibHandler(PeopleImpl people){
        this.original = people;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        before();
        method.invoke(original, objects);
        after(method);

        return null;
    }

    private void before() {
        System.out.println(">>>>> "+original.getName()+"의 활동을 시작합니다.");
        original.nowState();
    }

    private void after(Method method) {
        MethodName target = MethodName.valueOf(method.getName().toUpperCase());

        if (target.isEquals(MethodName.TALKING, MethodName.STUDYING)) {
            System.out.println(">> 스태미너를 사용합니다.");
        } else if (target.isEquals(MethodName.EATING)) {
            System.out.println(">> 스태미너가 증가합니다.");
        }

        original.nowState();
        System.out.println(">>>>> "+original.getName()+"의 활동을 종료합니다.");
        original.readCount();
        System.out.println("\n\n");
    }
}
