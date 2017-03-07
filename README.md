# 沉侵式状态栏StatusBar
# 侧滑菜单DrawerLayout+FrameLayout+NavigationView

```java
/**
 * 功能：
 * 1、沉侵式状态栏
 * 2、侧滑菜单，布局采用DrawerLayout+FrameLayout+NavigationView
 */
```

```java
<?xml version="1.0" encoding="utf-8"?>
<android.support.v4.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/drawer_layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <include
            layout="@layout/content_main"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
    </FrameLayout>

    <!--注意：这里直接导入了布局navigation_head、menu_drawer-->
    <android.support.design.widget.NavigationView
        android:id="@+id/nav_view"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        app:headerLayout="@layout/navigation_head"
        android:background="@android:color/white"
        app:menu="@menu/menu_drawer" />

</android.support.v4.widget.DrawerLayout>
```

![img01](https://github.com/ykmeory/StatusBar_DrawerLayout/blob/master/img_folder/img01.jpg "screenshot")
&nbsp;&nbsp;&nbsp;
![img02](https://github.com/ykmeory/StatusBar_DrawerLayout/blob/master/img_folder/img02.jpg "screenshot")
