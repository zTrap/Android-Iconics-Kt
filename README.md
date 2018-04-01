# Android-Iconics Core Kt
Kotlin extensions for [Android-Iconics Library](https://github.com/mikepenz/Android-Iconics)

[ ![Download](https://api.bintray.com/packages/ztrap/maven/core-kt/images/download.svg) ](https://bintray.com/ztrap/maven/core-kt/_latestVersion)

Install
-------

```groove
implementation 'ru.ztrap.iconics:core-kt:1.0.0'
```

Usage
-----

java
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LayoutInflaterCompat.setFactory2(getLayoutInflater(), new IconicsLayoutInflater2(getDelegate()));
    } else {
        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
    }
    //...
    super.onCreate(savedInstanceState);
    //...
}
```
kotlin
```kotlin
override fun onCreate(savedInstanceState: Bundle) {
    getLayoutInflater().setIconicsFactory(getDelegate())
    //...
    super.onCreate(savedInstanceState)
    //...
}
```

---

java
```java
@Override
protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
}
```
kotlin
```kotlin
override fun attachBaseContext(newBase: Context) {
    super.attachBaseContext(newBase.wrapByIconics())
}
```

---

java
```java
IconicsDrawable baseIcon = new IconicsDrawable(this).color(Color.RED);
IconicsDrawable[] iconsArray = new IconicsArrayBuilder(baseIcon)
        .add(FontAwesome.Icon.faw_android)
        .add("gmd_plus_circle")
        .add("gmd-favorite")
        .build();
```
kotlin
```kotlin
val baseIcon = IconicsDrawable(this).color(Color.RED)
val iconsArray: Array<IconicsDrawable> = baseIcon.createArray {
    add(FontAwesome.Icon.faw_android)
    add("gmd_plus_circle")
    add("gmd-favorite")
}
```

---

java
```java
new Iconics.IconicsBuilder().ctx(this)
                .style(new ForegroundColorSpan(Color.WHITE), new BackgroundColorSpan(Color.BLACK), new RelativeSizeSpan(2f))
                .styleFor(FontAwesome.Icon.faw_adjust, new BackgroundColorSpan(Color.RED))
                .on(tv1)
                .build();
```
kotlin
```kotlin
iconicsBuilder {
    style(ForegroundColorSpan(Color.WHITE), BackgroundColorSpan(Color.BLACK), RelativeSizeSpan(2f))
    styleFor(FontAwesome.Icon.faw_adjust, BackgroundColorSpan(Color.RED))
    on(tv1)
}
```

---

java
```java
new Iconics.IconicsBuilder().ctx(this)
                .style(new ForegroundColorSpan(Color.WHITE), new BackgroundColorSpan(Color.BLACK), new RelativeSizeSpan(2f))
                .styleFor(FontAwesome.Icon.faw_adjust, new BackgroundColorSpan(Color.RED))
                .on(tv1)
                .build();
```
kotlin
```kotlin
iconicsBuilder {
    style(ForegroundColorSpan(Color.WHITE), BackgroundColorSpan(Color.BLACK), RelativeSizeSpan(2f))
    styleFor(FontAwesome.Icon.faw_adjust, BackgroundColorSpan(Color.RED))
    on(tv1)
}
```

---

java
```java
String text = "Your awesome text for {faw-android}";
Spannable decoratedText = new Iconics.IconicsBuilder().ctx(this)
                .style(new ForegroundColorSpan(Color.WHITE), new BackgroundColorSpan(Color.BLACK), new RelativeSizeSpan(2f))
                .styleFor(FontAwesome.Icon.faw_android, new BackgroundColorSpan(Color.RED))
                .on(text)
                .build();
```
kotlin
```kotlin
val text = "Your awesome text for {faw-android}"
val decoratedText: Spannable = iconicsBuilder {
    style(ForegroundColorSpan(Color.WHITE), BackgroundColorSpan(Color.BLACK), RelativeSizeSpan(2f))
    styleFor(FontAwesome.Icon.faw_android, BackgroundColorSpan(Color.RED))
    on(text)
}
```

---

java
```java
@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    IconicsMenuInflaterUtil.inflate(inflater, getActivity(), R.menu.menu_fragment_main, menu);
}
```
kotlin
```kotlin
override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
    inflater.inflateWithIconics(getActivity(), R.menu.menu_fragment_main, menu)
}
```

How to Contribute
-----------------

We welcome your contributions to this project. There are various ways to contribute:

**Reporting issues**

Help improve the project by reporting issues that you find by filing a new issue at the
[Android-Iconics Kt issue tracker](https://github.com/zTrap/Android-Iconics-Kt/issues/new).

**Features suggestions**

You can also add feature suggestions by filing a new issue at the
[Android-Iconics Kt issue tracker](https://github.com/zTrap/Android-Iconics-Kt/issues/new).

**Documentation**

You can help by adding or improving existing documentation. Simply send us a pull request for us to
consider your proposed changes.

**Bug fixes**

Pull requests are welcome for minor bug fixes that do not involve any changes to existing API.
These changes should ideally be accompanied by a test case that would have otherwise failed without
the fix.

Developed By
------------

 - Peter Gulko
 - contacts@ztrap.ru
 - [paypal.me/zTrap](https://www.paypal.me/zTrap)

License
-------

       Copyright 2018 zTrap

       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at

           http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License.
