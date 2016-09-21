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

- If project has a dependency on the v7 appcompat library, `showAsAction` 
in a menu item in the resource file must be prefixed with `app:` and 
`app` namespace must be included
    - Otherwise, `showAsAction` must be prefixed with `android:`
