var prefix = "/exam/paperAnswer"

$().ready(function() {
    validateRule();
});

$.validator.setDefaults({
    submitHandler : function() {
        upLoadPaper();
    }
});

function upLoadPaper(){
    var singleChoiceAnswer = JSON.stringify($(".single_choice_answer").serializeArray());
    $("input[name='singleChoiceAnswer']").val(singleChoiceAnswer);

    var multipleChoiceAnswer = JSON.stringify($(".multiple_choice_answer").serializeArray());
    $("input[name='multipleChoiceAnswer']").val(multipleChoiceAnswer);

    var completionAnswer = JSON.stringify($(".completion_answer").serializeArray());
    $("input[name='completionAnswer']").val(completionAnswer);

    $.ajax({
        cache : true,
        type : "POST",
        url : prefix + "/upLoadPaper",
        data : $('#signupForm').serialize(),// 你的formid
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                layer.msg("试卷提交成功",function () {
                    location.reload();
                });

            } else {
                parent.layer.alert(data.msg)
            }

        }
    });
}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            name : {
                required : true
            }
        },
        messages : {
            name : {
                required : icon + "请输入姓名"
            }
        }
    })
}