/*

   Copyright 2015 Andreas Würl

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/

package org.blitzortung.android.map.overlay

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.shapes.Shape

class OwnLocationShape(private val size: Float) : Shape() {

    override fun draw(canvas: Canvas, paint: Paint) {
        paint.style = Paint.Style.FILL
        paint.color = -2007673515
        canvas.drawCircle(0.0f, 0.0f, size / 1.3f, paint)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = size / 4
        paint.color = -1
        canvas.drawLine(-size / 2, 0.0f, size / 2, 0.0f, paint)
        canvas.drawLine(0.0f, -size / 2, 0.0f, size / 2, paint)
        paint.color = -13391105
        canvas.drawCircle(0.0f, 0.0f, size / 1.3f, paint)
    }

}
