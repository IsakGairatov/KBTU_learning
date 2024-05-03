var ArrayWrapper = function(nums) {
    this.nums = nums;
};

ArrayWrapper.prototype.valueOf = function() {
    var sum = 0;
    var l = this.nums.length;

    for (var i = 0; i < l; i++) {
        sum += this.nums[i];
    }
    return sum;
}

ArrayWrapper.prototype.toString = function() {
    return JSON.stringify(this.nums);
}