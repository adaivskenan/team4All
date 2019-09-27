package com.adaivskenan.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class HelloWorld {

	@Benchmark
	public void err() {
		System.err.println("Error");
	}

	@Benchmark
	public void out() {
		System.out.println("Error");
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(HelloWorld.class.getSimpleName()).forks(2).build();
		new Runner(opt).run();
	}

}
