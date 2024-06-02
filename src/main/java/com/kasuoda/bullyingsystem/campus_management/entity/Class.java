package com.kasuoda.bullyingsystem.campus_management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class implements Serializable {

    @Id
    @TableId(value = "class_id",type = IdType.AUTO)
    private Integer classId;
    private String className;
}
