function getParams(sequence) {
	var sequence = window.location.search;
	map = new Object();
	if (sequence.length > 1) {
		p = sequence.substr(1).split("&");
		for ( var i = 0; i < p.length; i++) {
			kv = p[i].split("=");
			key = decodeURIComponent(kv[0]);
			if (key.match(/\W/)) {
				throw "Error: key \"" + key
						+ "\" has non alphanumeric characters";
			}
			if (key.charAt(0).match(/\d/)) {
				throw "Error: key \"" + key
						+ "\" has a leading numeric character";
			}
			value = decodeURIComponent(kv[1]);
			if (eval("map." + key + "!=undefined")) {
				throw "Error: key \"" + key + "\" set multiple times";
			}
			try {
				eval("map." + key + "=value");
			} catch (err) {
			}
		}
	}
	return map;
}
