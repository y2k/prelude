"use strict";

export const atom = (x) => { return Array.of(x) };
export const reset = (a, x) => { a[0] = x; return x; };
export const deref = (a) => { return a[0] };
export const swap = (a, f) => {
    let x = f(a[0]);
    a[0] = x;
    return x;
}