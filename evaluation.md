# Evaluation: running commentary

## Internal DSL

_Describe each change from your ideal syntax to the syntax you implemented, and
describe_ why _you made the change._

**On a scale of 1–10 (where 10 is "a lot"), how much did you have to change your syntax?**

2 (or so, given that we didn't actually finish).

* Using "::" instead of ":" - because ":" is protected in scala, we couldn't overload it for our own uses here.
 
**On a scale of 1–10 (where 10 is "very difficult"), how difficult was it to map your syntax to the provided API?**

10. We did not actually finish this part of the assignment because of the complexity of this version. The biggest problem we faced was that the partialrules needed to be recursively included, so that the program could tell when the partial rules concluded. Other issues were that there was jsut a lot of extra steps that we did not need in the external version to translate between the API and our new syntax. We believe that we're on the right track for finishing it, but we decided to cut losses.

## External DSL

_Describe each change from your ideal syntax to the syntax you implemented, and
describe_ why _you made the change._

**On a scale of 1–10 (where 10 is "a lot"), how much did you have to change your syntax?**

1 (no changes were necessary)

**On a scale of 1–10 (where 10 is "very difficult"), how difficult was it to map your syntax to the provided API?**

5. We had two sticking points in writing our DSL. The first was determining whether or not containing the partial rules in our state struct had to be done recursively or not. Eventually, we realized that we could use a scala star oprator to just include as many rules as we wanted without having the recursive problem we faced when writing the internal DSL. The other problem was just that general, we had to figure out how to actually implement some of the ideas in scala. Through look through other examples in class, we were able to figure out the syntax and make things work. We also were overcomplicating things at first and tried to introduce more structs before we realized doing so was unnecessary given the built-in libraries we had to work with.
