package com.example.chat.component

import com.example.chat.activity.MainActivity
import com.example.chat.module.ChatModule
import dagger.Component

@Component(modules=[ChatModule::class])
interface ChatComponent {
    fun inject(activity: MainActivity)
}