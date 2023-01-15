package com.example.mirimoney

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.io.FileOutputStream
import io.github.g0dkar.qrcode.QRCode

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    //@SuppressLint("MissingInflatedId", "SetTextI18n")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//
//        var welcome = findViewById<TextView>(R.id.welcome_text)
//        var template = "Your Balance, "
//        welcome.text = template + (FirebaseAuth.getInstance().currentUser?.email ?: "Max");
//
//        var balance: TextView = findViewById<TextView>(R.id.balance)
//        var balanceFlag = true
//        balance.setOnClickListener{
//            if (balanceFlag){
//                balance.text = "\$XX.XX"
//            }
//            else{
//                balance.text = "\$100.00"
//            }
//            balanceFlag = !balanceFlag
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_home, container, false)
//        val imageView: ImageView = view.findViewById(R.id.qrView)
//        val img = QRCode("https://github.com/g0dkar/qrcode-kotlin").render().writeImage()
//        imageView.setImageResource(img)

        var welcome = view.findViewById<TextView>(R.id.welcome_text)
        var template = "Your Balance, "
//        var uid = arguments.getString(username)
//        welcome.text = template + (FirebaseAuth.getInstance().currentUser?.email ?: "Dear");

        var balance: TextView = view.findViewById<TextView>(R.id.balance)
        var balanceFlag = true
        balance.setOnClickListener{
            if (balanceFlag){
                balance.text = "\$ecret\uD83E\uDD2B"
            }
            else{
                balance.text = "\$100.00"
            }
            balanceFlag = !balanceFlag
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}