package com.sailfish.domain;

import java.util.Set;

import lombok.Data;

/**
 * @author sailfish
 * @create 2017-03-08-上午9:09
 */
@Data
public class User {

    private Integer id;
    private String name;//姓名

    private Set<Address> addresses;
}
