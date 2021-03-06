package com.also.base.core

import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

/**
 * 描述：
 * 作者：ye.yuan
 * 邮箱：galsomail@163.com
 * 创建时间：2020/9/18 9:28 PM
 */
public abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewHashMap = HashMap<Int, View>()

    protected fun <T:View> getView(@IdRes id:Int):T{
        var view = viewHashMap[id]
        if (view == null) {
            view = itemView.findViewById(id)
            viewHashMap.put(id, view)
        }
        return view as T
    }

    protected fun setText(@IdRes id: Int, text: String?) {
        getView<TextView>(id).text = text
    }
}