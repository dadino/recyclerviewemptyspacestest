package com.dadino.recyclerviewemptyspacestest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val list = findViewById<RecyclerView>(R.id.list)
		list.adapter = TestAdapter()
		list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

		list.setOnClickListener { Toast.makeText(this, "List clicked", Toast.LENGTH_SHORT).show() }
	}
}

class TestAdapter : RecyclerView.Adapter<TestHolder>() {
	private val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
	private var layoutInflater: LayoutInflater? = null

	override fun onBindViewHolder(holder: TestHolder, position: Int) {
		holder.bindView(list[position].toString())
	}

	override fun getItemCount(): Int {
		return list.size
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
		return TestHolder(inflate(parent, R.layout.item_test))
	}

	private fun inflate(parent: ViewGroup, @android.support.annotation.LayoutRes layoutId: Int): android.view.View {
		return inflater(parent.context).inflate(layoutId, parent, false)
	}

	private fun inflater(context: android.content.Context): LayoutInflater {
		if (layoutInflater == null) layoutInflater = LayoutInflater.from(context)
		return layoutInflater!!
	}
}

class TestHolder(view: View) : RecyclerView.ViewHolder(view) {
	private val textview: TextView = view.findViewById(R.id.textview)

	init {
		view.setOnClickListener { Toast.makeText(view.context, "Item clicked: $layoutPosition", Toast.LENGTH_SHORT).show() }
	}

	fun bindView(string: String) {
		textview.text = string

	}

}
