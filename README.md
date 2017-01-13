
手机摇一摇
1.Android传感器:

    传感器的概念和作用
传感器是一种物理装置或者生物器官,这种传感器能够探测外界的信号,他能将这种信号传递给其他设置或者器官
举例:人--->手---->探测糖水---->大脑(器官)---->迅速做出响应
作用:将探测到的信息或者信号进行传输,满足存储,以及
2.操作方式上,有一定的创新,极大的改善用户的体验度
手机—>加速度是否改变——>具体某一个程序(注册好了传感器的内容)

    传感器的类型

运动传感器
加速度传感器,陀螺仪传感器
环境传感器
温度传感器 光传感器

    Android传感器的架构
SensorMannager:创建一个传感器服务的实列
Sensor类:代表一个传感器的具体容器
SensorEvent:代表传感器事件
SensorEventListernr:传感器的监听器
传感器的类的结构:
SensorMannager:代表的是传感器的服务类
包:android.hardware
实例化:
1.Context.getSystemService(Striing name)
方法:
1.Sensor getDefaultSensor(int type)
根据传感器的类型获取具体传感器的对象
参数:
type:传感器类型
值:Sensor.Type_ACCEERROR 表示加速度
registerListener()
注册传感器
参数:
listener 传感器的监听事件 
senor:具体的传感器
rate:延误的时间
值:SENOR_DELAY_FASTEST延迟事件0微妙
SENSOR_DELAY_GAME 延迟的时间为20000微妙
SENSOR_DELAY_UI 延迟事件为66667微妙
SENSOR_DELAY_NORMAL 延迟事件为20000微妙

取消注册:
unregister()
参数:时间 具体传感器的对象

Sensor;
final 代表的是一个传感器
返回我们手机当中的传感器,获取传感器的信息.
SensorEvent:代表的是传感器的事件
传感器的事件
SensorventListener接口

2.Android补间动画:
补间动画(Tween);
特点:
1.针对view对象,
2.不能改变view的属性:颜色,位置
3.只能提供四种效果:比如旋转,透明度,伸缩,透明度以及移动

实现方式:
1.在xml文件中实现其中的一个动画
2,在代码里面实现
4.Animation是所有补间动画的父类
子类:
Alpha
表示一个透明度的动画
Rotate:表示旋转的动画Scale:表示旋转的动画
Translate:移动动画
AnimaSet:表示动画集

提供一系列的效果,使UI控件旋转,透明度化,伸缩,移动效果
帧动画
属性动画

3.震动效果与音效 Mediaplayer
Vibrator:实现震动的服务
实例化:
1.Context.getSystemSerivce()
方法:vibrate()
指定时间间隔内震动并且可以设置震动的时间
参数:
pattern 设置震动的时间
repeat:设置震动重复的次数

Mediaplayer类:播放音频和视频文件
音频播放方式
1.静态方法
create()
根据音频文件的标识获取Mediaplayer的对象
2.Mediaplayer()
方法:
1.setDataSource(FileDescriper fd)

设置音频资源 
参数:文件标志符
初始偏移量
length 文件长度
注意:严格按照Mediaplayer 生命周期去实现
方法:
start() 播放音频文件

摇一摇代码的实现
UI的实现 
传感器的实现

