package com.cdt.hook;

import com.cdt.metrics.MetricUtils;
import com.codahale.metrics.ConsoleReporter;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wujianmin
 * @Date: 2019/11/12 16:32
 * @Function:
 * @Version 1.0
 */
@Component
public class MetricApplicationHook implements ApplicationRunner {
    private final static ConsoleReporter reporter = ConsoleReporter.forRegistry(MetricUtils.getMetricRegistry()).convertDurationsTo(TimeUnit.SECONDS).convertDurationsTo(TimeUnit.SECONDS).build();

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        reporter.start(15,TimeUnit.SECONDS);
    }
}
