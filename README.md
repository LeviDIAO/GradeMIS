# GradeMIS
学生成绩信息管理系统。会在根目录自动创建student.info存放数据。
已完成功能：（计算机系、英语系、文学系）学生的成绩录入、成绩删除、保存。根据学号或姓名的精准查询、根据成绩区间的查询。学生信息的修改、成绩排序输出。  
已知bug：只能保存最新的新增学生成绩信息，原因是调用新增方法时会覆盖记录，尚未修正。修改有bug，懒得做了。  
待改进功能：准备在删除时自动调用查询方法，实现删除前能够看到学号对应的完整个人信息。在无前置操作时保存无反应或弹窗无消息。增加数据可视化处理。
