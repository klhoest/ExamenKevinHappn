package com.lhoest.kevin.happn.examenkevinhappn.di;

import dagger.Component;

@Component(modules = RepoModule.class)
public interface MainComponent {

    ViewModelFactory getViewModelFactory();
}
