package com.d33t.intervalbeeper

import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Handler
import android.os.Looper

class BeepHelper
{
    private val toneGenerator = ToneGenerator(AudioManager.STREAM_ALARM, 100)

    fun beep(duration: Int)
    {
        toneGenerator.startTone(ToneGenerator.TONE_CDMA_PIP, duration)
        Handler(Looper.getMainLooper()).postDelayed({
            toneGenerator.release()
        }, (duration + 50).toLong())
    }

    fun finalBeep(duration: Int)
    {
        toneGenerator.startTone(ToneGenerator.TONE_DTMF_S, duration)
        Handler(Looper.getMainLooper()).postDelayed({
            toneGenerator.release()
        }, (duration + 50).toLong())
    }
}
