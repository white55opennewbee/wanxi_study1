$.ajax({
    url: "/head",
    method: "get",
    success: function (result) {
        console.log(result)
        initEuipments(result.equipment)
        initAdvices(result.advance)
    }

})

function initEuipments(data) {
    let ps = ""
    for (let i=0;i<data.length;i++){
        ps+="<li>\n" +
            "                <a href=\"\">\n" +
            "                    <img src=\"../img/"+data[i].imgUrl+"\"/>\n" +
            "\n" +
            "                </a>\n" +
            "                <span style=\"position: absolute; bottom:35px; left: 10px;font-size: 18px;color: white\">\n" +
            "                                "+data[i].name+"\n" +
            "                            </span>\n" +
            "            </li>"
    }
    $("#equitmentUl").html(ps)

}
function initAdvices(data) {
    let psimg = "";
    let ps = "";
    for (let i=0;i<data.length;i++){
        psimg+="<img src=\"../img/"+data[i].imgUrl+"\">"
        ps+="<a href=\"\">"+data[i].info+"</a>"

    }
    $("#adviceImg").html(psimg)
    $("#btn").html(ps)
}