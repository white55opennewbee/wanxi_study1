function getPage(type,maxsize) {
    $.ajax({
        url:"/getpage",
        method:"get",
        data:{"Pagetype":type},
        success:function (data) {
            console.log(maxsize)
            let num = Math.ceil(data/maxsize);
            console.log(num)
            let ps = "";
            for(let i = 0;i<num;i++){
                let j = i+1;
                ps+="<a id='pages' href='javascript:void(0);' onclick='changeCurrentPage("+j+")'>"+j+"</a> &nbsp;"
            }
            $("#bootbar").html(ps)
        }
    })
}