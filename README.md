<img src="http://cf.jare.io/?u=http%3A%2F%2Fwww.yegor256.com%2Fimages%2Fbooks%2Felegant-objects%2Fcactus.svg" height="100px" />

[![DevOps By Rultor.com](http://www.rultor.com/b/ashtonhogan/tacinga)](http://www.rultor.com/p/ashtonhogan/tacinga)

[![Maven Central](https://img.shields.io/maven-central/v/com.ashtonhogan/tacinga.svg)](https://maven-badges.herokuapp.com/maven-central/com.ashtonhogan/tacinga)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/ashtonhogan/tacinga/blob/master/LICENSE.txt)
[![License](https://img.shields.io/badge/license-commercial-brightgreen.svg)](http://www.binpress.com/license/view/l/36fb5928c44bd99f25d6da3c115a4fe3)

**ATTENTION**: We're still in a very early alpha version, the API
may and _will_ change frequently. Please, use it at your own risk.

Tacinga is an Object-Oriented Java unit testing library.

**Motivation.**
We are not happy with
[JUnit](https://junit.org/) and
[TestNG](http://testng.org) because
they are procedural and not object-oriented. They do their job,
but do not use the Elegant Objects approach.

**Principles.**
These are the [design principles](http://www.elegantobjects.org#principles) behind Tacinga.

**Dependencies.**
This software uses these dependencies: 

* [cactoos](https://github.com/yegor256/cactoos)

**How to use.** All you need is this (get the latest version [here](https://github.com/ashtonhogan/tacinga/releases)):

```xml
<dependency>
  <groupId>com.ashtonhogan</groupId>
  <artifactId>tacinga</artifactId>
</dependency>
```

Java version required: 1.9+.

StackOverflow tag is [cactoos](https://stackoverflow.com/questions/tagged/cactoos).

**Support.**
These are the [support principles](https://ashtonhogan.com/why-are-you-afraid-of-free-support.html) behind Tacinga.

**License.**
These are the [license principles](https://ashtonhogan.com/commercial-licenses-do-not-make-you-a-bad-person.html) behind Tacinga.

* The [MIT license](https://raw.githubusercontent.com/ashtonhogan/cactoos-webserver/master/README.md) applies while you're not using the software for any commercial activity
* Our [commercial license](http://www.binpress.com/license/view/l/36fb5928c44bd99f25d6da3c115a4fe3) applies when you use the software for any commercial activity

**How to buy a commercial license.**
It is really easy to buy a commercial license:

* All licenses types include all future 0.x.x versions
* If you have a small or medium size business with 1-49 people then [buy](https://www.coinpayments.net/index.php?cmd=_pay&reset=1&merchant=91248a0993242d7bb62ccec107a3e610&currency=USD&amountf=49&item_name=Payment%20for%20Tacinga%20Basic%20License) a basic license for $49
* If you have a large size business with 50 or more people then [buy](https://www.coinpayments.net/index.php?cmd=_pay&reset=1&merchant=91248a0993242d7bb62ccec107a3e610&currency=USD&amountf=1999&item_name=Payment%20for%20Tacinga%20Enterprise%20License) an enterprise license for $1999
* Note: Please keep your purchase receipt as evidence of your payment in future
* Note: Your license may be annulled if we cannot reach you using the contact details provided

## Usage

First implement one of `StringUnit`, `ObjectUnit` or `ArrayUnit` interfaces in the class being tested

Test for `null`:

```java
new ThatAssert(
        new ObjectiveText("Convert to null"),
        new NullCondition(
                new TextHasNull(
                        new CauseText("Text did not return null"),
                        new PrefixText("Text with"),
                        new NullText(new TextOf("HelLo!")),
                        null
                )
        )
).evaluate();
```

Test object equality:

```java
new ThatAssert(
        new ObjectiveText("Convert to lower case test"),
        new EqualCondition(
                new TextHasString(
                        new CauseText("Can't lower case a text"),
                        new PrefixText("Text with"),
                        new LowerText(new TextOf("HelLo!")),
                        "hello!"
                )
        )
).evaluate();
```
