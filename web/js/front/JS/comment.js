function submitComment(){
    let commonUsername = $("#commonUsername").val()
    let userEmail = $("#userEmail").val()
    let userCommon = $("#userCommon").val()
    if (commonUsername==null||"" ==commonUsername.trim()){
        alert("姓名不能为空")
        return;
    }
    if (userEmail==null||"" ==userEmail.trim()){
        alert("邮箱不能为空")
        return;
    }
    if (userCommon==null||"" ==userCommon.trim()){
        alert("内容不能为空")
        return;
    }
    json = {"commonUsername":commonUsername,"userEmail":userEmail,"userCommon":userCommon}

    $.ajax({
        url:"/comment",
        data:json,
        method:"post",
        dataType:"json",
        success:function (result) {
            if (true==result){
                alert("提交留言成功")
            } else {
                alert("提交留言失败")
            }
        }

    })
}