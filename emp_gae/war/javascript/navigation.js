sendRequest("GET", "/navigation.html", 200, function(response) {
    document.getElementById("navigation").innerHTML = response;
});
