package com.company;

import com.company.handler.PeopleHandler;
import com.company.object.People;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        People people = (People) Proxy.newProxyInstance(People.class.getClassLoader(), new Class[]{People.class}, new PeopleHandler());
        people.talking("Hello world!");
        people.eating("chicken");
        people.studying("math");
        people.nowState();
    }
}
