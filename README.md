## Test Automation Framework using Selenium, Java and TestNG

🔆 **SOME FEATURES IN FRAMEWORK**

1. Run the parallel test case
2. Read Config from Properties file
3. Extent Report
4. Allure Report
5. Send Mail after the run test (Report information and HTML file attachment)
6. Write Log to file
7. Record video and Screenshot test case
8. Read data test from Excel file (xlsx, csv, json,...)
9. Base function in the package: utils, helpers
10. Read data test from Json file
11. Main Keyword: WebUI (call common function)
12. Sample test all function in WebUI keyword
13. Send message
14. Run Selenium Grid (remote)
15. Use DataFaker and JavaFaker to generate data
16. Retry Failed Test in TestNG with IRetryAnalyzer and IAnnotationTransformer
17. Javadoc for this source

### ✳️ **SYSTEM REQUIREMENTS**

- Install Java JDK (recommend JDK >= 17)
- Install Chrome Browser, Edge Browser, Firefox Browser
- Run well on the **Windows** platform
- Setup **Allure ENV**:
  https://mvnrepository.com/artifact/io.qameta.allure/allure-java-commons
- Use **IntelliJ IDEA** is the best choice (easy change the JDK version)

### ✳️ **HOW TO USE**

**1. Run parallel the test case**

- Run test cases in suite XML (**src/test/resources/suites/**)
- Run test cases from Maven with setup in the pom.xml file 
  (**mvn clean test**)

**2. Read Config from Properties file**
- Config file: **_src/test/resources/config/config.properties_**

**3. Extent Report**

- Insert "FrameworkAnnotation" as sample or None:
- The base value read from Enums (src/main/java/vishal/com/enums)
- Setup on TestListener and BaseTest
- Pdf Report

**4. Allure Report**

- Open Terminal: `allure serve target/allure-results`
- or command: `allure generate --single-file target/allure-results --clean`

**5. Send Mail after the run test**

- Config **true/false** in config.properties
  (**_src/test/resources/config/config.properties_**)
- send_email_to_users=**true** is enable send mail
- Config mail with email and password in **_src/main/java/anhtester/com/mail/EmailConfig.java_**
- Note: if Gmail, you use App Password

**6. Write Logs to file**

- Call class: LogUtils.info(), LogUtils.pass(), LogUtils.error(),... (**LogUtils** is a custom global class from Log4j2)
  (**_import utils.com.vishal.LogUtils.java_**)

**7. Record video and Screenshot**

- Setup in **_config.properties_** file
  (**_src/test/resources/config/config.properties_**)
- screenshot_passed_steps=yes or no
- screenshot_failed_steps=yes or no
- screenshot_skipped_steps=yes or no
- screenshot_all_steps=yes or no

**8. Read data test from Excel file**

- Create function with annotation **DataProvider** on **src/test/java/anhtester/com/projects/website/crm/dataprovider/DataProviderManager.java**
- Read Excel file with Map and Hashtable

**9. Base function in the package**

- **_src/main/java/vishal/com/utils_**
- **_src/main/java/vishal/com/helpers_**

**10. Read data test from JSON file**

- **JsonUtils** class selects the JSON file path and calls **"get"** method with **key**

**11. Main Keyword: WebUI**

- WebUI class is the main keyword in Framework. It contains common functions
- How to use: WebUI.function_name
- Example: WebUI.setWindowSize(1024, 768), WebUI.screenshotElement(By by, String elementName),...

**12. Call function to using sample**

- All in one package: src/test/java/vishal/com/projects/website/crm/testcases

```
+ ClientTest
+ SignInTest
+ TestHandle
+ TestSimpleCode
```

**13. Use Selenium Grid**

### Download and Install

1. Download Selenium Grid 4: https://www.selenium.dev/downloads/

**selenium-server-4.22.0.jar** (updated 24/06/2024)

2. Set PATH for driver in Environment variables:

Follow with link:
https://www.selenium.dev/documentation/webdriver/getting_started/install_drivers/#2-the-path-environment-variable

### Run default 1 node

✅ Open one Hub with one default Node (port 4444)

> java -jar selenium-server-4.22.0.jar standalone

### Run multi Node

✅ Open one Hub with 3 Nodes (run 4 commands to open 4 CMD windows)

> java -jar selenium-server-4.22.0.jar hub

> java -jar selenium-server-4.22.0.jar node --port 5556

> java -jar selenium-server-4.22.0.jar node --port 6667

> java -jar selenium-server-4.22.0.jar node --port 7778


**📝 NOTE: Execute multiple commands by opening multiple CMD windows.**

### Edit Grid in Config.properties

> TARGET=remote

> REMOTE_URL=192.168.1.13 (url Grid của bạn)

> REMOTE_PORT=4444 (port của Grid)

**13. Use DataFaker and JavaFaker to generate data**

Document DataFaker: https://www.datafaker.net/documentation/getting-started/

### 🔆 Project structure

```
📦AutomationFrameworkSelenium
 ┣ 📂.github
 ┃ ┗ 📂workflows
 ┃ ┃ ┗ 📜maven.yml
 ┣ 📂src
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂vishal
 ┃ ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┃ ┣ 📂annotations
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FrameworkAnnotation.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ConfigFactory.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Configuration.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂constants
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FrameworkConstants.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂driver
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BrowserFactory.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DriverManager.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TargetFactory.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂enums
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthorType.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Browser.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CategoryType.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FailureHandling.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Platform.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Project.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Target.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂exceptions
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FrameworkException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜HeadlessNotSupportedException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InvalidPathForExcelException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InvalidPathForExtentReportFileException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InvalidPathForFilesException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InvalidRemoteWebDriverURLException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TargetNotValidException.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂helpers
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CaptureHelpers.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DatabaseHelpers.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ExcelHelpers.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FileHelpers.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Helpers.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PropertiesHelpers.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ScreenRecoderHelpers.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂keywords
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebUI.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂mail
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailAttachmentsSender.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EmailConfig.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂report
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AllureManager.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ExtentReportManager.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ExtentTestManager.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TelegramManager.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂utils
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BrowserInfoUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DataFakerUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DataGenerateUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DateUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DecodeUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailSendUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜IconUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JsonUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LanguageUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LocalStorageUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LogUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ObjectUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReportUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ZipUtils.java
 ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┣ 📂META-INF
 ┃ ┃ ┃ ┃ ┗ 📂services
 ┃ ┃ ┃ ┃ ┃ ┗ 📜io.qameta.allure.listener.TestLifecycleListener
 ┃ ┃ ┃ ┗ 📜log4j2.properties
 ┃ ┗ 📂test
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂vishal
 ┃ ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┃ ┣ 📂common
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BaseTest.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dataprovider
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DataProviderAddProduct.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DataProviderManager.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂listeners
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AllureListener.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TestListener.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂projects
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂cms
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂admin
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂pages
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂brands
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BrandPage.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂category
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CategoryPage.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂logins
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LoginPageCMS.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂products
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AddProductPage.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂testcases
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AddProductTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CategoryTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ProductInfoTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProfileTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂users
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂pages
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dashboard
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DashboardPage.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂logins
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂order
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜OrderPage.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂products
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductInfoPageCMS.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂profiles
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProfilePage.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CommonPageCMS.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂crm
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂models
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ClientModel.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SignInModel.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂pages
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Clients
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ClientPageCRM.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Dashboard
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DashboardPageCRM.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Projects
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProjectPageCRM.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂SignIn
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SignInPageCRM.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Tasks
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TaskPage.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CommonPageCRM.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂testcases
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ClientTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SignInTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TestHandle.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TestSimpleCode.java
 ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┣ 📜allure.properties
 ┃ ┃ ┃ ┃ ┣ 📜config.json
 ┃ ┃ ┃ ┃ ┣ 📜config.properties
 ┃ ┃ ┃ ┃ ┗ 📜data.properties
 ┃ ┃ ┃ ┣ 📂objects
 ┃ ┃ ┃ ┃ ┗ 📜crm_locators.properties
 ┃ ┃ ┃ ┣ 📂suites
 ┃ ┃ ┃ ┃ ┣ 📜Clients-parallel.xml
 ┃ ┃ ┃ ┃ ┣ 📜Clients-simple.xml
 ┃ ┃ ┃ ┃ ┣ 📜Clients-testAddClient.xml
 ┃ ┃ ┃ ┃ ┣ 📜Clients-testSearch.xml
 ┃ ┃ ┃ ┃ ┣ 📜SignIn-parallel-methods.xml
 ┃ ┃ ┃ ┃ ┣ 📜SignIn-simple.xml
 ┃ ┃ ┃ ┃ ┗ 📜SuiteAll.xml
 ┃ ┃ ┃ ┣ 📂testdataCMS
 ┃ ┃ ┃ ┃ ┣ 📜Book1.xlsx
 ┃ ┃ ┃ ┃ ┣ 📜ChocoPie.jpg
 ┃ ┃ ┃ ┃ ┣ 📜CMS_DATA.xlsx
 ┃ ┃ ┃ ┃ ┣ 📜CocaCola.png
 ┃ ┃ ┃ ┃ ┣ 📜Cosy.png
 ┃ ┃ ┃ ┃ ┣ 📜GetProductInfo.xlsx
 ┃ ┃ ┃ ┃ ┣ 📜Login.xlsx
 ┃ ┃ ┃ ┃ ┣ 📜Nabati.jpg
 ┃ ┃ ┃ ┃ ┗ 📜quatet.jpg
 ┃ ┃ ┃ ┣ 📂testdataCRM
 ┃ ┃ ┃ ┃ ┣ 📜ClientsDataExcel.xlsx
 ┃ ┃ ┃ ┃ ┣ 📜DOCX_File_01.docx
 ┃ ┃ ┃ ┃ ┣ 📜LoginCSV.csv
 ┃ ┃ ┃ ┃ ┗ 📜TxtFileData.txt
 ┃ ┃ ┃ ┗ 📜pdf-config.json
 ┣ 📂target
 ┃ ┣ 📂classes
 ┃ ┃ ┣ 📂vishal
 ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┣ 📂annotations
 ┃ ┃ ┃ ┃ ┃ ┗ 📜FrameworkAnnotation.class
 ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ConfigFactory.class
 ┃ ┃ ┃ ┃ ┃ ┗ 📜Configuration.class
 ┃ ┃ ┃ ┃ ┣ 📂constants
 ┃ ┃ ┃ ┃ ┃ ┗ 📜FrameworkConstants.class
 ┃ ┃ ┃ ┃ ┣ 📂driver
 ┃ ┃ ┃ ┃ ┃ ┣ 📜BrowserFactory$1.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜BrowserFactory$2.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜BrowserFactory$3.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜BrowserFactory$4.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜BrowserFactory.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜DriverManager.class
 ┃ ┃ ┃ ┃ ┃ ┗ 📜TargetFactory.class
 ┃ ┃ ┃ ┃ ┣ 📂enums
 ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthorType.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Browser.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CategoryType.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜FailureHandling.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Platform.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Project.class
 ┃ ┃ ┃ ┃ ┃ ┗ 📜Target.class
 ┃ ┃ ┃ ┃ ┣ 📂exceptions
 ┃ ┃ ┃ ┃ ┃ ┣ 📜FrameworkException.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜HeadlessNotSupportedException.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜InvalidPathForExcelException.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜InvalidPathForExtentReportFileException.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜InvalidPathForFilesException.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜InvalidRemoteWebDriverURLException.class
 ┃ ┃ ┃ ┃ ┃ ┗ 📜TargetNotValidException.class
 ┃ ┃ ┃ ┃ ┣ 📂helpers
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CaptureHelpers.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜DatabaseHelpers.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ExcelHelpers.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜FileHelpers.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Helpers.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PropertiesHelpers.class
 ┃ ┃ ┃ ┃ ┃ ┗ 📜ScreenRecoderHelpers.class
 ┃ ┃ ┃ ┃ ┣ 📂keywords
 ┃ ┃ ┃ ┃ ┃ ┗ 📜WebUI.class
 ┃ ┃ ┃ ┃ ┣ 📂mail
 ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailAttachmentsSender$1.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailAttachmentsSender.class
 ┃ ┃ ┃ ┃ ┃ ┗ 📜EmailConfig.class
 ┃ ┃ ┃ ┃ ┣ 📂report
 ┃ ┃ ┃ ┃ ┃ ┣ 📜AllureManager.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ExtentReportManager.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ExtentTestManager.class
 ┃ ┃ ┃ ┃ ┃ ┗ 📜TelegramManager.class
 ┃ ┃ ┃ ┃ ┗ 📂utils
 ┃ ┃ ┃ ┃ ┃ ┣ 📜BrowserInfoUtils.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜DataFakerUtils.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜DataGenerateUtils.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜DateUtils.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜DecodeUtils.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailSendUtils.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜IconUtils.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜JsonUtils$1.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜JsonUtils.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜LanguageUtils.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜LocalStorageUtils.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜LogUtils.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ObjectUtils.class
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ReportUtils.class
 ┃ ┃ ┃ ┃ ┃ ┗ 📜ZipUtils.class
 ┃ ┃ ┣ 📂META-INF
 ┃ ┃ ┃ ┗ 📂services
 ┃ ┃ ┃ ┃ ┗ 📜io.qameta.allure.listener.TestLifecycleListener
 ┃ ┃ ┗ 📜log4j2.properties
 ┃ ┣ 📂generated-sources
 ┃ ┃ ┗ 📂annotations
 ┃ ┣ 📂generated-test-sources
 ┃ ┃ ┗ 📂test-annotations
 ┃ ┗ 📂test-classes
 ┃ ┃ ┣ 📂vishal
 ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┣ 📂common
 ┃ ┃ ┃ ┃ ┃ ┗ 📜BaseTest.class
 ┃ ┃ ┃ ┃ ┣ 📂dataprovider
 ┃ ┃ ┃ ┃ ┃ ┣ 📜DataProviderAddProduct.class
 ┃ ┃ ┃ ┃ ┃ ┗ 📜DataProviderManager.class
 ┃ ┃ ┃ ┃ ┣ 📂listeners
 ┃ ┃ ┃ ┃ ┃ ┣ 📜AllureListener.class
 ┃ ┃ ┃ ┃ ┃ ┗ 📜TestListener.class
 ┃ ┃ ┃ ┃ ┗ 📂projects
 ┃ ┃ ┃ ┃ ┃ ┣ 📂cms
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂admin
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂pages
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂brands
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BrandPage.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂category
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CategoryPage.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂logins
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LoginPageCMS.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂products
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AddProductPage.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂testcases
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AddProductTest.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CategoryTest.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginTest.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderTest.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ProductInfoTest.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProfileTest.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂users
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂pages
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dashboard
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DashboardPage.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂logins
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂order
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜OrderPage.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂products
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductInfoPageCMS.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂profiles
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProfilePage.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CommonPageCMS.class
 ┃ ┃ ┃ ┃ ┃ ┗ 📂crm
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂models
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ClientModel.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SignInModel.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂pages
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Clients
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ClientPageCRM.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Dashboard
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DashboardPageCRM.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Projects
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProjectPageCRM.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂SignIn
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SignInPageCRM.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Tasks
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TaskPage.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CommonPageCRM.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂testcases
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ClientTest.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SignInTest.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TestHandle.class
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TestSimpleCode.class
 ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┣ 📜allure.properties
 ┃ ┃ ┃ ┣ 📜config.json
 ┃ ┃ ┃ ┣ 📜config.properties
 ┃ ┃ ┃ ┗ 📜data.properties
 ┃ ┃ ┣ 📂objects
 ┃ ┃ ┃ ┗ 📜crm_locators.properties
 ┃ ┃ ┣ 📂suites
 ┃ ┃ ┃ ┣ 📜Clients-parallel.xml
 ┃ ┃ ┃ ┣ 📜Clients-simple.xml
 ┃ ┃ ┃ ┣ 📜Clients-testAddClient.xml
 ┃ ┃ ┃ ┣ 📜Clients-testSearch.xml
 ┃ ┃ ┃ ┣ 📜SignIn-parallel-methods.xml
 ┃ ┃ ┃ ┣ 📜SignIn-simple.xml
 ┃ ┃ ┃ ┗ 📜SuiteAll.xml
 ┃ ┃ ┣ 📂testdataCMS
 ┃ ┃ ┃ ┣ 📜Book1.xlsx
 ┃ ┃ ┃ ┣ 📜ChocoPie.jpg
 ┃ ┃ ┃ ┣ 📜CMS_DATA.xlsx
 ┃ ┃ ┃ ┣ 📜CocaCola.png
 ┃ ┃ ┃ ┣ 📜Cosy.png
 ┃ ┃ ┃ ┣ 📜GetProductInfo.xlsx
 ┃ ┃ ┃ ┣ 📜Login.xlsx
 ┃ ┃ ┃ ┣ 📜Nabati.jpg
 ┃ ┃ ┃ ┗ 📜quatet.jpg
 ┃ ┃ ┣ 📂testdataCRM
 ┃ ┃ ┃ ┣ 📜ClientsDataExcel.xlsx
 ┃ ┃ ┃ ┣ 📜DOCX_File_01.docx
 ┃ ┃ ┃ ┣ 📜LoginCSV.csv
 ┃ ┃ ┃ ┗ 📜TxtFileData.txt
 ┃ ┃ ┗ 📜pdf-config.json
 ┣ 📜.gitignore
 ┣ 📜pom.xml
 ┗ 📜README.md
```

### Copyright 2026 Vishal
