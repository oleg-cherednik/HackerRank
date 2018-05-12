/**
 * @author Oleg Cherednik
 * @since 29.04.2018
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

function getGrade(score) {
    if (score >= 0 && score <= 5)
        return 'F';
    if (score > 5 && score <= 10)
        return 'E';
    if (score > 10 && score <= 15)
        return 'D';
    if (score > 15 && score <= 20)
        return 'C';
    if (score > 20 && score <= 25)
        return 'B';
    if (score > 25 && score <= 30)
        return 'A';
    return 'Z';
}

function main() {
    const score = +(readLine());

    console.log(getGrade(score));
}
