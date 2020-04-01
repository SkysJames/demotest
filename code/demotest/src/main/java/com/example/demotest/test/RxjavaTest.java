package com.example.demotest.test;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 响应式编程（rxjava）
 * @author xiefeiye
 *
 */
public class RxjavaTest {

	public static void main(String[] args) {
		// 发布者（可被观察者）
		Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
			@Override
			public void subscribe(ObservableEmitter<String> emitter) throws Exception {
				emitter.onNext("hello");
				emitter.onNext("xiefeiye!");
				emitter.onNext("bye!");
			}
		});
		
		// 消费者（比较简单的订阅者）
		Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String msg) throws Exception {
				System.out.println(Thread.currentThread().getName() + " == consumer == " + msg);
			}
		};
		
		// 同步订阅
		observable.subscribe(consumer);
		// 异步订阅
		observable.observeOn(Schedulers.newThread()).subscribe(consumer);
		
		// 观察者（比较复杂的订阅者）
		Observer<String> observer = new Observer<String>() {
			// 消息处理完成后做的事情（3）
			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				
			}
			// 消息处理出错后做的事情
			@Override
			public void onError(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}
			// 消息处理的时候做的事情（2）
			@Override
			public void onNext(String arg0) {
				System.out.println(Thread.currentThread().getName() + " == observer == " + arg0);
			}
			// 订阅消息的时候做的事情（1）
			@Override
			public void onSubscribe(Disposable arg0) {
				// TODO Auto-generated method stub
				
			}
		};
		
		// 同步订阅
		observable.subscribe(observer);
		// 异步订阅
		observable.observeOn(Schedulers.newThread()).subscribe(observer);
		
		for(;;);
	}

}
