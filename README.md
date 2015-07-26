# @Deprecated

Use google tools - refer to Google's [android-testing][7]

I wouldn't recommend using Robolectric. For unit test I'd use available JUnit support and for platform tests I'd go for Espresso.

android-tdd-bootstrap
=====================
##Goal:

 - TDD bootstrap Android project to be provided
 - Material design (using appcompat-v7) for preL devices to be enabled

I like TDD so I wanted to prepare bootstrap template for TDD.
But hey - Android Lolipop is out with new material design.
Thanks to appcompat library some features can be enabled to preL devices.
I decided to give it a try and started digging.

##Guides:

 - [Chris Banes guide][1] - how to backport material
 - [deckard-gradle][2] - Robolectric team TDD template with robolectric and espresso

##Libraries:

 - appcompat-v7 support lib (for material design)
 - robolectric - fast, runs on JVM, only hope for TDD
 - espresso - nice syntax, runs ui test on devices, slow
 - dagger - dependency injection framework

##How did it go?

Chris Banes posted some notes how to start using new support-v7 ([here][1]).
I started from here and played with theming and new Toolbar widget (ActionBar killer wannabe).
So I did very simple stub and proceed to building testing setup.

Testing was always painful in Android world. Let's just keep optimistic approach and get this done.

I decided to base my setup on [deckard-gradle][2].
It integrates Robolectric for TDD and Expresso for ui real device testing.

Want to see yourself?

 - git clone {github.repo}
 - ./gradlew clean test // for robolectric tests
 - ./gradlew clean connectedAndroidTest // for espresso tests

###Robolectric setup

Robolectric comes with nice gradle plugin.
I defined a simple failing test. It failed. Hurray.
Then added new and expected test succeeding.
My optimism ended.
Robolectric doesn't play nice with Appcompat theming.
Also it doesn't support just yet Toolbar widget nor Cardview.
That's the way Robolectric works.
It has to provide own implementation to Android classes.
So when new Android features are released there's always a lag.
Problems with appcompat theming are already reported to [robolectric team][3] and on [stackoverflow][4].

O well. No Robolectric for appcompat.
Still I can write some unit tests only for logic but I don't need Robolectric for that.
Example how to do jUnit setup [here][5].

I tried also to integate tests into Android Studio. No success.
Involves manual IDEA files editing, still not working, I gave up.

Ok. Maybe I won't be able to do TDD sor some while until it will be fixed.
(still we can leave our projects and rush to robolectric development, that's open source after all).

Robolectric summary:

 - doesn't play well with appcompat, at all [issue][3] and [stackoverflow][4]
 - supports only Android APIs 16, 17 and 18
 - it lags behind KitKat and now Lolipop
 - integrating with Android Studio is too painful
 - fast when working

###Let's try Espresso

Not without problems but it worked.
Unfortunately had some issues when provided updated versions of dependency libraries.
E.g. needed fallback from Dagger 1.2.1 to 1.1.0.
Also it has some problems when running on KitKat and Lolipop devices described [here][6].
I observed also some test to fail not deterministically on this devices but
had no time nor energy to chase that.

Espresso summary:

 - nice DSL
 - fast UI testing
 - backed by Google

##Conclusion
I was not very successful (in terms of using appcompat-v7:21).
My TDD attempt with Android failed. Hopefully it will get to work eventually.
Espresso test was working but still I had to many issues on the way to recommend that.

 - robolectric not working for Appcompat, useless for TDD until it'll be fixed
 - reported [issues][3]
 - problem posted on [stackoverflow][4]
 - style related posts on [stackoverflow][6]
 - new test tools from google -> [android-testing][7]

 [1]: https://chris.banes.me/2014/10/17/appcompat-v21
 [2]: https://github.com/robolectric/deckard-gradle
 [3]: https://github.com/robolectric/robolectric/issues/1332
 [4]: http://stackoverflow.com/questions/26512839/android-lolipop-appcompat-problems-running-with-robolectric
 [5]: http://tryge.com/2013/02/28/android-gradle-build/
 [6]: http://stackoverflow.com/questions/24231913/cant-find-parent-for-styledata-when-using-robolectric-in-android-studio-with-ap
 [7]: https://github.com/googlesamples/android-testing

 ##Next?

 I'm thinking of using just plain jUnit and TDD only logic. I'm thinking about giving a try to Robotium.
