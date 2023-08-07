(function () {

})()
function submin() {
    const xhr =new XMLHttpRequest()
    xhr.open(
        "GET",
        "/tools",
        true
    )
    xhr.send(
        {
            "loan":2000,
            "arp":20,
            "years":3
        }
    )

}