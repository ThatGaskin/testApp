package eu.barcikowski.proexetestapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import eu.barcikowski.proexetestapp.Utility.JsonUtil
import eu.barcikowski.proexetestapp.adapter.SampleItemAdapter
import eu.barcikowski.proexetestapp.model.Item
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var URL_DATA : String = "http://client.proexe.eu/json.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var adapter : RecyclerView.Adapter<SampleItemAdapter.ViewHolder>
        var item : List<Item>

//        val swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.activity_main_swipe_refresh_layout)
//        swipeRefreshLayout.setOnRefreshListener { loadJSON() }

        val linearLayoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL, false)
        val helper = LinearSnapHelper()

        helper.attachToRecyclerView(recyclerView)
        recyclerView.layoutManager = linearLayoutManager
        val jsonUtil = JsonUtil()
        item = jsonUtil.loadURLData(URL_DATA, applicationContext)
        recyclerView.adapter = SampleItemAdapter(item, applicationContext)

    }




}
