(function () {

})()
function submint() {
    var data={
        "loan":"2500.00",
        "years":"1",
        "apr":"0.4"
    }
    $.ajax({
        type:"POST",
        url:"/calculate/doloan2",
        data:JSON.stringify(data),
        contentType:"application/json",
        dataType:"json",
        success:function (data) {
            console.log(data)
        },
        erro:function (data) {
            console.log(data)
        }
    })

}