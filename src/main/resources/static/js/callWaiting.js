//managemyinfo에서 쓰는 스크립트
$(document).ready(function(e){
    var contextPath = $('#contextPathHolder').attr('data-contextPath') ? $('#contextPathHolder').attr('data-contextPath') : '';

    //모달 띄우기
    $(".waiting-table").on("click",".waiting-box", function(){
    console.log("click_modal");
        $("#memberNickname").val($(this).find('.wt-nickName').html());
        $("#modal-memberMobile").val($(this).find('.wt-memberMobile').html());
        $("#partyMember").val($(this).find('.wt-partyMember').html());
        $("#modal-waitingNum").val($(this).find('.wt-waitingNum').html());
        $("#modal-storeNum").val($(this).find('.wt-storeNum').html());
        $("#modal-memberNum").val($(this).find('.wt-memberNum').html());
        $('.waitingModal').modal('show');
    });

    //대기 모달 닫기
    $(".waiting-close21").click(function(){
        $('.waitingModal').modal('hide')
    });

    //웨이팅 취소
    $(".go-cancel21").on("click", function(){
        var waitingNum = $("#modal-waitingNum").val();
        console.log(waitingNum);
        var data = {
            waitingNum: waitingNum
            }
        console.log(data);

        $.ajax({
        url: contextPath + '/modifyWaiting/'+waitingNum,
        type:"DELETE",
        data:JSON.stringify(data),
        contentType:"application/json; charset=utf-8",
        dataType:"text",
        success: function(data){
                console.log("result: " + data);
                self.location.reload();
             },
        error:function(data){
            alert("delete_errorrrrrrrrrrrrrrrr");
            }
    });
    $('.waitingModal').modal('hide');
    });

    //대기 입장 완료
    $(".go-walkIn21").on("click", function(){
        var waitingNum = $("#modal-waitingNum").val();
        console.log(waitingNum);
        var data = {
            waitingNum: waitingNum
            }
        console.log(data);

        $.ajax({
        url: contextPath + '/modifyWaiting/'+waitingNum,
        type:"DELETE",
        data:JSON.stringify(data),
        contentType:"application/json; charset=utf-8",
        dataType:"text",
        success: function(data){
                console.log("result: " + data);
                alert("입장이 완료되었습니다")
                self.location.reload();
             },
        error:function(data){
            alert("delete_errorrrrrrrrrrrrrrrr");
            }
    });
    $('.waitingModal').modal('hide');
    });




    //대기 연락하기
    $(".go-call21").click(function(){
        alert("입장 안내 연락을 드렸습니다")
        $('.waitingModal').modal('hide')
    });


});