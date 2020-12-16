$.ajax({
    url:"/foot",
    method:"get",
    success:function (result) {
        console.log(result)
        init(result.logos)
        initCompany(result.name,result.symbol)
    }
})

function init(data) {
    let ps = "";
    for (let i = 0;i<data.length;i++){
        ps+="<img src=\"../img/"+data[i].footImgurl+"\">"
    }
    $("#footImgs").html(ps)
}


function initCompany(companyName,companySymbol) {
    $("#companyName").html("<strong>"+companyName+"</strong><br>")
    $("#companySymbol").html(companySymbol)
}
