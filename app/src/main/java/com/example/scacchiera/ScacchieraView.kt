package com.example.scacchiera

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.random.Random


var divisioni: Int = 4

class ScacchieraView:View {

    constructor(context: Context) : super(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, 0)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
        fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()
        var schermo = Rect()
        canvas?.getClipBounds(schermo)
        var paint = Paint()
        var casella : Rect? = null
        var booleanArray : ArrayList<Boolean> = arrayListOf()

        var vi: Int = 5
        5.toPx()
        var dx=(schermo.right-schermo.left)/divisioni
        for (i in 0..divisioni-1)
            for (j in 0..divisioni-1) {
                var width: Int = 3
                var random = Random.nextBoolean()
                booleanArray.add(random)
                casella = Rect(dx * i, dx * j, (dx *(i + 1)) - width.toPx(), (dx * (j + 1)) - width.toPx())
                if (random == true) {
                    paint.color = Color.GREEN
                }
                else{
                    paint.color = Color.RED
                }
                canvas?.drawRect(casella, paint)
            }

       /* override fun onTouchEvent(event: MotionEvent?): Boolean {
            if(event?.action == MotionEvent.ACTION_UP){

            }
            return super.onTouchEvent(event)
        }*/

    }
}
