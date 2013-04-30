function sendRequest(method, url, status, func, contenttype, body) {
    var xhr = new XMLHttpRequest();
    xhr.open(method, url, true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === status) {
                func(xhr.response);
            } else {
                error(xhr.status);
            }
        }
    };
    if (contenttype != null) {
        xhr.setRequestHeader('Content-Type', contenttype);
        console.log(body);
    }
    xhr.send(body);
}

function param() {
    var sequence = window.location.search;
    map = new Object();
    if (sequence.length > 1) {
        p = sequence.substr(1).split('&');
        for (var i = 0; i < p.length; i++) {
            kv = p[i].split('=');
            key = decodeURIComponent(kv[0]);
            if (key.match(/\W/)) {
                throw 'Error: key \'' + key
                        + '\' has non alphanumeric characters';
            }
            if (key.charAt(0).match(/\d/)) {
                throw 'Error: key \'' + key
                        + '\' has a leading numeric character';
            }
            value = decodeURIComponent(kv[1]);
            if (eval('map.' + key + '!=undefined')) {
                throw 'Error: key \'' + key + '\' set multiple times';
            }
            try {
                eval('map.' + key + '=value');
            } catch (err) {
            }
        }
    }
    return map;
}
function el(name) {
    return document.getElementById(name);
}

function createComparator(property) {
    return function(a, b) {
        if (a[property] < b[property]) {
            return -1;
        } else if (a[property] > b[property]) {
            return 1;
        } else {
            return 0;
        }
    };
}

function info(message) {
    var div = document.createElement('div');
    div.setAttribute('class', 'info');
    div.innerHTML = message;
    document.body.appendChild(div);
}

function error(message) {
    var div = document.createElement('div');
    div.setAttribute('class', 'error');
    div.innerHTML = message;
    document.body.appendChild(div);
    console.log(message);
}