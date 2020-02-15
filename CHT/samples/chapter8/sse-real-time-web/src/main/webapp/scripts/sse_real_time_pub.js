
/**
 * Created by waylau.com on 2015/8/18.
 */

//�P�_�s�����O�_�䴩 EventSource
if (typeof (EventSource) !== "undefined") {
    var source = new EventSource("webapi/see-events");

    // ��q�����A�����s�u�Q�}��
    source.onopen = function(event) {
        console.log("�s�u�}�ҡI");

    };

    // ������T���C�u��O�ƥ�W�٬O message
    source.onmessage = function(event) {
        console.log(event.data);
        var data = event.data;
        var lastEventId = event.lastEventId;
        document.getElementById("x").innerHTML += "\n" + 'lastEventId:'+lastEventId+';data:'+data;
    };

    //�i�H�O���N�R�W���ƥ�W��
    /*
    source.addEventListener('message', function(event) {
        console.log(event.data);
        var data = event.data;
        var lastEventId = event.lastEventId;
        document.getElementById("x").innerHTML += "\n" + 'lastEventId:'+lastEventId+';data:'+data;
    });
    */

    // ����~�o��
    source.onerror = function(event) {
        console.log("�s�u���~�I");

    };
} else {
    document.getElementById("result").innerHTML = "Sorry, your browser does not support server-sent events..."
}