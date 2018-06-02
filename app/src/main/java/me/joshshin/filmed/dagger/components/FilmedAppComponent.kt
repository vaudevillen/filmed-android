package me.joshshin.filmed.dagger.components

import dagger.Component
import dagger.android.AndroidInjectionModule
import me.joshshin.filmed.FilmedApp
import javax.inject.Singleton

/**
 * Created by Josh Shin on 6/1/18
 */

@Singleton
@Component(modules = [AndroidInjectionModule::class])
interface FilmedAppComponent {
    fun inject(app: FilmedApp)
}