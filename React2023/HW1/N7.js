var reduce = function(nums, fn, init) {
    var l = nums.length;
    var m = init
    for(var i = 0; i < l; i++) {
        m = fn(m, nums[i]);
    }
    return m;
};