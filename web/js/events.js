
document.addEventListener("keydown", handleHiddenEvents);

function handleHiddenEvents() {

    if (event.altKey && event.ctrlKey && event.shiftKey) {
        handleChangeSubmit();
    }
}
