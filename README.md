# JavaWebLearning5
设计学生成绩查询系统，需登录后才可查看各科成绩。该系统具有以下功能：
1、	用户注册功能（包括姓名、性别（单选框）、密码、专业（用下拉列表）、班级、学号、个人介绍），将注册信息保存到数据库中；注册成功后2秒钟跳转到登陆页面；
2、	登陆页面（用姓名和密码登陆），登陆后3秒钟跳转到成绩显示页面；
3、	成绩显示页面，需登录后才可访问该页面；
并设计以下过滤器：
4、	为成绩显示页面设计登陆验证过滤器，如果没有登陆的状态下访问成绩显示页面，拦截此请求，并转到登陆页面。
