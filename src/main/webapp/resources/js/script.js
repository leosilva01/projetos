//var answer = confirm("Are you sure?");

//console.log(answer);

var a = 10;
var b = 33;

function sum(a, b){

	return a + b;

}

console.log(sum(2, 5));

document.getElementById("btn-calculate").onclick = function(){

	var valueA = document.getElementById("value-a").value;
	var valueB = document.getElementById("value-b").value;

	alert(parseInt(valueA) + parseInt(valueB));

}