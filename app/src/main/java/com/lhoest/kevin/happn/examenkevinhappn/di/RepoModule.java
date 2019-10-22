package com.lhoest.kevin.happn.examenkevinhappn.di;

import dagger.Module;
import dagger.Provides;

import com.lhoest.kevin.happn.examenkevinhappn.datasource.network.DayServiceImpl;
import com.lhoest.kevin.happn.examenkevinhappn.repository.DayRepository;
import com.lhoest.kevin.happn.examenkevinhappn.repository.DayRepositoryImpl;
import com.lhoest.kevin.happn.examenkevinhappn.repository.DayRepositoryStub;

@Module
public class RepoModule {

    // TODO: create build variant to change it on test
    @Provides
    static DayRepository provideRepo() {
        return new DayRepositoryImpl(new DayServiceImpl());
    }
}
