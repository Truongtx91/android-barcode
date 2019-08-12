package com.xtruong.scanner.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by truongtx on 8/11/2019
 */
public interface ISchedulerProvider {
    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}
