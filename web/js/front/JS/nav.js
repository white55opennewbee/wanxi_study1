$.ajax({
    url:"/nav",
    method:"get",
    success:function (result) {
        // result = JSON.parse(result)
        console.log(result)
        initNav(result.navList)
        initCompany(result.companyLogo)
    }

})

function initCompany(companyData) {
    $("#companyName").html(companyData.companyName)
    $("#companySymbol").html(companyData.symbol)
    $("#companyImg").attr("src","../img/"+companyData.imgUrl)

}

function initNav(data){
    let ps = ""
    for (let i= 0;i<data.length;i++){
        ps += "<li><a href=\""+data[i].href+"\" title=\""+data[i].title+"\" target=\"_blank\">"+data[i].describe+"</a></li>"
    }
    $("#navHeader").html(ps)
}