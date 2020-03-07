package com.merchant.flow.domain;

import java.util.ArrayList;
import java.util.List;

public enum CategoryEnum {

    a(1,"a"),
    b(2,"b"),
    ab(3,"ab"),

    c(4,"c"),
    ac(5,"ac"),
    bc(6,"bc"),
    abc(7,"abc"),

    ;

    private Integer code;
    private String name;

    CategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<CategoryEnum> getByCode(Integer code) {
        List<CategoryEnum> list = new ArrayList<>();
        if (code == null) {
            return list;
        }
        for (CategoryEnum value : CategoryEnum.values()) {
            if ((value.getCode() & (value.getCode()-1)) == 0 && (code & value.getCode()) > 0) {
                list.add(value);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<CategoryEnum> byCode = CategoryEnum.getByCode(7);
        for (CategoryEnum categoryEnum : byCode) {
            System.out.println(categoryEnum.getCode());
        }
    }

}
