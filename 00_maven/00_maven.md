# 00_maven 筆記
</br>

[> 講義點此][1]
</br>
</br>

---

## 一、建立 Maven project
1. File -> New -> Maven Project
2. 勾選「Create a simple project」 -> 點擊「Next」
3. 填寫 「Group Id」 & 「Artifact Id」 -> 點擊「Finish」

## 二、測試設定檔是否可以正常執行
### 添加 Lombok 依賴
```xml
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

## 三、依賴關係介紹
[> 講義點此][2]  
`儘量不要依賴底層實作 儘量依賴高層抽象類別`

### 緊耦合 
Toyota.java
```java
public class Toyota extends ToyotaEngine {
    public void move() {
        // Toyota要能夠移動，必須要有可以啟動的引擎
        // 1. 創建物件
        ToyotaEngine toyotaEngine = new ToyotaEngine();
        toyotaEngine.start();
        // 2. 從引擎繼承的start方法（需要 extends）
        start();
    }
}
```
ToyotaEngine.java
```java
public class ToyotaEngine {
    public void start() {
        System.out.println("Toyota引擎發動");
    }
}
```

當 Toyota 類別依賴於 ToyotaEngine 類別時，如果 ToyotaEngine 類別發生變化或異常，Toyota 類別可能需要相應地進行修正。這是因為 Toyota 類別直接依賴於 ToyotaEngine 類別的實現細節，導致它們之間的關係緊密耦合。這就稱作 **緊耦合（tight coupling）**。  

想要抽換其他的引擎（像是 BenzEngine），則需要改變 Toyota 類別本身的程式。


### 鬆耦合



  [1]: https://hackmd.io/Q0JZHRakTaSIOxRXm5O79w?view#%E5%BB%BA%E7%AB%8B-HelloSpring-%E5%B0%88%E6%A1%88 "01. Spring 框架介紹"
  [2]: https://hackmd.io/eYtjufldQa2QUMIHIpo8mg "依賴關係介紹"

