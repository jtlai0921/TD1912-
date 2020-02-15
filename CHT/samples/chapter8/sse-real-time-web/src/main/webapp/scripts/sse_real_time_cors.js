
/**
 * Created by waylau.com on 2015/8/22
 */

//判斷瀏覽器是否支援 EventSource
if (typeof (EventSource) !== "undefined") {
    var source = new EventSource("http://192.168.11.125:8081/webapi/see-events");

    // 當通往伺服器的連線被開啟
    source.onopen = function(event) {
        console.log("連線開啟！");

    };

    // 當接收到訊息。只能是事件名稱是 message
    source.onmessage = function(event) {
        console.log(event.data);
        var data = event.data;
        var lastEventId = event.lastEventId;
        document.getElementById("x").innerHTML += "\n" + 'lastEventId:'+lastEventId+';data:'+data;
    };

    //可以是任意命名的事件名稱
    /*
    source.addEventListener('message', function(event) {
        console.log(event.data);
        var data = event.data;
        var lastEventId = event.lastEventId;
        document.getElementById("x").innerHTML += "\n" + 'lastEventId:'+lastEventId+';data:'+data;
    });
    */

    // 當錯誤發生
    source.onerror = function(event) {
        console.log("連線錯誤！");

    };
} else {
    document.getElementById("result").innerHTML = "Sorry, your browser does not support server-sent events..."
}