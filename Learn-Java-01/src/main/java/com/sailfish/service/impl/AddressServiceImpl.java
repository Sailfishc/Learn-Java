package com.sailfish.service.impl;


import com.google.common.base.Preconditions;

import com.sailfish.domain.Address;
import com.sailfish.domain.User;
import com.sailfish.service.IAddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.validation.Validator;

/**
 * @author sailfish
 * @create 2017-03-08-上午9:12
 */
@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private Validator validator;

    @Override
    public Address createAddress(Integer uid, Address address) {
        //============ 以下为约束条件   ==============
        //1.用户id不能为空，且此用户确实是存在的
        Preconditions.checkNotNull(uid);
        User user = new User();
        if(null == user){
            throw new RuntimeException("找不到当前用户!");
        }

        //2.收货地址的必要字段不能为空
//        BeanValidators.validateWithException(validator, address);

        return null;
    }

    @Override
    public void deleteAddress(Integer uid, Integer aid) {

    }

    @Override
    public List<Address> listAddresses(Integer uid) {
        return null;
    }
}
