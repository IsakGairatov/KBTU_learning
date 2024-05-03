var compose = function(functions) {
    var l = functions.length;
    return function(x) {
        if (l === 0) {
            return x;
        }

        var res = x;

        for (var i = l - 1; i >= 0; i--) {
            res = functions[i](res);
        }

        return res;
    }
};