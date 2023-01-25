package com.example.listtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() , PresidentsListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val presidentsListView :RecyclerView  = findViewById(R.id.presidents_list);
        val presidentsArray = resources.getStringArray(R.array.presidents)
        val presidentsListAdapter = PresidentsAdapter(presidentsArray, this)
        presidentsListView.adapter = presidentsListAdapter
    }

    override fun onItemClick(president: String) {

        //create a short Toast message
        Toast.makeText(baseContext, president, Toast.LENGTH_SHORT)
            .show()

        //alternatively we can create a Snackbar instead of a Toast
        //android.R.id.content finds the root element of current view
        Snackbar.make(findViewById(android.R.id.content), president, Snackbar.LENGTH_LONG)
            .show()
        val intent = Intent(baseContext, WebviewActivity::class.java)
        startActivity(intent)
    }
}
interface PresidentsListener{

    fun onItemClick(president: String){

    }

}
