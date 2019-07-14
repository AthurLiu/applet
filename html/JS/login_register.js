function login(){
    var name = document.getElementById("name").value;
    var pwsd = document.getElementById("pwd").value;
    var yzm = document.getElementById("yzm").value;
    var number = document.getElementById("number").innerHTML;
    if(name == "" || name == null){
        alert("请输入用户名");
    } else if(pwsd == "" || pwsd == null){
        alert("请输入密码");
    } else if(yzm == "" || yzm == null){
        alert("请输入验证码");
    } else if(yzm != number){
        alert("验证码输入错误！");
    } else{
        document.getElementById("form1").action ="../login";
    }
}

function register(){
    var name = document.getElementById("user").value;
    var pwsd = document.getElementById("pass").value;
    var pwsd1 = document.getElementById("pass1").value;
    if(name == "" || name == null){
        alert("请输入用户名");
    } else if(pwsd == "" || pwsd == null){
        alert("请输入密码");
    } else if(pwsd1 == "" || pwsd1 == null){
        alert("请输入确认密码密码");
    } else if(pwsd1 == pwsd){
        document.getElementById("form2").action ="../register";
    } else {
        alert("密码与确认密码不一致");
    }
}

function change(){
    var temp = (Math.random()*8888+1000);
    //右移位操作导致小数部分丢失,
    temp1 = temp >> 0;
    document.getElementById("number").innerHTML = temp1;   
}
