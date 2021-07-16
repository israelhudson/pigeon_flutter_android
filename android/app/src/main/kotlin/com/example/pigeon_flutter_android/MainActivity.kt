package com.example.pigeon_flutter_android

import android.util.Log
import androidx.annotation.NonNull
import com.example.pigeon_flutter_android.Pigeon.*
import com.example.pigeon_flutter_android.DeviceInfoPigeon.*
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class MainActivity: FlutterActivity() {
    private class MyApi : Api {
        override fun search(request: SearchRequest): SearchReply {
            val reply = SearchReply()
            reply.result = String.format("Hi %s!", request.query + " foi mlk :)")
            Log.i("resposta", String.format("Hi %s!", request.query))
            return reply
        }
    }

    private class MyApiInfo : DeviceInfoApi {
        override fun search(request: DeviceInfoRequest): DeviceInfoResponse {
            val reply = DeviceInfoResponse()
            //reply.result = String.format("Hi %s!", request.query + " device info :)")
            reply.result = String.format("Hi %s!", DeviceDetails.getDeviceSuperInfo())
            Log.i("resposta", String.format("Hi %s!", request.query))
            return reply
        }
    }

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        Api.setup(flutterEngine.dartExecutor.binaryMessenger, MyApi())
        DeviceInfoApi.setup(flutterEngine.dartExecutor.binaryMessenger, MyApiInfo())

    }
}
