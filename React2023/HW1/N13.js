var cancellable = function(fn, args, t) {
    var timeoutId;

    const cancelFn = () => {
        clearTimeout(timeoutId);
    };

    timeoutId = setTimeout(() => {
        fn(...args);
    }, t);

    return cancelFn;
};