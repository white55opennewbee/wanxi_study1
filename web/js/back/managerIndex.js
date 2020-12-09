function LoadContent(url) {
    $("#content").html("<object id=\"pp\" type=\"text/x-scriptlet\" data=\"" + url + "\" width=100% height='100%'>\n" +
        "        </object>")
}

function openMenus(object) {
    $(object).siblings().slideDown();
    $(object).parent().siblings().children("div div:nth-child(2)").slideUp();
}