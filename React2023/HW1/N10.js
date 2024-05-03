var once = function(fn) {
    var called = false;
    var res;
    return function(...args){
        if (!called) {
            res = fn(...args);
            called = true;
            return res;
        } else {
            return undefined;
        }
    }
};
