
var app = angular.module('geoApp', [
	'ngRoute']);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : 'app/vistas/principal.html'
    })
    .when("/visualizador", {
        templateUrl : 'app/vistas/mapa.html',
        controller : 'mapaController'
    });
});