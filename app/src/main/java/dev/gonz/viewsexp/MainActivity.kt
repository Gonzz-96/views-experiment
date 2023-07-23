package dev.gonz.viewsexp

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import dev.gonz.viewsexp.databinding.ActivityMainBinding
import dev.gonz.viewsexp.views.MainActivityViewBinder
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewBinderFactory: MainActivityViewBinder.Factory

    private lateinit var viewBinder: MainActivityViewBinder

    private val sensorManager by lazy { getSystemService(Context.SENSOR_SERVICE) as SensorManager }

    private lateinit var gravitySensorListener: SensorEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinder = viewBinderFactory.create(ActivityMainBinding.inflate(layoutInflater))
        subscribeToGravitySensor()
        setContentView(viewBinder.root)
    }

    private fun subscribeToGravitySensor() {
        val sensor: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
        gravitySensorListener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                Log.d("Gravity Sensor Changed", event?.description()!!)
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                Log.d("Gracity Accuracy Changed", accuracy.toString())
            }
        }
        sensorManager.registerListener(gravitySensorListener, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onStop() {
        if (::gravitySensorListener.isInitialized) {
            sensorManager.unregisterListener(gravitySensorListener)
        }
        super.onStop()
    }
}

fun SensorEvent.description() = buildString {
    append("SensorEvent{")
    append("${values.string()}, $timestamp")
    append("}")
}

fun FloatArray.string() = joinToString(separator = ", ", prefix = "[", postfix = "]")
