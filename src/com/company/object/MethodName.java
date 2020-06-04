package com.company.object;

import java.util.Arrays;
import java.util.List;

public enum MethodName {

    TALKING("talking"),
    STUDYING("studying"),
    EATING("eating"),
    NOWSTATE("nowState");

    private String realName;

    MethodName(String realName) {
        this.realName = realName;
    }

    public boolean isEquals(MethodName... methodNames) {
        List<MethodName> methodNameList = Arrays.asList(methodNames);

        return methodNameList.contains(this.realName);
    }

}
