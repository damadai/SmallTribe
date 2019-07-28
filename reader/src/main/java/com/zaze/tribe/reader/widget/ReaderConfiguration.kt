/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zaze.tribe.reader.widget

import android.content.Context
import android.graphics.Paint
import androidx.core.content.ContextCompat
import com.zaze.tribe.reader.R
import com.zaze.utils.ZDisplayUtil

/**
 * 一些阅读的配置
 */
class ReaderConfiguration {

    var borderLinePadding = 16F

     var fontSize: Float = 0F
        get() {
            if (field <= 0) {
                field = ZDisplayUtil.pxFromSp(16F)
            }
            return field
        }

    var fontHeight: Float = 0F
        get() {
            if (field <= 0) {
                field = fontSize + 8
            }
            return field
        }


    fun createReaderContentPaint(context: Context): Paint {
        return createReaderPaint().also {
            it.textSize = fontSize
            it.letterSpacing = 0.2F
            it.color = ContextCompat.getColor(context, R.color.colorPrimary)
            it.alpha = 255
        }
    }

    fun createReaderPaint(): Paint {
        return Paint().apply {
            isDither = true
            isAntiAlias = true
        }
    }
}