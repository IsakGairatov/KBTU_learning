var createCounter = function(n) {

    return function() {
        var a = n
        n++
        return a
    };
};