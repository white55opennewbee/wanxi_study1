function addimg() {
    if ($("#photoFile").val() == '') {
        return;
    }
    let formData = new FormData();
    formData.append('photo', document.getElementById('photoFile').files[0]);
    $.ajax({
        url: "/back/uploadImg",
        type: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (data) {
            if (data.type == "success") {
                $("#imgshow").attr("src", "/img/" + data.imgname);
                alert("上传图片成功，提交后完成信息更新！")
            } else {
                alert("上传图片失败");
            }
        },
        error: function (data) {
            alert("上传失败")
        }
    });
}

function add() {

    let productionName = $("#productionName").val();
    let price = $("#price").val();
    let type = $("#type").val();
    let number = $("#number").val();
    let imgshow = document.getElementById("imgshow").src;
    let index = imgshow.lastIndexOf("/");
    let productionImgUrl = imgshow.substring(index + 1);
    let exportPlace = $("#exportPlace").val();
    let incountryPlace = $("#incountryPlace").val();
    let tradeTime = $("#tradeTime").val();

    let result = {
        "productionName": productionName,
        "price": price,
        "type": type,
        "number": number,
        "productionImgUrl": productionImgUrl,
        "exportPlace": exportPlace,
        "incountryPlace": incountryPlace,
        "tradeTime": tradeTime
    };
    let s = JSON.stringify(result);
    $.ajax({
        url: "/back/addproduction",
        method: "post",
        data: s,
        success: function (data) {
            alert("新增成功")
        },
        error: function (data) {
            alert("新增失败")
        }
    })
}