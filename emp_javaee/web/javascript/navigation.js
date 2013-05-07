sendRequest("GET", "/emp/navigation.html", 200, function(response) {
    document.getElementById("navigation").innerHTML = response;
});
