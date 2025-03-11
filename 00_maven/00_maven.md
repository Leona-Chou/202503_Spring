# 00_maven
</br>

[> 講義點此][1]
</br>
</br>

---

## 建立 Maven project
1. File -> New -> Maven Project
2. 勾選「Create a simple project」 -> 點擊「Next」
3. 填寫 「Group Id」 & 「Artifact Id」 -> 點擊「Finish」

## 測試設定檔是否可以正常執行
### 添加 Lombok 依賴
Lombok plugin
```xml=
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.36</version>
    <scope>provided</scope>
</dependency>
```
1. 於 `pom.xml` 貼上以上 code，並存檔  
2. 右鍵 Project -> Maven -> Update Project **（這一步建議每次更新 `pom.xml` 都要做）**  
3. 右下角待 Maven 下載好套件後，到 `.m2` 下的 Lombok 目錄下雙擊 `lombok.jar` 打開安裝程式  
4. 重啟 Eclipse

### 建立 Bean -> User.java
```java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private Long id;
	
	private String name;


}
```
:warning: **Eclipse 應該要可以抓到以上的 annotation**

### 測試 Lombot 是否有被載入 -> Main.java
```java
public static void main(String[] args) {
    User user = new User();
    user.setName("Leona");	
}
```


  [1]: https://hackmd.io/Q0JZHRakTaSIOxRXm5O79w?view#%E5%BB%BA%E7%AB%8B-HelloSpring-%E5%B0%88%E6%A1%88 "01. Spring 框架介紹"

