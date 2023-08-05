package com.example.test_0_15_0;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;

@Service
public class TestComponent {

    private final String METRIC_NAME = "test.metric";

    @Autowired
    MeterRegistry meterRegistry;

    AtomicInteger val1;
    AtomicInteger val2;

    Counter count1;
    Counter count2;

    @PostConstruct
    public void init() {
        this.val1 = this.meterRegistry.gauge(METRIC_NAME, Arrays.asList(Tag.of("type", "This is val1 metric")), new AtomicInteger(0));

        this.val2 = this.meterRegistry.gauge(METRIC_NAME, Arrays.asList(Tag.of("type", "This is val2 metric")), new AtomicInteger(0));

        this.count1 = this.meterRegistry.counter(METRIC_NAME, Arrays.asList(Tag.of("type", "This is count1 metric")));

        this.count2 = this.meterRegistry.counter(METRIC_NAME, Arrays.asList(Tag.of("type", "This is count2 metric")));
    }

}
