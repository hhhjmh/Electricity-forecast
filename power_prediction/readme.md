
1.更新maven，PowerPredictionApplication没有报错

2.mysql数据库创建power数据库，建库语句
create database power;
将src/main/resources/power.sql导入数据库中

3.运行PowerPredictionApplication,没报错则数据库连接成功

4.使用Postman测试，URL是http://localhost:80/user/login，
POST类型
body中的raw模式json数据类型，主体是
{
"username": "admin",
"password": "123456"
}
返回
{
"root": 1,
"state": "Success",
"username": "admin"
}
则后端调试成功