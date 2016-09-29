# Assignment
Assignment for mavericks

1. What is the major difference between an abstract class and an interface?

Abstract Class:
     Abstract class can extend only one class at a time.
     Abstract class can have both abstract and concrete methods.
     Abstract class can have static, final or static final variable with any access specifier.    
Interface:
    Interface can extend any number of interfaces at a time.
    Interface can have only abstract methods.
    Interface can have only static final (constant) variable.
    
2. Why is Java 7’s class inheritance flawed?
   Multiple inheritance cause of diamond problem.

3. What are the major differences between Activities and Fragments?
    Activity:
        An Activity may contain 0 or multiple number of fragments.
        A fragment can be reused in multiple activities, so it acts like a reusable component in activities.
    Fragment:
        A fragment can't exist independently.
        It should be always part of an activity whereas activity can exist without any fragment in it.

4. When using Fragments, how do you communicate back to their hosting Activity?
    I don’t know.
    
5. Can you make an entire app without ever using Fragments? Why or why not?
    Yes. I can create entire app without using fragments.
    but accourding to recommendation it is not good.
6. What makes an AsyncTask such an annoyance to Android developers?

    Screen Rotation:
        When an app is rotated, the entire Activity is destroyed and recreated.
     When the Activity is restarted, your AsyncTask’s reference to the Activity is invalid,
     so onPostExecute() will have no effect on the new Activity.
     
     Limitations on Concurrent AsyncTasks:
        you queue up more than 138 tasks before they can complete, your app will crash.
     
    
