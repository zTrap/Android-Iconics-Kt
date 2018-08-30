# Usage of `views` modules

java
```java
IconicsDrawable drawable = mIconicsCheckableTextView.getCheckedIconicsDrawableStart();
if (drawable == null) {
    drawable = new IconicsDrawable(getContext());
    mIconicsCheckableTextView.setCheckedIconicsDrawableStart(drawable);
}
drawable.icon(FontAwesome.Icon.faw_android).color(Color.GREEN)
```

kotlin
```kotlin
mIconicsCheckableTextView.startIcon(checked = true) {
    icon(FontAwesome.Icon.faw_android)
    color(Color.GREEN)
}
```

---

java
```java
IconicsDrawable drawable = mIconicsCompoundButton.getCheckedIcon();
if (drawable == null) {
    drawable = new IconicsDrawable(getContext());
    mIconicsCompoundButton.setCheckedIcon(drawable);
}
drawable.icon(FontAwesome.Icon.faw_android).color(Color.GREEN)
```

kotlin
```kotlin
mIconicsCompoundButton.icon(checked = true) {
    icon(FontAwesome.Icon.faw_android)
    color(Color.GREEN)
}
```

---

java
```java
IconicsDrawable drawable = mIconicsImageView.getIcon();
if (drawable == null) {
    drawable = new IconicsDrawable(getContext());
    mIconicsImageView.setIcon(drawable);
}
drawable.icon(FontAwesome.Icon.faw_android).color(Color.GREEN)
```

kotlin
```kotlin
mIconicsImageView.icon {
    icon(FontAwesome.Icon.faw_android)
    color(Color.GREEN)
}
```

---

java
```java
IconicsDrawable drawable = mIconicsTextView.getStartIcon();
if (drawable == null) {
    drawable = new IconicsDrawable(getContext());
    mIconicsTextView.setStartIcon(drawable);
}
drawable.icon(FontAwesome.Icon.faw_android).color(Color.GREEN)
```

kotlin
```kotlin
mIconicsTextView.startIcon {
    icon(FontAwesome.Icon.faw_android)
    color(Color.GREEN)
}
```