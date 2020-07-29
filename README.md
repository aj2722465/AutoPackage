# AutoPackage
一键乐固加固+签名+walle多渠道打包

     实现原理：1->执行assembleProductRelease打release包
              2->乐固对release包进行加固
              3->zipalign 数据结构对齐
              4->apksigner.jar 进行签名
              5->签名后的release包重命名
              6->walle-cli-all.jar 注入渠道信息
              
第一步：拷贝根目录下的legu文件到自己的项目根目录

第二步：拷贝app下的release.gradle文件到自己项目的modle

第三步：app下的builde.gradle添加： 
 
     apply from: 'release.gradle'
     
     dependencies {
         .....
         //walle多渠道
        implementation 'com.meituan.android.walle:library:1.1.7'
    }

第四步：app下的bulide.gradle添加命名规则
           
     android.applicationVariants.all { variant ->
          variant.outputs.all {
              outputFileName = "atuo-v${variant.versionName}-${productFlavors[0].name}_${releaseTime()}.apk"
          }
     }

第五步：根据自己的项目配置gradle.properties

    ALIAS_NAME=autoPackage
    ALIAS_PASS=asdf1234
    KEY_MODULE_PATH=../../app/autoPackage.jks
    KEY_PASS=asdf1234
    KEY_PATH=../app/autoPackage.jks

第六步：配置app下的channel文件 填写要打的渠道信息

#打包命令

    gradlew clean  
    gradlew assemblePackageChannel
    
最终生成加固签名的渠道包路径：

    //多渠道安装包路径
    app/build/outputs/release/channels
    //压缩包路径
    app/build/phjt-channels.zip
    
    
#联系方式
email: ajsxmx@163.com

      
