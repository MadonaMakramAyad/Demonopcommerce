@Regression
Feature: F07_followUs | users could open followUs links
Scenario:  user opens facebook link
 Given  user opens facebook link
 When   User clicks on exist button
 Then   facebook page is opened in new tab

Scenario:  user opens Twitter link
  Given user opens Twitter link
  When  Twitter page is opened in new tab
  Then  User check for follow Page

 Scenario:  user opens rss  link
  Given user opens rss  link
  When  rss page is opened in new tab
  Then  User check for follow Page in rss Page

 Scenario:  user opens youtube link
  Given user opens youtube link
  When  youtube page is opened in new tab
  Then  User check for follow Page in youtube