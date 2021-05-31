package com.texnopos.redbook.ui.animal

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.room.Dao
import com.texnopos.redbook.R
import com.texnopos.redbook.data.RedBookDatabase
import com.texnopos.redbook.data.dao.AnimalDao
import com.texnopos.redbook.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_animal.*

class AnimalFragment : Fragment(R.layout.fragment_animal){

    private val myAdapter = AnimalListAdapter()
    private lateinit var dao: AnimalDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = myAdapter
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        val type = arguments?.getInt(MainActivity.TYPE_ID) ?: 1
        dao = RedBookDatabase.getInstance(requireContext()).dao()
        setData(type)
    }
    private fun setData(type : Int) {
        myAdapter.models = dao.getAllAnimals(type)
    }

}