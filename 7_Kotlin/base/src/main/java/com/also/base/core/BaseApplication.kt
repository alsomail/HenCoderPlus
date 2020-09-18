package com.also.base.core

import android.app.Application
import android.content.Context

/**
 * 描述：
 * 作者：ye.yuan
 * 邮箱：galsomail@163.com
 * 创建时间：2020/9/17 10:20 PM
 */
class BaseApplication : Application() {

    private lateinit var currentApplication:Context

    companion object{
        fun currentApplication():Context{
            return BaseApplication().currentApplication
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = this

    }
}