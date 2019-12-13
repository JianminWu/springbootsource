package com.cdt.metrics;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

/**
 * @Author: wujianmin
 * @Date: 2019/11/12 16:04
 * @Function:
 * @Version 1.0
 */
public class MetricUtils {

    private static class MetricRegistryHolder{
        private final static MetricRegistry registry = new MetricRegistry();
    }



    public static MetricRegistry getMetricRegistry(){
        return MetricRegistryHolder.registry;
    }
    private static class CountMetricHolder{
        private final static MetricRegistry registry = new MetricRegistry();
    }

    private static final Meter counterMetric = getMetricRegistry().register("TPS-meter",new Meter());

    public static Meter getCountMetric(){
        return counterMetric;
    }

}
