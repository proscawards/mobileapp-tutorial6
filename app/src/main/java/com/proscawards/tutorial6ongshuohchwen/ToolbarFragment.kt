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

    var activityCallback: ToolbarListener? = null

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val root: View = inflater.inflate(R.layout.fragment_toolbar, container, false)
        val seekBar = root.findViewById<SeekBar>(R.id.seekBar1)
        val btn = root.findViewById<Button>(R.id.button1)
        seekBar.setOnSeekBarChangeListener(this)
        btn.setOnClickListener { v: View -> buttonClicked(v) }
        return root
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        seekvalue = progress
    }

    override fun onStartTrackingTouch(arg0: SeekBar) {}
    override fun onStopTrackingTouch(arg0: SeekBar) {}
}