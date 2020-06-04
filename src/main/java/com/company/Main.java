package com.company;

import com.company.handler.PeopleCglibHandler;
import com.company.handler.PeopleHandler;
import com.company.object.People;
import com.company.object.PeopleImpl;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        /**
         * JDK dynamic proxy */
        //People merry = (People) Proxy.newProxyInstance(People.class.getClassLoader(), new Class[]{People.class}, new PeopleHandler(new PeopleImpl("Merry")));
        //People judy = (People) Proxy.newProxyInstance(People.class.getClassLoader(), new Class[]{People.class}, new PeopleHandler(new PeopleImpl("Judy")));

        //merry.talking("헬로 월드!");
        //judy.eating("사과");
        //judy.eating("바나나");
        //merry.studying("과학");
        //judy.eating("후라이드 치킨");
        //merry.studying("수학");
        //judy.talking("저녁 시간 이에요!");

        //캐스팅 실패
        //PeopleImpl merryImpl = (PeopleImpl) merry;
        //merryImpl.readCount();



        /**
         *  cglib */
        PeopleImpl uzu = (PeopleImpl) Enhancer.create(PeopleImpl.class, new PeopleCglibHandler(new PeopleImpl("Uzu")));
        PeopleImpl ruby = (PeopleImpl) Enhancer.create(PeopleImpl.class, new PeopleCglibHandler(new PeopleImpl("Ruby")));

        uzu.talking("저는 우주입니다!");
        ruby.talking("저는 루비입니다!!");
        ruby.studying("Java");
        uzu.studying("C++");
        ruby.eating("치킨");

    }

}
