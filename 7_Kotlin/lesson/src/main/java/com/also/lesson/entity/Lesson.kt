package com.also.lesson.entity

/**
 * 描述：
 * 作者：ye.yuan
 * 邮箱：galsomail@163.com
 * 创建时间：2020/9/18 9:48 PM
 */
class Lesson(var date: String?, var content: String?, var state: State?){
    enum class State{
        PLAYBACK{
            override fun stateName():String{
                return "有回放"
            }
        },
        LIVE{
            override fun stateName():String{
                return "正在直播"
            }
        },
        WAIT{
            override fun stateName():String{
                return "等待中"
            }
        };
        abstract fun stateName():String
    }
}