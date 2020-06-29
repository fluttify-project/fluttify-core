# 一个为原生SDK生成Dart Binding的编译器

## 快速开始
### 形态
Fluttify形态上是一个gradle插件, 利用了gradle提供的基础设施, 包括任务依赖管理, 任务缓存, 并行执行等. 
在工程结构上, Fluttify呈现了一个编译器的结构, 即包含了前端和后端, 如下图所示:
![structure](https://github.com/fluttify-project/fluttify-project/blob/master/resources/structure.png?raw=true)

第一个阶段, Fluttify会把原生SDK解析为一个json表示; 第二个阶段, 使用这个json表示生成最终的插件代码.

### build.gradle

### run!

## 架构概览
### 分包结构
- extension:
- model:
- task:
- tmpl:

## 配套基础库
### foundation_fluttify

### core_location_fluttify

## 局限性
