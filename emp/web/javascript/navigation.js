function includeNavigation() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/emp/navigation.html', true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                document.getElementById('navigation').innerHTML = xhr.responseText;
            } else {
                alert(xhr.status);
            }
        }
    };
    xhr.send(null);
}