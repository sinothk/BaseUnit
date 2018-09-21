# 内容
CommUnit：包含样式，适配文件，图标，工具类等

# 引入
## Step 1. Add the JitPack repository to your build file
  Add it in your root build.gradle at the end of repositories:

    allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
    }

## Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.sinothk:CommUnit:2.0.0921'
	}

# 使用
  工具类：
  **Util.xx(?);
  
  适配方式：
	<TextView
	android:layout_width="@dimen/dp_140"
	android:layout_height="@dimen/dp_70"
	android:background="@color/colorPrimary"
	android:gravity="center"
	android:text="不同尺寸效果一样"
	android:textColor="#FFF"
	android:textSize="@dimen/sp_16"/>
