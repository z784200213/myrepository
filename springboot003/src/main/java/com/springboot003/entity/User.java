package com.springboot003.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Levin
 * @since 2018/5/7 0007
 */
@Entity(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 8655851615465363473L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    /**
     * TODO 忽略该字段的映射
     */
    @Transient
    private String  email;

    // TODO  省略get set
}
