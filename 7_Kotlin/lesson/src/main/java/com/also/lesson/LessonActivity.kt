package com.also.lesson

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.also.base.core.BaseView
import com.also.base.core.utils.get
import com.also.base.core.utils.save
import com.also.lesson.entity.Lesson

/**
 * 描述：
 * 作者：ye.yuan
 * 邮箱：galsomail@163.com
 * 创建时间：2020/9/18 12:35 AM
 */
class LessonActivity:AppCompatActivity(), BaseView<LessonPresenter>,Toolbar.OnMenuItemClickListener {

    override val presenter: LessonPresenter by lazy {
        LessonPresenter(this)
    }

    var token:String
        set(value){
            save("token", value)
        }
        get() {
            return get("token")
        }

    private var lessonAdapter = LessonAdapter()

    private lateinit var refreshLayout:SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu_lesson)
        toolbar.setOnMenuItemClickListener(this)

        var recyclerView=findViewById<RecyclerView>(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = lessonAdapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

        refreshLayout = findViewById(R.id.swipe_refresh_layout)
        refreshLayout.setOnRefreshListener {
            presenter.fetchData()
        }
        refreshLayout.isRefreshing = true

        presenter.fetchData()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        presenter.showPlayback()
        return false
    }

    public fun showResult(lessons: List<Lesson>) {
        lessonAdapter.updateAndNotify(lessons)
        refreshLayout.isRefreshing = false

    }

}