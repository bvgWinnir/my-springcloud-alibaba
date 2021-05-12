nacos 过关
技术上没有什么难点
难点在于问题的感知,能定位到问题的关键点
此次问题出现的关键点是 加载不到bootstrap.properties 这个文件 
再添加jar 包之后解决
nacos 集中配置
nacos 动态更新配置,需要现在配置文件加入
        spring.cloud.nacos.config.extension-configs[2].refresh=true 类似的配置,
        重启之后才能生效
        只需要更改配置,项目会自动打印最新的配置
打印配置
根据环境区分配置

插件反向细节 easycode 选择 mp 一键解决

集成mp
1.mp中自动填充中 
    1.meteobjecthandler 中 filedName-->java 对象中的字面值 类型是此字段的类型
    2.需要在字段上添加注解,标识在何时自动赋值
2.乐观锁 需要2步:
    1.在自动填充中配置,对字段进行初始化
    2.在修改时才生效
fegin
1.a->b,c
2.a->b->c
