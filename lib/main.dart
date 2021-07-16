import 'package:flutter/material.dart';
import 'package:pigeon_flutter_android/pigeon_generate/pigeon.dart';

import 'pigeon_generate/device_info_pigeon.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String textInfo = 'Tap in fab for load info';
  String textTest = '...';
  late SearchReply reply;
  late DeviceInfoReply deviceInfoReply;

  @override
  void didChangeDependencies() async {
   await initSearchRequest();
   await initDeviceInfoRequest();

    super.didChangeDependencies();
  }

  Future<void> initSearchRequest() async {
    SearchRequest request = SearchRequest()..query = 'test';
    Api api = Api();
    reply = await api.search(request);
  }

  Future<void> initDeviceInfoRequest() async {
    DeviceInfoRequest request = DeviceInfoRequest()..queryInfoDetails = 'InfoDart';
    DeviceInfoApi api = DeviceInfoApi();
    deviceInfoReply = await api.search(request);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Text(
          '$textInfo',
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () async {

          //await initSearchRequest();
          await initDeviceInfoRequest();

          setState(() {
            textInfo = deviceInfoReply.infoDetailsResult!;
          });
        },
        tooltip: 'Tap to get device details',
        child: Icon(Icons.perm_device_info),
      ),
    );
  }
}
