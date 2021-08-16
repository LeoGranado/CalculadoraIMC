 package com.example.imcapplication

 import android.os.Bundle
 import android.widget.Toast
 import androidx.appcompat.app.AppCompatActivity
 import androidx.core.widget.doAfterTextChanged
 import androidx.core.widget.doOnTextChanged
 import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity(){

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         setListeners()
     }


         private fun setListeners() {
             alturaEDT?.doAfterTextChanged { text ->

             }

             pesoEDT?.doOnTextChanged { text, _, _, _ ->
                 titleTXT?.text = text
             }
             calculaBTN?.setOnClickListener {
                 calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())
             }

         }

        private fun calcularIMC(peso:String, altura:String) {
            val peso = peso.toFloatOrNull()
            val altura = altura.toFloatOrNull()

            if (peso!= null && altura!= null) {
                val imc = peso / (altura * altura)
                titleTXT.text = ("Seu IMC é de:" + imc).toString().format(imc)
            }
        }




 }
