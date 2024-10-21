*** Settings ***
Documentation       Robot to update claim in HOST system

Library             RPA.Browser.Playwright
Library             RPA.HTTP
Library             Camunda

*** Variables ***
&{claim}       number=123456789    resolution=PAID

*** Tasks ***   
Generate Claim on HOST system
    Open the form
    Fill the form
    Collect the result

*** Keywords ***
Open the form
    New Browser   headless=false
    New Page      https://claim-handling-fakes-617934349805.australia-southeast1.run.app/host2.html    

Fill the form    
    Fill Text    //input[@id="claimNumber"]    ${claim.number}
    Fill Text    //input[@id="claimResolution"]    ${claim.resolution}
    Sleep    2s
    Click        xpath=//*[@id='secretLink']

Collect the result
    Sleep    2s
    Take Screenshot  %{ROBOT_ARTIFACTS}${/}result
    Close Browser