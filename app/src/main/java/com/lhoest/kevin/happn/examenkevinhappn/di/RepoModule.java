package com.lhoest.kevin.happn.examenkevinhappn.di;

import dagger.Module;
import dagger.Provides;

import com.lhoest.kevin.happn.examenkevinhappn.datasource.network.DayService;
import com.lhoest.kevin.happn.examenkevinhappn.repository.DayRepository;
import com.lhoest.kevin.happn.examenkevinhappn.repository.DayRepositoryImpl;

@Module
public class RepoModule {

    // TODO: create build variant to change it on test
    @Provides
    static DayRepository provideRepo() {
        return new DayRepositoryImpl(new DayService());
    }
}
