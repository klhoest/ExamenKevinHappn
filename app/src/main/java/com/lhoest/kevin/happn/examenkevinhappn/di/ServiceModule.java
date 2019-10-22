package com.lhoest.kevin.happn.examenkevinhappn.di;

import com.lhoest.kevin.happn.examenkevinhappn.datasource.DayService;
import com.lhoest.kevin.happn.examenkevinhappn.datasource.network.DayServiceImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

    // TODO: create build variant to change it on test
    @Provides
    static DayService provideRepo() {
        return new DayServiceImpl();
    }
}
