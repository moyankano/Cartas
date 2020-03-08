package jotajotaavm.android.juegodecartas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
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

        var array: IntArray = intArrayOf(8, 9, 10, 18, 19, 20, 28, 29, 30, 38, 39, 40)
        var arrayValores = IntArray(5)

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
                //total+=nextValues.get(0)
                count++
                pressed = true
            } else if (count <= 3 && pressed) {
            } else if (count > 3 && !pressed) {
                restart()
            } else {
                restart()
            }
        }
        imageView2.setOnClickListener {

            if (count <= 3 && !pressed2) {
                imageView2.setImageResource(drawableResourceId2)
                //total+=nextValues.get(1)
                count++
                pressed2 = true
            } else if (count <= 3 && pressed2) {
            } else if (count > 3 && !pressed2) {
                restart()
            } else {
                restart()
            }
        }
        imageView3.setOnClickListener {
            if (count <= 3 && !pressed3) {
                imageView3.setImageResource(drawableResourceId3)
                //total+=nextValues.get(2)
                count++
                pressed3 = true
            } else if (count <= 3 && pressed3) {
            } else if (count > 3 && !pressed3) {
                restart()
            } else {
                restart()
            }
        }
        imageView4.setOnClickListener {
            if (count <= 3 && !pressed4) {
                imageView4.setImageResource(drawableResourceId4)
                //total+=nextValues.get(3)
                count++
                pressed4 = true
            } else if (count <= 3 && pressed4) {
            } else if (count > 3 && !pressed4) {
                restart()
            } else {
                restart()
            }
        }
        imageView5.setOnClickListener {
            if (count <= 3 && !pressed5) {
                imageView5.setImageResource(drawableResourceId5)
                //total+=nextValues.get(4)
                count++
                pressed5 = true
            } else if (count <= 3 && pressed5) {
            } else if (count > 3 && !pressed5) {
                restart()
            } else {
                restart()
            }
        }
    }

    private fun restart() {
        val intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)
    }
}