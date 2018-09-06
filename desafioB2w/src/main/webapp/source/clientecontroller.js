projeto.controller('HomeController', function() {
	
});

projeto.controller('NovoController', ['$scope', '$resource', function($scope, $resource) {
	$scope.cadastrar = function(){
		var nome = $scope.nome;
		var terreno = $scope.terreno;
		var clima = $scope.clima;
		
		var cliente = {
				'name' : nome, 'terreno' : terreno, 'clima' : clima
		};
		var url = $resource('planeta/novo');
		//Method = POST
		var result = url.save(planeta, function(){
			console.log(result);
			$scope.resp = result.msg;
		}, function(error){
			var erros = JSON.stringify(error);
			console.log(erros);
			var mensagem = angular.fromJson(erros);
			$scope.resp = mensagem.data.msg;
		});
	};
}]);

projeto.controller('ListarControllerNome', ['$scope', '$resource', function($scope, $resource) {
	
	$scope.buscarPorNome = function(){
		var txtnome = $scope.nome;
		
		var url = $resource("planeta/buscar/:nome");
		var result = url.query({ nome : txtnome }, function(){
			var conteudo = JSON.stringify(result);
			$scope.lista = angular.fromJson(conteudo);
		}, function(error){
			var erros = JSON.stringify(error);
			var mensagem = angular.fromJson(erros);
			console.log(mensagem.data.msg);
		});
	}
	
}]);

projeto.controller('ListarControllerId', ['$scope', '$resource', function($scope, $resource) {
	
	$scope.buscarPorId = function(){
		var txtnome = $scope.nome;
		
		var url = $resource("planeta/buscar/:id");
		var result = url.query({ id : txtid }, function(){
			var conteudo = JSON.stringify(result);
			$scope.lista = angular.fromJson(conteudo);
		}, function(error){
			var erros = JSON.stringify(error);
			var mensagem = angular.fromJson(erros);
			console.log(mensagem.data.msg);
		});
	}
	
}]);

projeto.controller('RemoverController', ['$scope', '$resource', function($scope, $resource) {
	$scope.remover = function(){
		var nome = $scope.nome;
		var terreno = $scope.terreno;
		var clima = $scope.clima;
		
		var cliente = {
				'name' : nome, 'terreno' : terreno, 'clima' : clima
		};
		var url = $resource('planeta/remover');
		//Method = POST
		var result = url.remove(planeta, function(){
			console.log(result);
			$scope.resp = result.msg;
		}, function(error){
			var erros = JSON.stringify(error);
			console.log(erros);
			var mensagem = angular.fromJson(erros);
			$scope.resp = mensagem.data.msg;
		});
	};
}]);

projeto.controller('ListarControllerId', ['$scope', '$resource', function($scope, $resource) {
	
	$scope.buscarTodos = function(){
		
		var url = $resource("planeta/buscar");
		var result = url.query({ }, function(){
			var conteudo = JSON.stringify(result);
			$scope.lista = angular.fromJson(conteudo);
		}, function(error){
			var erros = JSON.stringify(error);
			var mensagem = angular.fromJson(erros);
			console.log(mensagem.data.msg);
		});
	}
	
}]);