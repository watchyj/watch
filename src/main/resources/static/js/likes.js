$(document).ready(function(e){
    var contextPath = $('#contextPathHolder').attr('data-contextPath') ? $('#contextPathHolder').attr('data-contextPath') : '';
    var storeNum = $('#js-storeNum').text();
    var memberNum = $('#js-memberNum').text();
    var likes = $('.like-like');
    var liking = $('.liking').text();
    var likesNum = $('.js-likesNum').text();

    //좋아요 클릭....
/*
    $(".like-like").on("click", function(){
        console.log("likelike");
        var data = {
            memberNum: memberNum,
            storeNum: storeNum,
            likes: "1"
        };
        console.log(data);
        $.ajax({
            url: contextPath+'/addLikes/'+storeNum,
            type:"POST",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"text",
            success: function(data){
                console.log("result: "+data);
                var likesNum = parseInt(data);
                console.log("result: "+likesNum);
//                likes = "1";
                console.log("likes: "+likes);
                $(".like-like").html("☆☆☆☆☆");
                //self.location.reload();
             },
            error:function(data){
            alert("errorrrrrrrrrrrrrrrr");
            }
        });
    });
*/

    //라이크 유지하기 (수정중)
    if (liking == "1") {
        $(".like-like").html("☆☆☆☆☆");
    }

    //좋아요 취소
    $(".like-like").on("click", function(){
            console.log(likesNum);
            var data = {likesNum: likesNum}

            $.ajax({
            url: contextPath + '/modifyLikes/'+storeNum+"/"+likesNum,
            type:"DELETE",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"text",
            success: function(data){
                        console.log("result: " + data);
                        $(".like-like").html("♡♡♡♡♡");
                        //self.location.reload();
                }
            });
    });



});
