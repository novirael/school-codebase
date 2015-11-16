
var numberIds = 0;


function newElement(number) {
    var num = number ? number : numberIds++,
        el = document.createElement("LI"),
        text = document.createTextNode("Item " + num);

    el.id = "item-" + num;
    el.appendChild(text);

    return el;
}


function getItem(inputId) {
    var target = document.getElementById(inputId),
        targetId = "item-" + target.value;

    return document.getElementById(targetId)
}


function myCreate() {
    var list = document.getElementById("myList"),
        el = newElement();

    list.appendChild(el);
}


function myInsertBefore() {
    var list = document.getElementById("myList"),
        targetEl = getItem("insertBeforeNum"),
        el = newElement();

    list.insertBefore(el, targetEl)
}


function myReplaceChild() {
    var list = document.getElementById("myList"),
        newItem = getItem("replaceNew"),
        oldItem = getItem("replaceOld"),
        targetNum;

    if (!newItem) {
        targetNum = document.getElementById("replaceNew").value;
        newItem = newElement(targetNum);
    }

    list.replaceChild(newItem, oldItem)
}


function myRemoveChild() {
    var list = document.getElementById("myList"),
        target = getItem("removeTarget");

    list.removeChild(target);
}
