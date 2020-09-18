package com.also.base.core.http

import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Type

/**
 * 描述：
 * 作者：ye.yuan
 * 邮箱：galsomail@163.com
 * 创建时间：2020/9/18 9:59 PM
 */
class HttpClient private constructor(): OkHttpClient() {

    companion object{
        val INSTANCE = HttpClient()
    }

    private val gson = Gson()

    private fun <T> convert(json:String?,type: Type):T{
        return gson.fromJson(json, type)
    }

    public fun <T> get(path: String, type: Type, entityCallback: EntityCallback<T>) {
        val request = Request.Builder().url("https://api.hencoder.com/$path")
            .build()
        val call = INSTANCE.newCall(request)

        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                entityCallback.onFailure("网络异常")
            }

            override fun onResponse(call: Call, response: Response) {
                when (response.code()) {
                    in 200..299 -> {
                        val body = response.body()
                        var json: String? = null
                        try {
                            json = body?.string()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                        entityCallback.onSuccess(convert(json, type))
                    }
                    in 400..499 -> entityCallback.onFailure("客户端错误")
                    in 501..599 -> entityCallback.onFailure("服务器错误")
                    else -> entityCallback.onFailure("未知错误")
                }
            }
        })
    }
}