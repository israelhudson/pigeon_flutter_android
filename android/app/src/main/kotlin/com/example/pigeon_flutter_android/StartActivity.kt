//package com.example.pigeon_flutter_android
//
//import android.app.Activity
//import dev.flutter.pigeon.Pigeon.Api
//import dev.flutter.pigeon.Pigeon.SearchRequest
//import dev.flutter.pigeon.Pigeon.SearchReply
//import android.os.Bundle
//import dev.flutter.pigeon.Pigeon
//import com.example.pigeon_flutter_android.StartActivity.MyApi
//
//class StartActivity : Activity() {
//    private inner class MyApi : Api {
//        fun search(request: SearchRequest): SearchReply {
//            val reply = SearchReply()
//            reply.result = String.format("Hi %s!", request.query)
//            return reply
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        Pigeon.SetupApi(getBinaryMessenger(), MyApi())
//    }
//}