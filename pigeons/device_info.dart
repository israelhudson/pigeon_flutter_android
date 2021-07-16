import 'package:pigeon/pigeon.dart';

class DeviceInfoRequest {
  String? query;
}

class DeviceInfoResponse {
  String? result;
}

@HostApi()
abstract class DeviceInfoApi {
  DeviceInfoResponse search(DeviceInfoRequest request);
}