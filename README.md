## 利用springToolSuite 試作出材料管理系統   
(ユーザログインし、アイテムを検索、新規、更新、削除する試作作品)  
  
概要 使用者登入後, 會進入使用者材料管理畫面, 從使用者的權限搜查所有的材料,接著去新增,更新, 刪除頁面做DB的更新  
  
主要畫面 : 1.登入 2.新增使用者 3.使用者管理[檢索材料一覽] 4.材料追加 5.材料更新 6.材料刪除  
  
以下為檔案的樹狀圖  
│  obj_itemManagement_folder_tree  
│    
└─obj_itemManagement  
    │  .classpath  
    │  .factorypath  
    │  .gitignore  
    │  .project  
    │  HELP.md  
    │  mvnw  
    │  mvnw.cmd  
    │  pom.xml  
    │    
    ├─.mvn  
    │  └─(略)  
    ├─.settings  
    │      (略)  
    ├─sample  
    ├─src  
    │  ├─main  
    │  │  ├─java  
    │  │  │  └─com  
    │  │  │      └─demo  
    │  │  │          │  SampleApplication.java  
    │  │  │          │    
    │  │  │          ├─bean  
    │  │  │          │      AddItemBean.java  
    │  │  │          │      CreateUserAccountBean.java  
    │  │  │          │      deleteItemBean.java  
    │  │  │          │      LoginBean.java  
    │  │  │          │      SelectUserBean.java  
    │  │  │          │      updateItemBean.java  
    │  │  │          │      UserInfoBean.java  
    │  │  │          │        
    │  │  │          ├─controller  
    │  │  │          │      HelloController.java  
    │  │  │          │        
    │  │  │          ├─mapper  
    │  │  │          │      HelloMapper.java  
    │  │  │          │        
    │  │  │          └─service  
    │  │  │                  HelloService.java  
    │  │  │                    
    │  │  ├─resources  
    │  │  │  │  application.properties  
    │  │  │  │  mybatis-config.xml  
    │  │  │  │    
    │  │  │  ├─com  
    │  │  │  │  └─demo  
    │  │  │  │      └─mapper  
    │  │  │  │              HelloMapper.xml  
    │  │  │  │                
    │  │  │  ├─static  
    │  │  │  │  ├─css  
    │  │  │  │  │      addItem.css  
    │  │  │  │  │      deleteItem.css  
    │  │  │  │  │      login.css  
    │  │  │  │  │      registerUser.css  
    │  │  │  │  │      updateItem.css  
    │  │  │  │  │      userInfo.css  
    │  │  │  │  │        
    │  │  │  │  └─js  
    │  │  │  │          login.js  
    │  │  │  │            
    │  │  │  └─templates  
    │  │  │          hello_bk.html  
    │  │  │          login.html  
    │  │  │          login_bk.html  
    │  │  │          login_js_bk.html  
    │  │  │          toAddItem.html  
    │  │  │          toDeleteItem.html  
    │  │  │          toRegisterUser.html  
    │  │  │          toUpdateItem.html  
    │  │  │          userInfo.html  
    │  │  │            
    │  │  └─webapp  
    │  └─test  
    │      └─java  
    │          └─com  
    │              └─demo  
    │                      SampleApplicationTests.java  
    │                        
    └─target  
        │  sample-0.0.1-SNAPSHOT.war  
        │  sample-0.0.1-SNAPSHOT.war.original  
        │    
        ├─classes  
        │  │  application.properties  
        │  │  mybatis-config.xml  
        │  │    
        │  ├─com  
        │  │  └─demo  
        │  │      │  SampleApplication.class  
        │  │      │    
        │  │      ├─bean  
        │  │      │      AddItemBean.class  
        │  │      │      CreateUserAccountBean.class  
        │  │      │      deleteItemBean.class  
        │  │      │      LoginBean.class  
        │  │      │      SelectUserBean.class  
        │  │      │      updateItemBean.class  
        │  │      │      UserInfoBean.class  
        │  │      │        
        │  │      ├─controller  
        │  │      │      HelloController.class  
        │  │      │        
        │  │      ├─mapper  
        │  │      │      HelloMapper.class  
        │  │      │      HelloMapper.xml  
        │  │      │        
        │  │      └─service  
        │  │              HelloService.class  
        │  │                
        │  ├─static  
        │  │  ├─css  
        │  │  │      addItem.css  
        │  │  │      deleteItem.css  
        │  │  │      login.css  
        │  │  │      registerUser.css  
        │  │  │      updateItem.css  
        │  │  │      userInfo.css  
        │  │  │        
        │  │  └─js  
        │  │          login.js  
        │  │            
        │  └─templates  
        │          toAddItem.html  
        │          toDeleteItem.html  
        │          toRegisterUser.html  
        │          toUpdateItem.html  
        │          userInfo.html  
        │            
        ├─generated-sources  
        │  └─annotations  
        ├─generated-test-sources  
        │  └─test-annotations  
        ├─m2e-wtp  
        │  └─web-resources  
        │      └─META-INF  
        │          │  MANIFEST.MF  
        │          │    
        │          └─maven  
        │              └─com.demo  
        │                  └─sample  
        │                          pom.properties  
        │                          pom.xml  
        │                            
        ├─maven-archiver  
        │      pom.properties  
        │        
        ├─maven-status  
        │  └─maven-compiler-plugin  
        │      ├─compile  
        │      │  └─default-compile  
        │      │          createdFiles.lst  
        │      │          inputFiles.lst  
        │      │            
        │      └─testCompile  
        │          └─default-testCompile  
        │                  createdFiles.lst  
        │                  inputFiles.lst  
        │                    
        ├─sample-0.0.1-SNAPSHOT  
        │  ├─META-INF  
        │  └─WEB-INF  
        │      ├─classes  
        │      │  │  application.properties  
        │      │  │  mybatis-config.xml  
        │      │  │    
        │      │  ├─com  
        │      │  │  └─demo  
        │      │  │      │  SampleApplication.class  
        │      │  │      │    
        │      │  │      ├─bean  
        │      │  │      │      HelloBean.class  
        │      │  │      │      LoginBean.class  
        │      │  │      │        
        │      │  │      ├─controller  
        │      │  │      │      HelloController.class  
        │      │  │      │        
        │      │  │      ├─mapper  
        │      │  │      │      HelloMapper.class  
        │      │  │      │      HelloMapper.xml  
        │      │  │      │        
        │      │  │      └─service  
        │      │  │              HelloService.class  
        │      │  │                
        │      │  ├─static  
        │      │  │  ├─css  
        │      │  │  │      login.css  
        │      │  │  │        
        │      │  │  └─js  
        │      │  │          login.js  
        │      │  │            
        │      │  └─templates  
        │      │          hello.html  
        │      │          login.html  
        │      │          login2.html  
        │      │          userInfo.html  
        │      │          userInfo2.html  
        │      │            
        │      └─lib  
        │              attoparser-2.0.5.RELEASE.jar  
        │              bootstrap-4.5.3.jar  
        │              classmate-1.4.0.jar  
        │              commons-compress-1.9.jar  
        │              commons-lang3-3.8.1.jar  
        │              hibernate-validator-6.0.17.Final.jar  
        │              HikariCP-3.2.0.jar  
        │              jackson-annotations-2.9.0.jar  
        │              jackson-core-2.9.9.jar  
        │              jackson-databind-2.9.9.3.jar  
        │              jackson-datatype-jdk8-2.9.9.jar  
        │              jackson-datatype-jsr310-2.9.9.jar  
        │              jackson-module-parameter-names-2.9.9.jar  
        │              javax.annotation-api-1.3.2.jar  
        │              jboss-logging-3.3.3.Final.jar  
        │              jquery-3.5.1.jar  
        │              jul-to-slf4j-1.7.28.jar  
        │              log4j-api-2.11.2.jar  
        │              log4j-to-slf4j-2.11.2.jar  
        │              logback-classic-1.2.3.jar  
        │              logback-core-1.2.3.jar  
        │              mybatis-3.5.2.jar  
        │              mybatis-spring-2.0.2.jar  
        │              mybatis-spring-boot-autoconfigure-2.1.0.jar  
        │              mybatis-spring-boot-starter-2.1.0.jar  
        │              popper.js-1.16.0.jar  
        │              postgresql-42.2.6.jar  
        │              slf4j-api-1.7.28.jar  
        │              snakeyaml-1.23.jar  
        │              spring-aop-5.1.9.RELEASE.jar  
        │              spring-beans-5.1.9.RELEASE.jar  
        │              spring-boot-2.1.8.RELEASE.jar  
        │              spring-boot-autoconfigure-2.1.8.RELEASE.jar  
        │              spring-boot-starter-2.1.8.RELEASE.jar  
        │              spring-boot-starter-jdbc-2.1.8.RELEASE.jar  
        │              spring-boot-starter-json-2.1.8.RELEASE.jar  
        │              spring-boot-starter-logging-2.1.8.RELEASE.jar  
        │              spring-boot-starter-thymeleaf-2.1.8.RELEASE.jar  
        │              spring-boot-starter-web-2.1.8.RELEASE.jar  
        │              spring-context-5.1.9.RELEASE.jar  
        │              spring-core-5.1.9.RELEASE.jar  
        │              spring-expression-5.1.9.RELEASE.jar  
        │              spring-jcl-5.1.9.RELEASE.jar  
        │              spring-jdbc-5.1.9.RELEASE.jar  
        │              spring-tx-5.1.9.RELEASE.jar  
        │              spring-web-5.1.9.RELEASE.jar  
        │              spring-webmvc-5.1.9.RELEASE.jar  
        │              thymeleaf-3.0.11.RELEASE.jar  
        │              thymeleaf-extras-java8time-3.0.4.RELEASE.jar  
        │              thymeleaf-spring5-3.0.11.RELEASE.jar  
        │              unbescape-1.1.6.RELEASE.jar  
        │              validation-api-2.0.1.Final.jar  
        │              webjars-locator-0.40.jar  
        │              webjars-locator-core-0.35.jar  
        │                
        ├─surefire-reports  
        │      com.demo.SampleApplicationTests.txt  
        │      TEST-com.demo.SampleApplicationTests.xml  
        │        
        └─test-classes  
            └─com  
                └─demo  
                        SampleApplicationTests.class  
                          
