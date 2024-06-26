package com.kasuoda.bullyingsystem.util;

import lombok.Data;

@Data
public class R {
  //
  private  Boolean flag;
  //
  private Object data;
  //
  private  String msg;
  public  R(boolean flag){
    this.flag=flag;
  }
  public  R(){}

  public R(Boolean flag, Object data) {
    this.flag = flag;
    this.data = data;
  }

  public R(Boolean flag, String msg) {
    this.flag = flag;
    this.msg = msg;
  }
}

