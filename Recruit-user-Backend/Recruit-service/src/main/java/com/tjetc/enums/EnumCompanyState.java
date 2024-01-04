package com.tjetc.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlEnumValue;


@NoArgsConstructor
@AllArgsConstructor
public enum EnumCompanyState {
    //枚举类实例
    A(0,"A轮"),
    B(1,"B轮"),
    C(2,"C轮"),
    D(3,"D轮"),
    E(4,"已上市"),
    F(5,"未融资"),
    G(6,"不需要融资");
    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static EnumCompanyState getByCode(int code) {
        //获取枚举类中所有枚举对象
        EnumCompanyState[] values = EnumCompanyState.values();
        //遍历所有枚举值，判断枚举值的code是否与给定的code是否一致，
        for (EnumCompanyState value : values) {
            if (value.code == code) {
                return value;
            }
        }
        throw new RuntimeException("给定的code=" + code + ",不存在对应的枚举对象");
        //如果一致，直接返回枚举对象，如果没有对象的枚举对象，则抛出异常
    }
    public static EnumCompanyState getByName(String name) {
        EnumCompanyState[] values = EnumCompanyState.values();
        for (EnumCompanyState value : values) {
            if (value.name.equals(name) ) {
                return value;
            }
        }
        throw new RuntimeException("给定的name=" + name + ",不存在对应的枚举对象");
    }
}
