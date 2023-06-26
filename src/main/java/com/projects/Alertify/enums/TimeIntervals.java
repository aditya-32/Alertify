package com.projects.Alertify.enums;

import java.util.concurrent.TimeUnit;

public enum TimeIntervals {
    TIME_1_MIN(1, TimeUnit.MINUTES),
    TIME_10_MIN(10, TimeUnit.MINUTES),
    TIME_20_MIN(20, TimeUnit.MINUTES),
    TIME_30_MIN(30, TimeUnit.MINUTES),
    TIME_40_MIN(40, TimeUnit.MINUTES),
    TIME_1_HR(1, TimeUnit.HOURS),
    TIME_2_HR(2, TimeUnit.HOURS),
    TIME_3_HR(3, TimeUnit.HOURS);

    private final Integer duration;
    private final TimeUnit unit;

    TimeIntervals(int duration, TimeUnit unit) {
        this.duration = duration;
        this.unit = unit;
    }

    public Integer getDuration() {
        return duration;
    }

    public TimeUnit getUnit() {
        return unit;
    }
}
