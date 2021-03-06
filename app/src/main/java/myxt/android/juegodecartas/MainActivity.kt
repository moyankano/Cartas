package myxt.android.juegodecartas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    var count = 1
    var pressed = false
    var pressed2 = false
    var pressed3 = false
    var pressed4 = false
    var pressed5 = false
    var total = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array: IntArray = intArrayOf(8, 9, 10, 18, 19, 20, 28, 29, 30, 38, 39, 40)
        val arrayValores = IntArray(5)

        var nextValues = MutableList(5) { Random.nextInt(1, 40) }
        nextValues.sort()

        while (nextValues[0] == nextValues[1] || nextValues[1] == nextValues[2]
            || nextValues[2] == nextValues[3] || nextValues[3] == nextValues[4]
        ) {
            nextValues = MutableList(5) { Random.nextInt(1, 40) }
            nextValues.sort()
        }

        var x = 0
        for (i in nextValues) {
            if (i in array)
                arrayValores[x] = i + 2
            x++
        }

        nextValues.shuffle()

        val nombreCarta = "carta" + nextValues.get(0)
        val nombreCarta2 = "carta" + nextValues.get(1)
        val nombreCarta3 = "carta" + nextValues.get(2)
        val nombreCarta4 = "carta" + nextValues.get(3)
        val nombreCarta5 = "carta" + nextValues.get(4)

        Log.d("nombreCarta", "carta" + nextValues.get(0))
        Log.d("nombreCarta2", "carta" + nextValues.get(1))
        Log.d("nombreCarta3", "carta" + nextValues.get(2))
        Log.d("nombreCarta4", "carta" + nextValues.get(3))
        Log.d("nombreCarta5", "carta" + nextValues.get(4))

        val drawableResourceId =
            this.resources.getIdentifier(nombreCarta, "drawable", this.packageName)
        val drawableResourceId2 =
            this.resources.getIdentifier(nombreCarta2, "drawable", this.packageName)
        val drawableResourceId3 =
            this.resources.getIdentifier(nombreCarta3, "drawable", this.packageName)
        val drawableResourceId4 =
            this.resources.getIdentifier(nombreCarta4, "drawable", this.packageName)
        val drawableResourceId5 =
            this.resources.getIdentifier(nombreCarta5, "drawable", this.packageName)

        imageView.setOnClickListener {
            if (count <= 3 && !pressed) {
                imageView.setImageResource(drawableResourceId)
                total += calcularCarta(nextValues.get(0))
                editText5.setText(total.toString())
                count++
                pressed = true
            } else if (count <= 3 && pressed) {
                Log.d("onClickListener",
                    "Valores: count = $count y pressed = $pressed. No se realiza acción alguna"
                )
            } else if (count > 3 && !pressed) {
                checkAndShowFinalResult()
                restart()
            } else {
                checkAndShowFinalResult()
                restart()
            }
        }
        imageView2.setOnClickListener {

            if (count <= 3 && !pressed2) {
                imageView2.setImageResource(drawableResourceId2)
                total += calcularCarta(nextValues.get(1))
                editText5.setText(total.toString())
                count++
                pressed2 = true
            } else if (count <= 3 && pressed2) {
                Log.d("onClickListener2",
                    "Valores: count = $count y pressed = $pressed. No se realiza acción alguna"
                )
            } else if (count > 3 && !pressed2) {
                checkAndShowFinalResult()
                restart()
            } else {
                checkAndShowFinalResult()
                restart()
            }
        }
        imageView3.setOnClickListener {
            if (count <= 3 && !pressed3) {
                imageView3.setImageResource(drawableResourceId3)
                total += calcularCarta(nextValues.get(2))
                editText5.setText(total.toString())
                count++
                pressed3 = true
            } else if (count <= 3 && pressed3) {
                Log.d("onClickListener3",
                    "Valores: count = $count y pressed = $pressed. No se realiza acción alguna"
                )
            } else if (count > 3 && !pressed3) {
                checkAndShowFinalResult()
                restart()
            } else {
                checkAndShowFinalResult()
                restart()
            }
        }
        imageView4.setOnClickListener {
            if (count <= 3 && !pressed4) {
                imageView4.setImageResource(drawableResourceId4)
                total += calcularCarta(nextValues.get(3))
                editText5.setText(total.toString())
                count++
                pressed4 = true
            } else if (count <= 3 && pressed4) {
                Log.d("onClickListener4",
                    "Valores: count = $count y pressed = $pressed. No se realiza acción alguna"
                )
            } else if (count > 3 && !pressed4) {
                checkAndShowFinalResult()
                restart()
            } else {
                checkAndShowFinalResult()
                restart()
            }
        }
        imageView5.setOnClickListener {
            if (count <= 3 && !pressed5) {
                imageView5.setImageResource(drawableResourceId5)
                total += calcularCarta(nextValues.get(4))
                editText5.setText(total.toString())
                count++
                pressed5 = true
            } else if (count <= 3 && pressed5) {
                Log.d("onClickListener5",
                    "Valores: count = $count y pressed = $pressed. No se realiza acción alguna"
                )
            } else if (count > 3 && !pressed5) {
                checkAndShowFinalResult()
                restart()
            } else {
                checkAndShowFinalResult()
                restart()
            }
        }
    }

    private fun restart() {

        val intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)
    }

    private fun calcularCarta(numCarta: Int): Int {
        var resultNumCarta:Int

        if (numCarta in 11..20) {
            resultNumCarta = numCarta - 10
        } else if (numCarta in 21..30) {
            resultNumCarta = numCarta - 20
        } else if (numCarta in 31..40) {
            resultNumCarta = numCarta - 30
        } else
            resultNumCarta = numCarta

        val array: IntArray = intArrayOf(8, 9, 10, 18, 19, 20, 28, 29, 30, 38, 39, 40)

        if (resultNumCarta in array) {
            resultNumCarta += 2
        }

        return resultNumCarta
    }

    private fun checkAndShowFinalResult() {
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = DecelerateInterpolator() //add this
        fadeIn.duration = 1000

        val fadeOut = AlphaAnimation(1f, 0f)
        fadeOut.interpolator = AccelerateInterpolator() //and this
        fadeOut.startOffset = 1000
        fadeOut.duration = 1000

        val animation = AnimationSet(false) //change to false
        animation.addAnimation(fadeIn)
        animation.addAnimation(fadeOut)
        imageView6.animation = animation

        if (total <= 20)
            imageView6.setImageResource(R.drawable.mano1)
        else
            imageView6.setImageResource(R.drawable.mano2)

        imageView6.visibility = View.VISIBLE
    }
}