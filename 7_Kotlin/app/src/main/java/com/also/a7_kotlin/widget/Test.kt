package com.also.a7_kotlin.widget

import android.util.Log

/**
 * 描述：
 * 作者：ye.yuan
 * 邮箱：galsomail@163.com
 * 创建时间：2020/9/24 9:55 PM
 */

class View{
    fun setOnClickListener(listener: (View) -> Unit) {
    }
}
fun main(){
    var array= ArrayList<String>()
    with(array) {
        add("1")
        add("2")
        add("3")
        this
    }.let {
        println(it)
    }

}

inline fun log(text: String) {
    println("=======")
    println(text)
    println("=======")
}

fun onClick(view: View) {

}