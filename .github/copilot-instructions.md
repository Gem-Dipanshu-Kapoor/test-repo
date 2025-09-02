# GitHub Copilot Instructions

## Task: debug and suggest
Please examine the failed-tests.log file and provide me with the following:
- A tabular summary of failing tests including test name, expected vs actual values, and error details with each testcase in a row
- Open the specific feature file and identify the exact line causing the failure
- Analyze whether the expected value or the implementation is incorrect
- Suggest and implement a fix for the failing test

## Task: code review
Analyze the changes in the current files and unversioned files. Include:
- Run 'git status --short' command only to get list of files changed modified unversioned or staged in a table. Replace M with modified and ?? with unversioned
- Filter out unversioned or updated files from the list
- Extract detailed changes using 'git --no-pager diff HEAD' or 
git ls-files --others --exclude-standard | ForEach-Object {
  Write-Output "===== $_ ====="
  Get-Content $_
  Write-Output ""
  }
if there are unversioned files
- Execute ONLY the commands explicitly listed above - do not add any additional commands like 'cd', 'pwd', or path navigation
- Analyze the changes using CodingStandards.md and create a detailed html report in target directory where heading should be file name, add all content in a code block like git diff, added in green, removed in red and on that content add comments where coding standards are violated with reference to CodingStandards.md and suggest improvements
- If there are no changes or unversioned files, simply state "No changes detected"
- Do not add execution status in the report
- Do not read config files only read src/test project files

## Task: Generate JavaDocs
- Traverse the `src/` directory.
- For every `.java` file, ensure all classes, methods, and public fields are documented using standard JavaDoc conventions.
- If a class or method lacks JavaDocs, infer the purpose based on method names, parameters, return types, and context from nearby code.
- Use the format:
```java
/**
* Brief summary.
*
* @param paramName description
* @return description
  */
```

## Task: Summarize the Project
- Analyze the entire codebase to understand its purpose and functionality.
- Create a concise summary (3-5 sentences) of what the project does, its main features, and its intended use case.
- Place this summary in a `SUMMARY.md` file at the root of the project.
- Create a simple architecture diagram (using ASCII art or a simple text-based format) that outlines the main components and their interactions. Save this as `ARCHITECTURE.md`.

## Task: Identify duplicate code and refactor steps or scenarios into reusable methods or classes
- Look for repeated code blocks, especially in test steps or scenario definitions.
- Extract these into reusable methods or utility classes to promote DRY (Don't Repeat Yourself) principles
- Ensure that the refactored code maintains the same functionality and is well-documented.
- Remove the duplicate code after refactoring to keep the codebase clean and maintainable.