var et;
var gf;
var fName;
var lName;
var userID;
var eID;

window.onload=function(){
    console.log("in load");
    fName=localStorage.getItem("fName");
    lName=localStorage.getItem("lName");
    userID=localStorage.getItem("userID");
    console.log(userID);
    
//    userID=localStorage.getItem("userID");  
//    document.getElementById("userID").value = userID;
    
    document.getElementById("userID").value = userID;
    document.getElementById("fName").value = fName;
    document.getElementById("lName").value = lName;
    
    this.getET();
    this.getGF();

    document.getElementById("rFormSubmit").addEventListener("click",postForm,false);
    document.getElementById("eType").addEventListener("change",calculateReimburse,false);
    document.getElementById("tFees").addEventListener("change",calculateReimburse,false);
}

function calculateReimburse(){
    var cost = document.getElementById("tFees").value;
    console.log(cost);
    var sel = document.getElementById("eType");
    if(sel.value != 0){
//        var percent = et[(sel.value)-1].etPercent;
//        console.log(percent);
//        var pr = ((cost*percent)/100);
//        console.log(pr);
    	
    	if(sel.value == "University Course"){
    		var pr = (cost*0.8);
    	}
    	else if(sel.value == "Seminar"){
    		var pr = (cost*0.6);
    	}
    	else if(sel.value == "Certification Prep Class"){
    		var pr = (cost*0.75);
    	}
    	else if(sel.value == "Certification"){
    		var pr = cost;
    	}
    	else if(sel.value == "Technical Training"){
    		var pr = (cost*0.9);
    	} else {
    		var pr = cost*0.3;
    	}
    	
        document.getElementById("reimbursement").value = pr;
    }
}

function getGF(){
    console.log("in getGF");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            gf=JSON.parse(xhr.responseText);
            loadGF(gf);
        }
    }
    xhr.open("GET","http://localhost:8080/TRMS/grade",true);
    xhr.send();
}

function loadGF(gf){
    for (var i=0; i < gf.length; i++){
        document.getElementById("gFormat").options[i+1] = new Option(gf[i].gfName,gf[i].gfName);
        //document.getElementById("gFormat").options[i+1] = new Option(gf[i].gfName);
    }
}

function getET(){
    console.log("in getET");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            et=JSON.parse(xhr.responseText);
            loadET(et);
        }
    }
    xhr.open("GET","http://localhost:8080/TRMS/event",true);
    xhr.send();
}

function loadET(et){
    for (var i=0; i<et.length;i++){
        document.getElementById("eType").options[i+1] = new Option(et[i].etName,et[i].etName);
        //document.getElementById("eType").options[i+1] = new Option(et[i].etName);
    }
}

function jsonBuilder(){
    var elements=document.getElementById("reimburseForm").elements;
    var obj={};
    for(var i=0; i<elements.length-1;i++){
        var item=elements.item(i);
        obj[item.name]=item.value;
        console.log(obj);  
    }
    var json=JSON.stringify(obj);
    console.log(json);
    return json;
}

function postForm(){
    console.log("in postForm");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }
    xhr.open("POST","http://localhost:8080/TRMS/form",true);
    var payload=jsonBuilder()
    xhr.send(payload);
}