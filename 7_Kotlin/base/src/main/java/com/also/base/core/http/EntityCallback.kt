package com.also.base.core.http

/**
 * 描述：
 * 作者：ye.yuan
 * 邮箱：galsomail@163.com
 * 创建时间：2020/9/18 10:10 PM
 */
interface EntityCallback<T> {

    fun onSuccess(entity:T)

    fun onFailure(message: String)

}