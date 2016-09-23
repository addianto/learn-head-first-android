# Reading "Head First Android"

This repository is to contain my work related to the exercises described 
in the Head First Android book.

## Notes

The following are my notes on reading and trying the exercises from the 
book.

### Chapter 5: The User Interface

- Use `android:layout_alignX` (X can be `ParentTop`, `ParentRight`, etc.) 
to put view element at position relative to its parent `RelativeLayout`.
    - `layout_alignLeft`, `layout_below` and others to align view 
    element relative to specified view
- `android:layout_alignX` properties are specific to `RelativeLayout`. 
Similar alternative exists for `LinearLayout`, that is, 
`android:layout_gravity`.
    - `android:layout_gravity` can be used in view elements governed by 
    `GridLayout`.
- `android:gravity` is different to `android:layout_gravity`. The first one 
relates to the **content** of the view while the latter relates to the 
**view** itself.
- `sp` size means **scale-independent pixels** size.

### Chapter 6: List Views & Adapters

- `ListActivity` provides a `ListView` by default.
- Add a fragment to an activity using `<fragment>` if you don't need it 
to respond changes in the user interface. Otherwise, use a `<FrameLayout>`.

### Chapter 9: Action Bars

- Use **Back** button to navigate back to the previous activity.
- Use **Up** button to navigate up the app's hierarchy.
- If project has a dependency on the v7 appcompat library, `showAsAction` 
in a menu item in the resource file must be prefixed with `app:` and 
`app` namespace must be included
    - Otherwise, `showAsAction` must be prefixed with `android:`

### Chapter 13: Services

- A **started service** can run in the background indefinitely, even when 
the activity that started it is destroyed.
- A **bound service** is bound to another component such as an activity. It 
runs as long as components are bound to it.
- The **Service** class is the base class for creating services. It provides 
you with basic service functionality, and you will usually extend this class 
if you want to create a bound service.
- The **IntentService** class is a subclass of **Service** that is designed 
to handle intents. You'll usually extends this class if you want to create 
a started service.
- When to override `onStartCommand()` or `onHandleIntent()`?
    - Override `onHandleIntent()` if there are no needs to run codes in the 
    main thread, i.e. the codes can be run in background thread.
    - Otherwise, override `onStartCommand()`.
