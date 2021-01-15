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
    document.getElementById("monatsAnsicht").textContent = months[dateMonth] + " " + dateYear;
    createTable(dateMonth, dateYear);
    createSelection(dateMonth);
}

/**
 * Ändert Textfelder für die Monate
 * @param elementID
 */
function selectionOfMonth(elementID) {
    document.getElementById("monatsAnsicht").textContent = months[elementID] + " " + dateYear;
    createTable(elementID, dateYear);
    document.getElementById("monatDropDown").textContent = months[elementID];
    document.getElementById("monat").textContent = months[elementID] + " " + dateYear;
}

/**
 * Funktion zum erstellen der Monats Auswahl
 * @param month
 */
function createSelection(month) {
    const tableBody = document.getElementById("menu")
    let dataHtml = '';
    dataHtml += `<ul>
                <li class="topmenu selected">
                    <a id="monatDropDown">${months[month]}</a>
                    <ul>
                        <li class="submenu"><button type="submit" onclick="selectionOfMonth(0)" value="January">Januar</button></li>
                        <li class="submenu"><button type="submit" onclick="selectionOfMonth(1)" value="February">Februar</button></li>
                        <li class="submenu"><button type="submit" onclick="selectionOfMonth(2)" value="March">März</button></li>
                        <li class="submenu"><button type="submit" onclick="selectionOfMonth(3)" value="April">April</button></li>
                        <li class="submenu"><button type="submit" onclick="selectionOfMonth(4)" value="May">Mai</button></li>
                        <li class="submenu"><button type="submit" onclick="selectionOfMonth(5)" value="June">Juni</button></li>
                        <li class="submenu"><button type="submit" onclick="selectionOfMonth(6)" value="July">Juli</button></li>
                        <li class="submenu"><button type="submit" onclick="selectionOfMonth(7)" value="August">August</button></li>
                        <li class="submenu"><button type="submit" onclick="selectionOfMonth(8)" value="September">September</button></li>
                        <li class="submenu"><button type="submit" onclick="selectionOfMonth(9)" value="October">Oktober</button></li>
                        <li class="submenu"><button type="submit" onclick="selectionOfMonth(10)" value="November">November</button></li>
                        <li class="submenu"><button type="submit" onclick="selectionOfMonth(11)" value="December">Dezember</button></li>
                    </ul>
                </li>
            </ul>`
    console.log(dataHtml);
    tableBody.innerHTML = dataHtml;
}

/**
 * Funktion zum erstellen der Tabelle
 * @param month
 * @param year
 */
function createTable(month, year) {

    var week = weeksCount(month);
    for (let i = 0; i < 4; i++) {
        const tableBody = document.getElementById("tableHeader" + i);
        let dataHtml = '';
        dataHtml += `<tr><th class="date">KW ${week}</th>
                    <th class="day">Montag</th>
                        <th class="day">Dienstag</th>
                            <th class="day">Mittwoch</th>
                                <th class="day">Donnerstag</th>
                                    <th class="day">Freitag</th>
                                        <th class="day">Samstag</th>
                                            <th class="day">Sonntag</th>
                                                 <th class="soll">SOLL</th>
                                                      <th class="ist">IST</th></tr>`;

        console.log(dataHtml);
        tableBody.innerHTML = dataHtml;
        week++;
    }
}

/**
 * Funktion zum Berechnen der aktuellen Kalenderwoche
 * @returns {number}
 * @param elementID
 */
function weeksCount(elementID) {
    // Copy date so don't modify original
    d = new Date(Date.UTC(dateYear, elementID, 1));
    // Set to nearest Thursday: current date + 4 - current day number
    // Make Sunday's day number 7
    d.setUTCDate(d.getUTCDate() + 4 - (d.getUTCDay() || 7));
    // Get first day of year
    var yearStart = new Date(Date.UTC(d.getUTCFullYear(), 0, 1));
    // Calculate full weeks to nearest Thursday
    var weekNo = Math.ceil((((d - yearStart) / 86400000) + 1) / 7);
    // Return array of year and week number
    if (elementID === 0 && weekNo !== 1) {
        weekNo = 1;
    }
    return weekNo;
}

