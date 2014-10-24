android-tdd-bootstrap
=====================
##Aim:

 - Material design introduced in Lolipop material design (using appcompat-v7) for preL devices to be enabled
 - TDD ready easy to deploy bootstrap Android project to be provided

##To be used:

 - Appcompat support lib (for material design)
 - Dagger - dependency injection framework
 - Robolectric - fast, runs on JVM
 - Espresso - nice syntax, runs ui test on devices
 - stub template for Android MVP pattern

##Following:

 - [Chris Banes guide][1]
 - [deckard-gradle - Robolectric team TDD template][2]

##How did that go?
Android L out with new material design and guides how to enable that to preL devices.
I decided to give it a try.
I wanted also to prepare bootstrap template for TDD.
I started digging.

Chris banes posted some notes how to start using new support-v7 ([here][1]).
I started from here and played with theming and new Toolbar widget (new more flexible ActionBar alternative).
So I did very simple stub and proceed to building testing setup.

Testing was always painful in Android world. Let's just keep optimistic approach and get this done.

I decided to base my setup on [deckard-gradle][2].
It integrates Robolectric for TDD and Expresso for ui real device testing.

###Robolectric setup

Robolectric comes with nice gradle plugin.
I defined a simple failing test. It failed. Hurray.
Then it was a time for actually test the test succeeding.
And here optimism ends.
Robolectric doesn't play nice with Appcompat theming.
Not in Lolipop nor KitKat.
Also it doesn't not support just yet Toolbar widget nor Cardview.
That's the way Robolectric works.
It has to provide own implementation to Android classes.
So when new Android features come there's always a lag.
Problems with appcompat theming are already reported to [robolectric team][3] and on [stackoverflow][4].

O well. No Robolectric.
Still we can write some unit test and run them but we don't need Robolectric for that.
Example how to do this [here][5]. Robolectric summary:

 - doesn't play well with appcompat, at all [issue][3]
 - suports only Android APIs 16,17 and 18
 - always has a lag when new Android features are out
 - integrating with Android Studio is hard (I didn't manage to do that)

Ok. Maybe won't be able to do TDD sor some while
(still we can leave our projects and rush robolectric development, that's open source after all).

###Let's try Espresso

Not without problems but it worked.
Unfortunately had some issues when provided updated versions of dependency libraries.
For example needed fallback from Dagger 1.2.1 to 1.1.0.
Also is has some problems when running on KitKat and Lolipop devices described [here][6].




##Conclusion
I was not very successful (in terms of using appcompat-v7:21).

 - [reported issues with robolectric][3]
 - [problem posted on stackoverflow][4]
 - blog post

 [1]: https://chris.banes.me/2014/10/17/appcompat-v21
 [2]: https://github.com/robolectric/deckard-gradle
 [3]: https://github.com/robolectric/robolectric/issues/1332
 [4]: http://stackoverflow.com/questions/26512839/android-lolipop-appcompat-problems-running-with-robolectric
 [5]: http://tryge.com/2013/02/28/android-gradle-build/
 [6]: https://code.google.com/p/android-test-kit/issues/detail?id=84