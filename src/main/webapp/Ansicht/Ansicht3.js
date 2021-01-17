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

const months = ["Januar", "Februar", "März", "April", "Mai", "Juni",
        "Juli", "August", "September", "Oktober", "November", "Dezember"],
    Tag = ["Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"];


Kalender(dateMonth, dateYear);

/**
 * Funktion zum Erstellen eines Kalenders für die einzelnen Kalenderwochen
 * @param month
 * @param year
 * @constructor
 */
function Kalender(month, year) {

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

window.onload = () => {
    if (!new URLSearchParams(window.location.search).has('selectmonth')) {
        createTable(dateMonth);
    } else {
        createTable(parseInt(new URLSearchParams(window.location.search).get('selectmonth')));
    }
}

/**
 * Funktion zum erstellen der Tabelle
 * @param month
 * @param year
 */
function createTable(month) {
    var week = weeksCount(month);
    for (let i = 0; i < 4; i++) {
        const tableBody = document.getElementById("tableHeader" + i);
        let dataHtml = '';
        dataHtml += `<tr><th class="date"">KW ${week}</th>
                    <th class="day day-word">Montag
                        <ul class="day-menu">
                            <li><input class="knopf" name="date" type="submit" value="Kommentar setzen"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf freien Tag"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf Urlaub"></li>
                        </ul>
                    </th>
                    <th class="day day-word">Dienstag
                        <ul class="day-menu">
                            <li><input class="knopf" name="date" type="submit" value="Kommentar setzen"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf freien Tag"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf Urlaub"></li>
                        </ul>
                    </th>
                    <th class="day day-word">Mittwoch
                        <ul class="day-menu">
                            <li><input class="knopf" name="date" type="submit" value="Kommentar setzen"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf freien Tag"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf Urlaub"></li>
                        </ul>
                    </th>
                    <th class="day day-word">Donnerstag
                        <ul class="day-menu">
                            <li><input class="knopf" name="date" type="submit" value="Kommentar setzen"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf freien Tag"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf Urlaub"></li>
                        </ul>
                    </th>
                    <th class="day day-word">Freitag
                        <ul class="day-menu">
                            <li><input class="knopf" name="date" type="submit" value="Kommentar setzen"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf freien Tag"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf Urlaub"></li>
                        </ul>
                    </th>
                    <th class="day day-word">Samstag
                        <ul class="day-menu">
                            <li><input class="knopf" name="date" type="submit" value="Kommentar setzen"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf freien Tag"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf Urlaub"></li>
                        </ul>
                    </th>
                    <th class="day day-word">Sonntag
                        <ul class="day-menu">
                            <li><input class="knopf" name="date" type="submit" value="Kommentar setzen"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf freien Tag"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf Urlaub"></li>
                        </ul>
                    </th>
                    <th class="soll">SOLL</th>
                    <th class="ist">IST</th></tr>`;

        console.log(dataHtml);
        tableBody.innerHTML = dataHtml;
        week++;
    }
    if (week < weeksCount(month + 1)) {
        const tableBody2 = document.getElementById("tableHeader4");
        let dataHtml2 = '';
        dataHtml2 += `<tr><th class="date"">KW ${week}</th>
                    <th class="day day-word">Montag
                        <ul class="day-menu">
                            <li><input class="knopf" name="date" type="submit" value="Kommentar setzen"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf freien Tag"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf Urlaub"></li>
                        </ul>
                    </th>
                    <th class="day day-word">Dienstag
                        <ul class="day-menu">
                            <li><input class="knopf" name="date" type="submit" value="Kommentar setzen"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf freien Tag"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf Urlaub"></li>
                        </ul>
                    </th>
                    <th class="day day-word">Mittwoch
                        <ul class="day-menu">
                            <li><input class="knopf" name="date" type="submit" value="Kommentar setzen"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf freien Tag"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf Urlaub"></li>
                        </ul>
                    </th>
                    <th class="day day-word">Donnerstag
                        <ul class="day-menu">
                            <li><input class="knopf" name="date" type="submit" value="Kommentar setzen"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf freien Tag"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf Urlaub"></li>
                        </ul>
                    </th>
                    <th class="day day-word">Freitag
                        <ul class="day-menu">
                            <li><input class="knopf" name="date" type="submit" value="Kommentar setzen"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf freien Tag"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf Urlaub"></li>
                        </ul>
                    </th>
                    <th class="day day-word">Samstag
                        <ul class="day-menu">
                            <li><input class="knopf" name="date" type="submit" value="Kommentar setzen"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf freien Tag"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf Urlaub"></li>
                        </ul>
                    </th>
                    <th class="day day-word">Sonntag
                        <ul class="day-menu">
                            <li><input class="knopf" name="date" type="submit" value="Kommentar setzen"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf freien Tag"></li>
                            <li><input class="knopf" name="date" type="submit" value="Anfrage auf Urlaub"></li>
                        </ul>
                    </th>
                    <th class="soll">SOLL</th>
                    <th class="ist">IST</th></tr>`;

        console.log(dataHtml2);
        tableBody2.innerHTML = dataHtml2;
        document.getElementById("table4").style.display="block";
    } else {
        document.getElementById("table4").style.display="none";
    }
}

/**
 * Funktion zum Berechnen der aktuellen Kalenderwoche
 * @returns {number}
 * @param elementID
 */
function weeksCount(elementID) {
    // Copy date so don't modify original
    d = new Date(Date.UTC(dateYear, elementID, 7));
    // Set to nearest Thursday: current date + 4 - current day number
    // Make Sunday's day number 7
    d.setUTCDate(d.getUTCDate() + 4 - (d.getUTCDay() || 7));
    // Get first day of year
    var yearStart = new Date(Date.UTC(dateYear, 0, 1));
    // Calculate full weeks to nearest Thursday
    var weekNo = Math.ceil((((d - yearStart) / 86400000) + 1) / 7);
    // Return array of year and week number
    if (elementID === 0 && weekNo !== 1) {
        weekNo = 1;
    }
    return weekNo;
}

