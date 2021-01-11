/**
 * Funktion zum erstellen der Printview in einem Popup
 * @param areaID
 */
function printPageArea(areaID) {
    var printContent = document.getElementById(areaID);
    var WinPrint = window.open('', '', 'width=900,height=650');
    WinPrint.document.write('<link href="/Ansicht/Ansicht2.css" rel="stylesheet" type="text/css">');
    WinPrint.document.write(printContent.innerHTML);
}


const date = new Date();
dateMonth = date.getMonth();
dateYear = date.getFullYear();


Kalender(dateMonth, dateYear);

/**
 * Funktion zum Erstellen eines Kalenders für die einzelnen Kalenderwochen
 * @param month
 * @param year
 * @constructor
 */
function Kalender(month, year) {

    const months = ["Januar", "Februar", "März", "April", "Mai", "Juni",
            "Juli", "August", "September", "Oktober", "November", "Dezember"],
        Tag = ["Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"];


    const today = new Date();
    let dayToday = -1;
    if ((today.getFullYear() === year) && (today.getMonth() + 1 === month))
        dayToday = today.getDate();

    const time = new Date(year, month - 1, 1);
    const start = (time.getDay() + 6) % 7;

// die meisten Monate haben 31 Tage
    let stop = 31;

// ...April (4), Juni (6), September (9) und November (11) haben nur 30 Tage
    if (month === 4 || month === 6 || month === 9 || month === 11) --stop;

// der Februar nur 28 Tage
    if (month === 2) {
        stop = stop - 3;
        // außer in Schaltjahren
        if (year % 4 === 0) stop++;
        if (year % 100 === 0) stop--;
        if (year % 400 === 0) stop++;
    }
}

let sortDirection = false;
let personData = [
    {name: 'Tim'},
    {name: 'Filip'},
    {name: 'Denis'},
    {name: 'Simon'}

]

window.onload = () => {
    createTable(personData);
}

function createTable(table) {

    const tableBody = document.getElementById("tableHeader");
    let dataHtml = '';
    dataHtml += ``
    dataHtml += `<tr><th class="date">KW1</th><th class="day">Montag</th><th class="day">Dienstag</th><th class="day">Mittwoch</th><th class="day">Freitag</th><th class="day">Samstag</th><th class="day">Sonntag</th><th class="soll">SOLL</th><th class="ist">IST</th></tr>`
    console.log(dataHtml);
    tableBody.innerHTML = dataHtml;
}

