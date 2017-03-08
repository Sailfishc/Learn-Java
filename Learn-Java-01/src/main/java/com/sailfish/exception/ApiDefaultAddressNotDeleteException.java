package com.sailfish.exception;

import com.sailfish.common.AddressErrorCode;

/**
 * @author sailfish
 * @create 2017-03-08-上午9:53
 */
public class ApiDefaultAddressNotDeleteException extends ApiException {

    public ApiDefaultAddressNotDeleteException(String message) {
        super(AddressErrorCode.DefaultAddressNotDeleteErrorCode, message, null);
    }
}
