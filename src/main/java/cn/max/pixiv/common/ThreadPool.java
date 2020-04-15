package cn.max.pixiv.common;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * @author MaxStar
 * @date 2020/4/11
 */
public class ThreadPool {

    /**
     * clean http thread pool
     */
    public static ScheduledExecutorService scheduledPool = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(true).build());

    /**
     * crawler pool
     */
    public static ExecutorService crawlerPool = new ThreadPoolExecutor(5,
            20,
            60 * 1000,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(),
            new BasicThreadFactory.Builder().namingPattern("crawler-pool-%d").daemon(true).build());
}