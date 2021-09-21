package com.adrianlukito.daggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
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
    private val someDependency: SomeInterface, // compile time error, cannot do constructor injection when injected interface
    private val gson: Gson // compile time error, something not own, such as thrid party library
){
    fun doAThing(): String{
        return "Look I got: ${someDependency.getAThing()}"
    }
}

class SomeDependency @Inject constructor() : SomeInterface {
    override fun getAThing() : String {
        return "A Thing"
    }
}

interface SomeInterface {

    fun getAThing(): String
}