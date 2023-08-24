(function () {
    validateSubmit()
})()
function submint() {
    var loan =$('input[name="loan"]').val();
    var years =$('input[name="years"]').val();
    var apr =$('input[name="apr"]').val();

    var data={
        "loan":loan,
        "years":years,
        "apr":apr
    }
    $.ajax({
        type:"POST",
        url:"/calculate/doloan2",
        data:JSON.stringify(data),
        contentType:"application/json",
        dataType:"json",
        success:function (data) {
            if (data.code=="SUCCESS"){
                console.log("success");
            }

            console.log(data)
        },
        error:function (data) {
            window.alert("请填写正确内容")
            console.log("erro")
            console.log(data)
        }
    })
}

function validateSubmit() {
    $('#calculate').validate({
        rules:{
            loan:{
                required:true,
                number:true
            },
            years:{
                required:true,
                number:true
            },
            apr:{
              required:true,
              number:true
            }
        },
        messages:{
            loan:{
                required:"请输入内容",
                number:"请输入数字"
            },
            years:{
                required:"请输入内容",
                number:"请输入数字"
            },
            apr:{
                required:"请输入内容",
                number:"请输入数字"
            }
        }
    })
}