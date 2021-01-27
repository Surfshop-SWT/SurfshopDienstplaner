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

function commentLength() {
    document.getElementById('kommentar').style.borderColor = 'black';
    document.getElementById('bestaetigen').disabled = false;
    console.log(document.getElementById("kommentar").value.length);
    if(document.getElementById("kommentar").value.length > 300 || document.getElementById("kommentar").value.length < 1) {
        document.getElementById('bestaetigen').disabled = true;
        document.getElementById('kommentar').style.borderColor = 'red';
    }
    return true;
}