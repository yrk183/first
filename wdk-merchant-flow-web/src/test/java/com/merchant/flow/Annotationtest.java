package com.merchant.flow;

import com.merchant.flow.domain.StudentDO;
import com.merchant.flow.manage.CheckStudent;
import org.junit.Test;

import javax.annotation.Resource;

public class Annotationtest extends BaseTest{

    @Resource
    public CheckStudent checkStudent;

    @Test
    public void test() {
        StudentDO studentDO = new StudentDO();
        studentDO.setName("小明");
        checkStudent.check("123456", studentDO);
    }

}
