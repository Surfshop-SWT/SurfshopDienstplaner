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
    document.getElementById('benutzername').style.borderColor = 'black';
    document.getElementById('benutzernameHinweis').style.color = 'black';
    document.getElementById('bestätigen').disabled = false;


    if(document.getElementById('benutzername').value.length < 3 || document.getElementById('benutzername').value.length > 16)
    {
        if(document.getElementById('benutzername').value.length < 3)
        {
            document.getElementById('benutzername').style.borderColor = 'red';
            document.getElementById('benutzernameHinweis').style.color = 'red';
            document.getElementById('bestätigen').disabled = true;
            return false;
        }

        if(document.getElementById('benutzername').value.length > 16)
        {
            document.getElementById('benutzername').style.borderColor = 'red';
            document.getElementById('benutzernameHinweis').style.color = 'red';
            document.getElementById('bestätigen').disabled = true;
            return false;
        }
    }
}

function passShort()
{
    document.getElementById('passwort').style.borderColor = 'black';
    document.getElementById('passwortHinweis').style.color = 'black';
    document.getElementById('bestätigen').disabled = false;

    if(document.getElementById('passwort').value.length < 4)
    {
        document.getElementById('passwort').style.borderColor = 'red';
        document.getElementById('passwortHinweis').style.color = 'red';
        document.getElementById('bestätigen').disabled = true;
        return false;
    }
}

function eingabe() {

    document.getElementById('vorname').style.borderColor = 'black';
    document.getElementById('bestätigen').disabled = false;
    if(document.getElementById('vorname').value.length === 0) {
        document.getElementById('vorname').style.borderColor = 'red';
        document.getElementById('bestätigen').disabled = true;
    }
}

