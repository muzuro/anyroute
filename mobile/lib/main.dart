import 'dart:async';

import 'package:flutter/material.dart';
import 'package:mobile/redux/action/route_actions.dart';
import 'package:mobile/redux/reducers/route_reducers.dart';
import 'package:flutter_redux/flutter_redux.dart';
import 'package:redux/redux.dart';
import 'package:mobile/model/route.dart' as m;

void main() {
  var route = new m.Route();
  final store = new Store<m.Route>(allReducers, initialState: route);
  runApp(new FlutterReduxApp(store: store));
}

class FlutterReduxApp extends StatelessWidget {
  final Store<m.Route> store;

  GlobalKey<RefreshIndicatorState> _refreshIndicatorKey = new GlobalKey<RefreshIndicatorState>();
  FlutterReduxApp({Key key, this.store}) : super(key: key);

  Future<void> _updateRoute() async {
    var route = new m.Route();

    for (var i = -100; i < 50; ++i) {
      var task1 = new m.Task();
      var point1 = new m.Point();
      point1.name = "point$i name";
      task1.point = point1;
      route.tasks.add(task1);
    }
    this.store.dispatch(UpdateRouteAction(route));
  }

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
          body: new StoreConnector<m.Route, m.Route>(
              converter: (store) => store.state,
              builder: (context, route) {
                return RefreshIndicator(
                  key: _refreshIndicatorKey,
                  onRefresh: _updateRoute,
                  child: ListView.separated(
                    itemCount: route.tasks.length,
                    itemBuilder: (context, position) => new TaskItem(task: route.tasks[position]),
                    separatorBuilder: ((context, position) =>
                    new Padding(
                        padding: EdgeInsets.only(left: 20.0, right: 20.0),
                        child:new Container(height: 1.5, color: Colors.grey)
                    )
                    ),
                  )
                );
              }
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
      mainAxisSize: MainAxisSize.max,
      children: [
        Container(
          padding: const EdgeInsets.fromLTRB(20.0, 10.0, 20.0, 10.0),
          child: Text(task.point.name, style: TextStyle(fontSize: 18.0))
        )
      ],
    );
  }

}