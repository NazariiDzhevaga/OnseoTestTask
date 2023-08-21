# Test automation project for [LiveScore](https://www.livescore.com/en/)

<p align="center">
  <img src="media/logotypes/live_score_icon.png" alt="Toolsqa" width="200" height="200">
</p>

# <a name="TableOfContents">Table of contents</a>

+ [Test Documentation](#Documentation)
+ [Tools and technologies](#Technology)


# <a name="Description">Test Documentation</a>

## _Time Zone Change Feature_

## Objective

To verify that the time zone change feature on the livescore.com website works correctly. The test will ensure that when
a user changes their time zone setting, the start time of a specific event updates accordingly.

## Test Environment

- [x] Programming Language: `Java`
- [x] Automation Libraries: `Selenide`
- [x] Reporting Tool: `Allure` (for test results and reports)
- [x] Version Control: `Git`
- [x] Repository: `GitHub` (https://github.com/NazariiDzhevaga/OnseoTestTask.git)

## Test Cases

### Test Case 1: Verify Event Time Zone Change Feature

### Description

Verify that changing the time zone in the site settings updates the start time of a specific event according to the new
time zone.

## Test Steps

### Step 1: Open the Site

* Open the [livescore.com](https://www.livescore.com/en/) website.
### Step 2: Click on a Not Started Event
* Identify and click on any event marked as "not started."
### Step 3: Capture Event Start Date and Time
* Save the start date and time of the opened event.
### Step 4: Open the Site Menu
* Click on the site menu button.
### Step 5: Access Settings
* Click on the "Settings" option in the menu.
### Step 6: Change Time Zone Setting
* Choose a new time zone option that is not "Automatic".
* Click on the "Apply" button.
### Step 7: Check Previous Page is Opened
* After changing the time zone setting and clicking the "Apply" button, ensure other elements, such as active sport section, league and event info, remain consistent and unaffected by the time zone change.
### Step 8: Verify Event Start Time Update
* Validate that the page updates successfully after applying the new settings.
* Check that the event start date and time have changed according to the new time zone.
* Calculate the expected updated start time based on the time zone difference (e.g., if UTC +02:00 changes to UTC +05:00, the event start time should increase by 3 hours).
* Compare the calculated expected start time with the actual updated start time.

### Expected Results

1. [x] The website should successfully load, and the event details page should display.
2. [x] The event start date and time should be captured successfully.
3. [x] The site menu should open, and the settings page should be accessible.
4. [x] The new time zone setting should be applied without errors.
5. [x] The previous page must be opened after applying new timezone.
6. [x] The event details page should update after applying the new time zone setting.
7. [x] The event start date and time should change according to the new time zone, as expected.

### Environment Details
Browser: Chrome (Version 114.0.5735.91)

Operating System: Windows 10



# <a name="Technology">Tools and a technologies</a>
<p align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="./media/logotypes/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="./media/logotypes/java-logo.svg"></code>
  <code><img width="5%" title="Selenide" src="./media/logotypes/selenide-logo.svg"></code>
  <code><img width="10%" title="Maven" src="./media/logotypes/maven-logo.png"></code>
  <code><img width="10%" title="TestNG" src="./media/logotypes/test.webp"></code>
  <code><img width="5%" title="Allure Report" src="./media/logotypes/allure-Report-logo.svg"></code>
  <code><img width="5%" title="Github" src="./media/logotypes/git-logo.svg"></code>

</p>