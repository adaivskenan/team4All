package com.adaivskenan.gof.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverLambdaMain {

	public static void main(String[] args) {
		
		Feed f = new Feed();
		//add three observer
		f.registerObserver(new NYTimes());
		f.registerObserver(new Guardian());
		f.registerObserver(new LeMonde());
		
		f.notifyObservers("The queen said her favourite book is Java 8 in Action!");

		Feed feedLambda = new Feed();

		feedLambda.registerObserver((String tweet) -> {
			if (tweet != null && tweet.contains("money")) {
				System.out.println("Breaking news in NY! " + tweet);
			}
		});
		feedLambda.registerObserver((String tweet) -> {
			if (tweet != null && tweet.contains("queen")) {
				System.out.println("Yet another news in London... " + tweet);
			}
		});
		
		//before 1.8
		feedLambda.registerObserver(new Observer(){

			@Override
			public void inform(String tweet) {
				if (tweet != null && tweet.contains("money")) {
					System.out.println("Alex say " + tweet);
				}
			}
			
		});

		feedLambda.notifyObservers("Money money money, give me money!");

	}

	/**
	 * <p>
	 * Observer（观察者）
	 * </p>
	 *
	 */
	interface Observer {
		void inform(String tweet);
	}

	/**
	 * <p>
	 * Subject（目标）：目标又称为主题，它是指被观察的对象
	 * </p>
	 *
	 */
	interface Subject {
		void registerObserver(Observer o);

		void notifyObservers(String tweet);
	}

	static private class NYTimes implements Observer {
		@Override
		public void inform(String tweet) {
			if (tweet != null && tweet.contains("money")) {
				System.out.println("Breaking news in NY!" + tweet);
			}
		}
	}

	static private class Guardian implements Observer {
		@Override
		public void inform(String tweet) {
			if (tweet != null && tweet.contains("queen")) {
				System.out.println("Yet another news in London... " + tweet);
			}
		}
	}

	static private class LeMonde implements Observer {
		@Override
		public void inform(String tweet) {
			if (tweet != null && tweet.contains("wine")) {
				System.out.println("Today cheese, wine and news! " + tweet);
			}
		}
	}

	/**
	 * <p> ConcreteSubject（具体目标）：具体目标是目标类的子类，通常它包含有经常发生改变
	 * 的数据，当它的状态发生改变时，向它的各个观察者发出通知；同时它还实现了在目标类中定
	 * 义的抽象业务逻辑方法（如果有的话）。如果无须扩展目标类，则具体目标类可以省略</p>
	 *
	 */
	static private class Feed implements Subject {
		private final List<Observer> observers = new ArrayList<>();

		public void registerObserver(Observer o) {
			this.observers.add(o);
		}

		public void notifyObservers(String tweet) {
			observers.forEach(o -> o.inform(tweet));
		}
	}

}
