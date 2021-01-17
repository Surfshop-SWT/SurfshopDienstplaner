function cancle() {
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

function userChange()
{
    console.log(document.getElementById('benutzername').value.length);
    if(document.getElementById('benutzername').value.length < 3 || document.getElementById('benutzername').value.length > 16)
    {
        if(document.getElementById('benutzername').value.length < 3)
        {
            document.getElementById('benutzername').style.borderColor = 'red';
            alert("Benutzername zu kurz");
            return false;
        }

        if(document.getElementById('benutzername').value.length > 16)
        {
            document.getElementById('benutzername').style.borderColor = 'red';
            alert("Benutzername zu lang");
            return false;
        }
    }
}