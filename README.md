# Android_Broadcast_Receiver

Broadcast Receivers simply respond to broadcast messages from other applications or from the system itself. These messages are sometime called events or intents.

Broadcasr receivers works when it is created and registeted for the system broadcasted intents.

1) Creating Broadcast Receiver

Here I have created a class <a href="https://github.com/Vijay-Tahelramani/Android_Broadcast_Receiver/blob/master/Broadcast_Receiver_Demo/app/src/main/java/com/example/broadcast_receiver_demo/MyBroadcasrtReceiver.java">```MyBroadcasrtReceiver.java```</a>.

It extends the ```BroadcastReceiver``` class and override it's method named ```onReceive()```, This method is automatically called whenever the broadcast intent is detected.
```
String action = intent.getAction();

if (("android.net.conn.CONNECTIVITY_CHANGE").equals(action)) {
      Toast.makeText(context, "Network Connectivity Changed!", Toast.LENGTH_SHORT).show();
}
```

Above lines of code inside the ```onReceive()``` Method will generate the toast message when broadcast will detect the intent action as ```android.net.conn.CONNECTIVITY_CHANGE```.


I have also created the constructor of MyBroadcasrtReceiver Class.

2) Registering the Broadcast receiver

Here I have registered my broadcast in <a href="https://github.com/Vijay-Tahelramani/Android_Broadcast_Receiver/blob/master/Broadcast_Receiver_Demo/app/src/main/java/com/example/broadcast_receiver_demo/MainActivity.java">```MainActivity.java```</a>

First Create the variable of your broadcast class, Here I have created 
```
BroadcastReceiver receiver;

 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new MyBroadcasrtReceiver();
    }

```

Now, Create an ```IntentFilter``` and register the receiver by calling ```registerReceiver(BroadcastReceiver, IntentFilter)```.

Using intent filters we tell the system any intent that matches our subelements should get delivered to that specific broadcast receiver.

Here I have done this in ```onResume()``` Method.
```
@Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        filter.addAction("android.intent.");

        registerReceiver(receiver, filter);
    }
```

When Boradcast is not in use simply unregister it. I have done it in ```onStop()``` method.
```
@Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }
```

That's It. Now run the code and enable the flight mode you will receive the Toast message.

<img src="https://github.com/Vijay-Tahelramani/Android_Broadcast_Receiver/blob/master/Images/Screenshot.png" width="300">
