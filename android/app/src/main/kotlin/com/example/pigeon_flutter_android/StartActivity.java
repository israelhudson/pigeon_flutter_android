//package com.example.pigeon_flutter_android;
//
//import android.app.Activity;
//import android.os.Bundle;
//
//import com.example.pigeon_flutter_android.Pigeon.*;
//
//public class StartActivity extends Activity {
//    private class MyApi implements Api {
//        public Pigeon.SearchReply search(Pigeon.SearchRequest request) {
//            Pigeon.SearchReply reply = new Pigeon.SearchReply();
//            reply.result = String.format("Hi %s!", request.query);
//            return reply;
//        }
//    }
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Pigeon.SetupApi(getBinaryMessenger(), new MyApi());
//    }
//}