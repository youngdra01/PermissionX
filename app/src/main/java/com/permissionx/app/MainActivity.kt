package com.permissionx.app

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.permissionx.youngdev.PermissionX

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.makeCallBtn).setOnClickListener {
            PermissionX.request(this,
                Manifest.permission.CALL_PHONE
//                Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                Manifest.permission.READ_CONTACTS
            ){ allGranted, deniedList -> 
                if (allGranted){
                    call()
                }else{
                    Toast.makeText(this, "You denied $deniedList", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun call(){
        try{
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}