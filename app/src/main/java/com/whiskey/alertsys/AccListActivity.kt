package com.whiskey.alertsys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class AccListActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var accidentRecyclerView: RecyclerView
    private lateinit var accidentList : ArrayList<Accident>
    private lateinit var logoutBtn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acc_list)

        logoutBtn = findViewById(R.id.logout_icon)
        logoutBtn.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        accidentRecyclerView = findViewById(R.id.accList)
        accidentRecyclerView.layoutManager = LinearLayoutManager(this)
        accidentRecyclerView.setHasFixedSize(true)

        accidentList = arrayListOf<Accident>()
        getAccidentData()

    }

    private fun getAccidentData() {
        dbref = FirebaseDatabase.getInstance().getReference("Accidents")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {
                    for(accidentSnapShot in snapshot.children){


                        val accident = accidentSnapShot.getValue(Accident::class.java)
                        accidentList.add(accident!!)
                    }

                    accidentRecyclerView.adapter = MyAdapter(accidentList)

                }

            }

            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
            }

        })
    }
}