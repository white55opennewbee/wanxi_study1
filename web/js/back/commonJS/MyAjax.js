function myAjax(url,data,method) {
    let result = {};
    $.ajax({
        url:url,
        data:data,
        async:false,
        method:method,
        dataType:"json",
        success:function (data1) {
            // console.log(result)
            result = data1;
        },
        error:function (data1) {
            result = data1;
        }

    })
    return result;
}