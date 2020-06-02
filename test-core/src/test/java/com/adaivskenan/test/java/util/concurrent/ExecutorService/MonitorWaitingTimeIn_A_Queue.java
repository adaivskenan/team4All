/**
 * 
 */
package com.adaivskenan.test.java.util.concurrent.ExecutorService;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Throwables.throwIfUnchecked;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author qinjunjie
 *
 */
public class MonitorWaitingTimeIn_A_Queue {
	
	final static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Orders-%d").setDaemon(true).build();
	final static ExecutorService executorService = Executors.newFixedThreadPool(5, threadFactory);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WrappingExecutorService delegateExecutorService = new WrappingExecutorService(executorService) {

			@Override
			protected <T> Callable<T> wrapTask(Callable<T> callable) {
				return new Callable<T>() {

					@Override
					public T call() throws Exception {
						System.out.println("TTT");
						return null;
					}
				};
			}

			@Override
			protected Runnable wrapTask(Runnable command) {
				return command;

			}
		};
		delegateExecutorService.submit(()->{
			System.out.println("I am wrapped !!!");
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

abstract class WrappingExecutorService implements ExecutorService {
	
	private final ExecutorService delegate;

	protected WrappingExecutorService(ExecutorService delegate) {
		this.delegate = checkNotNull(delegate);
	}
	/**
	   * Wraps a {@code Callable} for submission to the underlying executor. This method is also applied
	   * to any {@code Runnable} passed to the default implementation of {@link #wrapTask(Runnable)}.
	   */
	  protected abstract <T> Callable<T> wrapTask(Callable<T> callable);

	  /**
	   * Wraps a {@code Runnable} for submission to the underlying executor. The default implementation
	   * delegates to {@link #wrapTask(Callable)}.
	   */
	  protected Runnable wrapTask(Runnable command) {
		  final long startTime = System.currentTimeMillis();
	    final Callable<Object> wrapped = wrapTask(Executors.callable(command, null));
	    return new Runnable() {
	      @Override
	      public void run() {
	        try {
	          wrapped.call();
	        } catch (Exception e) {
	          throwIfUnchecked(e);
	          throw new RuntimeException(e);
	        }
	      }
	    };
	  }

	  /**
	   * Wraps a collection of tasks.
	   *
	   * @throws NullPointerException if any element of {@code tasks} is null
	   */
	  private <T> ImmutableList<Callable<T>> wrapTasks(Collection<? extends Callable<T>> tasks) {
	    ImmutableList.Builder<Callable<T>> builder = ImmutableList.builder();
	    for (Callable<T> task : tasks) {
	      builder.add(wrapTask(task));
	    }
	    return builder.build();
	  }

	  // These methods wrap before delegating.
	  @Override
	  public final void execute(Runnable command) {
	    delegate.execute(wrapTask(command));
	  }

	  @Override
	  public final <T> Future<T> submit(Callable<T> task) {
	    return delegate.submit(wrapTask(checkNotNull(task)));
	  }

	  @Override
	  public final Future<?> submit(Runnable task) {
		  final long startTime = System.currentTimeMillis();
	    return delegate.submit(()->{
	    	final long queueDuration = System.currentTimeMillis() - startTime;
	    	System.out.println(queueDuration);
	    	wrapTask(task);
	    });
	  }

	  @Override
	  public final <T> Future<T> submit(Runnable task, T result) {
	    return delegate.submit(wrapTask(task), result);
	  }

	  @Override
	  public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
	      throws InterruptedException {
	    return delegate.invokeAll(wrapTasks(tasks));
	  }

	  @Override
	  public final <T> List<Future<T>> invokeAll(
	      Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
	      throws InterruptedException {
	    return delegate.invokeAll(wrapTasks(tasks), timeout, unit);
	  }

	  @Override
	  public final <T> T invokeAny(Collection<? extends Callable<T>> tasks)
	      throws InterruptedException, ExecutionException {
	    return delegate.invokeAny(wrapTasks(tasks));
	  }

	  @Override
	  public final <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
	      throws InterruptedException, ExecutionException, TimeoutException {
	    return delegate.invokeAny(wrapTasks(tasks), timeout, unit);
	  }

	  // The remaining methods just delegate.

	  @Override
	  public final void shutdown() {
	    delegate.shutdown();
	  }

	  @Override
	  public final List<Runnable> shutdownNow() {
	    return delegate.shutdownNow();
	  }

	  @Override
	  public final boolean isShutdown() {
	    return delegate.isShutdown();
	  }

	  @Override
	  public final boolean isTerminated() {
	    return delegate.isTerminated();
	  }

	  @Override
	  public final boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
	    return delegate.awaitTermination(timeout, unit);
	  }

}
