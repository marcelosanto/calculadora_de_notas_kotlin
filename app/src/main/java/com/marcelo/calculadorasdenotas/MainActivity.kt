package com.marcelo.calculadorasdenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.marcelo.calculadorasdenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            val num1 = binding.nota1
            val num2 = binding.nota2
            val num3 = binding.nota3
            val num4 = binding.nota4
            val faltas = binding.numeroFaltas

            var resul = binding.txtResult

            if (!num1.text.isEmpty() || !num2.text.isEmpty() || !num3.text.isEmpty() || !num4.text.isEmpty() || !faltas.text.isEmpty() ) {
                val nota1 = Integer.parseInt(num1.text.toString())
                val nota2 = Integer.parseInt(num2.text.toString())
                val nota3 = Integer.parseInt(num3.text.toString())
                val nota4 = Integer.parseInt(num4.text.toString())
                val numFaltas = Integer.parseInt(faltas.text.toString())

                val media = (nota1 + nota2 + nota3 + nota4) / 4


                if (media >= 5 && numFaltas <= 20) {
                    resul.setText("Aluno foi aprovado!! \n Média final: $media")
                    resul.setTextColor(getColor(R.color.green))
                } else if (numFaltas > 20) {
                    resul.setText("Aluno foi reprovado por faltas!! \n Média final: $media")
                    resul.setTextColor(getColor(R.color.red))
                } else {
                    resul.setText("Aluno foi reprovado por media!! \n Média final: $media")
                    resul.setTextColor(getColor(R.color.red))
                }
            } else {
                Toast.makeText(this, "Numeros tem que ser preenchidos!!", Toast.LENGTH_LONG).show()
            }
        }

    }
}