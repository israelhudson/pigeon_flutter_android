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