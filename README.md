Android-Progress-Layout
=======================
![screenshot][1]

Compatibility
-------------
Compatible from API 10 (Android 2.3.3).

Usage
-------------
- Import ProgressLayout-lib as a library to your project.
- Add a ProgressLayout to your view.
``` xml
 <com.oxzimo.progresslayout.ProgressLayout
        android:id="@+id/progress_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        
                <!--> add any view <-->
                
    </com.oxzimo.progresslayout.ProgressLayout>
```
- Add ProgressLayout view class to your activity or fragment and make sure you call init().
``` java
      ProgressLayout progressLayout;
      progressLayout = (ProgressLayout) findViewById(R.id.progress_layout);
      progressLayout.init();
```
- Show progress view wherever you like  
``` java
      // call when you want to show progress view
      progressLayout.showProgress(true);
      
      // call when you want to hide progress view
      progressLayout.showProgress(false);
      
      // call when you want to show error view
      progressLayout.showError();
  ```
- Set a custom progress view or error view as you like via attributes progressLayout and errorLayout.
![screenshot][2]
``` xml
 <com.oxzimo.progresslayout.ProgressLayout
        android:id="@+id/progress_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        progressLayout="@layout/progress_custom"
        errorLayout="@layout/error_custom">
        
                <!--> add any view <-->
               
    </com.oxzimo.progresslayout.ProgressLayout>
```
Developed By
------------
* Ahmed Talaat - <ahmedtalaat.mail@gmail.com>

License
-------

    Copyright 2014 Ahmed Talaat
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
    http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: http://i57.tinypic.com/wbqnpz.jpg
[2]: http://i62.tinypic.com/28ja4ow.jpg
