package com.xtruong.scanner.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by truongtx on 8/11/2019
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
