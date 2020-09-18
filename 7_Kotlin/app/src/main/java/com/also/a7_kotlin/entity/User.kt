package com.also.a7_kotlin.entity

import com.also.base.core.utils.get

/**
 * 描述：
 * 作者：ye.yuan
 * 邮箱：galsomail@163.com
 * 创建时间：2020/9/18 12:27 AM
 */
class User(var username: String?, var password: String?, var code: String?) {

    constructor() : this(null, null, null)

}