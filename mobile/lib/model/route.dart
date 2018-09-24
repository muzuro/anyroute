

import 'package:mobile/model/stereotypes.dart';

class Route extends LongIdDto {
  List<Task> tasks;
}

class Task extends LongIdDto {
  int number;
  Point point;
}

class Point extends LongIdDto {
  String name;
  double lat;
  double lng;
}