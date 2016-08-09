# Reading "Head First Android"

This repository is to contain my work related to the exercises described 
in the Head First Android book.

## Notes

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
