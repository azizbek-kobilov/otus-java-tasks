"use strict"

function addStudent() {
    var table = document.getElementsByTagName('tbody')[0];
    var name = document.getElementById("fname").value;
    var date = document.getElementById("fdate").value;
    var sex = document.getElementById("fsex").value;

    var row = table.insertRow(table.rows.length);
    var cell = row.insertCell();
    cell.append(document.createTextNode(name));
    cell = row.insertCell();
    cell.append(document.createTextNode(date));
    cell = row.insertCell();
    cell.append(document.createTextNode(sex));
    cell = row.insertCell();
    cell.append(document.createTextNode(getAge(date)));

    countAvg(table);
}

function getAge(date) {
    return Math.floor((new Date() - new Date(date)) / 1000 / 60 / 60 / 24 / 365)
}

function countAvg(table) {
    var rows = table.getElementsByTagName('tr');
    var footer = document.getElementsByTagName('tfoot')[0];

    for(var i=3; i<4; i++){
        var sum = 0;
        var numOfValues = 0;
        for(numOfValues=0; numOfValues<rows.length; numOfValues++){
        sum += parseInt(
            rows[numOfValues].getElementsByTagName('td')[i].innerHTML
          );
        }

        footer.getElementsByTagName('td')[2].innerHTML = Math.floor(sum / numOfValues);
    }
}
