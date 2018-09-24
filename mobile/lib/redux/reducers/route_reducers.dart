import 'package:mobile/model/route.dart';
import 'package:mobile/redux/action/route_actions.dart';

Route allReducers(Route route, dynamic action) {
  return updateRoute(route, action);
}

Route updateRoute(Route route, UpdateRouteAction action) {
  return action.route;
}