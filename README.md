# 一个为原生SDK生成Dart Binding的编译器

## 快速开始
### 形态
Fluttify形态上是一个gradle插件, 利用了gradle提供的基础设施, 包括任务依赖管理, 任务缓存, 并行执行等. 
在工程结构上, Fluttify呈现了一个编译器的结构, 即包含了前端和后端, 如下图所示:
![structure](https://github.com/fluttify-project/fluttify-project/blob/master/resources/structure.png?raw=true)

第一个阶段, Fluttify会把原生SDK解析为一个json表示; 第二个阶段, 使用这个json表示生成最终的插件代码.

### build.gradle
以高德定位SDK为例, 为了生成高德定位的Flutter插件, 需要新建并编辑如下的build.gradle文件:
```groovy
// 应用fluttify插件
// 这个是已经上传到gradle官方插件仓库的版本
plugins {
  id "me.yohom.fluttify" version "0.6.0"
}
// 如果是要依赖自己编译的fluttify-core, 那么使用如下方式引入
// buildscript {
//     repositories {
//         // maven本地仓库, 先执行`gradle install`把fluttify-core安装在本地
//         mavenLocal()
//         jcenter()
//     }
// 
//     dependencies {
//         classpath('me.yohom:fluttify-core:0.+')
//     }
// }
// 
// apply plugin: 'me.yohom.fluttify'

// 开始配置编译器参数
fluttify {
    projectName = "amap_location_fluttify" // 输出工程名称
    org = "me.yohom" // 输出工程组织名称
    desc = "An `Amap` Location Component, Powered By `Fluttify`, A Compiler Generating Dart Bindings For Native SDK." // 输出工程描述
    author = "yohom" // 作者
    email = "yohombao@qq.com" // 作者邮箱
    homepage = "https://github.com/fluttify-project/amap_location_fluttify" // 项目主页
    // foundation插件的版本, 目前foundation包括foundation_fluttify和core_location_fluttify. 包含了系统类的实现
    foundationVersion = [
        "foundation_fluttify": "^0.8.10",
        "core_location_fluttify": "^0.2.1",
    ]
    // 其他插件依赖
    pluginDependencies = ["amap_core_fluttify": "^0.9.5"]

    // android端配置
    android {
        // 远程仓库配置
        remote {
            org = ["com.amap.api"] // 这里参数是一个数组, 所以可以指定多个远程仓库
            name = ["location"]
            version = ["4.7.2"]
        }
    }

    // ios端配置
    ios {
        remote {
            name = ["AMapLocation"]
            version = ["2.6.3"]
        }
    }
}
```
其他具体的配置项, 可以参考`FluttifyExtension`类.

### run!
在`build.gradle`所在目录, 命令行输入一下命令, 即可生成高德地图插件!
```shell script
gradle fluttify
```

## 架构概览
### 分包结构
- extension: 包含一些辅助方法
- model: 所有的模型类, 主要是对语言元素的抽象
- task: 所有的gradle task
- tmpl: 处理模板的类

分包原则:
1. 包下面有类:
    - 有且仅有一个类, 这个类是对包名的实现
    - 包下的其他元素只能是子包, 这些子包下的类是当前包下类的组成部分, 其他类推
2. 包下面没有类, 只有子包
    - 当包下面没有类, 只有并列的子包时, 代表这些子包是相同组成部分的不同情况

## 配套基础库
### foundation_fluttify
foundation_fluttify封装了Android和iOS两端的系统类和一些公共方法.

### core_location_fluttify
既然有了foundation_fluttify, 为什么还要有core_location_fluttify? 因为苹果机审的时候会扫描你用到了哪些系统framework, 如果你的app没有使用定位, 却引入了CoreLocation, 那么苹果可能会拒绝你的app, 所以这里把敏感framework单独分离出一个插件, 需要的时候才作为依赖添加.

## 局限性
目前的局限性来自于Flutter, 由于原生调用dart的时候, 是无法同步调用的, 所以碰到一个原生回调方法需要同步返回一个值的时候, Method Channel是无能为力的.
具体案例可以参考[高德地图iOS端添加Marker](https://github.com/fluttify-project/amap_map_fluttify/blob/3996a6d8c340c18250937ca7c8095c1e06ddb74c/ios/Classes/MAMapViewFactory.m#L4044) 。

所以如何解决? 不要有洁癖，该手写代码的时候就手写代码 :)

## 相关文章
- [Flutter插件开发必备 原生SDK->Dart接口生成引擎`Fluttify`介绍](https://juejin.im/post/5dc65fa2f265da4d23759cec)
- [如何利用Fluttify开发一个新的Flutter插件](https://juejin.im/post/5e06faa651882512416a7630)
- [Fluttify输出Flutter插件工程详解](https://juejin.im/post/5e19306c6fb9a02ff67d3780)
- [Fluttify编译器原理介绍](https://juejin.im/post/5e67321751882549717d8de7)

## Showcase
请参考 https://github.com/fluttify-project?type=source 下的项目