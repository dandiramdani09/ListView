package com.example.listview2
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.view.*

class MainActivity : AppCompatActivity() {

var listBahasa=ArrayList<bahasa>()
    var adapter:AdapterBahasa?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
listBahasa.add(
    bahasa("Ruby","bahasa pemrograman dinamis berbasis skrip yang berorientasi objek",R.drawable.ruby))
        listBahasa.add(
            bahasa("python","bahasa pemrograman interpretatif multiguna dengan filosofi perancangan yang berfokus pada tingkat keterbacaan kode.",R.drawable.python))
        listBahasa.add(
            bahasa("Ralls","sebuah kerangka kerja aplikasi web sumber terbuka yang berjalan via bahasa pemrograman Ruby.",R.drawable.jangkrik))
        listBahasa.add(
            bahasa("JavaScript","ahasa pemrograman tingkat tinggi dan dinamis.",R.drawable.java))
        listBahasa.add(
            bahasa("PHP","bahasa skrip yang dapat ditanamkan atau disisipkan ke dalam HTML.",R.drawable.php))

        adapter=AdapterBahasa(listBahasa,this)
        listView.adapter=adapter

    }
inner class AdapterBahasa: BaseAdapter {
    var listBahasa= ArrayList<bahasa>()
    var contex: Context?=null

    constructor(listBahasa: ArrayList<bahasa>, contex: Context?) : super() {
        this.listBahasa = listBahasa
        this.contex = contex
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val bahasa =listBahasa[p0]
        val inflator= contex!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
        var myView =
            inflator.inflate(R.layout.row,null)
        myView.nama.text=bahasa.nama!!
        myView.title.text=bahasa.deskripsi!!
        myView.image.setImageResource(bahasa.gambar!!)
        return myView


    }

    override fun getItem(p0: Int): Any {
        return listBahasa[p0]

    }

    override fun getItemId(p0: Int): Long {
       return p0.toLong()
    }

    override fun getCount(): Int {
        return listBahasa.size
    }

}
}
ROW:
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="16dp"
    >
    <ImageView
        android:layout_width="75dp"
        android:layout_height="75dp"
        android:src="@mipmap/ic_launcher"
        android:id="@+id/image"/>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <TextView
            android:id="@+id/nama"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="5dp"
            android:text="Title"
            android:textColor="#000"
            android:textSize="20dp"
            android:textStyle="bold" />

        <TextView
            android:id="@+id/title"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="5dp"
            android:text="title"
            android:textColor="#9E7E7E"
            android:textSize="15dp"
            android:textStyle="bold" />
    </LinearLayout>

</LinearLayout>
