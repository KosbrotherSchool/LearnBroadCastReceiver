當手機接收到外來的訊息,
例如: 收到簡訊, 接到來電, 或者是 App 本身的廣播...等.
我們的應用程式 App 可以透過 BroadCastReceiver 接收並做出回應,

BroadCastReceiver 的使用方式

1. 寫一個繼承自 BroadCastReceiver 的 Class, 處理 onReceive() 事件.
2. 在 AndroidManifest 裡註冊這個 BroadCastReceiver Class

這樣一但接收到系統的廣播或者是自己應用程式的廣播時,
我們的 BroadCastReceiver 就會執行 onReceive() 的程式碼.

BroadCastReceiver 的生命週期

BroadCastReceiver 的生命週期非常短, 只有三個階段:

BroadcastReceiver --> onReceive() --> 結束

需要注意的是, onReceive 的程式碼執行不能超過五秒,
否則會彈出 "應用程式沒有回應" 的 Dialog.

因此, 我們應該在 onReceive 時, 發送 Notification 提示使用者,
或者直接把長時間的運算透過 intent 丟給 Service.

BroadCast 廣播的發送

App 內廣播的發送是透過 intent 以及 sendBroadCast(intent) 來發送的

 Intent intent = new Intent();  
 intent.setAction(ACTION_SHOW_DIALOG);  
 sendBroadcast(intent);  

BroadCast 的範例

我們範例做一個按鈕, 點擊了之後發送 BroadCast, 然後利用 BroadCastReceiver 接收回來並彈出接收到 BroadCast 的 Dialog 確認框.
