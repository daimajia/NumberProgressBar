## Android NumberProgressBar [![Build Status](https://travis-ci.org/daimajia/NumberProgressBar.png?branch=master)](https://travis-ci.org/daimajia/NumberProgressBar)

[![Insight.io](https://insight.io/repoBadge/github.com/daimajia/NumberProgressBar)](https://insight.io/github.com/daimajia/NumberProgressBar)
-----

The NumberProgressBar is a bar, slim and sexy (every man wants! ). 

I decided to do this because I was really tired of android original progress bar. So, I made some change, added more color style for this.

And also you can contribute more color style, or new idea to me.

BTW. My friends also made some other platform's NumberProgressBar：

- [Web-Front](https://github.com/kalasoo/NumberProgressBar) by [kalasoo](https://github.com/kalasoo/NumberProgressBar)
- [iOS](https://github.com/Ming-Zhe/NumberProgressBar) by [Ming-Zhe](https://github.com/Ming-Zhe/NumberProgressBar)
- [Windows Phone](https://github.com/s2003zy/NumberProgressBar) by [s2003zy](https://github.com/s2003zy)

---

### Demo

![NumberProgressBar](http://ww3.sinaimg.cn/mw690/610dc034jw1efyrd8n7i7g20cz02mq5f.gif)


[Download Demo](https://github.com/daimajia/NumberProgressBar/releases/download/v1.0/NumberProgressBar-Demo-v1.0.apk)


### Usage
----

#### Gradle

```groovy
dependencies {
   compile 'com.daimajia.numberprogressbar:library:1.4@aar'
}
```

#### Maven 

```xml
<dependency>
    <groupId>com.daimajia.numberprogressbar</groupId>
    <artifactId>library</artifactId>
    <version>1.4</version>
    <type>apklib</type>
</dependency>
```

Use it in your own code:

```java
	<com.daimajia.numberprogressbar.NumberProgressBar
		android:id="@+id/number_progress_bar"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
	/>
```	

I made some predesign style. You can use them via `style` property.


![Preset color](http://ww1.sinaimg.cn/mw690/610dc034jw1efyslmn5itj20f30k074r.jpg)

Use the preset style just like below:

```java
	<com.daimajia.numberprogressbar.NumberProgressBar
		android:id="@+id/number_progress_bar"
		style="@style/NumberProgressBar_Default"
	/>
```	

In the above picture, the style is : 

`NumberProgressBar_Default`
`NumberProgressBar_Passing_Green`
`NumberProgressBar_Relax_Blue`
`NumberProgressBar_Grace_Yellow`
`NumberProgressBar_Warning_Red`
`NumberProgressBar_Funny_Orange`
`NumberProgressBar_Beauty_Red`
`NumberProgressBar_Twinkle_Night`

You can get more beautiful color from [kular](https://kuler.adobe.com), and you can also contribute your color style to NumberProgressBar!  

### Build

run `./gradlew assembleDebug` (Mac/Linux)

or

run `gradlew.bat assembleDebug` (Windows)

### Attributes

There are several attributes you can set:

![](http://ww2.sinaimg.cn/mw690/610dc034jw1efyttukr1zj20eg04bmx9.jpg)

The **reached area** and **unreached area**:

* color
* height 

The **text area**:

* color
* text size
* visibility
* distance between **reached area** and **unreached area**

The **bar**:

* max progress
* current progress

for example, the default style:

```java
	<com.daimajia.numberprogressbar.NumberProgressBar
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"
	        
	        custom:progress_unreached_color="#CCCCCC"
	        custom:progress_reached_color="#3498DB"
	        
	        custom:progress_unreached_bar_height="0.75dp"
	        custom:progress_reached_bar_height="1.5dp"
	        
	        custom:progress_text_size="10sp"
	        custom:progress_text_color="#3498DB"
	        custom:progress_text_offset="1dp"
	        custom:progress_text_visibility="visible"
	        
	        custom:progress_max="100"
	        custom:progress_current="80"
	         />
```

### About me:

A student in China mainland, I like Google, like Android, like open source, like doing something interesting. :)

If you have some new idea or internship opportunity, please [email me](mailto:daimajia@gmail.com) !
