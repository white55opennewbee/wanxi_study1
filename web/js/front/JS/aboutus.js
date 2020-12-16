$.ajax({
    url:"/aboutus",
    method:"get",
    success:function (result) {
        console.log(result)
        $("#aboutusinfo").html(result.aboutUsInfo)
        $("#pageTitle").html(result.pagename)
        $("#pageUsTitle").html(result.pageusname)
    }
})
