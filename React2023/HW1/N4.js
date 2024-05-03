var createCounter = function(init) {
    n = init
    return {
        increment: function() {
            n++;
            return n;
        },
        decrement: function() {
            n--;
            return n;
        },
        reset: function() {
            n = init;
            return n;
        }
    }
};