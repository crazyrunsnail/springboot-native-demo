package com.github.crazyrunsnail.snd.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("users")
public class User {
    @TableId
    private Long id;

    private String name;

    private Integer age;

    @TableField("created_at")
    private LocalDateTime createdAt;
}
