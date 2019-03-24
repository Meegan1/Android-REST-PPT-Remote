package me.meegan.rest_powerpoint_controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var forward = findViewById<Button>(R.id.forward)
        var back = findViewById<Button>(R.id.back)
        var ip = findViewById<EditText>(R.id.ip)

        var queue = Volley.newRequestQueue(this)



        forward.setOnClickListener {
            // Request a string response from the provided URL.
            val stringRequest = StringRequest(Request.Method.GET, "http://${ip.text}:8088/api/forward",
                    Response.Listener<String> { response ->
                        // Display the first 500 characters of the response string.
                        Toast.makeText(this, "$response", Toast.LENGTH_SHORT).show()

                    },
                    Response.ErrorListener { Toast.makeText(this, "That didn't work!", Toast.LENGTH_SHORT).show() })

            // Add the request to the RequestQueue.
                        queue.add(stringRequest)
        }

        back.setOnClickListener {
            // Request a string response from the provided URL.
            val stringRequest = StringRequest(Request.Method.GET, "http://${ip.text}:8088/api/back",
                    Response.Listener<String> { response ->
                        // Display the first 500 characters of the response string.
                        Toast.makeText(this, "$response", Toast.LENGTH_SHORT).show()

                    },
                    Response.ErrorListener { Toast.makeText(this, "That didn't work!", Toast.LENGTH_SHORT).show() })

            // Add the request to the RequestQueue.
            queue.add(stringRequest)
        }
    }
}
