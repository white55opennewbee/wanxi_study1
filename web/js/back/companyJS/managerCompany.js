function uploadCompanyInfo() {
    let imgUrl = $("#imgShow").attr("src")
    console.log(imgUrl)
    let index = imgUrl.lastIndexOf("/")
    let imgName = imgUrl.substring(index+1)
    let json = {"companyName":$("#companyName").val(),"symbol":$("#symbol").val(),"callUsIntroduce":$("#callUsIntroduce").val(),"aboutUsIntroduce":$("#aboutUsIntroduce").val(),"imgUrl":imgName}
    console.log(json)
    $.ajax({
        url:"/back/updateCompany",
        data: JSON.stringify(json),
        // dataType:"json",
        method: "post",
        success:function (result) {
            alert("更新公司成功")
        },
        error:function (result) {
            alert("更新公司失败")
        }

    })



}


function init() {
    $.ajax({
        url:"/getCompany",
        method:"get",
        success:function (result) {
            $("#companyName").val(result.companyName);
            $("#symbol").val(result.symbol);
            $("#callUsIntroduce").val(result.callUsIntroduce);
            $("#aboutUsIntroduce").val(result.aboutUsIntroduce);
            $("#imgShow").attr("src","/img/"+result.imgUrl);
        }
    })
}

function uploadimg() {
    if ($("#img").val() == '') {
        return;
    }
    var formData = new FormData();
    formData.append('photo', document.getElementById('img').files[0]);
    $.ajax({
        url:"/back/uploadImg",
        type:"post",
        data: formData,
        contentType: false,
        processData: false,
        success: function(data) {
            if (data.type == "success") {
                $("#imgShow").attr("src", "../img/"+data.imgname);
                alert("上传图片成功，提交后完成信息更新！")
            } else {
                alert("上传图片失败");
            }
        },
        error:function(data) {
            alert("上传失败")
        }
    });

}



function setEditable() {
    let companyName = $("#companyName").removeAttr("disabled")
    let symbol = $("#symbol").removeAttr("disabled")
    let callUsIntroduce = $("#callUsIntroduce").removeAttr("disabled")
    let aboutUsIntroduce = $("#aboutUsIntroduce").removeAttr("disabled")
    let img = $("#img").attr("type","file")
    let put = $("#put").removeAttr("disabled")


    let edit = $("#edit")
    if (edit.val() == "编辑") {
        edit.val("取消编辑")
        companyName.removeAttr("disabled")
        symbol.removeAttr("disabled")
        callUsIntroduce.removeAttr("disabled")
        aboutUsIntroduce.removeAttr("disabled")
        img.attr("type", "file")
        put.removeAttr("disabled")
    } else {
        edit.val("编辑")
        companyName.attr("disabled","disabled")
        symbol.attr("disabled","disabled")
        callUsIntroduce.attr("disabled","disabled")
        aboutUsIntroduce.attr("disabled","disabled")
        img.attr("type", "hidden")
        put.attr("disabled","disabled")
        init()
    }


}
init()