package com.lhoest.kevin.happn.examenkevinhappn.di;

import dagger.Module;
import dagger.Provides;
import kevin.repository.DayRepository;
import kevin.repository.DayRepositoryStub;

@Module
public class RepoModule {

    // TODO: create build variant to change it on test
    @Provides
    static DayRepository provideRepo() {
        return new DayRepositoryStub();
    }
}
