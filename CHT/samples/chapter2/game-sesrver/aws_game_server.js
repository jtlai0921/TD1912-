/**
 * Created by waylau on 2016/8/6.
 */
var AWS = require('aws-sdk');
exports.handler = function (event, context) {
    console.log("Received data as:", event);
    var ec2 = new AWS.EC2({region: 'ap-northeast-1'});
    var params = {
        ImageId: 'ami-29160d47',
        InstanceType: 't2.micro',
        KeyName: 'Tech-labs',
        SecurityGroupIds: ['sg-d0aa1bb4'],
        IamInstanceProfile: {Name: 'EC2-Admin'},
        MinCount: 1,
        MaxCount: 1
    };

    // 建立案例
    ec2.runInstances(params, function (err, data) {
        if (err) {
            console.log("Could not create instance", err);
            context.fail(err);
        }
        var instanceId = data.Instances[0].InstanceId;
        console.log("Created instance", instanceId);

        //TODO（待完成）持久化範例 id 並設定狀態為啟動狀態
        context.succeed(instanceId);
    });
};


var AWS = require('aws-sdk');
exports.handler = function (event, context) {
    console.log("Received data as:", event);
    var instanceId = event.instanceId;
    var region = event.region;
    var publicIp = event.publicIp;
    var version = event.version;
    // ...

    //TODO（待完成）檢驗範例 id 並更新範例狀態到線上
};


var AWS = require('aws-sdk');
exports.handler = function (event, context) {
    console.log("Received data as:", event);
    var message = JSON.parse(event.Records[0].Sns.Message);
    var region = event.Records[0].EventSubscriptionArn.split(":")[3];
    console.log("Need to terminate the server in region:", region);
    var ec2 = new AWS.EC2({region: region});
    console.log("Need to terminate the server:", message);
    var instanceId = message.Trigger.Dimensions[0].value;
    console.log("Need to terminate the server:", instanceId);

    //TODO（待完成）檢驗案例是否可被從 DynamoDB 終止，而後更新範例為終止狀態
    var params = {InstanceIds: [instanceId]};

    //終止案例
    ec2.terminateInstances(params, function (err, data) {
        if (err) {
            console.log("Could not terminate instance", err);

        //TODO 返回終止案例
            context.fail(err);
        }
        for (var i in data.TerminatingInstances) {
            var instance = data.TerminatingInstances[i];
            console.log('TERM:\t' + instance.InstanceId);

            //TODO 移除終止的案例
        }
        context.succeed(data.TerminatingInstances);
    });
};