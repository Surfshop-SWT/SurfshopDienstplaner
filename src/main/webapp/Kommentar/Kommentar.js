function cancleComment() {
    var div = document.getElementById("yesornowrapper");
    if (div.style.display === "none") {
        div.style.display = "block";
    } else {
        div.style.display = "none";
    }
    var div2 = document.getElementById("abbrechen-box");
    if (div2.style.display === "block") {
        div2.style.display = "none";
    } else {
        div2.style.display = "block";
    }
}