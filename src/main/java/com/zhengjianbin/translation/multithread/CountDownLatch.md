## 一、CountDownLatch 翻译

### 1.1&emsp;类文档翻译

&emsp;&emsp;一个同步的助手。允许一个或者多个线程等待，直到一组线程执行结束。

&emsp;&emsp;一个CountDownLatch 初始化需要给它一个count。awit 方法会造成阻塞，直到由于调用
countDown 方法，使得count 变成0。随后释放所有等待的线程以及后续的调用。这是一次性的现象，这个
count 不能被重置，如果你需要一个重置版本，你可以考虑使用CyclicBarrier。

&emsp;&emsp;一个CountDownLatch 是一个多功能的工具，并能够使用于多个用途。一个CountDownLatch
初始化时，将count 设置为1，可以实现一个简单的开/关锁存器，或者一个大门。所有线程调用awit 都会堵在
大门外，只有一个线程调用countDown方法时，释放等待线程。一个CountDownLatch 初始化时，count设置为
N（任意数字） 时，能够让一个线程等待直到N个线程都执行完，或者某些方法执行了N 次。

&emsp;&emsp;CountDownLatch 有一个有用的属性，它不需要在扇区等待的线程调用countDown 方法，在程序中
的count 变成0之前进入等待。它只是阻止线程在await 时通过，直到count 变成0 方可通过。