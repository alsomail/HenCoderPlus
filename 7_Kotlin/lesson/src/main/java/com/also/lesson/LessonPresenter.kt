package com.also.lesson

import com.also.base.core.http.EntityCallback
import com.also.base.core.http.HttpClient
import com.also.base.core.utils.toast
import com.also.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken

/**
 * 描述：
 * 作者：ye.yuan
 * 邮箱：galsomail@163.com
 * 创建时间：2020/9/18 9:46 PM
 */
class LessonPresenter(var activity: LessonActivity) {
    private val LESSON_PATH = "lessons"

    private var lessons:List<Lesson> = ArrayList()

    private val type= object : TypeToken<List<Lesson>>() {}.type

    fun fetchData(){
        HttpClient.INSTANCE.get(LESSON_PATH,type,object:EntityCallback<List<Lesson>>{
            override fun onSuccess(entity: List<Lesson>) {
                this@LessonPresenter.lessons=entity
                activity.runOnUiThread {
                    activity.showResult(lessons)
                }
            }

            override fun onFailure(message: String) {
                activity.runOnUiThread {
                    toast(message)
                }
            }

        })
    }

    fun showPlayback(){
        var playbackLessons=ArrayList<Lesson>()
        for (lesson in lessons) {
            if (lesson.state == Lesson.State.PLAYBACK) {
                playbackLessons.add(lesson)
            }
        }
        activity.showResult(playbackLessons)
    }

}