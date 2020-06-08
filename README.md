# PermissionX

简化Android运行时请求权限的开源库。

添加如下配置，即可直接使用
```groovy
dependencies {
    implementation 'com.qingyan.lib:permissionx:1.0.0'
}
```
调用方法用例：
```kotlin
PermissionX.request(this,Manifest.permission.CALL_PHONE
                ,Manifest.permission.WRITE_EXTERNAL_STORAGE)
        {success,deniedList->
            if (success){
                Toast.makeText(this,"权限都得了",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"权限未全获得：$deniedList",Toast.LENGTH_SHORT).show()
            }
        }
        ```