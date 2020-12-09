function getImg(object) {
    console.log(1111)
    $(object).attr("src","/img?time="+new Date());
}

function f() {
    window.location.href = "register.html";
}


function login() {
    let account = $("#account")
    let password = $("#password")
    let code = $("#code")
    if (account.val()==undefined||account.val().trim()==""){
        account.val("用户名不能为空");
        return;
    }
    if (password.val()==undefined||password.val().trim()=="") {
        password.val("密码不能为空")
        return;
    }
    if (code.val()==undefined||code.val().trim()=="") {
        code.val("验证码不能为空")
        return;
    }
    let user = {"account":account.val(),"password":password.val(),"code":code.val()};

    let userjson = JSON.stringify(user)
    console.log(userjson)
    $.ajax({
        url:"/login",
        method:"post",
        data:userjson,
        dataType:"json",
        success:function (data) {
            if (data){
                console.log(data)
                window.location.href = "managerindex.html";
            } else {
                console.log(data)
                alert("账户或密码错误");
            }
        }
    })

}