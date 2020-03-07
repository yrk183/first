package com.merchant.flow.manage.impl;

import com.merchant.flow.anotation.TestPoint;
import com.merchant.flow.anotation.TestPoint2;
import com.merchant.flow.domain.StudentDO;
import com.merchant.flow.manage.CheckStudent;
import org.springframework.stereotype.Service;

@Service
public class CheckStudentImpl implements CheckStudent {

    @TestPoint2(rule = "studentDO.name")
    @Override
    public void check(String ss, StudentDO studentDO) {
        //我和我的祖国 一刻也不能分割 无论你走到哪里 都留下一首赞歌 我歌唱每一座高山 我歌唱每一条河 袅袅炊烟
        System.out.println("=============================");
        System.out.println(studentDO.getName());
    }
}
