package com.bisaai.webinarroom

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var dataSiswa = mutableListOf<UserEntity>()
    private lateinit var viewModel: DataViewModel
    private lateinit var mAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()
        viewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)
        viewModel.dataUser.observe(this, Observer {
            dataSiswa.addAll(it)
            mAdapter.notifyDataSetChanged()
        })
        viewModel.getAllData()
        fabMain.setOnClickListener {
            val intent = Intent(this, InsertUpdateActivity::class.java)
            intent.putExtra(InsertUpdateActivity.DATAFLAG, InsertUpdateActivity.TAMBAHDATA)
            startActivity(intent)
        }
    }

    private fun setRecyclerView() {
        val mLayoutManager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        mAdapter = UserAdapter(dataSiswa){ data, position, check ->
            when(check){
                1 -> {
                    val intent = Intent(this, InsertUpdateActivity::class.java)
                    intent.putExtra(InsertUpdateActivity.DATAFLAG, InsertUpdateActivity.EDITDATA)
                    intent.putExtra(InsertUpdateActivity.DATA, data)
                    startActivity(intent)
                }
                2 -> {
                    viewModel.deleteData(data)
                    dataSiswa.removeAt(position)
                    mAdapter.notifyDataSetChanged()
                }
            }
        }
        rvMain.apply {
            layoutManager = mLayoutManager
            addItemDecoration(decoration)
            adapter = mAdapter
        }
    }

    override fun onRestart() {
        super.onRestart()
        dataSiswa.clear()
        mAdapter.notifyDataSetChanged()
        viewModel.getAllData()
    }
}