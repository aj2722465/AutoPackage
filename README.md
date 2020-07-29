# AutoPackage
一件乐固加固+签名+美团多渠道打包

第一步：拷贝根目录下的legu文件到自己的项目根目录

第二步：拷贝app下的release.gradle文件到自己项目的modle

第三步：app下的builde.gradle顶部添加 
 
     apply from: 'release.gradle'

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

      
