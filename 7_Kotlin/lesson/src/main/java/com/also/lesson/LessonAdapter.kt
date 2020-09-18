package com.also.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.also.base.core.BaseViewHolder
import com.also.lesson.entity.Lesson

/**
 * 描述：
 * 作者：ye.yuan
 * 邮箱：galsomail@163.com
 * 创建时间：2020/9/18 10:39 PM
 */
class LessonAdapter:RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    private var list: List<Lesson> = ArrayList()

    fun updateAndNotify(list: List<Lesson>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder.onCreate(parent)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
       holder.onBind(list[position])
    }

    class LessonViewHolder(itemView: View) : BaseViewHolder(itemView) {

        companion object{
            fun onCreate(parent: ViewGroup):LessonViewHolder {
                return LessonViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_lesson, parent, false)

                )
            }
        }

        fun onBind(lesson: Lesson) {
            var date = lesson.date?:"日期待定"
            setText(R.id.tv_state, date)
            setText(R.id.tv_content, lesson.content)

            val state = lesson.state
            if (state != null) {
                setText(R.id.tv_state, state.stateName())
                var colorRes = R.color.playback
                when (state) {
                    Lesson.State.PLAYBACK -> colorRes = R.color.playback
                    Lesson.State.LIVE -> colorRes = R.color.live
                    Lesson.State.WAIT -> colorRes = R.color.wait
                }
                val backgroundColor = itemView.context.getColor(colorRes)
                getView<View>(R.id.tv_state).setBackgroundColor(backgroundColor)
            }
        }
    }
}