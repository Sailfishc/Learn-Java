package com.sailfish.domain;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author sailfish
 * @create 2017-03-08-上午9:07
 */
@Data
public class Address {

    private Integer id;
    @NotNull
    private String province;//省
    @NotNull
    private String city;//市
    @NotNull
    private String county;//区
    private Boolean isDefault;//是否是默认地址

    private User user;
}
