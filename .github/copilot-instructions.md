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