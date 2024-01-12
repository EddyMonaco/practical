package com.cids.eduardo.exception;

import com.cids.eduardo.model.DefaultError;
import org.hibernate.TransientPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ExceptionHandlerEx extends ResponseEntityExceptionHandler {


        @ExceptionHandler(MethodArgumentTypeMismatchException.class)
        public ResponseEntity handlerException(Exception e) {

            DefaultError errorDefault = new DefaultError(HttpStatus.BAD_GATEWAY.value(),  "The provided arg must be an integer, check for the ID of the product provided");
            return new ResponseEntity(errorDefault, HttpStatus.BAD_GATEWAY);

        }

        @ExceptionHandler(TransientPropertyValueException.class)
        public ResponseEntity handlerException2(Exception e) {

            DefaultError errorDefault = new DefaultError(HttpStatus.BAD_GATEWAY.value(),  "The provided body must be completed with the needed information, check the passed data");
            return new ResponseEntity(errorDefault, HttpStatus.BAD_GATEWAY);
        }

        @ExceptionHandler(NullPointerException.class)
        public ResponseEntity handlerException3(Exception e) {

            DefaultError errorDefault = new DefaultError(HttpStatus.BAD_GATEWAY.value(),  "Null value, kindly check the ID provided if is correct");
            return new ResponseEntity(errorDefault, HttpStatus.BAD_GATEWAY);
        }


}

