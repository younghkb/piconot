# Design

## Who is the target for this design, e.g., are you assuming any knowledge on the part of the language users?

We assume that users will have familiarity with the picobot world and basic concepts (ie, how the game is supposed to work). However,
we do not expect users to have advanced computer science knowledge. CS5 level students should still be able to work with the language that we design.

## Why did you choose this design, i.e., why did you think it would be a good idea for users to express the maze-searching computation using this syntax?

Our design is similar to the original picobot language in that we still have an original condition producing a new condition. However, our organization is different. We group all the rules per phase together, which makes it easier for reading and organizing. Also, our use of ASCII characters makes it more visually understandable, which is easier to piece together than NEWS (a fairly abstract acroyny that needs some internal human translation to make sense of it). 

## What behaviors are easier to express in your design than in Picobot’s original design?  If there are no such behaviors, why not?

It's easier to cohesively group the behaviours for a state. As such, the user can easily see at a glance what partial rules they have already defined for a state and how the partial rules work together. With the old design, states did not have to be grouped, which made reading the code itself more difficult. It also means a little less typing as you don't have to specify the original state each time.

## What behaviors are more difficult to express in your design than in Picobot’s original design? If there are no such behaviors, why not?

The potentially most complex part is specifying which directions are currently blocked and unblocked. In the original design, the user input a string in NEWS order, where a capital letter meant block, a star meant must be open, and an x meant anything could pass. This specified ordering made the input very regular each time. However, in our new design, the user has to specify blocked and unblocked seperately. This could cause some confusion.

## On a scale of 1–10 (where 10 is “very different”), how different is your syntax from PicoBot’s original design?

4

## Is there anything you would improve about your design?

This language is really better suited to something more gui-based because of the cardinal directions. Viewing and writing these would be easier to undersand through some sort of graphic, like a compass with directions highlighted. Otherwise, we like the format of grouping the rules by associated state. We also thought that the format of "current conditions go to new conditions" was very clear, so we did not see a reason to change that.
