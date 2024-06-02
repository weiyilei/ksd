package com.kasuoda.bullyingsystem.campus_management.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum RecordStatus {
    REPORTED(0, "已经上报，还未处理"),
    CHECKED(1,"老师处理完成，获得回执"),
    CLOSED(2,"家长得到确认，确定结束");

    @EnumValue
    private final int code;

    private final String msg;

    RecordStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
