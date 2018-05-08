function changeLabel() {
    let btn = document.getElementById('btn');
    let value = parseInt(btn.textContent);
    btn.textContent = (value + 1).toString();
}
