*** Settings ***
Documentation       Robot to enter claim information in HOST to create claim and get claim number

Library             RPA.Browser.Playwright
Library             RPA.HTTP
Library             Camunda

*** Variables ***
&{claim}    date=2024/10/01     policyId=123456789    policyType=EXTENDED

*** Tasks ***   
Generate Claim on HOST system
    Open the form
    Fill the form
    Collect the result

*** Keywords ***
Open the form
    New Browser   headless=false
    New Page      http://localhost:8080/host.html    

Fill the form    
    Fill Text    //input[@id="dateOfAccident"]    ${claim}[date]
    Fill Text    //input[@id="policyNumber"]    ${claim}[policyId]
    Fill Text    //input[@id="policyType"]    ${claim}[policyType]    
    Sleep    2s
    Click        xpath=//*[@id='secretLink']

Collect the result
    ${claimNumber}=   Get Property    //input[@id="claimNumber"]      value
    Set Output Variable	claimNumber	${claimNumber}
    Sleep    2s
    Take Screenshot  %{ROBOT_ARTIFACTS}${/}result
    Close Browser