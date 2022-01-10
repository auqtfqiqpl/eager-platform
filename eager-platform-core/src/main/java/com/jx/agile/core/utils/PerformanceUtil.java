package com.jx.agile.core.utils;

import com.jx.agile.core.model.BizCostTime;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class PerformanceUtil {

    private static double mb = 1024 * 1024 * 1.0;

    private static Long threshold = 2000L;


    private static  boolean  isEnable = true;


    private static ConcurrentHashMap<String,Boolean> threadStatusMap = new ConcurrentHashMap<>();

    private static ThreadLocal<BizCostTime> timeMapLocal = new ThreadLocal<>();


    public static void setIsEnable(boolean isEnable) {
        isEnable = isEnable;
    }


    /**
     * 查看内存使用率
     * @param stage
     * @return
     */
    public static double lookMemorySituation(String stage){
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long maxMemory = runtime.maxMemory();
        double scale = 1-freeMemory/totalMemory;
        if(scale > 0.8){
            scale = freeMemory/maxMemory;
            if(scale > 0.85){
                log.warn("{}-->最大内存使用率:{}%",new Object[]{stage,scale*100});
            }
        }
        log.info("{}-->最大可使用内存:{}M,可使用内存:{}M,剩余内存:{}M",new Object[]{stage,maxMemory/mb,totalMemory/mb,freeMemory/mb});
        return  1-scale;
    }

    /**
     * 超过设置响应的时间阀值
     * @param biz
     * @param tempThreshold
     */
    public static void startTime(final String biz, final Long tempThreshold) {
        if(isEnable){

            Thread logThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        timeMapLocal.set(new BizCostTime(biz,System.currentTimeMillis()));
                            boolean isEnd = threadStatusMap.get(biz);
                        while (!isEnd) {
                            isEnd = threadStatusMap.get(biz);
                        }
                        long currentTime = System.currentTimeMillis();
                        long costTime = currentTime -timeMapLocal.get().getCostTime();
                        if(costTime>tempThreshold){
                            log.warn("{}业务超时预警-->识别业务耗时:{}",timeMapLocal.get().getBiz(), costTime);
                        }else{
                            log.warn("{}-->识别业务耗时:{}", timeMapLocal.get().getBiz(), costTime);
                        }
                    }finally {
                        threadStatusMap.remove(biz);
                        timeMapLocal.remove();
                    }
                }
            });
            threadStatusMap.put(biz,false);
            logThread.start();

        }
    }

    public static void startTime(final String biz){
       startTime(biz,threshold);
    }


    public static void endTime(final String biz){
        if(threadStatusMap.containsKey(biz)){
            threadStatusMap.put(biz,true);
        }
    }
}
