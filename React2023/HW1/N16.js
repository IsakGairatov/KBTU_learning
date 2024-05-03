var chunk = function(arr, size) {
    const chunkedArray = [];
    var l = arr.length;

    for (var i = 0; i < l; i += size) {
        chunkedArray.push(arr.slice(i, i + size));
    }

    return chunkedArray;
};