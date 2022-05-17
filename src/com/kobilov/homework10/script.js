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

//    var averageAge = document.getElementById("averageAge");
    var rows = table.getElementsByTagName('tr'),
      footer = document.getElementsByTagName('tfoot')[0];

    // for each column that must be treated
    for(var i=3; i<4; i++){
      var sum = 0;
        var numOfValues = 0;

      // add each row's value
      for(numOfValues=0, l=rows.length; numOfValues<l; numOfValues++){
        sum += parseFloat(
            rows[numOfValues].getElementsByTagName('td')[i].innerHTML
          );
      }

      // calculate the average
      var avg = sum / numOfValues;
      // insert it in the corresponding TD (rounded to 2 decimals)
      footer.getElementsByTagName('td')[i-1].innerHTML = Math.round(avg * 100) / 100;
    }
}

function getAge(date) {
    return Math.floor((new Date() - new Date(date)) / 1000 / 60 / 60 / 24 / 365)
}

