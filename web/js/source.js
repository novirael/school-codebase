
window.addEventListener("resize", updateScreenSize);


function calculate () {
    var a, b, add_result, sub_result, mult_result, div_result, mult_string;

    window.alert(
        "You will be asked for two numbers. As result I'll print " +
        "out addition, subtraction, multiplication and division"
    );
    a = parseFloat(window.prompt("Type A"));
    b = parseFloat(window.prompt("Type B"));

    add_result = a + b;
    sub_result = a - b;
    mult_result = a * b;
    div_result = a !== 0 ? a/b : null;

    window.alert(
        a + ' + ' + b + ' = ' + add_result + '\n' +
        a + ' - ' + b + ' = ' + sub_result + '\n' +
        a + ' * ' + b + ' = ' + mult_result + '\n' +
        a + ' / ' + b + ' = ' + div_result
    );
}

function changeHeader() {
    var header = document.getElementById("formHeadText");
    header.innerHTML = "Scripts Manager New title";
}

function changeMarioToJumping() {
    var image = document.getElementById("marioImage"),
        button = document.getElementById("marioChange");
    image.setAttribute("src", "img/mario-jumping.png");
    button.addEventListener("click", changeMarioToHead);
}

function changeMarioToHead() {
    var image = document.getElementById("marioImage"),
        button = document.getElementById("marioChange");
    image.setAttribute("src", "img/mario-head.png");
    button.addEventListener("click", changeMarioToJumping);
}

function updateScreenSize() {
    var windowRes = document.getElementById("windowRes");
    windowRes.innerHTML = window.innerWidth + " x " + window.innerHeight;
}

function randomNumber() {
    var input = document.getElementById("numInput"),
        value = Math.floor(Math.random() * 1000000000);

    input.setAttribute("value", value);
}
