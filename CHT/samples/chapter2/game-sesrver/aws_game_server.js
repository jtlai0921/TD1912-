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

    // �إ߮ר�
    ec2.runInstances(params, function (err, data) {
        if (err) {
            console.log("Could not create instance", err);
            context.fail(err);
        }
        var instanceId = data.Instances[0].InstanceId;
        console.log("Created instance", instanceId);

        //TODO�]�ݧ����^���[�ƽd�� id �ó]�w���A���Ұʪ��A
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

    //TODO�]�ݧ����^����d�� id �ç�s�d�Ҫ��A��u�W
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

    //TODO�]�ݧ����^����רҬO�_�i�Q�q DynamoDB �פ�A�ӫ��s�d�Ҭ��פ�A
    var params = {InstanceIds: [instanceId]};

    //�פ�ר�
    ec2.terminateInstances(params, function (err, data) {
        if (err) {
            console.log("Could not terminate instance", err);

        //TODO ��^�פ�ר�
            context.fail(err);
        }
        for (var i in data.TerminatingInstances) {
            var instance = data.TerminatingInstances[i];
            console.log('TERM:\t' + instance.InstanceId);

            //TODO �����פ�ר�
        }
        context.succeed(data.TerminatingInstances);
    });
};