package pl.edu.uwr.pum.wfiappkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private val institutes: ArrayList<Institute> = ArrayList()
    private val instituteAdapter by lazy { InstituteAdapter(this, institutes) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val gridColumnCount = resources.getInteger(R.integer.grid_column_count)
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, gridColumnCount)
            adapter = instituteAdapter
        }

        findViewById<FloatingActionButton>(R.id.fabRefreshButton).setOnClickListener {
            initializeData()
            instituteAdapter.notifyDataSetChanged()
        }

        val swipeDirs = if (gridColumnCount > 1) 0 else ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        val helper = ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT or
                    ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            swipeDirs
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val from = viewHolder.adapterPosition
                val to = target.adapterPosition

                Collections.swap(institutes, from, to)
                instituteAdapter.notifyItemMoved(from, to)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                institutes.removeAt(viewHolder.adapterPosition)
                instituteAdapter.notifyItemRemoved(viewHolder.adapterPosition)
            }

        })

        helper.attachToRecyclerView(recyclerView)

        initializeData()
    }

    private fun initializeData() {
        val instituteList = resources.getStringArray(R.array.institute_titles)
        val instituteInfo = resources.getStringArray(R.array.institute_info)

        val instituteImageResources = resources.obtainTypedArray(R.array.institute_images)

        institutes.clear()

        for (i in instituteList.indices) institutes.add(
            Institute(
                instituteList[i],
                instituteInfo[i],
                instituteImageResources.getResourceId(i, 0)
            )
        )

        instituteImageResources.recycle()
    }
}