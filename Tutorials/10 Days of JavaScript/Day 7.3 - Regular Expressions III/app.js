/**
 * @author Oleg Cherednik
 * @since 08.05.2018
 */
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

function regexVar() {
    /*
     * Declare a RegExp object variable named 're'
     * It must match ALL occurrences of numbers in a string.
     */

    /*
     * Do not remove the return statement
     */
    return /\d+/g;
}

function main() {
    const re = regexVar();
    const s = readLine();

    console.log(re.test(s));
}
