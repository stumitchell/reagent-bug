Setup
=====

1. Checkout this repository from git
2. run `lein figwheel`
3. go to http://localhost:3449/

Expected behaviour
------------------
The check box should change status when clicked

Current behaviour
-----------------

Works in `reagent 0.6.0-rc` fails in `reagent 0.6.0`


In `reagent 0.6.0-rc` and previous versions the `:input` component would accept
a `nil` value and and rely on its truthiness.

In `reagent 0.6.0` we need to wrap the value in `some?`


