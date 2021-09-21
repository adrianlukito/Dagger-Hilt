package com.adrianlukito.daggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
    }
}

//~1: constructor injection - The dependencies are provided through a client's class constructor.
//
//~2: constructor injection - Constructor Injection is the act of statically defining the list of required
//Dependencies by specifying them as parameters to the class’s constructor.

class SomeClass @Inject constructor(
    private val someInterfaceImpl: SomeInterface
){
    fun doAThing(): String{
        return "Look I got: ${someInterfaceImpl.getAThing()}"
    }
}

class SomeInterfaceImpl @Inject constructor() : SomeInterface {
    override fun getAThing() : String {
        return "A Thing"
    }
}

interface SomeInterface {

    fun getAThing(): String
}

// 2 option to inject interface/instance
// @Provides
// @Binds

@InstallIn(SingletonComponent::class)
@Module
abstract class MyModule {

//    PROVIDES
    @Singleton
    @Provides
    fun provideSomeInterface (): SomeInterface {
        return SomeInterfaceImpl()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

//    BINDS
//    @Singleton
//    @Binds
//    abstract fun bindSomeDependency (
//        someImpl: SomeInterfaceImpl
//    ): SomeInterface
//
//    @Singleton
//    @Binds
//    abstract fun bindGson(
//        gson: Gson
//    ): Gson
}






