package cn.tuyucheng.taketoday.concurrent.lock;

import com.google.common.base.Supplier;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class SingleLock extends ConcurrentAccessExperiment {
	ReentrantLock lock;

	public SingleLock() {
		lock = new ReentrantLock();
	}

	protected Supplier<?> putSupplier(Map<String, String> map, int key) {
		return (() -> {
			lock.lock();
			try {
				return map.put("key" + key, "value" + key);
			} finally {
				lock.unlock();
			}
		});
	}

	protected Supplier<?> getSupplier(Map<String, String> map, int key) {
		return (() -> {
			lock.lock();
			try {
				return map.get("key" + key);
			} finally {
				lock.unlock();
			}
		});
	}
}