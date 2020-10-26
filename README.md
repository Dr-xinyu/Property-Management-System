# 物业管理系统

## 需求分析

​	1、业主信息主要包括：业主编号，姓名，房号，房屋面积，工作单位，联系电话等。房号可唯一标识一条业主信息，且一个房号仅对应一套房屋；一个业主可以有一套或多套的房屋。
​	2、部门信息主要包括：部门号，部门名称，部门负责人，部门电话等；一个员工只能属于一个部门，一个部门只有一位负责人
​	3、员工信息主要包括：员工号，姓名，出生年月，性别，住址，联系电话，所在部门号，职务和密码等。根据职务不同员工可以有不同的权限，职务为“经理”的员工具有更改（添加、删除和修改）员工表中本部门员工信息的操作权限，并具有查询所有收费记录的权限；职务为“收费”的员工只具有收费的操作权限。
​	4、收费信息包括：房号，业主编号，收费日期，收费类型，数量，收费金额，员工号等。收费类型包括物业费、卫生费、水费和电费，并按月收取，收费标准如表10-1所示。其中：物业费=房屋面积（平方米）×每平米单价，电梯费=楼层（套）×每层单价，水费=用水数量（吨）×每吨水单价，电费=用电数量（度）×每度电单价。收费单费用根据业主上次缴纳的月份以及每月消耗的水电费总和生成。

##  环境配置

使用了maven进行这次项目的 管理。数据库连接部分使用了hibernate 5.4.21框架，GUI部分使用了JavaFx 15.

   