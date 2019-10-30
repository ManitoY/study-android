# study-android

## 项目结构 学习项目分为12个大模块(后面版本发现新模块会再添加)

                                        app
                                  _______|_______
                                 |               |
                              lib_base        lib_view

## 注解
   BNA: BaseNavigationActivity
   BTF: BaseTheoryFragment
   BQF: BaseQuizFragment

### -app
     |__animation(动画)
     |__components(四大组件)
        |__BNA_activity(Activity 组件)
           |__BTF_theory(理论知识)
           |__BQF_quiz(一些面试题)
     |__designmodel(设计模式)
     |__framework(Android Framework)
     |__jetpack(Android Jetpack)
     |__network(网络相关)
     |__optimization(Android 优化)
     |__process(进程)
     |__storage(存储)
     |__thread(线程)
     |__tools(第三方)
     |__view(界面相关)
     |__app.gradle
        |__api project(':lib_base')

### -lib_base(app 中可以下沉的父类、公共资源)
     |__BaseNavigationActivity(纯导航界面)
     |__BaseQuizFragment(面试题)
     |__BaseTheoryFragment(理论知识)
     |__lib_base.gradle
        |__api project(':lib_customview')
        |__api androidx.navigation

### -lib_customview(自定义View、动画)
     |__Animations(动画)
        |__startShakeByPropertyAnim(面试题按钮动画-变大变小抖动动画)
     |__CodeTextView(将文字处理成代码块)
     |__ScreenMatch(屏幕适配)
     |__SvgView(Svg图片处理)
     |__styles.xml
        |__AppTitle(标题样式)
        |__AppTitle2(标题样式2)
        |__AppContent(内容样式)
        |__AppCode(代码块样式)
        |__AppCase(按钮样式'面试题')
     |__lib_customview.gradle
        |__api kotlin
        |__api androidx.constraintlayout
        |__api androidx.appcompat
        |__api androidx.core
