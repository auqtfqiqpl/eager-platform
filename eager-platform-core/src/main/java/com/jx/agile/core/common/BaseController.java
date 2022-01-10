package com.jx.agile.core.common;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jx.agile.core.constant.ResultMsgConstant;
import com.jx.agile.core.model.BaseEntity;
import com.jx.agile.core.utils.ResultUtils;
import com.jx.agile.core.web.Result;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/03/04/18:16
 * @Description:
 */
public class BaseController<Service extends IBaseService<T>,T extends BaseEntity> {

    @Autowired(required = false)
    private Service service;


    /**
     * 获取所有数据
     * @return
     */
    @GetMapping("/getAll")
    public Result<List<T>> getAll(){
        List<T> list = service.list();
        return ResultUtils.success(list);
    }

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    @GetMapping("/getById")
    public Result<T> getById(Long id) {
        if (id == null || id == 0){
            return ResultUtils.fail(ResultMsgConstant.FAIL, "id参数不正确");
        }
        T t = service.getById(id);
        return ResultUtils.success(t);
    }

    /**
     * 根据IDS批量查询
     * @param ids
     * @return
     */
    @PostMapping("/getByIds")
    public Result<List<T>> getById(Set<Long> ids){
        if(CollectionUtils.isEmpty(ids)){
            return ResultUtils.fail(ResultMsgConstant.FAIL,"ids参数为空");
        }
        List<T> list = (List<T>) service.listByIds(ids);
        return ResultUtils.success(list);
    }

    /**
     * 根据map条件查询数据
     * @param conditionMap
     * @return
     */
    @PostMapping("/getByMapConditon")
    public Result<List<T>> getByMapConditon(@RequestBody HashMap conditionMap){
        if(null == conditionMap || conditionMap.isEmpty()){
            return ResultUtils.fail(ResultMsgConstant.FAIL,"查询条件为空");
        }
        List<T> list = (List<T>) service.listByMap(conditionMap);
        return ResultUtils.success(list);
    }

    /**
     * 根据实体条件查询数据
     * @param entityCondition
     * @return
     */
    @PostMapping("/getByConditon")
    public Result<List<T>> getByConditon(@Validated @RequestBody T entityCondition) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if(null == entityCondition ){
            return ResultUtils.fail(ResultMsgConstant.FAIL,"查询条件为空");
        }
        Map conditionMap = BeanUtilsBean.getInstance().describe(entityCondition);

        List<T> list = (List<T>) service.listByMap(conditionMap);
        return ResultUtils.success(list);
    }


//    /**
//     * 根据实体条件查询数据
//     * @param entityCondition
//     * @return
//     */
//    @PostMapping("/getPageByConditon")
//    public Result<Page<List<T>>> getPageByConditon(@Validated @RequestBody <T extends BasePage> entityCondition) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        if(null == entityCondition ){
//            return ResultUtils.fail(ResultMsgConstant.FAIL,"查询条件为空");
//        }
//        Map conditionMap = BeanUtilsBean.getInstance().describe(entityCondition);
//
//        List<T> list = (List<T>) service.listByMap(conditionMap);
//        return ResultUtils.success(list);
//    }


    /**
     * 保存数据
     * @param data
     * @return
     */
    @PostMapping("/save")
    public Result<T> save(@RequestBody T data){
        boolean insertResult = service.save(data);
        if(!insertResult){
            return ResultUtils.fail("添加失败",data);
        }
        return  ResultUtils.success(data);
    }

    /**
     * 批量保存数据
     * @param listData
     * @return
     */
    @PostMapping("/saveBatch")
    public Result<List<T>> saveBatch(@RequestBody List<T> listData){
        if(CollectionUtils.isEmpty(listData)){
            return ResultUtils.fail("参数为空");
        }
        boolean insertResult = service.saveBatch(listData,listData.size());
        if(!insertResult){
            return ResultUtils.fail("添加失败",listData);
        }
        return  ResultUtils.success(listData);
    }


    /**
     * 更新数据
     * @param data
     * @return
     */
    @PostMapping("/updateById")
    public Result<T> updateById(@RequestBody T data){
        if(null == data){
            return ResultUtils.fail("参数为空");
        }
        boolean insertResult = service.updateById(data);
        if(!insertResult){
            return ResultUtils.fail("更新失败",data);
        }
        return  ResultUtils.success(data);
    }

    /**
     * 批量更新数据
     * @param listData
     * @return
     */
    @PostMapping("/updateBatchById")
    public Result<List<T>> updateBatchById(@RequestBody List<T> listData){
        if(CollectionUtils.isEmpty(listData)){
            return ResultUtils.fail("参数为空");
        }
        boolean insertResult = service.updateBatchById(listData,listData.size());
        if(!insertResult){
            return ResultUtils.fail("更新失败",listData);
        }
        return  ResultUtils.success(listData);
    }


    /**
     * 保存数据
     * @param data
     * @return
     */
    @PostMapping("/saveOrUpdate")
    public Result<T> saveOrUpdate(@RequestBody T data){
        if(null == data){
            return ResultUtils.fail("参数为空");
        }
        boolean insertResult = service.saveOrUpdate(data);
        if(!insertResult){
            return ResultUtils.fail("添加失败",data);
        }
        return  ResultUtils.success(data);
    }

    /**
     * 批量保存数据
     * @param listData
     * @return
     */
    @PostMapping("/saveOrUpdateBatch")
    public Result<List<T>> saveOrUpdateBatch(@RequestBody List<T> listData){
        if(CollectionUtils.isEmpty(listData)){
            return ResultUtils.fail("参数为空");
        }
        boolean insertResult = service.saveOrUpdateBatch(listData,listData.size());
        if(!insertResult){
            return ResultUtils.fail("添加失败",listData);
        }
        return  ResultUtils.success(listData);
    }



    /**
     *根据ID删除数据
     * @param id
     * @return
     */
    @GetMapping("/delById")
    public Result<Boolean> delById(Long id){
        boolean flag = service.removeById(id);
        return ResultUtils.success(flag);
    }


    /**
     * 根据ids批量删除数据
     * @param ids
     * @return
     */
    @GetMapping("/delByIds")
    public Result<Boolean> delByIds(Set<Long> ids){
        if(CollectionUtils.isEmpty(ids)){
            return ResultUtils.fail("参数为空");
        }
        boolean flag = service.removeByIds(ids);
        return ResultUtils.success(flag);
    }


    /**
     * 根据map条件删除数据
     * @param conditionMap
     * @return
     */
    @PostMapping("/delByMap")
    public Result<Boolean> delByMap(@RequestBody HashMap conditionMap){
        if(null == conditionMap || conditionMap.isEmpty()){
            return ResultUtils.fail(ResultMsgConstant.FAIL,"查询条件为空");
        }
        boolean flag =  service.removeByMap(conditionMap);
        return ResultUtils.success(flag);
    }

}
