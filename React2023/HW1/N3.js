var expect = function(val) {
    return {
        toBe: function(Val) {
            if (val === Val) {
                return true;
            } else {
                throw new Error("Not Equal");
            }
        },
        notToBe: function (Val){
            if (val !== Val) {
                return true;
            } else {
                throw new Error("Equal");
            }
        }
    };
};