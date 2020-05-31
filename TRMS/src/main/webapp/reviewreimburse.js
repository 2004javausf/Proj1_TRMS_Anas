var er;
var formLvl;
var title;
var formId;
var reject;
var reason;

window.onload=function(){
    console.log("in load review");
    
    title = localStorage.getItem("title");
    
    if (title == "DS"){
    	formLvl = 1;
    } else if (title == "DH"){
    	formLvl = 2;
    } else if (title == "BC"){
    	formLvl = 3;
    }else if (title == "CEO"){
    	formLvl = 4;
    } else {
    	formLvl = 0;
    }
    
    this.getER();
    document.getElementById("trmsApprove").addEventListener("click",postApprove,false);
    document.getElementById("trmsReject").addEventListener("click",postReject,false);

}

function getER(){
    console.log("in getER");

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            er=JSON.parse(xhr.responseText);
            console.log(er);
            loadER(er);
        }
    }
    xhr.open("GET","http://localhost:8080/TRMS/review?formLvl=" + formLvl,true);
    xhr.send();
}

function loadER(er){
    var col = [];
    for (var c = 0; c < er.length; c++) {
        for (var key in er[c]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }
    console.log(col);
    var table = document.createElement("table");

        // Create table header row using the extracted headers above.
        var tr = table.insertRow(-1);                   // table row.

        for (var h = 0; h < col.length; h++) {
            var th = document.createElement("th");      // table header.
            th.innerHTML = col[h];
            tr.appendChild(th);
        }

        // add json data to the table as rows.
        for (var i = 0; i < er.length; i++) {

            tr = table.insertRow(-1);
            
            for (var j = 0; j < col.length; j++) {
                var tabCell = tr.insertCell(-1);
                console.log(er[i][col[j]]);
                if(j==7){
                	var d = er[i][col[j]];
                	var date = new Date(d).toDateString();
                	console.log(date);
                	tabCell.innerHTML = date;
                }
                else {
                tabCell.innerHTML = er[i][col[j]];
                }
            }
        }

        // Now, add the newly created table with json data, to a container.
        var divShowData = document.getElementById('showData');
        divShowData.innerHTML = "";
        divShowData.appendChild(table);
}


function postApprove(){
    console.log("in postApprove");
    formId = document.getElementById('approval');
    
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }
    xhr.open("POST","http://localhost:8080/TRMS/approveRim?formId=" + formId,true);
    var payload=jsonBuilder()
    xhr.send(payload);
}


function postReject(){
    console.log("in postForm");
    reject = document.getElementById('rejection');
    reason = document.getElementById('reasonReject');
    
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }
    xhr.open("POST","http://localhost:8080/TRMS/deny",true);
    var payload=jsonBuilder()
    xhr.send(payload);
}

