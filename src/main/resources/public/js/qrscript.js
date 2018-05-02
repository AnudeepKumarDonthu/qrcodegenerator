(function(){
	var app=angular.module("mainapp",[]);
	app.controller("maincontroller",
	function($scope,$http){
		$scope.flag=false;
		$scope.baseUrl="http://localhost:9091/";
		$scope.navigate = function(data) {
			$scope.value = data;
			if ($scope.value == "generateqr") {
				$scope.filename=$scope.qrfilename;
				$scope.qrcontent=$scope.qrdata;	
				//$scope.senddatatoprocess={"filename":"name1","qrdata":"I am Anudeep Kumar"};
				$scope.senddatatoprocess={"filename":$scope.qrfilename,"qrdata":$scope.qrdata,"email":$scope.email};
				var res = $http
				.post($scope.baseUrl
						+ "generateqr",
						$scope.senddatatoprocess);
				res.then(function(response){
					$scope.flag=response.data.status;
				});
			}
			}
	}
	)
}());

