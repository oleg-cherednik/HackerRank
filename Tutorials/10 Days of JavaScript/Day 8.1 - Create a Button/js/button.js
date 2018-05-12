/**
 * @author Oleg Cherednik
 * @since 08.05.2018
 */
function changeLabel() {
    let btn = document.getElementById('btn');
    let value = parseInt(btn.textContent);
    btn.textContent = (value + 1).toString();
}
