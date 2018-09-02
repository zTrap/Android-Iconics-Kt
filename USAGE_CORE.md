# Usage of `core` modules

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
    layoutInflater.setIconicsFactory(delegate)
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

---

java
```java
IconicsDrawable drawable = new IconicsDrawable(this)
                                   .icon(FontAwesome.Icon.faw_android)
                                   .sizeDp(24)
                                   .toBitmap();
Icon icon = Icon.createWithBitmap(drawable);
```
kotlin
```kotlin
val icon = IconicsDrawable(this)
                .icon(FontAwesome.Icon.faw_android)
                .sizeDp(24)
                .toAndroidIcon()
```
