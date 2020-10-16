package com.also.base.core.utils

import android.content.Context
import android.text.Editable
import com.also.base.R
import com.also.base.core.BaseApplication

/**
 * 描述：
 * 作者：ye.yuan
 * 邮箱：galsomail@163.com
 * 创建时间：2020/9/17 10:25 PM
 */
private var context = BaseApplication.currentApplication

private var SP =
    context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

fun save(key: String, value: String) = SP.edit().putString(key, value).apply()

fun get(key: String) = SP.getString(key, "")!!

