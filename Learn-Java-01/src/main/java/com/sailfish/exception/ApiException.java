package com.sailfish.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sailfish
 * @create 2017-03-08-上午9:52
 */
@Getter
@Setter
public class ApiException extends RuntimeException {

    protected Long errorCode;
    protected Object data;

    public ApiException(Long errorCode, String message, Object data, Throwable e) {
        super(message, e);
        this.errorCode = errorCode;
        this.data = data;
    }

    public ApiException(Long errorCode, String message, Object data) {
        this(errorCode, message, data, null);
    }

    public ApiException(Long errorCode, String message) {
        this(errorCode, message, null, null);
    }

    public ApiException(String message, Throwable e) {
        this(null, message, null, e);
    }

    public ApiException() {

    }

    public ApiException(Throwable e) {
        super(e);
    }


    @ControllerAdvice(annotations = RestController.class)
    class ApiExceptionHandlerAdvice {

        /**
         * Handle exceptions thrown by handlers.
         */
        @ExceptionHandler(value = Exception.class)
        @ResponseBody
        public ResponseEntity<ErrorDTO> exception(Exception exception, HttpServletResponse response) {
            ErrorDTO errorDTO = new ErrorDTO();
            if (exception instanceof ApiException) {//api异常
                ApiException apiException = (ApiException) exception;
                errorDTO.setErrorCode(apiException.getErrorCode());
            } else {//未知异常
                errorDTO.setErrorCode(0L);
            }
            errorDTO.setTip(exception.getMessage());
            ResponseEntity<ErrorDTO> responseEntity = new ResponseEntity<>(errorDTO, HttpStatus.valueOf(response.getStatus()));
            return responseEntity;
        }

        @Setter
        @Getter
        class ErrorDTO {
            private Long errorCode;
            private String tip;
        }

    }
}
