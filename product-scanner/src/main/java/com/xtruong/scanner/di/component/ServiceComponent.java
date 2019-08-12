package com.xtruong.scanner.di.component;

import com.xtruong.scanner.di.PerService;
import com.xtruong.scanner.di.module.ServiceModule;

import dagger.Component;

/**
 * Created by truongtx on 8/11/2019
 */
@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {
}
