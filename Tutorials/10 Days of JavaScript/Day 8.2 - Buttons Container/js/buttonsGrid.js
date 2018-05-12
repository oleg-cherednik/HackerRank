/**
 * @author Oleg Cherednik
 * @since 09.05.2018
 */
class Rotate {
    constructor(values) {
        this.values = values
    }

    rotate() {
        this.values.unshift(this.values.pop())
    }

    round() {
        this.rotate();
        this.render();
    }

    render() {
        let [btn1, btn2, btn3, btn6, btn9, btn8, btn7, btn4] = this.values;
        let hashTable = {btn1, btn2, btn3, btn6, btn9, btn8, btn7, btn4};

        for (let key in hashTable) {
            document.getElementById(key).innerHTML = hashTable[key]
        }
    }
}

document.addEventListener("DOMContentLoaded", () => {
    let rotate = new Rotate([1, 2, 3, 6, 9, 8, 7, 4]);
    rotate.render();

    document.getElementById("btn5").addEventListener("click", () => {
        rotate.round()
    })
});
