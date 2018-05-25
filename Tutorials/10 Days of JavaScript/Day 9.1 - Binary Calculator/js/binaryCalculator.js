/**
 * @author Oleg Cherednik
 * @since 12.05.2018
 */
class Model {
    constructor() {
        this.clear();
    }

    add(ch) {
        if (Model.isOperator(ch)) {
            if (this.res !== '' && !Model.isOperator(this.res.slice(-1)))
                this.res = this.res + ch;
        } else if (ch !== '0' || (this.res !== '' && !Model.isOperator(this.res.slice(-1))))
            this.res = this.res + ch;
    }

    calc() {
        if (this.res !== '') {
            let num = '';
            let cur = '';
            let op = '+';

            for (let i = 0; i < this.res.length; i++) {
                let ch = this.res[i];

                if (Model.isOperator(ch)) {
                    let v1 = parseInt(num !== '' ? num : '0', 2);
                    let v2 = parseInt(cur !== '' ? cur : '0', 2);
                    num = Model.calc(v1, op, v2).toString(2);
                    cur = '';
                    op = ch;
                } else
                    cur += ch;
            }

            let v1 = parseInt(num !== '' ? num : '0', 2);
            let v2 = parseInt(cur !== '' ? cur : '0', 2);
            this.res = Model.calc(v1, op, v2).toString(2);
        }
    }

    static calc(v1, op, v2) {
        if (op === '+')
            return v1 + v2;
        if (op === '-')
            return v1 - v2;
        if (op === '*')
            return v1 * v2;
        if (op === '/')
            return v1 / v2;
        return -1;
    }

    static isOperator(ch) {
        return ['+', '-', '*', '/'].indexOf(ch) >= 0;
    }

    clear() {
        this.res = '';
    }
}

let model = new Model();

function onBtn0() {
    model.add('0');
    update();
}

function onBtn1() {
    model.add('1');
    update();
}

function onBtnClr() {
    model.clear();
    update();
}

function onBtnEql() {
    model.calc();
    update();
}

function onBtnSum() {
    model.add('+');
    update();
}

function onBtnSub() {
    model.add('-');
    update();
}

function onBtnMul() {
    model.add('*');
    update();
}

function onBtnDiv() {
    model.add('/');
    update();
}

function update() {
    document.getElementById("res").innerHTML = model.res;
}
