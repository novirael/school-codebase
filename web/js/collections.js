

function newElements(targetList, collection) {
    var list = document.getElementById(targetList),
        text,
        el;

    for (var item in collection) {
        if (collection.hasOwnProperty(item)) {
            text = document.createTextNode(
                collection[item].text ||
                collection[item].id
            );
            el = document.createElement("LI");
            el.appendChild(text);
            list.appendChild(el);
        }
    }
}


function myCollections() {
    newElements("images", document.images);
    newElements("links", document.links);
    newElements("forms", document.forms);
    newElements("anchors", document.anchors);
}
