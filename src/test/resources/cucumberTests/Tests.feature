Feature: TEST AUTOMATION

Scenario: Successful Login
 Given User is on Home Page
 When User enters name and password
 Then User is redirected to inventory page

Scenario: Add Product to Cart
 Given User is on Product Page
 When User click on add to cart on a certain product
 And User goes to shopping cart
 Then Selected product is on the cart