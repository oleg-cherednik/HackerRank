'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inpustStdin => {
    inputString += inpustStdin;
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

/**
 *   A line of code that prints "Hello, World!" on a new line is provided in the editor.
 *   Write a second line of code that prints the contents of 'parameterVariable' on a new line.
 *
 *    Parameter:
 *   parameterVariable - A string of text.
 **/
function greeting(parameterVariable) {
    console.log('Hello, World!');
    console.log(parameterVariable);
}

function main() {
    const parameterVariable = readLine();

    greeting(parameterVariable);
}
