/*
package com.ismin.android

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val SERVER_BASE_URL = "https://app-0e186a35-b187-42f9-8331-300c0017c6f9.cleverapps.io"

class MainActivity : AppCompatActivity(), WomanCreator {

    private var listener: WomanCreator? = null
    lateinit var edtName: EditText
    lateinit var edtCategory: EditText
    lateinit var edtPlace: EditText
    lateinit var edtDesc1: EditText
    lateinit var edtDesc2: EditText
    lateinit var edtDesc3: EditText
    lateinit var edtDesc4: EditText
    lateinit var edtDesc5: EditText
    lateinit var edtLat: EditText
    lateinit var edtLong: EditText
    lateinit var edtURL: EditText
    lateinit var btnSave: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_create_woman, container, false)

        edtName = rootView.findViewById(R.id.f_create_woman_edt_name)
        edtCategory = rootView.findViewById(R.id.f_create_woman_edt_category)
        edtPlace = rootView.findViewById(R.id.f_create_woman_edt_place)
        edtDesc1 = rootView.findViewById(R.id.f_create_woman_edt_desc1)
        edtDesc2 = rootView.findViewById(R.id.f_create_woman_edt_desc2)
        edtDesc3 = rootView.findViewById(R.id.f_create_woman_edt_desc3)
        edtDesc4 = rootView.findViewById(R.id.f_create_woman_edt_desc4)
        edtDesc5 = rootView.findViewById(R.id.f_create_woman_edt_desc5)
        edtLat = rootView.findViewById(R.id.f_create_woman_edt_lat)
        edtLong = rootView.findViewById(R.id.f_create_woman_edt_long)
        edtURL = rootView.findViewById(R.id.f_create_woman_edt_url)

        btnSave = rootView.findViewById(R.id.f_create_woman_btn_save)

        btnSave.setOnClickListener {
            val name = edtName.text.toString()
            val desc1 = edtDesc1.text.toString()
            val desc2 = edtDesc2.text.toString()
            val desc3 = edtDesc3.text.toString()
            val desc4 = edtDesc4.text.toString()
            val desc5 = edtDesc5.text.toString()
            val place = edtPlace.text.toString()
            val category = edtCategory.text.toString()
            val long = edtLong.text.toString().toInt()
            val lat = edtLat.text.toString().toInt()
            val url = edtURL.text.toString()

            val woman = Woman(name, desc1,desc2,desc3,desc4,desc5,place,category, long, lat, url)
            listener?.onWomanCreated(woman)
        }

        return rootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is WomanCreator) {
            listener = context
        } else {
            throw RuntimeException("$context must implement WomanCreator")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = CreateWomanFragment()
    }
}

private val bookshelf = Bookshelf()
private val btnCreateBook: FloatingActionButton by lazy { findViewById(R.id.a_main_btn_create_book) }

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(SERVER_BASE_URL)
    .build()

private val bookService = retrofit.create(BookService::class.java)

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    bookService.getAllBooks()
        .enqueue(object : Callback<List<Book>> {
            override fun onResponse(
                call: Call<List<Book>>,
                response: Response<List<Book>>
            ) {
                val allBooks: List<Book>? = response.body()
                allBooks?.forEach {bookshelf.addBook(it)}
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Toast.makeText(applicationContext, "It fails with error", Toast.LENGTH_SHORT).show()
            }
        })

    displayBookListFragment()

    btnCreateBook.setOnClickListener {
        displayCreateBookFragment()
    }
}

private fun displayBookListFragment() {
    val bookListFragment = BookListFragment.newInstance(bookshelf.getAllBooks())
    supportFragmentManager.beginTransaction()
        .replace(R.id.a_main_frame_layout, bookListFragment)
        .commit()
    btnCreateBook.show()

}

private fun displayCreateBookFragment() {
    val createBookFragment = CreateBookFragment.newInstance()
    supportFragmentManager.beginTransaction()
        .replace(R.id.a_main_frame_layout, createBookFragment)
        .commit()
    btnCreateBook.hide()
}

override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    super.onCreateOptionsMenu(menu)
    menuInflater.inflate(R.menu.menu, menu)
    return true
}

override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
        R.id.menu_clean -> {
            bookshelf.clean()
            displayBookListFragment()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}

override fun onBookCreated(book: Book) {

    bookService.createBook(book)
        .enqueue(object : Callback<Book> {
            override fun onResponse(
                call: Call<Book>,
                response: Response<Book>
            ) {
                response.body()?.let {bookshelf.addBook(it)}
                displayBookListFragment()
            }

            override fun onFailure(call: Call<Book>, t: Throwable) {
                Toast.makeText(applicationContext, "It fails with error", Toast.LENGTH_SHORT).show()
            }
        })

}
}

 */