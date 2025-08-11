# Unit Testing in Java

## 📌 Introduction

### What is Unit Testing?

* Testing individual units/components of software to validate correctness.

### What is JUnit?

* A Java library for writing unit tests.
* Version History:

    * JUnit 4.x (latest: 4.13)
    * JUnit 5.x (major revamp)

---

## 🔁 JUnit 4.x vs JUnit 5.x

### ⚙️ Architecture Differences

| Feature     | JUnit 4       | JUnit 5                                |
| ----------- | ------------- | -------------------------------------- |
| JDK Version | 5+            | 8+                                     |
| Jar File    | Single jar    | Split into: Platform, Jupiter, Vintage |
| Platform    | Not Available | Used for launching test engines        |
| Jupiter     | N/A           | New API & extension model              |
| Vintage     | N/A           | Backward compatibility with JUnit 3/4  |

### 🔤 Annotation Differences

| JUnit 4        | JUnit 5       |
| -------------- | ------------- |
| `@Before`      | `@BeforeEach` |
| `@After`       | `@AfterEach`  |
| `@BeforeClass` | `@BeforeAll`  |
| `@AfterClass`  | `@AfterAll`   |
| `@Ignore`      | `@Disabled`   |
| `@Category`    | `@Nested`     |

### ✨ New in JUnit 5

* Lambda support (Java 8)
* More annotation-driven
* Advanced features:

    * `@TestFactory`
    * `@Nested`
    * `@ExtendWith`
    * `@SelectPackages`, `@SelectClasses`

---

## 🛠️ Environment Setup & Writing First Unit Test

---

## ✅ Test Classes, Methods, Lifecycle
### 1  Test Class
1. Must not be abstract
2. Must have one constructor

### 2 Test Methods

* Annotated with:

  * `@Test`
  * `@RepeatedTest`
  * `@ParameterizedTest`
  * `@TestFactory`
  * `@TestTemplate`
  * 
### 🔁 Lifecycle Methods
> Initailsed before all the test feeding part and destruction 
* `@BeforeAll`, `@AfterAll`, `@BeforeEach`, `@AfterEach`
* Must be non-private and return void
* test method and life cycle methods must not be abstract and must not return a value
* test classes methods, lifecycle methods are not required to be public but they
* must not to be private



---

## 📦 Writing Tests for Your Application (Using Jupiter API)

---

## ⚠️ Exception Testing

* New way to test exceptions in JUnit 5 using Jupiter API.

---

## ⏱ Timeout Testing

* `@Timeout`
* `assertTimeout()`

---

## 🧾 Assertions & Nesting

* `assertAll()`
* `@Nested`

---

## 🔁 Repeated Tests

* `@RepeatedTest`

---

## 🔢 Parameterized Tests

* `@ParameterizedTest`

---

## 🧬 Test Execution Order & Instance Lifecycle

### Execution Order

* Default: Fixed (non-deterministic)
* Customizable:

    * Random
    * Alphanumeric
    * Using `@Order`

### Test Instance Lifecycle

* Default: Per Method
* Optional: Per Class

---

## 💾 Temporary Directories & Custom Annotations

* `@TempDir`
* Creating reusable custom test annotations

---

## 🏷️ Tagging & Filtering Tests
> 1. for different environment and different Group so during production we can specify which test cases will run and which ill exclude
* Tag tests to selectively run them

---

## 🧪 Mocking with Mockito

### Why Mocking?

* Unit tests should isolate the class under test by replacing dependencies.
* Mockito is a mocking framework for java. Mockito allows convenient creation of substitutes of real objects for testing pursposes
* mock dependency 

### Test Double
1. Test replacement of real/external dependencies
2. Dummy objects :passed around but never used
3. Fake objects : like memory db for acual db
4. A sub class : intialise --> exercises --> verify
5. Mock objec : initialse-->set expectation --> exercise --> verify

### Types of Test Doubles

| Type  | Purpose                        |
| ----- | ------------------------------ |
| Dummy | Passed but never used          |
| Fake  | Simulated (e.g., in-memory DB) |
| Stub  | Provides canned responses      |
| Mock  | Verifies behavior              |

### Mockito

* A popular mocking framework for Java

#### Limitations

* Cannot mock:

    * Static methods
    * Private methods
    * Constructors can't mock

**Docs:** [Mockito FAQ](https://github.com/mockito/mockito/wiki/FAQ#what-are-the-limitations-of-mockito)

---

## 📡 Testing Microservices (Covid-19 Alert Service)

### REST Endpoints

* `/india/summary`
* `/india/{state}`

### Components

* `AlertController`
* `AlertService`
* `CovidDataProvider` (calls external API)

**API Ref:** [Rootnet API](https://api.rootnet.in/covid19-in/stats/latest)

---

## 📈 Code Coverage with JaCoCo

### What is Code Coverage?

* Measures how much code is exercised during tests.

### Types

* Function Coverage
* Statement Coverage
* Path Coverage
* Branch/Decision Coverage
* Condition Coverage

### Integration

* Spring Boot + Gradle plugin
  [Jacoco Gradle Plugin](https://docs.gradle.org/current/userguide/jacoco_plugin.html)

---

## 🧹 Static Code Analysis with SonarQube

* Detects:

    * Bugs
    * Code smells
    * Security vulnerabilities

* Supports 20+ languages

* Metrics:

    * Code duplication
    * Code coverage
    * Complexity, etc.

---

## 🧬 Mutation Testing (PIT)

### What is Mutation Testing?

* Mutate code intentionally and run tests
* If tests pass = mutation survived = weak test
* If tests fail = mutation killed = strong test

### Goals

* Find untested code
* Detect ineffective tests
* Mutation Score

### PIT Features

* Fast, actively developed
* Works with Maven/Gradle/Ant
* HTML reports

**Useful Links:**

* [PIT](https://pitest.org/)
* [Gradle Integration Guide](https://github.com/devcon5io/mutation-analysis-plugin/wiki)

---

## 📚 Additional Learning Schedule

| Date    | Topic                                            |
| ------- | ------------------------------------------------ |
| July 19 | Mockito                                          |
| July 20 | Creating microservice from scratch (Spring Boot) |
| July 21 | Writing tests for microservices                  |
| July 22 | Code coverage integration                        |
| July 23 | Sonarqube setup                                  |
| July 24 | Mutation Testing                                 |
| July 26 | WireMock                                         |
| July 28 | Spring Cloud Contract                            |

---


