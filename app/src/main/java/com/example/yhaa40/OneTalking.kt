package com.example.yhaa40

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.yhaa40.comversation.MainActivity
import com.example.yhaa40.comversation.SentenceActivity
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

        if (numTalking > 0) {
            pref.createListZero(numTalking)
            val list = pref.getTalkingList(1)

            pref.saveRecognizer(numTalking)
            if (pref.getFirstTalk()) {
                initAll()
            }
            enterData()
            animationInAction.executeTalker()
        } else {
            val intent = Intent(this, SentenceActivity::class.java)
            startActivityForResult(intent,5)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==5){
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
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
