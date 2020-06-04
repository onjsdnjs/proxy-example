package com.company.object;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum MethodName {

    TALKING("talking"),
    STUDYING("studying"),
    EATING("eating");

    private String realName;

    MethodName(String realName) {
        this.realName = realName;
    }

    public static boolean isEquals(String realName, MethodName ...methodNames){
        MethodName target = MethodName.valueOf(realName.toUpperCase());
        List<MethodName> methodNameList = Arrays.asList(methodNames);

        return methodNameList.contains(target);
    }

}
