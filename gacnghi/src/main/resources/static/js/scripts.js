let eyeicon = document.getElementById("eyeicon");
let eyeicon1 = document.getElementById("eyeicon1");

let password = document.getElementById("password");
let repassword = document.getElementById("repassword");

eyeicon.onclick = function(){
    if(repassword.type == "password"){
        repassword.type = "text"
    }else{
        repassword.type = "password"
    }
}

eyeicon1.onclick = function(){
    if(password.type == "password"){
        password.type = "text"
    }else{
        password.type = "password"
    }
}