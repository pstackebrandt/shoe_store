# Check list / rubric 

# Code Quality
Criteria 	Meets Specifications

Correctly use ViewModel and LiveData lifecycle classes in an Android app
	

The Detail screen needs to add the new item to the view model. The listing screen should be listening to that model and show the new item.

Correctly implement Single Activity architecture
	

There should only be one activity: MainActivity. Each screen should be a fragment.

Write error-free code
	

The project's code is error-free.

# Layouts
Criteria 	Meets Specifications

Create layouts using the correct ViewGroups and Views in an Android app.
	

The project correctly implements LinearLayout and ConstraintLayout to match the complexity of the layout of a page. Using code comments, the project justifies the use of ConstraintLayout or LinearLayout

Apply Databinding in Layouts to show the correct data to users in multiple layouts.
	

    All layouts will use the <layout> tag to support Databinding.
    Detail screen uses the <data> element.
    Databinding is set to the appropriate setting in the app build.gradle file

Correctly use the <data> and <variable> elements within the layout.
	

The detail layout contains an <data> element with the name of the variable and the class associated with it.

    All EditViews correctly refer to created class variable

Create a multi-screened Android Application using Android widgets.
	

    The app contains at least 5 screens.
    The app contains correctly laid-out labels and edit fields for each screen.
    The app contains button positioned below the text fields

List screen uses ScrollView and LinearLayout for showing a list of items and one Floating Action button for going to the detail screen.
Creates a layout for the item.
	

    A new item layout is created for each item
    New item layout is added to LinearLayout
    Layout is updated with items added on the detail screen

Create a detail screen that shows two columns of labels and edit views to enter in a new item.
	

    Layout created with a label & edit view for each item
    Uses data binding to save data
    Uses a save button to save data to view model

# Navigation
Criteria 	Meets Specifications

Create a navigation file that correctly takes a user from one page to the next in an Android app
	

The app needs to traverse the following screens in the correct order:

    Login
    Welcome
    Instructions screen
    Listing screen
    Detail screens
    The app should also be able to navigate back via the back arrow or the back button.
    A navigation file has been created that defines a start destination.
    All destinations have a fragment, label and action associated with it.

Use Databinding for click listeners on a navigation screen in an Android app.
	

    All code will use the DataBindingUtil class to inflate the layout.
    All click listeners are connected via the DataBindingUtil class and uses the NavController to navigate to the next screen.

Create a Logout menu to return to the Login screen.
	

This menu will appear only on the Shoe Listing screen and will return the user to the login screen