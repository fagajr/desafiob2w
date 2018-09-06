var projeto = angular.module("projeto", ['ngRoute', 'ngResource']);

projeto.config(['$routeProvider', function($routeProvider) {
	
	$routeProvider
		.when("/", {
			templateUrl: "template/home.html",
			controller: "HomeController"
		})
		.when("/novo", {
			templateUrl: "template/novo.html",
			controller: "NovoController"
		})
		.when("/listar", {
			templateUrl: "template/listar.html",
			controller: "ListarController"
		});
	
}]);