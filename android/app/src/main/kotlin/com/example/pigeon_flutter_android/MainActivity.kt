package com.example.pigeon_flutter_android

import android.os.Bundle
import androidx.annotation.NonNull
import com.example.pigeon_flutter_android.Pigeon.*
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugins.GeneratedPluginRegistrant;


class MainActivity: FlutterActivity() {
    private class MyApi : Api {
        override fun search(request: SearchRequest): SearchReply {
            val reply = SearchReply()
            reply.result = String.format("Hi %s!", request.query + " foi mlk :)")
            return reply
        }
    }

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        Api.setup(flutterEngine.dartExecutor.binaryMessenger, MyApi())

    }
}
