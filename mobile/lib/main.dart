import 'package:flutter/material.dart';
import 'package:mobile/redux/reducers/route_reducers.dart';
import 'package:flutter_redux/flutter_redux.dart';
import 'package:redux/redux.dart';
import 'package:mobile/model/route.dart' as m;

void main() {
  var route = new m.Route();

  for (var i = 0; i < 20; ++i) {
    var task1 = new m.Task();
    var point1 = new m.Point();
    point1.name = "point$i name";
    task1.point = point1;
    route.tasks.add(task1);
  }

  final store = new Store<m.Route>(allReducers, initialState: route);
  runApp(new FlutterReduxApp(store: store));
}

class FlutterReduxApp extends StatelessWidget {
  final Store<m.Route> store;

  const FlutterReduxApp({Key key, this.store}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    String title = "Any route";
    return new StoreProvider<m.Route>(
      store: store,
      child: new MaterialApp(
        theme: new ThemeData.light(),
        title: title,
        home: new Scaffold(
          appBar: new AppBar(
            title: new Text(title),
          ),
          body: new Column(
            children: [
              new StoreConnector<m.Route, m.Route>(
                converter: (store) => store.state,
                builder: (context, route) {
                    return new ListView.builder(
                        itemCount: route.tasks.length,
                        itemBuilder: (context, position) => new TaskItem(task: route.tasks[position])
                    );
                }
              )
            ]
          )
        )
      ),
    );
  }
}

class TaskItem extends StatelessWidget {

  final m.Task task;

  const TaskItem({Key key, this.task}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return new Row(
      children: [new Text(task.point.name)],
    );
  }

}