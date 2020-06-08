package com.qingyan.permissionx

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.qingyan.lib.permission.PermissionX
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_makeCall.setOnClickListener{
            PermissionX.request(this,android.Manifest.permission.CALL_PHONE){allGranted,deniedList->
                if (allGranted){
                    call()
                }else{
                    Toast.makeText(this,"你拒绝了权限$deniedList",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun call(){
        val intent=Intent(Intent.ACTION_CALL)
        intent.data= Uri.parse("tel:10086")
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }
        startActivity(intent)
    }
}