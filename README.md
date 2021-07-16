# pigeon_flutter_android
flutter pub run pigeon \
  --input pigeons/device_info.dart \
  --dart_out lib/pigeon_generate/device_info_pigeon.dart \
  --java_out ./android/app/src/main/kotlin/com/example/pigeon_flutter_android/DeviceInfoPigeon.java \
  --java_package "com.example.pigeon_flutter_android"


flutter pub run pigeon \
  --input pigeons/device_info.dart \
  --dart_out lib/pigeon_generate/device_info_pigeon.dart \

flutter pub run pigeon \
  --input pigeons/message.dart \
  --dart_out lib/pigeon_generate/pigeon.dart \
  --java_out ./android/app/src/main/kotlin/com/example/pigeon_flutter_android/Pigeon.java \
  --java_package "dev.flutter.pigeon"

slidy run codepigeon
slidy run codepigeoninfo

