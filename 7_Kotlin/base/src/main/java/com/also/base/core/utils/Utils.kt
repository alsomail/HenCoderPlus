package com.also.base.core.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.Toast
import com.also.base.core.BaseApplication

/**
 * 描述：
 * 作者：ye.yuan
 * 邮箱：galsomail@163.com
 * 创建时间：2020/9/17 10:17 PM
 */
private val displayMetrics = Resources.getSystem().displayMetrics

fun dp2px(dp:Float):Float{
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp, displayMetrics)
}

fun toast(string:String){
    toast(string,Toast.LENGTH_SHORT)
}

fun toast(string: String, duration: Int) {
    Toast.makeText(BaseApplication.currentApplication(),string,duration).show()
}