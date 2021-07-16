import 'package:pigeon/pigeon.dart';

class DeviceInfoRequest {
  String? queryInfoDetails;
}

class DeviceInfoReply {
  String? infoDetailsResult;
}

@HostApi()
abstract class DeviceInfoApi {
  DeviceInfoReply search(DeviceInfoRequest request);
}

//esse enum é apenas para fazer o configure options
@ConfigurePigeon(PigeonOptions(
  input: 'pigeons/device_info.dart',
  dartOut: 'lib/pigeon_generate/device_info_pigeon.dart',
  javaOut: 'android/app/src/main/kotlin/com/example/pigeon_flutter_android/DeviceInfoPigeon.java',
  javaOptions: JavaOptions(
    package: 'com.example.pigeon_flutter_android',
  ),
))
enum RequestState {
  pending,
  success,
  failure,
}
