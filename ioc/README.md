# IOC控制反转

## 应用（Application），它包含一个写文件的服务（FileWriterService），该服务在创建时会创建并打开一个文件，销毁时关闭该文件，并且该服务包含一个write(String content)方法：会将content写入到文件中

* 使用Spring IoC的相关内容组织该程序；

* 文件路径通过配置文件（properties）指定；