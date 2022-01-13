$(document).ready(function(e){
    var contextPath = $('#contextPathHolder').attr('data-contextPath') ? $('#contextPathHolder').attr('data-contextPath') : '';
    var storeNum = $('#js-storeNum').text();
    var memberNum = $('#js-memberNum').text();

    $(".like-like").on("click", function(){
        console.log("likelike");
        var data = {
            memberNum: memberNum,
            storeNum: storeNum
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

                $(".like-like").css("font-weight", "bold");
                //self.location.reload();
             },
            error:function(data){
            alert("errorrrrrrrrrrrrrrrr");
            }
        });


        

    });



});
