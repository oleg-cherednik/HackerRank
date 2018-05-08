'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    main();
});

function readLine() {
    return inputString[currentLine++];
}

/*
 *	Return the largest value of any a & b < k in S (where a < b).
 *
 *	n: Set S is a sequence of distinct integers from 1 to n (i.e., {1, 2, ..., n}).
 *	k: An integer.
 */
function getMaxLessThanK(n, k) {
    let max = 0;

    for (let b = 2; b <= n; b++)
        for (let a = 1; a < b; a++)
            if ((a & b) < k)
                max = Math.max(max, a & b);

    return max;
}

function main() {
    const q = +(readLine());

    for (let i = 0; i < q; i++) {
        const [n, k] = readLine().split(' ').map(Number);

        console.log(getMaxLessThanK(n, k));
    }
}
