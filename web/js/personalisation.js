

function handleChangeSubmit() {
    var style = document.getElementsByTagName("body")[0].style,
        headers = document.getElementsByTagName("h2"),
        hColor = document.getElementById("changeHeadColor").value,
        fontsSelect = document.getElementById("changeFonts");

    style.backgroundColor = document.getElementById("changeBgColor").value;
    style.fontFamily = fontsSelect.options[fontsSelect.selectedIndex].value;

    for (var header in headers) {
        if (headers.hasOwnProperty(header)) {
            headers[header].style.color = hColor;
        }
    }
}
