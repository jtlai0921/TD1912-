
/**
 * Created by waylau.com on 2015/8/18.
 */

//�P�_�s�����O�_�䴩 EventSource
if (typeof (EventSource) !== "undefined") {
    var source = new EventSource("webapi/sse-chat");

    // ��q�����A�����s�u�Q�}��
    source.onopen = function(event) {
        var ta = document.getElementById('response_text');
        ta.value = '�s�u�}��!';
    };

    // ������T���C�u��O�ƥ�W�٬O message
    source.onmessage = function(event) {
        var ta = document.getElementById('response_text');
        ta.value = ta.value + '\n' + event.data;
    };

    //�i�H�O���N�R�W���ƥ�W��
    /*
    source.addEventListener('message', function(event) {
         var ta = document.getElementById('response_text');
         ta.value = ta.value + '\n' + event.data;
    });
    */

    // ����~�o��
    source.onerror = function(event) {
        var ta = document.getElementById('response_text');
        ta.value = ta.value + '\n' + "�s�u�X���I";

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