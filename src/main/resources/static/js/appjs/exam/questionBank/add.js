$().ready(function() {
	validateRule();
	checkOptions();
});

$.validator.setDefaults({
	submitHandler : function() {
		var options = JSON.stringify($(".options").serializeArray());
		$("#options").val(options);
		save();
	}
});

function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/exam/questionBank/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

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

function checkOptions() {
	debugger;
	var questionType = $("input[name='questionType']:checked").val();
	if(questionType == 'single_choice' || questionType == 'multiple_choice'){
		$("#div-options").show();
	}else{
		$("#div-options").hide();
	}
}