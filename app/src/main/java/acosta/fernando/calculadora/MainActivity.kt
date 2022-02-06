package acosta.fernando.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener los botones
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btn0 = findViewById<Button>(R.id.btn0)
        val btnPunto = findViewById<Button>(R.id.btnPunto)
        val btnIgual = findViewById<Button>(R.id.btnIgual)
        val btnSuma = findViewById<Button>(R.id.btnSuma)
        val btnResta = findViewById<Button>(R.id.btnResta)
        val btnMultiplicacion = findViewById<Button>(R.id.btnMultiplicar)
        val btnDivision = findViewById<Button>(R.id.btnDivision)
        val btnLimpiar = findViewById<Button>(R.id.btnLimpiar)


        // Añadir listener a los botones
        btn1.setOnClickListener { precionarBoton("1") }
        btn2.setOnClickListener { precionarBoton("2") }
        btn3.setOnClickListener { precionarBoton("3") }
        btn4.setOnClickListener { precionarBoton("4") }
        btn5.setOnClickListener { precionarBoton("5") }
        btn6.setOnClickListener { precionarBoton("6") }
        btn7.setOnClickListener { precionarBoton("7") }
        btn8.setOnClickListener { precionarBoton("8") }
        btn9.setOnClickListener { precionarBoton("9") }
        btn0.setOnClickListener { precionarBoton("0") }
        btnPunto.setOnClickListener { precionarBoton(".") }

        // Añadir listener a los operadores
        btnSuma.setOnClickListener { precionarOperador("+") }
        btnResta.setOnClickListener { precionarOperador("-") }
        btnMultiplicacion.setOnClickListener { precionarOperador("x") }
        btnDivision.setOnClickListener { precionarOperador("/") }

        // Añadir función al boton de limpiar
        btnLimpiar.setOnClickListener { limpiar(R.id.txtResultado) }

        // Añadir función al botón igual
        btnIgual.setOnClickListener { calcular() }
    }

    private fun calcular() {
        // Obtener el textview de la operacion
        val txtOperacion = findViewById<TextView>(R.id.txtOperacion)
        // Obtener el texto
        val operacion = txtOperacion.text.toString()
        // Extraer el operador
        val operador = operacion.substring(operacion.length - 1)

        operacion(operador)
        limpiar(R.id.txtOperacion)
    }

    private fun precionarOperador(operador: String) {
        // Obtener el texto del resultado
        val resultado = findViewById<TextView>(R.id.txtResultado)

        // Obtener el text view de operacion
        val operacion = findViewById<TextView>(R.id.txtOperacion)
        operacion.text = resultado.text
        operacion.append(operador)
        limpiar(R.id.txtResultado)
    }

    private fun precionarBoton(numero: String) {
        // Obtener el text view de resultado
        val tvOperacion = findViewById<TextView>(R.id.txtResultado)
        // Añadir el número al text view
        if(numero == "."){
            if( tvOperacion.text.toString() == "0" ){
                tvOperacion.text = "0."
            }
            if(tvOperacion.text.contains(".")){
                return
            }

        }
        if(tvOperacion.text.toString() == "0") {
            tvOperacion.text = numero
        } else {
            tvOperacion.append(numero)
        }
    }

    private fun limpiar(id: Int) {
        // Obtener el text view de resultado
        val tv = findViewById<TextView>(id)
        // Limpiar el text view
        if(id == R.id.txtResultado){
            tv.text = "0"
        } else {
            tv.text = ""
        }
    }

    // Operaciones
    private fun operacion(operacion: String) {

        // Obtener el text view de resultado
        val tvResultado = findViewById<TextView>(R.id.txtResultado)
        val tvOperacion = findViewById<TextView>(R.id.txtOperacion)
        // Obtener el valor del text view
        val valor = tvResultado.text.toString()

        when(operacion){
            "+" -> {
                // Quitar el signo de mas de la operación
                tvOperacion.text = tvOperacion.text.toString().replace("+", "")
                val valor1 = tvOperacion.text.toString()
                val resultado = valor1.toDouble() + valor.toDouble()
                tvResultado.text = resultado.toString()
            }
            "-" -> {
                // Quitar el signo de menos de la operación
                tvOperacion.text = tvOperacion.text.toString().replace("-", "")
                val valor1 = tvOperacion.text.toString()
                val resultado = valor1.toDouble() - valor.toDouble()
                tvResultado.text = resultado.toString()
            }
            "x" -> {
                // Quitar el signo de multiplicar de la operación
                tvOperacion.text = tvOperacion.text.toString().replace("x", "")
                val valor1 = tvOperacion.text.toString()
                val resultado = valor1.toDouble() * valor.toDouble()
                tvResultado.text = resultado.toString()
            }
            "/" -> {
                // Quitar el signo de dividir de la operación
                tvOperacion.text = tvOperacion.text.toString().replace("/", "")
                val valor1 = tvOperacion.text.toString()
                val resultado = valor1.toDouble() / valor.toDouble()
                tvResultado.text = resultado.toString()
            }
        }


    }


}