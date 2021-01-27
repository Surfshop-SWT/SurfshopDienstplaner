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

window.onload = function() {
    commentLength();
}

function commentLength() {
    document.getElementById('bestaetigen').disabled = false;
    console.log(document.getElementById("kommentar").value.length || document.getElementById("kommentar").value.length < 1);
    if(document.getElementById("kommentar").value.length === 0) {
        document.getElementById('bestaetigen').disabled = true;
    } else if(document.getElementById("kommentar").value.length > 300) {
        document.getElementById('bestaetigen').disabled = true;
        document.getElementById('kommentar').style.borderColor = 'red';
    }
    return true;
}