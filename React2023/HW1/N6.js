var filter = function(arr, fn) {
    var res = [];
    var l = arr.length;

    for(var i = 0; i < l; i++) {
        if(fn(arr[i], i)) {
            res.push(arr[i])
        };
    }
    return res;
};