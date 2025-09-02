# Coding Standards Evaluation Criteria

## Overview

This document defines the coding standards criteria used to evalulate diffs in current changes. The evaludation focuses
on Java-based test automation using selenium, cucumber frameworks.

---

## 1. Java Coding Standards

### 1.1 Naming Conventions

- Classes: PascalCase (e.g., `MyTestClass`)
- Methods: camelCase (e.g., `myTestMethod()`)
- Variables: camelCase (e.g., `myVariable`)
- Constants: UPPER_SNAKE_CASE (e.g., `MAX_RETRY_COUNT`
- Packages: lowercase (e.g., `com.mycompany.project`)
- Files: Match class name (e.g., `MyTestClass.java`)

### 1.2 Collection Operations

- ** ❌ Avoid**: Traditional for-loops for iterating collections.
- ** ✅ Use**: Enhanced for-loops or Java Streams for better readability and performance.
- Example:
```
// ❌ Avoid
for (int i = 0; i < list.size(); i++) {
System.out.println(list.get(i));
}
// ✅ Use
for (String item : list) {
System.out.println(item);
}
// or using Streams
list.forEach(item -> System.out.println(item));
``` 

### 1.3 Control Flow Statements
- **✅Required**: All if/else statements must use curly braces `{}` even for single-line blocks.
- Example:
```
// ❌ Avoid
if (condition) doSomething();
else doSomethingElse();
// ✅ Use
if (condition) {
    doSomething();
} else {
    doSomethingElse();
}
```

### 1.4 String Comparision
- **✅Required**: Use `.equals()` or `.equalsIgnoreCase()` for string comparison instead of `==`.
- Example:
```
// ❌ Avoid
if (str1 == str2) { ... }
// ✅ Use
if (str1.equals(str2)) { ... }
```

### 1.5 Locator Variables
- **✅Format**: Use `By` class and camelcasing for defining locators.
- **✅Required**: Use descriptive names for locator variables that reflect their purpose.
```
// ❌ Avoid
By submit_button = By.id("submit");
// ✅ Use
By submitButton = By.id("submit");
By loginForm = By.id("login-form");
```
  
## 2 Page Object Model (POM) Standards
### 2.1 Design Pattern Requirements
- **✅Required**: Each web page should have a corresponding Page Object class.
- **✅Required**: Page Object classes should encapsulate web elements and actions related to that page.
- **✅Required**: Use meaningful method names that describe the action being performed.

### 2.2 Page Object Scope
- **✅Required**: Page Object classes should only contain methods and locators relevant to that specific page.
- **❌Avoid**: Including methods that interact with other pages.

### 2.3 Reusability and Data
- **✅Required**: Use parameterized methods to handle dynamic data inputs.
- **✅Required**: Avoid hardcoding values within Page Object methods.

## Evaulation Severity Levels
- **🔴 CRITICAL**: Security issues, hardcoded secrets, prohibited practices.
- **🟡 MAJOR**: Missing required patterns, incorrect naming conventions, improper control flow.
- **🟢 MINOR**: Code style issues, minor readability improvements, non-critical best practices.
- **ℹ️ SUGGESTION**: Optional improvements, enhancements for better maintainability.


## Usage Instructions
This document should be used by the CondingStandardsEvaulatior.ps1 script to:
1. Analyze code diff
2. Evaludate changes against each criterion
3. Generate detailed reports with severity levels
4. Provide specific recommendations for improvement

Each Violation should include:
- Rule violated: Reference to specific section
- Severity level: Critical, Major, Minor, Suggestion
- Location: File name and line number
- Recommendation: Suggested fix or improvement