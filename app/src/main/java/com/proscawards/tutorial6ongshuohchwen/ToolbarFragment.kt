package com.proscawards.tutorial6ongshuohchwen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.content.Context
import kotlinx.android.synthetic.main.fragment_toolbar.*

class ToolbarFragment : Fragment(), SeekBar.OnSeekBarChangeListener {
    var seekvalue = 10

    var activityCallback: ToolbarFragment.ToolbarListener? = null

    interface ToolbarListener {
        fun onButtonClick(position: Int, text: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            activityCallback = context as ToolbarListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + " must implement ToolbarListener")
        }
    }

    private fun buttonClicked(view: View) {
        activityCallback?.onButtonClick(seekvalue,
            editText1.text.toString())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        seekBar1.setOnSeekBarChangeListener(this)
        button1.setOnClickListener { v: View -> buttonClicked(v) }
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        seekvalue = progress
    }

    override fun onStartTrackingTouch(arg0: SeekBar) {}
    override fun onStopTrackingTouch(arg0: SeekBar) {}
}