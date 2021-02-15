package trinidad.daniel.asignacion04_calculadora_imc
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

//Daniel Trinidad ID:205857

class MainActivity : AppCompatActivity() {

    var estatura:Float = 0F
    var peso: Float = 0F
    var resultado: Float = 0F
    var rango: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calcularIMC: Button = findViewById(R.id.btnCalcular)
        val weight : EditText = findViewById(R.id.etPeso) as EditText
        val height : EditText = findViewById(R.id.etEstatura) as EditText
        val resultadoIMC: TextView = findViewById(R.id.tvResultadoIMC)
        val rangoP: TextView = findViewById(R.id.tvRango)

        calcularIMC.setOnClickListener {
            peso = weight.getText().toString().toFloat()
            estatura = height.getText().toString().toFloat()
            if (validarValores()){
                resultado = calcularIMC()
                resultadoIMC.visibility= View.VISIBLE
                resultadoIMC.setText(resultado.toString())
                rango(resultado, rangoP)
            }else{
                resultadoIMC.setText("Verifique los datos ingresados")
                resultadoIMC.visibility= View.VISIBLE
            }
        }
        limpiarValores()
    }
    fun limpiarValores(){
        estatura = 0F
        peso = 0F
        resultado = 0F
        rango = ""
    }

    fun validarValores():Boolean{
        return estatura>0 && peso>0
    }

    fun rango(resultado: Float, rangoP:TextView){
        if(resultado < 18.5){
            rangoP.setText("Bajo peso")
            rangoP.setBackgroundResource(R.color.colorBrown)
        }else if(resultado>= 18.5  && resultado <25F){
            rangoP.setText("Normal")
            rangoP.setBackgroundResource(R.color.colorGreen)
        }else if(resultado>= 25F && resultado<30F){
            rangoP.setText("Sobre Peso")
            rangoP.setBackgroundResource(R.color.colorGreenish)
        }else if(resultado>=30F && resultado<35F){
            rangoP.setText("Obesidad grado 1")
            rangoP.setBackgroundResource(R.color.colorOrange)
        }else if(resultado>=35F && resultado<40F){
            rangoP.setText("Obesidad grado 2")
            rangoP.setBackgroundResource(R.color.colorRed)
        }else if(resultado >= 40F){
            rangoP.setText("Obesidad grado 3")
            rangoP.setBackgroundResource(R.color.teal_700)
        }
    }

    fun calcularIMC ():Float{
        var imc:Float = peso / (estatura*estatura)
        return imc
    }
}