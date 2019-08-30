function show_loc(str){
    // hide();
    if(str == "loc"){
        document.getElementById("location").style.visibility="visible";
        document.getElementById("local").style.backgroundColor="white";
    } else if(str == "wb"){
        document.getElementById("website").style.visibility="visible";
        document.getElementById("web").style.backgroundColor="white";
    } else if(str == "ser"){
        document.getElementById("kefu").style.visibility="visible";
        document.getElementById("service").style.backgroundColor="white";
    }else if(str == "phjd"){
        document.getElementById("phjd").style.visibility="visible";
        document.getElementById("ph_jd").style.backgroundColor="white";
    }
    // document.getElementById("location7").style.visibility="hidden";
}
function hide_loc(str){
    if(str == "loc"){
        document.getElementById("location").style.visibility="hidden";
        document.getElementById("local").style.backgroundColor="rgb(228, 227, 227)";
    } else if(str == "wb"){
        document.getElementById("website").style.visibility="hidden";
        document.getElementById("web").style.backgroundColor="rgb(228, 227, 227)";
    } else if(str == "ser"){
        document.getElementById("kefu").style.visibility="hidden";
        document.getElementById("service").style.backgroundColor="rgb(228, 227, 227)";
    } else if(str == "phjd"){
        document.getElementById("phjd").style.visibility="hidden";
        document.getElementById("ph_jd").style.backgroundColor="rgb(228, 227, 227)";
    }
}