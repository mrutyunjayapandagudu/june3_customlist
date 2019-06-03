package com.example.iteradmin.june3_customlist

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list=findViewById<ListView>(R.id.list)
        val names= arrayOf("iron_man","Captain America","Thor","Hulk","Black Widow","Barton","ant man")
        val real_name= arrayOf("Robert Downy jr","Ress evens","Grass M Stone","mark proof","Scar Joo","Hawk eye","Scott lyn")
        val images= arrayOf("https://images5.alphacoders.com/101/1018167.jpg",
                "https://images2.alphacoders.com/100/1001031.jpg",
                "https://images7.alphacoders.com/997/997191.jpg",
                "https://images2.alphacoders.com/100/1001031.jpg",
                "https://images2.alphacoders.com/100/1001031.jpg",
                "https://images2.alphacoders.com/100/1001031.jpg",
                "https://images2.alphacoders.com/100/1001031.jpg",
                "https://images2.alphacoders.com/100/1001031.jpg")
        list.adapter=MyAdpter(this,names,real_name,images)
    }
    class MyAdpter(context: Context, names:Array<String>, real_name:Array<String>, images:Array<String>): BaseAdapter(){
        private val mContext: Context
        private val names:Array<String>
        private val real_name:Array<String>
        private val images:Array<String>
        init{
            mContext=context
            this.names=names
            this.real_name=real_name
            this.images=images
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layout: LayoutInflater =
                    mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rootview=layout.inflate(R.layout.card,null,true)
            val im=rootview.findViewById<ImageView>(R.id.icon)
            val tt=rootview.findViewById<TextView>(R.id.title)
            val tt1=rootview.findViewById<TextView>(R.id.sub_title)
          Glide.with(mContext).load(images[position]).into(im)

            tt.text=names[position]
            tt1.text=real_name[position]
            im.setOnClickListener(){
                Toast.makeText(mContext,names[position], Toast.LENGTH_LONG).show()
            }
            return rootview
        }

        override fun getItem(position: Int): Any {
            return "any"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return names.size
        }

    }
}


