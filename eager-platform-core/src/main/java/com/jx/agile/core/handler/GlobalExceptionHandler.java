package com.jx.agile.core.handler;

import com.jx.agile.core.constant.ResultMsgConstant;
import com.jx.agile.core.constant.ResultStatusConstant;
import com.jx.agile.core.exception.BussinessException;
import com.jx.agile.core.exception.SystemException;
import com.jx.agile.core.utils.ExceptionUtil;
import com.jx.agile.core.web.Result;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 业务异常
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BussinessException.class)
    public Result BussinessException(BussinessException ex) {
        return new Result(ex.getStatus(),ex.getMessage());
    }


    /**
     * 系统异常
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = SystemException.class)
    public Result SystemException(SystemException ex) {
        return new Result(ex.getStatus(),ex.getMessage());
    }


    /**
     * 其它系统异常
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result Exception(Exception ex) {
        log.error("Exception 异常：{}",ex);
        return new Result(ResultStatusConstant.FAIL, ResultMsgConstant.FAIL, ExceptionUtil.transform(ex));
    }

    /**
     * 空指针异常  这类比较特殊
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = NullPointerException.class)
    public Result NullPointerException(NullPointerException ex) {
        log.error("NullPointerException 异常：{}",ex);
        return new Result(ResultStatusConstant.FAIL, ResultMsgConstant.FAIL, ExceptionUtil.transform(ex));
    }
}
