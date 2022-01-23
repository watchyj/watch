$(document).ready(function(e){
    var contextPath = $('#contextPathHolder').attr('data-contextPath') ? $('#contextPathHolder').attr('data-contextPath') : '';
    var storeNum = $('#js-storeNum').text();
    var memberNum = $('#js-memberNum').text();
    var likes = $('.like-like');
    var liking = $('.liking').text();
    var likesNum = $('.js-likesNum').text();
    var likesStoreNum = $('.like-storeNum').text();

    //라이크 유지하기
    if (likesNum == "") {
        $(".like-like").html("♡");
    } else if (likesNum != ""){
      $(".like-like").html("♥");
    }

    //좋아요 add, delete
    $(".like-like").on("click", function(){
        if (likes.text() == "♡") {

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
                console.log("result1: "+data);
                var likesNum = parseInt(data);
                //self.location.reload();
                console.log("result2: "+likesNum);
                console.log("likes: "+likes);
             },
            error:function(data){
            alert("errorrrrrrrrrrrrrrrr");
            }
        });
        $(".like-like").html("♥");
        }

        else if (likes.text() == "♥") {
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
                        //self.location.reload();
                }
            });
            $(".like-like").html("♡");
        }

    });

});