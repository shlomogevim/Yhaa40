package com.example.yhaa40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_one_talking.*

class OneTalking : AppCompatActivity() {
    var numTalking = 1
    lateinit var animationInAction: AnimationInAction1
    lateinit var pref: GetAndStoreData
    lateinit var arrangeScreen: ArrangeScreen
    lateinit var buttonSpace: ButtonSpace

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_talking)

        pref = GetAndStoreData(this)

        numTalking = intent.getIntExtra("TalkNum", 0)
        Log.d("clima", "oneTalking numTalking-> $numTalking")

        pref.createListZero(numTalking)
        val list=pref.getTalkingList(1)

        pref.saveRecognizer(numTalking)
        if (pref.getFirstTalk()) {
            initAll()
    }
        enterData()
        animationInAction.executeTalker()
       // pref.saveFirstTalk(false)
    }



    private fun enterData() {

        //var talkList = pref.getTalkingList(0) //***********
        pref.saveCurrentPage(1)

      //  pref.saveFonts(1)
    }
    private fun initAll() {



        var showPosition = true
        pref.saveShowPosition(showPosition)
        var testMode = false
        pref.saveTestMode(testMode)
        arrangeScreen = ArrangeScreen(this)
        buttonSpace = ButtonSpace(this)
        animationInAction = AnimationInAction1(this)
        buttonSpace.initButton()
        arrangeScreen.setLayoutShowMode()
        arrangeScreen.operateListView()
        buttonSpace.setShowPositionMode()

    }
}
