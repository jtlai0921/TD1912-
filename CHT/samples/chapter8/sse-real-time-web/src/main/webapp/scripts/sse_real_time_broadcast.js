
/**
 * Created by waylau.com on 2015/8/18.
 */

//判斷瀏覽器是否支援 EventSource
if (typeof (EventSource) !== "undefined") {
    var source = new EventSource("webapi/sse-chat");

    // 當通往伺服器的連線被開啟
    source.onopen = function(event) {
        var ta = document.getElementById('response_text');
        ta.value = '連線開啟!';
    };

    // 當接收到訊息。只能是事件名稱是 message
    source.onmessage = function(event) {
        var ta = document.getElementById('response_text');
        ta.value = ta.value + '\n' + event.data;
    };

    //可以是任意命名的事件名稱
    /*
    source.addEventListener('message', function(event) {
         var ta = document.getElementById('response_text');
         ta.value = ta.value + '\n' + event.data;
    });
    */

    // 當錯誤發生
    source.onerror = function(event) {
        var ta = document.getElementById('response_text');
        ta.value = ta.value + '\n' + "連線出錯！";

    };
} else {
    alert("Sorry, your browser does not support server-sent events");
}

function send(message) {
    var xmlhttp;
    var name = document.getElementById('name_id').value;

    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.open("POST","webapi/sse-chat?message=" + message +'&name=' + name ,true);
    xmlhttp.send();
}