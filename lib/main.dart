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
  dynamic _counter = 0;
  late SearchReply reply;
  late DeviceInfoResponse response;

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
    DeviceInfoRequest request = DeviceInfoRequest()..query = 'LIBERATO';
    DeviceInfoApi api = DeviceInfoApi();
    response = await api.search(request);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'You have pushed the button this many times:',
            ),
            Text(
              '$_counter',
              style: Theme.of(context).textTheme.headline4,
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          setState(() {
            //_counter = reply.result;
            _counter = response.result;
          });
        },
        tooltip: 'Increment',
        child: Icon(Icons.add),
      ),
    );
  }
}
