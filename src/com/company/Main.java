package com.company;

import com.company.handler.PeopleHandler;
import com.company.object.People;
import com.company.object.PeopleImpl;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        People merry = (People) Proxy.newProxyInstance(People.class.getClassLoader(), new Class[]{People.class}, new PeopleHandler(new PeopleImpl("Merry")));
        People judy = (People) Proxy.newProxyInstance(People.class.getClassLoader(), new Class[]{People.class}, new PeopleHandler(new PeopleImpl("Judy")));

        merry.talking("헬로 월드!");
        judy.eating("사과");
        judy.eating("바나나");
        merry.studying("과학");
        judy.eating("후라이드 치킨");
        merry.studying("수학");
        judy.talking("저녁 시간 이에요!");

    }

}
