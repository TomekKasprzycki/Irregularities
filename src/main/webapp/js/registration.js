document.addEventListener("DOMContentLoaded" ,function(){
  let password = document.querySelector("#pass1");
  let password2 = document.querySelector("#pass2");
  let registerButton = document.querySelector("#registrationButton");

  registerButton.style.visibility = "hidden";

    function validate(){
        let valueOfThis = this.value;
        let pattern = "^([!@#$%^&*()a-zA-Z0-9]*\\d*[A-Z]+\\d*[!@#$%^&*()a-zA-Z0-9]*\\d*)+$";
        if(valueOfThis.length>=8 && valueOfThis.length<=16 && valueOfThis.match(pattern)){
            this.style.backgroundColor = "lightgreen";
        } else {
            this.style.backgroundColor = "lightcoral";
        }
    }

    function send(){
        if(this.value===password.value){
            registerButton.style.visibility = "";
        }else{
            registerButton.style.visibility = "hidden";
        }
    }

    password.addEventListener("keyup", validate);
    password.addEventListener("keydown", validate);
    password2.addEventListener("keyup", validate);
    password2.addEventListener("keydown", validate);
    password2.addEventListener("keyup",send);
    password2.addEventListener("keydown",send);
});