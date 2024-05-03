Array.prototype.last = function() {
    var l = this.length;
    if (l === 0) {
        return -1;
    } else {
        return this[l - 1];
    }
};
