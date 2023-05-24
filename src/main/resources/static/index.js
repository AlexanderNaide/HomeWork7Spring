angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/students';

    $scope.updateStudents = function () {
        let searchValue;
        if ($scope.value !== null){
            searchValue = $scope.value;
        }
        $http({
            url: contextPath + "/search",
            method: 'POST',
            params: {
                searchValue: searchValue
            }
        }).then(function (response) {
            $scope.StudentsList = response.data;
            });
    };

    $scope.loadStudents = function () {
        $http({
            url: contextPath,
            method: 'GET'
        }).then(function (response) {
            $scope.StudentsList = response.data;
        });
    };

    $scope.getStudent = function (id) {
        $http({
            url: contextPath + "/st/" + id,
            method: 'GET'
        }).then(function (response) {
            $scope.Student = response.data;
        });
    };

    $scope.getGroup = function (group) {
        $http({
            url: contextPath + "/gr/" + group,
            method: 'GET'
        }).then(function (response) {
            $scope.Group = response.data;
        });
    };

    $scope.getGroupList = function () {
        $http({
            url: contextPath + "/gr",
            method: 'GET'
        }).then(function (response) {
            $scope.GroupList = response.data;
        });
    };

    $scope.saveStudent = function () {
        $http.post(contextPath + '/add-student', $scope.CheckStudent)
            .then(function (response) {
                $scope.CheckStudent = null;
                $scope.loadStudents();
            });
    };

    $scope.loadStudents();
});