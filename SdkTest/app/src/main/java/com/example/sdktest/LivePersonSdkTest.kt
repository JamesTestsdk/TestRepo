package com.example.sdktest

import android.app.Activity
import android.util.Log
import com.example.sdktest.SdkConstantsTest.digitalMessagingAPPID
import com.example.sdktest.SdkConstantsTest.digitalMessagingAPPINSTALLID
import com.example.sdktest.SdkConstantsTest.digitalMessagingBRANDID
import com.liveperson.infra.ConversationViewParams
import com.liveperson.infra.InitLivePersonProperties
import com.liveperson.infra.LPAuthenticationParams
import com.liveperson.infra.MonitoringInitParams
import com.liveperson.infra.callbacks.InitLivePersonCallBack
import com.liveperson.messaging.sdk.api.LivePerson
import java.lang.Exception

class LivePersonSdkTest(private val activity: Activity) {
    
    private  val mMoniorParams = MonitoringInitParams(digitalMessagingAPPINSTALLID)
    private  val mLPAuthParams = LPAuthenticationParams(LPAuthenticationParams.LPAuthenticationType.UN_AUTH)

    private val mInitLpProperties = InitLivePersonProperties(
        digitalMessagingBRANDID, digitalMessagingAPPID, mMoniorParams, object: InitLivePersonCallBack{
            override fun onInitFailed(p0: Exception?) { Log.d("Error: ", p0?.localizedMessage.toString()) }

            override fun onInitSucceed() { LivePerson.showConversation(activity,mLPAuthParams ,ConversationViewParams())}

        })
    
    fun basicInitalization(){ LivePerson.initialize(activity, mInitLpProperties) }

}
