package com.example.searchablerecyclerview.kotlin

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.DefaultRetryPolicy
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.searchablerecyclerview.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import java.util.*

class MainActivity : AppCompatActivity(),AnimalsAdapter.AnimalsAdapterListener {

    lateinit var recyclerView: RecyclerView
    lateinit var searchView: SearchView
    lateinit var requestQueue: RequestQueue
    var url = "http://192.168.75.5/www.android.com/searchRv/get_animals.php"
    lateinit var adapter: AnimalsAdapter
    var animalList: MutableList<Animal>? = null
//    private var recyclerViewAdapter: CatalogAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        //make toolbar look wow!
        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setTitle(R.string.toolbar_title)
        recyclerView = findViewById(R.id.recyclerView)
        animalList = ArrayList()
        adapter = AnimalsAdapter(this, animalList as ArrayList<Animal>)
        //initialize requestQueue
        requestQueue = Volley.newRequestQueue(this)

        //notification bar white background
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
//        getAnimals()
        loadData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu?.findItem(R.id.action_search)?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.maxWidth = Int.MAX_VALUE

        //implement a listener
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                adapter.getFilter().filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adapter.getFilter().filter(newText)
                return false
            }
        })

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        return if (id == R.id.action_search) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        //close search view
        if (!searchView.isIconified) {
            searchView.isIconified = true
            return
        }
        super.onBackPressed()
    }

    private fun getAnimals() {
        val request = JsonArrayRequest(url, Response.Listener { response ->
            if (response == null) {
                Toast.makeText(applicationContext, "Couldn't get animals", Toast.LENGTH_SHORT).show()
                return@Listener
            }
            val items = Gson().fromJson<List<Animal>>(response.toString(), object : TypeToken<List<Animal?>?>() {}.type)
            //adding animals to the list
            animalList?.clear()
            animalList?.addAll(items)
            //refresh Rv
            adapter.notifyDataSetChanged()
        }, Response.ErrorListener { error -> error.printStackTrace() })
        requestQueue.add(request)
    }

    private fun loadData() {

        val str = object : StringRequest(
                Method.POST, url,
                Response.Listener { response ->

                    val jsonArray = JSONArray(response)

                    for (i in 0 until jsonArray.length()) {

                        //getting product object from json array
                        val product = jsonArray.getJSONObject(i)

                        //adding the product to product list
                        val catalog = Animal(
                                product.getString("name"),
                                product.getString("location"),
                                product.getString("img")
                        )
                        animalList?.add(catalog)

                    }
                    adapter = AnimalsAdapter(
                            this,
                            animalList as ArrayList<Animal>
                    )
                    recyclerView.adapter = adapter

                },
                Response.ErrorListener { error ->
                    error.printStackTrace()

                }) {
            override fun getParams(): Map<String, String> {
                val param = HashMap<String, String>()

                return param
            }
        }
        str.retryPolicy = DefaultRetryPolicy(
                7000,
                5,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )
        requestQueue.add(str)
    }

    override fun onAnimalSelected(animal: Animal) {
        Toast.makeText(applicationContext, "Selected: " + animal.name, Toast.LENGTH_SHORT).show()
    }

}
