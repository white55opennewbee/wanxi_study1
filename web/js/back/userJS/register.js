function register() {
    let account = $("#account");
    let password = $("#password");
    let retrypassword = $("#retrypassword");
    let realname = $("#realname");
    let phonenum = $("#phonenum");
    console.log(account.val())
    if (password.val()!=retrypassword.val()){
        $("#result").html("两次密码不一样")
        return
    }

    let s = {"account":account.val(),"password":retrypassword.val(),"name":realname.val(),"phoneNum":phonenum.val()};
    let User = JSON.stringify(s);
    $.ajax({
        url:"/useradd",
        method:"post",
        data:User,
        success:function (data) {
            if (data == "true"){
                window.location.href = "login.html";
            } else {
                alert("注册失败");
            }
        },
        error:function (data) {
            alert("注册失败")
        }
    })
}
function toLoginPage() {
    window.location.href = "login.html"
}